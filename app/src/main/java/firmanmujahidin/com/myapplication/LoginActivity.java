package firmanmujahidin.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText userName;
    private EditText password;
    private Button buttonSave;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        buttonSave.setOnClickListener(this);
        progressBar.setVisibility(View.GONE);
    }

    private boolean userLogin(){
        String user = userName.getText().toString().trim();
        String pass = password.getText().toString().trim();
        boolean isValid = true;

        if (TextUtils.isEmpty(user)){
            Toast.makeText(this, "Masukan Email Anda", Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        if (TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Masukan Password Anda", Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        return isValid;
    }




    @Override
    public void onClick(View v) {
        if (v == buttonSave){
            if (userLogin()){
                progressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }else {
                progressBar.setVisibility(View.GONE);

            }
        }
    }
}
