package com.mukesh.otpview_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        OnOtpCompletionListener {
    private Button validateButton;
    private OtpView otpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUi();
        setListeners();
    }

    @Override
    public void onClick(View v) {
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

    @Override
    public void onOtpComplete(boolean completed, String otp) {
        // do Stuff
        Log.d("onOtpComplete", "completed " + completed + " , otp" + otp    );
        Toast.makeText(this, "onOtpCompleteListener called", Toast.LENGTH_SHORT).show();
    }
}
