package com.mukesh.otpview_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.mukesh.OtpView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private Button mDeleteButton, mDisableKeypadButton, mEnableKeypadButton;
  private OtpView mOtpView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initializeUi();
    setListeners();
    mOtpView.setOTP("1234");
  }

  @Override public void onClick(View v) {
    if (v == mDeleteButton) {
      mOtpView.simulateDeletePress();
    } else if (v == mDisableKeypadButton) {
      mOtpView.disableKeypad();
    } else if (v == mEnableKeypadButton) {
      mOtpView.enableKeypad();
    }
  }

  private void initializeUi() {
    mDeleteButton = (Button) findViewById(R.id.delete);
    mDisableKeypadButton = (Button) findViewById(R.id.disable_keypad);
    mEnableKeypadButton = (Button) findViewById(R.id.enable_keypad);
    mOtpView = (OtpView) findViewById(R.id.otp_view);
  }

  private void setListeners() {
    mEnableKeypadButton.setOnClickListener(this);
    mDisableKeypadButton.setOnClickListener(this);
    mDeleteButton.setOnClickListener(this);
  }
}
