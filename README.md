<h1 align="center">Android PinView/ OtpView</h1>
<p align="center">
  <a href="https://jitpack.io/#mukeshsolanki/android-otpview-pinview"><img src="https://jitpack.io/v/mukeshsolanki/android-otpview-pinview/month.svg"/></a>
  <a href="https://android-arsenal.com/api?level=11"> <img src="https://img.shields.io/badge/API-14%2B-blue.svg?style=flat" /></a>
  <a href="https://jitpack.io/#mukeshsolanki/android-otpview-pinview"> <img src="https://jitpack.io/v/mukeshsolanki/android-otpview-pinview.svg" /></a>
  <a href="https://android-arsenal.com/details/1/3764"> <img src="https://img.shields.io/badge/Android%20Arsenal-Android%20PinView%20%2F%20OtpView-brightgreen.svg?style=flat" /></a>
  <a href="https://travis-ci.org/mukeshsolanki/android-otpview-pinview"> <img src="https://travis-ci.org/mukeshsolanki/android-otpview-pinview.svg?branch=master" /></a>
  <a href="https://opensource.org/licenses/Apache-2.0"><img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://www.paypal.me/mukeshsolanki"> <img src="https://img.shields.io/badge/paypal-donate-yellow.svg" /></a>
  <br /><br />
    A custom control to enter a four digit code usually in cases of authentication.
</p>

<img src="https://raw.githubusercontent.com/mukeshsolanki/android-otpview-pinview/master/screenshots/Screenshot_20160622-201727.png" width="500" height="839" />
<br />
<img src="https://raw.githubusercontent.com/mukeshsolanki/android-otpview-pinview/master/screenshots/Screenshot_20160622-201845.png" width="500" height="839" />

## How to integrate into your app?
Integrating the project is simple a refined all you need to do is follow the below steps

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
        implementation 'com.github.mukeshsolanki:android-otpview-pinview:<latest-version>'
}
```

## How to use the library?
Okay seems like you integrated the library in your project but **how do you use it**? Well its really easy just add the following to your xml design to show the otpview

```xml
.....
<com.mukesh.OtpView
      android:id="@+id/otp_view"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:background="#cccccc"
      android:inputType="number"
      android:textColor="#FFFFFF"
      app:otp="1234"
      app:length="4"
      app:text_background_color="@color/colorAccent"
      >
</com.mukesh.OtpView>
.....
```

That's pretty much it and your all wrapped up.
