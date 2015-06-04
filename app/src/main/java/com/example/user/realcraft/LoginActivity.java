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


public class LoginActivity extends Activity {


    private  Button button_submit;
    private Button button_register;
    private EditText login_name ;
    private EditText login_password;
    private  String inputTextName;
    private String inputTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button_submit = (Button)findViewById(R.id.login_submit);
        button_register = (Button)findViewById(R.id.turn_to_register);
        login_name = (EditText) findViewById(R.id.login_name);
        login_password = (EditText) findViewById(R.id.login_password);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                inputTextName = login_name.getText().toString();
                            inputTextPassword = login_password.getText().toString();
                            List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username",inputTextName));
                params.add(new BasicNameValuePair("password", inputTextPassword));
                Toast.makeText(LoginActivity.this,R.string.login_wait,Toast.LENGTH_SHORT).show();
                String response = HttpUtil.HttpClientPOST("http://112.74.98.74/login",params);
                Log.d("Test",inputTextName);
                Log.d("Test",inputTextPassword);
                Log.d("Test", "response" + response);
                if((response.equals("FALSE NOT_VALID"))){
                    Toast.makeText(LoginActivity.this,R.string.login_fail,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this,R.string.turning,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


}
