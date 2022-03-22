<h1 align="center">Compose OtpView/PinView</h1>
<p align="center">
  <a href="https://www.codacy.com/app/mukeshsolanki/android-otpview-pinview?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mukeshsolanki/android-otpview-pinview&amp;utm_campaign=Badge_Grade"><img src="https://api.codacy.com/project/badge/Grade/ea98277d42924a09b5ae9daa5d10e424"/></a>
  <a href="https://jitpack.io/#mukeshsolanki/android-otpview-pinview"> <img src="https://jitpack.io/v/mukeshsolanki/android-otpview-pinview/month.svg" /></a>
  <a href="https://jitpack.io/#mukeshsolanki/android-otpview-pinview"> <img src="https://jitpack.io/v/mukeshsolanki/android-otpview-pinview.svg" /></a>
  <a href="https://github.com/mukeshsolanki/android-otpview-pinview/actions"> <img src="https://github.com/mukeshsolanki/android-otpview-pinview/workflows/Build/badge.svg" /></a>
  <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-blue.svg"/></a>
  <br /><br />
    A custom control to enter a code usually in cases of authentication.
</p>

<img src="https://raw.githubusercontent.com/mukeshsolanki/android-otpview-pinview/main/screenshots/ss1.png"/> &nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/mukeshsolanki/android-otpview-pinview/main/screenshots/ss2.png" /> &nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/mukeshsolanki/android-otpview-pinview/main/screenshots/ss3.png" /> &nbsp;&nbsp;

# Supporting Compose OtpView/PinView

Compose PinView/OtpView is an independent project with ongoing development and support made possible thanks to your donations.
- [Become a backer](https://www.paypal.me/mukeshsolanki)

## How to integrate into your app?
Integrating the project is simple. All you need to do is follow the below steps

Step 1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:

```java
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
```
Step 2. Add the dependency
```java
dependencies {
        implementation 'com.github.mukeshsolanki:android-otpview-pinview:3.0.0'
}
```

## How to use the library?
Okay seems like you integrated the library in your project but **how do you use it**? Well its really easy.
- Using Compose
Just use the `OtpView` composable where you need to display the view like.
```kotlin
....
var otpValue by remember { mutableStateOf("") }
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
....
```
- Using Older View System (aka XML)
Add a compose view in your xml file like
```xml
.....
<androidx.compose.ui.platform.ComposeView
    android:id="@+id/otp_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
.....
```
Next in your code assign `otp_view` with the `OtpView` composable likewise.
```kotlin
....
val otpView = findViewById(R.id.otp_view)
otpView.composeView.apply {
    // Dispose of the Composition when the view's LifecycleOwner is destroyed
    setViewCompositionStrategy(DisposeOnViewTreeLifecycleDestroyed)
    setContent {
       // In Compose world
       MaterialTheme {
           var otpValue by remember { mutableStateOf("") }
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
       }
    }
}
....
```
That's pretty much it and your all wrapped up.

## Author
Maintained by [Mukesh Solanki](https://www.github.com/mukeshsolanki)

## Contribution
[![GitHub contributors](https://img.shields.io/github/contributors/mukeshsolanki/android-otpview-pinview.svg)](https://github.com/mukeshsolanki/android-otpview-pinview/graphs/contributors)

* Bug reports and pull requests are welcome.

## License
```
MIT License

Copyright (c) 2018 Mukesh Solanki

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
