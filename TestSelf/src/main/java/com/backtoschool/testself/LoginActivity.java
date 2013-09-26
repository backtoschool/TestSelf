package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PublicKey;

/**
 * Created by MiracleLife on 9/25/13.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    Button btnLogin, btnRegis;
    EditText edtEmailLogin;
    String strEmail;
    private Intent objIntent;
    public static  String MemberID,Name,Lastname,Email,Sex,Age,Result;
    /***
     *  0 = MemberID
     *  1 = Name
     *  2 = Lastname
     *  3 = Email
     *  4 = Sex
     *  5 = Age
     *  6 = Result
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        InitialWidget();
        btnRegis.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    private void InitialWidget() {
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegis = (Button) findViewById(R.id.btnLogin);
        edtEmailLogin = (EditText) findViewById(R.id.edtLogin);
    }

    @Override
    public void onClick(View v) {
        strEmail = edtEmailLogin.getText().toString().trim();
        switch (v.getId()){
            case R.id.btnLogin:
                if(strEmail!= null){
                    getDataMember(strEmail);
                    if(strEmail.equals(Email)){
                        //Intent to HomeScreen
                        objIntent = new Intent(LoginActivity.this,MainMenu.class);
                        objIntent.putExtra("Email",Email);
                        startActivity(objIntent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Email is not correct !!", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Please fill Email !!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnRegis:
                //Go to Register Page -> PersonalActivity.class
                objIntent = new Intent(LoginActivity.this,PersonalActivity.class);
                startActivity(objIntent);
                break;

        }
    }

    private void getDataMember(String strEmail) {
        // new Class DB
        final myDBClass myDb = new myDBClass(this);

        // Show Data
        String arrData[] = myDb.SelectDataMember(strEmail);
        if(arrData != null)
        {
            MemberID = arrData[0];
            Name = arrData[1];
            Lastname = arrData[2];
            Email = arrData[3];
            Sex = arrData[4];
            Age = arrData[5];
            Result = arrData[6];
        }
        //return arrData;

    }
}