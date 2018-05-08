package com.mukesh.otpview_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.mukesh.OtpListener;
import com.mukesh.OtpView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OtpListener {
  private Button mDeleteButton, mDisableKeypadButton, mEnableKeypadButton;
  private OtpView mOtpView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initializeUi();
    setListeners();
    mOtpView.setOTP("123");
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

  @Override public void onOtpEntered(String otp) {
    // do Stuff
    Log.d("onOtpEntered=>", otp);
  }

  private void initializeUi() {
    mDeleteButton = findViewById(R.id.delete);
    mDisableKeypadButton = findViewById(R.id.disable_keypad);
    mEnableKeypadButton = findViewById(R.id.enable_keypad);
    mOtpView = findViewById(R.id.otp_view);
  }

  private void setListeners() {
    mEnableKeypadButton.setOnClickListener(this);
    mDisableKeypadButton.setOnClickListener(this);
    mDeleteButton.setOnClickListener(this);
    mOtpView.setListener(this);
  }
}
