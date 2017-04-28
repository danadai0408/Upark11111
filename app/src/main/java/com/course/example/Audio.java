package com.course.example;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class Audio extends Activity {
   private MediaPlayer up, down, left, right, enter;
   private MediaPlayer a, s, d, f, g, h, j, x, y, z;
   private MediaPlayer mp;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);

      // Native rate is 44.1kHz 16 bit stereo, but
      // to save space some files just use MPEG-3 22kHz mono
      up = MediaPlayer.create(this, R.raw.up);
      down = MediaPlayer.create(this, R.raw.down);
      left = MediaPlayer.create(this, R.raw.left);
      right = MediaPlayer.create(this, R.raw.right);
      enter = MediaPlayer.create(this, R.raw.enter);
      a = MediaPlayer.create(this, R.raw.a);
      s = MediaPlayer.create(this, R.raw.s);
      d = MediaPlayer.create(this, R.raw.d);
      f = MediaPlayer.create(this, R.raw.f);
      g = MediaPlayer.create(this, R.raw.tone440hz);
      h = MediaPlayer.create(this, R.raw.tone1000hz);
      j = MediaPlayer.create(this, R.raw.bobmarley);
      y = MediaPlayer.create(this, R.raw.a4);
      z = MediaPlayer.create(this, R.raw.haunted);
   }

   @Override
   public boolean onKeyDown(int keyCode, KeyEvent event) {

      switch (keyCode) {
      case KeyEvent.KEYCODE_DPAD_UP:
         mp = up;
         break;
      case KeyEvent.KEYCODE_DPAD_DOWN:
         mp = down;
         break;
      case KeyEvent.KEYCODE_DPAD_LEFT:
         mp = left;
         break;
      case KeyEvent.KEYCODE_DPAD_RIGHT:
         mp = right;
         break;
      case KeyEvent.KEYCODE_DPAD_CENTER:
      case KeyEvent.KEYCODE_ENTER:
         mp = enter;
         break;
      case KeyEvent.KEYCODE_A:
         mp = a;
         break;
      case KeyEvent.KEYCODE_S:
         mp = s;
         break;
      case KeyEvent.KEYCODE_D:
         mp = d;
         break;
      case KeyEvent.KEYCODE_F:
         mp = f;
         break;
      case KeyEvent.KEYCODE_G:
          mp = g;
          break;
      case KeyEvent.KEYCODE_H:
          mp = h;
          break;
      case KeyEvent.KEYCODE_J:
          mp = j;
          break;
      case KeyEvent.KEYCODE_Y:
          mp = y;
          break;
      case KeyEvent.KEYCODE_Z:
          mp = z;
          break;
      case KeyEvent.KEYCODE_X:
    	  Toast.makeText(this, "Stop audio", Toast.LENGTH_LONG).show();
    	  mp.stop();
    	  return true;
      default:
         return super.onKeyDown(keyCode, event);
      }
      mp.seekTo(0); 
      mp.start();
      return true;
   }
}
