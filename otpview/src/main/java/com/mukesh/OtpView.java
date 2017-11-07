package com.mukesh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.TextUtils;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

public class OtpView extends LinearLayout {
  private EditText mOtpOneField, mOtpTwoField, mOtpThreeField, mOtpFourField,
      mCurrentlyFocusedEditText;

  public OtpView(Context context) {
    super(context);
    init(null);
  }

  public OtpView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  public OtpView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init(attrs);
  }

  private void init(AttributeSet attrs) {
    TypedArray styles = getContext().obtainStyledAttributes(attrs, R.styleable.OtpView);
    LayoutInflater mInflater =
        (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    mInflater.inflate(R.layout.otpview_layout, this);
    mOtpOneField = (EditText) findViewById(R.id.otp_one_edit_text);
    mOtpTwoField = (EditText) findViewById(R.id.otp_two_edit_text);
    mOtpThreeField = (EditText) findViewById(R.id.otp_three_edit_text);
    mOtpFourField = (EditText) findViewById(R.id.otp_four_edit_text);
    styleEditTexts(styles);
    styles.recycle();
  }
  
  /**
     * Get an instance of the present otp
     */
    private String makeOTP(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(mOtpOneField.getText().toString());
        stringBuilder.append(mOtpTwoField.getText().toString());
        stringBuilder.append(mOtpThreeField.getText().toString());
        stringBuilder.append(mOtpFourField.getText().toString());
        return stringBuilder.toString();
    }

    /**
     * Checks if all four fields have been filled
     * @return length of OTP
     */
    public boolean hasValidOTP(){
        return makeOTP().length()==4;
    }

    /**
     * Returns the present otp entered by the user
     * @return OTP
     */
    public String getOTP(){
        return makeOTP();
    }

    /**
     * Used to set the OTP. More of cosmetic value than functional value
     * @param otp Send the four digit otp
     */
    public void setOTP(String otp){
        if(otp.length()!=4){
            Log.e("OTPView","Invalid otp param");
            return;
        }
        if(mOtpOneField.getInputType()== InputType.TYPE_CLASS_NUMBER
                && !otp.matches("[0-9]+")){
            Log.e("OTPView","OTP doesn't match INPUT TYPE");
            return;
        }
        mOtpOneField.setText(String.valueOf(otp.charAt(0)));
        mOtpTwoField.setText(String.valueOf(otp.charAt(1)));
        mOtpThreeField.setText(String.valueOf(otp.charAt(2)));
        mOtpFourField.setText(String.valueOf(otp.charAt(3)));
    }

  private void styleEditTexts(TypedArray styles) {
    int textColor = styles.getColor(R.styleable.OtpView_android_textColor, Color.BLACK);
    int backgroundColor =
        styles.getColor(R.styleable.OtpView_text_background_color, Color.TRANSPARENT);
    if (styles.getColor(R.styleable.OtpView_text_background_color, Color.TRANSPARENT)
        != Color.TRANSPARENT) {
      mOtpOneField.setBackgroundColor(backgroundColor);
      mOtpTwoField.setBackgroundColor(backgroundColor);
      mOtpThreeField.setBackgroundColor(backgroundColor);
      mOtpFourField.setBackgroundColor(backgroundColor);
    } else {
      mOtpOneField.getBackground().mutate().setColorFilter(textColor, PorterDuff.Mode.SRC_ATOP);
      mOtpTwoField.getBackground().mutate().setColorFilter(textColor, PorterDuff.Mode.SRC_ATOP);
      mOtpThreeField.getBackground().mutate().setColorFilter(textColor, PorterDuff.Mode.SRC_ATOP);
      mOtpFourField.getBackground().mutate().setColorFilter(textColor, PorterDuff.Mode.SRC_ATOP);
    }
    mOtpOneField.setTextColor(textColor);
    mOtpTwoField.setTextColor(textColor);
    mOtpThreeField.setTextColor(textColor);
    mOtpFourField.setTextColor(textColor);
    setEditTextInputStyle(styles);
  }

  private void setEditTextInputStyle(TypedArray styles) {
    int inputType =
        styles.getInt(R.styleable.OtpView_android_inputType, EditorInfo.TYPE_TEXT_VARIATION_NORMAL);
    mOtpOneField.setInputType(inputType);
    mOtpTwoField.setInputType(inputType);
    mOtpThreeField.setInputType(inputType);
    mOtpFourField.setInputType(inputType);
    String text = styles.getString(R.styleable.OtpView_otp);
    if (!TextUtils.isEmpty(text) && text.length() == 4) {
      mOtpOneField.setText(String.valueOf(text.charAt(0)));
      mOtpTwoField.setText(String.valueOf(text.charAt(1)));
      mOtpThreeField.setText(String.valueOf(text.charAt(2)));
      mOtpFourField.setText(String.valueOf(text.charAt(3)));
    }
    setFocusListener();
    setOnTextChangeListener();
  }

  private void setFocusListener() {
    View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
      @Override public void onFocusChange(View v, boolean hasFocus) {
        mCurrentlyFocusedEditText = (EditText) v;
        mCurrentlyFocusedEditText.setSelection(mCurrentlyFocusedEditText.getText().length());
      }
    };
    mOtpOneField.setOnFocusChangeListener(onFocusChangeListener);
    mOtpTwoField.setOnFocusChangeListener(onFocusChangeListener);
    mOtpThreeField.setOnFocusChangeListener(onFocusChangeListener);
    mOtpFourField.setOnFocusChangeListener(onFocusChangeListener);
  }

  public void disableKeypad() {
    OnTouchListener touchListener = new OnTouchListener() {
      @Override public boolean onTouch(View v, MotionEvent event) {
        v.onTouchEvent(event);
        InputMethodManager imm =
            (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
          imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
        return true;
      }
    };
    mOtpOneField.setOnTouchListener(touchListener);
    mOtpTwoField.setOnTouchListener(touchListener);
    mOtpThreeField.setOnTouchListener(touchListener);
    mOtpFourField.setOnTouchListener(touchListener);
  }

  public void enableKeypad() {
    OnTouchListener touchListener = new OnTouchListener() {
      @Override public boolean onTouch(View v, MotionEvent event) {
        return false;
      }
    };
    mOtpOneField.setOnTouchListener(touchListener);
    mOtpTwoField.setOnTouchListener(touchListener);
    mOtpThreeField.setOnTouchListener(touchListener);
    mOtpFourField.setOnTouchListener(touchListener);
  }

  public EditText getCurrentFoucusedEditText() {
    return mCurrentlyFocusedEditText;
  }

  private void setOnTextChangeListener() {
    TextWatcher textWatcher = new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
      }

      @Override public void afterTextChanged(Editable s) {
        if (mCurrentlyFocusedEditText.getText().length() >= 1
            && mCurrentlyFocusedEditText != mOtpFourField) {
          mCurrentlyFocusedEditText.focusSearch(View.FOCUS_RIGHT).requestFocus();
        } else if (mCurrentlyFocusedEditText.getText().length() >= 1
            && mCurrentlyFocusedEditText == mOtpFourField) {
          InputMethodManager imm =
              (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
          if (imm != null) {
            imm.hideSoftInputFromWindow(getWindowToken(), 0);
          }
        } else {
          String currentValue = mCurrentlyFocusedEditText.getText().toString();
          if (currentValue.length() <= 0 && mCurrentlyFocusedEditText.getSelectionStart() <= 0) {
            mCurrentlyFocusedEditText.focusSearch(View.FOCUS_LEFT).requestFocus();
          }
        }
      }
    };
    mOtpOneField.addTextChangedListener(textWatcher);
    mOtpTwoField.addTextChangedListener(textWatcher);
    mOtpThreeField.addTextChangedListener(textWatcher);
    mOtpFourField.addTextChangedListener(textWatcher);
  }

  public void simulateDeletePress() {
    mCurrentlyFocusedEditText.setText("");
  }
}
