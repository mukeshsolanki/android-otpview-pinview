package com.mukeshsolanki

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val OTP_VIEW_TYPE_NONE = 0
const val OTP_VIEW_TYPE_UNDERLINE = 1
const val OTP_VIEW_TYPE_BORDER = 2

@Composable
fun OtpView(
    otpText: String,
    modifier: Modifier = Modifier,
    charColor: Color = Color.Black,
    containerColor: Color = charColor,
    selectedContainerColor: Color = charColor,
    charBackground: Color = Color.Transparent,
    charSize: TextUnit = 16.sp,
    containerSize: Dp = charSize.value.dp * 2,
    containerRadius: Dp = 4.dp,
    containerSpacing: Dp = 4.dp,
    otpCount: Int = 4,
    type: Int = OTP_VIEW_TYPE_UNDERLINE,
    enabled: Boolean = true,
    password: Boolean = false,
    passwordChar: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    onOtpTextChange: (String) -> Unit
) {
    BasicTextField(
        modifier = modifier,
        value = otpText,
        onValueChange = {
            if (it.length <= otpCount) {
                onOtpTextChange.invoke(it)
            }
        },
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        decorationBox = {
            Row(horizontalArrangement = Arrangement.spacedBy(containerSpacing)) {
                repeat(otpCount) { index ->
                    CharView(
                        index = index,
                        otpCount = otpCount,
                        text = otpText,
                        charColor = charColor,
                        containerColor = containerColor,
                        highlightColor = selectedContainerColor,
                        charSize = charSize,
                        containerRadius = containerRadius,
                        containerSize = containerSize,
                        type = type,
                        charBackground = charBackground,
                        password = password,
                        passwordChar = passwordChar,
                    )
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    otpCount: Int,
    text: String,
    charColor: Color,
    highlightColor: Color,
    containerColor: Color,
    charSize: TextUnit,
    containerSize: Dp,
    containerRadius: Dp,
    type: Int = OTP_VIEW_TYPE_UNDERLINE,
    charBackground: Color = Color.Transparent,
    password: Boolean = false,
    passwordChar: String = ""
) {

    val containerColor2 =
        if (index == text.length || (index == otpCount - 1 && text.length == otpCount)) highlightColor else containerColor

    val modifier = if (type == OTP_VIEW_TYPE_BORDER) {
        Modifier
            .size(containerSize)
            .border(
                width = 1.dp,
                color = containerColor2,
                shape = RoundedCornerShape(containerRadius)
            )
            .padding(bottom = 4.dp)
            .clip(RoundedCornerShape(containerRadius))
            .background(charBackground)
    } else Modifier
        .width(containerSize)
        .background(charBackground)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val char = when {
            index >= text.length -> ""
            password -> passwordChar
            else -> text[index].toString()
        }
        Text(
            text = char,
            color = charColor,
            modifier = modifier.wrapContentHeight(),
            style = MaterialTheme.typography.body1,
            fontSize = charSize,
            textAlign = TextAlign.Center,
        )
        if (type == OTP_VIEW_TYPE_UNDERLINE) {
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = Modifier
                    .background(charColor)
                    .height(1.dp)
                    .width(containerSize)
            )
        }
    }
}