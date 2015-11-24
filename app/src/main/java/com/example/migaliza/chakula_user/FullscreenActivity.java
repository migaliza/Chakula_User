package com.example.migaliza.chakula_user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);
        getSupportActionBar().setTitle("Chakula");
    }

    public void login(View view) {
        if (view == findViewById(R.id.loginbtn)) {
            TextView usernameV = (TextView) findViewById(R.id.username);
            String username = usernameV.getText().toString();
            if (username.length() < 6) {
                Toast.makeText(this, "name is at least 6 characters", Toast.LENGTH_LONG).show();
                return;
            }
            TextView passwordV = (TextView) findViewById(R.id.password);
            String password = passwordV.getText().toString();
            if (password.length() < 6) {
                Toast.makeText(this, "password is at least 6 characters", Toast.LENGTH_LONG).show();
                return;
            }

            Controller mycontrol = new Controller();
            String cmd = "login";
            String url = "http://10.10.33.36/chakula/controller/ajax-action.php?cmd=21&username="+username+"&password="+password;
            mycontrol.execute(cmd, url);
            try {
                Thread.sleep(500);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            String server_username = mycontrol.username;
            String server_password = mycontrol.password;
            int server_user_id = mycontrol.user_id;

            if (username.equals(server_username) && password.equals(server_password)) {
                Intent intent = new Intent(this, Home.class);
                intent.putExtra("name", username);
                intent.putExtra("password", password);
                intent.putExtra("user_id", server_user_id);
                startActivity(intent);
            }else{
                Toast.makeText(this, "wrong login details", Toast.LENGTH_LONG).show();
            }

        }
    }

}
