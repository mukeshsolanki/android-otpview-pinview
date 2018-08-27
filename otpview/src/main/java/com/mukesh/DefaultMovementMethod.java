package com.mukesh;

/*
 * Copyright 2018 Mukesh Solanki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.text.Selection;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Used to disable arrow key
 *
 * @author Mukesh Solanki
 * 31/03/2018
 */
class DefaultMovementMethod implements MovementMethod {

  private static DefaultMovementMethod sInstance;

  public static MovementMethod getInstance() {
    if (sInstance == null) {
      sInstance = new DefaultMovementMethod();
    }

    return sInstance;
  }

  private DefaultMovementMethod() {
  }

  @Override
  public void initialize(TextView widget, Spannable text) {
    Selection.setSelection(text, 0);
  }

  @Override
  public boolean onKeyDown(TextView widget, Spannable text, int keyCode, KeyEvent event) {
    return false;
  }

  @Override
  public boolean onKeyUp(TextView widget, Spannable text, int keyCode, KeyEvent event) {
    return false;
  }

  @Override
  public boolean onKeyOther(TextView view, Spannable text, KeyEvent event) {
    return false;
  }

  @Override
  public void onTakeFocus(TextView widget, Spannable text, int direction) {
    //Intentionally Empty
  }

  @Override
  public boolean onTrackballEvent(TextView widget, Spannable text, MotionEvent event) {
    return false;
  }

  @Override
  public boolean onTouchEvent(TextView widget, Spannable text, MotionEvent event) {
    return false;
  }

  @Override
  public boolean onGenericMotionEvent(TextView widget, Spannable text, MotionEvent event) {
    return false;
  }

  @Override
  public boolean canSelectArbitrarily() {
    return false;
  }
}