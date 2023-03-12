package com.mukeshsolanki.otpview_example

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mukeshsolanki.OnOtpCompletionListener
import com.mukeshsolanki.OtpView

class ViewSystemExampleActivity : AppCompatActivity(), View.OnClickListener,
  OnOtpCompletionListener {

  private var validateButton: Button? = null
  private var otpView: OtpView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_view_system_example)
    initializeUi()
    setListeners()
  }

  private fun initializeUi() {
    otpView = findViewById<OtpView>(R.id.otp_view)
    validateButton = findViewById<Button>(R.id.validate_button)
  }

  private fun setListeners() {
    validateButton!!.setOnClickListener(this)
    otpView!!.setOtpCompletionListener(this)
  }

  override fun onClick(v: View?) {
    if (v?.id == R.id.validate_button) {
      Toast.makeText(this, otpView?.text, Toast.LENGTH_SHORT).show()
    }
  }

  override fun onOtpCompleted(otp: String?) {
    Toast.makeText(this, "OnOtpCompletionListener called", Toast.LENGTH_SHORT).show()
  }
}