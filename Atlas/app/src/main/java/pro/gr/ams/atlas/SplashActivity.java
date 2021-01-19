package pro.gr.ams.atlas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    Intent i = new Intent(getApplicationContext(), AppActivity.class);
                    startActivity(i);
                    finish();
                }
                catch (Exception ex) {}
            }
        };
        thread.start();
    }
}
