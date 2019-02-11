<h1 align="center">Android PinView/OtpView</h1>
<p align="center">
  <a href="https://www.codacy.com/app/mukeshsolanki/android-otpview-pinview?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mukeshsolanki/android-otpview-pinview&amp;utm_campaign=Badge_Grade"><img src="https://api.codacy.com/project/badge/Grade/ea98277d42924a09b5ae9daa5d10e424"/></a>
  <a href="https://jitpack.io/#mukeshsolanki/android-otpview-pinview"> <img src="https://jitpack.io/v/mukeshsolanki/android-otpview-pinview/month.svg" /></a>
  <a href="https://jitpack.io/#mukeshsolanki/android-otpview-pinview"> <img src="https://jitpack.io/v/mukeshsolanki/android-otpview-pinview.svg" /></a>
  <a href="https://circleci.com/gh/mukeshsolanki/android-otpview-pinview/tree/master"> <img src="https://circleci.com/gh/mukeshsolanki/android-otpview-pinview/tree/master.svg?style=shield" /></a>
  <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-blue.svg"/></a>
  <br /><br />
    A custom control to enter a four digit code usually in cases of authentication.
</p>

<img src="https://raw.githubusercontent.com/mukeshsolanki/android-otpview-pinview/master/screenshots/ss1.png" width="270" height="480" /> &nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/mukeshsolanki/android-otpview-pinview/master/screenshots/ss2.png" width="270" height="480" /> &nbsp;&nbsp;
<img src="https://raw.githubusercontent.com/mukeshsolanki/android-otpview-pinview/master/screenshots/ss3.png" width="270" height="480" /> &nbsp;&nbsp;

# Supporting Android PinView/OtpView

Android PinView/OtpView is an independent project with ongoing development and support made possible thanks to donations made by [these awesome backers](BACKERS.md#sponsors). If you'd like to join them, please consider:

- [Become a backer or sponsor on Patreon](https://www.patreon.com/mukeshsolanki).
- [One-time donation via PayPal](https://www.paypal.me/mukeshsolanki)

<a href="https://www.patreon.com/bePatron?c=935498" alt="Become a Patron"><img src="https://c5.patreon.com/external/logo/become_a_patron_button.png" /></a>

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
      android:layout_marginTop="72dp"
      android:inputType="number"
      android:itemBackground="@color/colorPrimary"
      android:textColor="@android:color/white"
      app:itemCount="6"
      app:lineColor="@color/colorPrimary"
      app:viewType="line"
      />
.....
```
Add otpview style in the AppTheme
```xml
  <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
    <!-- Customize your theme here. -->
    <item name="otpViewStyle">@style/OtpWidget.OtpView</item>
  </style>
```
To get a callback when the user enters the otp make use of `OnOtpCompletionListener` like wise

```java
 private OtpView otpView;
 otpView = findViewById(R.id.otp_view);
 otpView.setListener(new OnOtpCompletionListener() {
   @Override public void onOtpCompleted(String otp) {

     // do Stuff
     Log.d("onOtpCompleted=>", otp);
   }
 });
```

That's pretty much it and your all wrapped up.

## OtpView Attributes
| Attribute | Use |
| ----------| --- |
| app:itemCount | sets the length of the otp view |
| app:itemWidth | sets the with of each item inside the otp view |
| app:itemHeight | sets the height of each item inside the otp view |
| app:itemSpacing | sets the space between each item in otp view |
| app:lineWidth | sets the line border width |
| app:lineColor | sets the color to the line border |
| app:viewType | sets the view type of the otp view it can be either `rectangle` `line` or `none` |
| app:cursorVisible | sets the visibility of the cursor |
| app:cursorColor | sets the color of the cursor |
| app:cursorWidth | sets width of the cursor |
| app:itemBackground | sets the background color of each item in the otp view |
| app:hideLineWhenFilled | toggles the line border |
| app:rtlTextDirection | toggles RTL text direction |
| app:state_filled | toggles the option fill the field after data has been entered (Style of file can we set with a drawable assigned using itemBackground |

Apart from these you can use any property that applies to an `EditText`.

## Author
Maintained by [Mukesh Solanki](https://www.github.com/mukeshsolanki)

## Contribution
[![GitHub contributors](https://img.shields.io/github/contributors/mukeshsolanki/android-otpview-pinview.svg)](https://github.com/mukeshsolanki/android-otpview-pinview/graphs/contributors)

* Bug reports and pull requests are welcome.
* Make sure you use [square/java-code-styles](https://github.com/square/java-code-styles) to format your code.

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
