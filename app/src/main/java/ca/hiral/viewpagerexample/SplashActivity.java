package ca.hiral.viewpagerexample;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashHandler();
    }


    private void splashHandler() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create a.n Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this, LayoutActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}

