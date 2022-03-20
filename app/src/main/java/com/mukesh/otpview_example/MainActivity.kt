package com.mukesh.otpview_example

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mukesh.OTP_VIEW_TYPE_BORDER
import com.mukesh.OTP_VIEW_TYPE_UNDERLINE
import com.mukesh.OtpView
import com.mukesh.otpview_example.ui.theme.ComposeOTPViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOTPViewTheme {
                var otpValue by remember { mutableStateOf("") }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF3F51B5)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Verification Code",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                    Text(
                        modifier = Modifier.padding(32.dp),
                        textAlign = TextAlign.Center,
                        text = "Please type the verification code sent to +xxxxxxxxxxxx",
                        color = Color.White,
                    )
                    OtpView(
                        otpText = otpValue,
                        onOtpTextChange = {
                            otpValue = it
                            Log.d("Actual Value", otpValue)
                        },
                        type = OTP_VIEW_TYPE_BORDER,
                        password = true,
                        containerSize = 48.dp,
                        passwordChar = "•",
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        charColor = Color.White
                    )

                    TextButton(modifier = Modifier.padding(32.dp), onClick = {
                        if (otpValue == "1234") {
                            Toast.makeText(this@MainActivity, "OTP is correct", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            Toast.makeText(this@MainActivity, "OTP is wrong", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }) {
                        Text(text = "Validate", color = Color.White)
                    }
                }
            }
        }
    }
}