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

To get a callback when the user enters the otp make use of `OtpListener` like wise

```java
 private OtpView otpView;
 otpView = findViewById(R.id.otp_view);
 otpView.setListener(new OtpListener() {
   @Override public void onOtpEntered(String otp) {

     // do Stuff
     Log.d("onOtpEntered=>", otp);
   }
 });
```

That's pretty much it and your all wrapped up.

## OtpView Attributes
| Attribute | Use |
| ----------| --- |
| android:background | sets the background color for the otp view |
| android:inputType | sets the input type for otp view, can be `text` `password` `number` |
| android:textColor | sets the text color of the edittext inside the otp view |
| app:text_background_color | sets the background color of the edittext |
| app:otp | prefills the otp in the view when loaded |
| app:length | sets the lenght of the otp |
| app:width | sets the width of the edittext inside otp view |
| app:height | sets the height of the edittext inside otp view |
| app:space | adds space on all the sides of the edittexts |
| app:space_left | adds  space to the left of the edittexts |
| app:space_right | adds space to the right of the edittexts |
| app:space_top | adds space to the top of the edittexts |
| app:space_bottom | adds space to the bottom of the edittexts |
| app:hint_color | sets the color for hint in the edittexts |
| app:hint | sets the character for hint in the edittexts |

## Author
Maintained by [Mukesh Solanki](https://www.github.com/mukeshsolanki)

## Contribution
[![GitHub contributors](https://img.shields.io/github/contributors/mukeshsolanki/android-otpview-pinview.svg)](https://github.com/mukeshsolanki/android-otpview-pinview/graphs/contributors)

* Bug reports and pull requests are welcome.
* Make sure you use [square/java-code-styles](https://github.com/square/java-code-styles) to format your code.

## License
```
Copyright 2018 Mukesh Solanki

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```