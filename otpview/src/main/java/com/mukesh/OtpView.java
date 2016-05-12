package com.mukesh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;

public class OtpView extends LinearLayout {
  private EditText mOtpOneField, mOtpTwoField, mOtpThreeField, mOtpFourField;
  private LinearLayout mRootView;

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
    LayoutInflater mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    mInflater.inflate(R.layout.otpview_layout, this);
    mOtpOneField = (EditText) findViewById(R.id.otp_one_edit_text);
    mOtpTwoField = (EditText) findViewById(R.id.otp_two_edit_text);
    mOtpThreeField = (EditText) findViewById(R.id.otp_three_edit_text);
    mOtpFourField = (EditText) findViewById(R.id.otp_four_edit_text);
    styleEditTexts(styles);
    styles.recycle();
  }

  private void styleEditTexts(TypedArray styles) {
    int textColor = styles.getColor(R.styleable.OtpView_android_textColor, Color.BLACK);
    int backgroundColor = styles.getColor(R.styleable.OtpView_text_background_color, Color.TRANSPARENT);
    if (styles.getColor(R.styleable.OtpView_text_background_color, Color.TRANSPARENT) != Color.TRANSPARENT) {
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
    mOtpOneField.setInputType(styles.getInt(R.styleable.OtpView_android_inputType, EditorInfo.TYPE_TEXT_VARIATION_NORMAL));
    String text = String.valueOf(styles.getString(R.styleable.OtpView_otp));
    if (!TextUtils.isEmpty(text) && text.length() == 4) {
      mOtpOneField.setText(String.valueOf(text.charAt(0)));
      mOtpTwoField.setText(String.valueOf(text.charAt(1)));
      mOtpThreeField.setText(String.valueOf(text.charAt(2)));
      mOtpFourField.setText(String.valueOf(text.charAt(3)));
    }
  }
}
