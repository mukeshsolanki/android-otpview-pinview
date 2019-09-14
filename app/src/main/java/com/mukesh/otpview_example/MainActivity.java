package com.mukesh.otpview_example;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
    OnOtpCompletionListener {
  private Button validateButton;
  private OtpView otpView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initializeUi();
    setListeners();
  }

  @Override public void onClick(View v) {
    if (v.getId() == R.id.validate_button) {
      Toast.makeText(this, otpView.getText(), Toast.LENGTH_SHORT).show();
    }
  }

  private void initializeUi() {
    otpView = findViewById(R.id.otp_view);
    validateButton = findViewById(R.id.validate_button);
  }

  private void setListeners() {
    validateButton.setOnClickListener(this);
    otpView.setOtpCompletionListener(this);
  }

  @Override public void onOtpCompleted(String otp) {
    // do Stuff
    Toast.makeText(this, "OnOtpCompletionListener called", Toast.LENGTH_SHORT).show();
  }
}
