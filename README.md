# Android PinView/ OtpView
A custom control to enter a four digit code usually in cases of authentication.

<img src=""/>
<br />
<img src=""/>

## How to integrate into your app?

Integrating the library into you app is extremely easy. A few changes in the build gradle and your all ready to use otpview. Make the following changes to build.gradle inside you app.
```java
.....
dependencies {
  ...
  compile 'com.mukesh:otpview:1.0.1'
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
      app:text_background_color="@color/colorAccent"
      >
</com.mukesh.OtpView>
.....
```

That's pretty much it and your all wrapped up.