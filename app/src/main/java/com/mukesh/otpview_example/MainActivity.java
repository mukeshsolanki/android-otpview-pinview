package com.mukesh.otpview_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.mukesh.OtpView;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button button = (Button) findViewById(R.id.delete);
    final OtpView otpView = (OtpView) findViewById(R.id.otp_view);
    assert otpView != null;
    assert button != null;
    otpView.disableKeypad();
    button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        otpView.enableKeypad();
      }
    });
  }
}
