package com.mukesh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class OtpView extends LinearLayout {
  private EditText currentlyFocusedEditText;
  private List<EditText> editTexts = new ArrayList<>();
  private int length;

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
    styleEditTexts(styles);
    styles.recycle();
  }

  /**
   * Get an instance of the present otp
   */
  private String makeOTP() {
    StringBuilder stringBuilder = new StringBuilder();
    for (EditText editText : editTexts) {
      stringBuilder.append(editText.getText());
    }
    return stringBuilder.toString();
  }

  /**
   * Checks if all four fields have been filled
   *
   * @return length of OTP
   */
  public boolean hasValidOTP() {
    return makeOTP().length() == length;
  }

  /**
   * Returns the present otp entered by the user
   *
   * @return OTP
   */
  public String getOTP() {
    return makeOTP();
  }

  /**
   * Used to set the OTP. More of cosmetic value than functional value
   *
   * @param otp Send the four digit otp
   */
  public void setOTP(String otp) {
    if (otp.length() != length) {
      throw new IllegalArgumentException("Otp Size is different from the OtpView size");
    } else {
      for (int i = 0; i < editTexts.size(); i++) {
        editTexts.get(i).setText(String.valueOf(otp.charAt(i)));
      }
      currentlyFocusedEditText = editTexts.get(length - 1);
      currentlyFocusedEditText.requestFocus();
    }
  }

  private void styleEditTexts(TypedArray styles) {
    length = styles.getInt(R.styleable.OtpView_length, 4);
    generateViews(styles);
  }

  private void generateViews(TypedArray styles) {
    if (length > 0) {
      for (int i = 0; i < length; i++) {
        EditText editText = new EditText(getContext());
        editText.setId(i);
        editText.setSingleLine();
        editText.setMaxLines(1);
        editText.setFilters((new InputFilter[] { getFilter(), new InputFilter.LengthFilter(1) }));
        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(getPixels(16), getPixels(16), getPixels(16), getPixels(16));
        editText.setLayoutParams(params);
        int textColor = styles.getColor(R.styleable.OtpView_android_textColor, Color.BLACK);
        int backgroundColor =
            styles.getColor(R.styleable.OtpView_text_background_color, Color.TRANSPARENT);
        if (backgroundColor != Color.TRANSPARENT) {
          editText.setBackgroundColor(backgroundColor);
        } else {
          editText.getBackground().mutate().setColorFilter(textColor, PorterDuff.Mode.SRC_ATOP);
        }
        editText.setTextColor(textColor);
        editText.setInputType(styles.getInt(R.styleable.OtpView_android_inputType,
            EditorInfo.TYPE_TEXT_VARIATION_NORMAL));
        setFocusListener(editText);
        setOnTextChangeListener(editText);
        addView(editText, i);
        editTexts.add(editText);
      }
    } else {
      throw new IllegalStateException("Please specify the length of the otp view");
    }
  }

  private InputFilter getFilter() {
    return new InputFilter() {
      @Override
      public CharSequence filter(CharSequence source, int start, int end, Spanned dest,
          int dstart, int dend) {
        for (int i = start; i < end; ++i) {
          if (!Pattern.compile(
              "[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890]*")
              .matcher(String.valueOf(source.charAt(i)))
              .matches()) {
            return "";
          }
        }
        return null;
      }
    };
  }

  private int getPixels(int valueInDp) {
    Resources r = getResources();
    float px =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, r.getDisplayMetrics());
    return (int) px;
  }

  private void setFocusListener(EditText editText) {
    View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
      @Override public void onFocusChange(View v, boolean hasFocus) {
        currentlyFocusedEditText = (EditText) v;
        currentlyFocusedEditText.setSelection(currentlyFocusedEditText.getText().length());
      }
    };
    editText.setOnFocusChangeListener(onFocusChangeListener);
  }

  @SuppressLint("ClickableViewAccessibility") public void disableKeypad() {
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
    for (EditText editText : editTexts) {
      editText.setOnTouchListener(touchListener);
    }
  }

  @SuppressLint("ClickableViewAccessibility") public void enableKeypad() {
    OnTouchListener touchListener = new OnTouchListener() {
      @Override public boolean onTouch(View v, MotionEvent event) {
        return false;
      }
    };
    for (EditText editText : editTexts) {
      editText.setOnTouchListener(touchListener);
    }
  }

  public EditText getCurrentFoucusedEditText() {
    return currentlyFocusedEditText;
  }

  private void setOnTextChangeListener(EditText editText) {

    TextWatcher textWatcher = new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
      }

      @Override public void afterTextChanged(Editable s) {
        int length = currentlyFocusedEditText.getText().length();
        InputMethodManager imm =
            (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (length == 0) {
          if (currentlyFocusedEditText == editTexts.get(0)) {
            if (imm != null) {
              imm.hideSoftInputFromWindow(getWindowToken(), 0);
            }
          } else {
            if (currentlyFocusedEditText.focusSearch(View.FOCUS_LEFT) != null) {
              currentlyFocusedEditText.focusSearch(View.FOCUS_LEFT).requestFocus();
            }
          }
        } else if (length == 1) {
          if (currentlyFocusedEditText == editTexts.get(editTexts.size() - 1)) {
            if (imm != null) {
              imm.hideSoftInputFromWindow(getWindowToken(), 0);
            }
          } else {
            if (currentlyFocusedEditText.focusSearch(View.FOCUS_RIGHT) != null) {
              currentlyFocusedEditText.focusSearch(View.FOCUS_RIGHT).requestFocus();
            }
          }
        }
      }
    };
    editText.addTextChangedListener(textWatcher);
  }

  public void simulateDeletePress() {
    currentlyFocusedEditText.setText("");
  }
}
