package com.example.user.realcraft;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


public class RegisterActivity extends Activity {


    private Button button_submit;
    private EditText register_email;
    private EditText register_rePassword;
    private EditText register_name ;
    private EditText register_password;
    private String inputTextName;
    private String inputTextPassword;
    private String inputTextEmail;
    private String inputTextRePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisiter);
        button_submit = (Button)findViewById(R.id.register_submit);
        register_name = (EditText) findViewById(R.id.register_name);
        register_password = (EditText) findViewById(R.id.register_password);
        register_rePassword = (EditText) findViewById(R.id.register_re_password);
        register_email = (EditText) findViewById(R.id.register_email);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                inputTextName = register_name.getText().toString();
                inputTextPassword = register_password.getText().toString();
                inputTextEmail = register_email.getText().toString();
                inputTextRePassword = register_rePassword.getText().toString();
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username", inputTextName));
                params.add(new BasicNameValuePair("password", inputTextPassword));
                params.add(new BasicNameValuePair("passconf",inputTextRePassword));
                params.add(new BasicNameValuePair("email", inputTextEmail));
                String response = HttpUtil.HttpClientPOST("http://112.74.98.74/account/register",params);
                Toast.makeText(RegisterActivity.this,R.string.register_wait,Toast.LENGTH_SHORT).show();
                Log.d("Test", inputTextName);
                Log.d("Test",inputTextPassword);
                Log.d("Test",inputTextEmail);
                Log.d("Test",inputTextRePassword);
                Log.d("Test", "response" + response);
                if(response.equals("FALSE NOT_VALID")){
                    Toast.makeText(RegisterActivity.this,R.string.login_fail,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegisterActivity.this,R.string.turning,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


}
