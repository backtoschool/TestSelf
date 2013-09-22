package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by MiracleLife on 31/8/2556.
 */
public class MainMenu extends Activity implements View.OnClickListener {
    private ImageView btnPersonal, btnResult,btnStartTest;
    private Intent objIntent;
    //Database
    SQLiteDatabase db;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        try{
            //Database Create
            myDBClass myDb = new myDBClass(this);
            myDb.getWritableDatabase();//First method
            //End Database
        }
        catch (Exception e){
            Log.i("DB",e.toString());

        }



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
                objIntent = new Intent(MainMenu.this,PersonalActivity.class);
                //objIntent = new Intent(MainMenu.this,PersonalDetActivity.class);
                startActivity(objIntent);
                break;
            case R.id.imgStarttest:
                objIntent = new Intent(MainMenu.this,TestMenuActivity.class);
                startActivity(objIntent);
                break;
            case R.id.imgResult:
                objIntent = new Intent(MainMenu.this,ResultActivity.class);
                startActivity(objIntent);
                break;
        }

    }
}