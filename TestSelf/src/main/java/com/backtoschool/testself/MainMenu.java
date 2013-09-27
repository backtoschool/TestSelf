package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.lang.reflect.Member;

/**
 * Created by MiracleLife on 31/8/2556.
 */
public class MainMenu extends Activity implements View.OnClickListener {
    private ImageView btnPersonal, btnResult,btnStartTest;
    private Intent objIntent;
    private String MemberID,Email;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
           Email = extras.getString("Email");
        }

        //Bundle extras = getIntent().getExtras();
        if (extras != null) {
            MemberID = extras.getString("MemberID");
        }

        //Log.i("DATA",Email+ MemberID);

        initialWidget();
        btnPersonal.setOnClickListener(this);
        btnStartTest.setOnClickListener(this);
        btnResult.setOnClickListener(this);


    }

    private void initialWidget() {
       try{
           btnPersonal = (ImageView) findViewById(R.id.imgPersonal);
           btnStartTest = (ImageView) findViewById(R.id.imgStarttest);
           btnResult = (ImageView) findViewById(R.id.imgResult);
           Log.i("MainMenu", "initialWidget");
       }
       catch (Exception e){
           Log.i("MainMenu", e.toString());
       }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgPersonal:
                //objIntent = new Intent(MainMenu.this,PersonalActivity.class);
                objIntent = new Intent(MainMenu.this,PersonalDetActivity.class);
                objIntent.putExtra("Email",Email);
                //objIntent.putExtra("MemberID",MemberID);
                startActivity(objIntent);
                break;
            case R.id.imgStarttest:
                objIntent = new Intent(MainMenu.this,TestMenuActivity.class);
                objIntent.putExtra("Email",Email);
                //objIntent.putExtra("MemberID",MemberID);
                startActivity(objIntent);
                break;
            case R.id.imgResult:
                objIntent = new Intent(MainMenu.this,ResultActivity.class);
                objIntent.putExtra("Email",Email);
                //objIntent.putExtra("MemberID",MemberID);
                startActivity(objIntent);
                break;
        }

    }
}