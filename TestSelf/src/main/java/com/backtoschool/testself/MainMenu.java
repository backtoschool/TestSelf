package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by MiracleLife on 31/8/2556.
 */
public class MainMenu extends Activity implements View.OnClickListener {
    private ImageButton btnPersonal, btnResult,btnStarttest;
    private Intent objintent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        initialWidget();
        btnPersonal.setOnClickListener(this);
        btnStarttest.setOnClickListener(this);
        btnStarttest.setOnClickListener(this);

    }

    private void initialWidget() {
        btnPersonal = (ImageButton) findViewById(R.id.imgPersonal);
        btnStarttest = (ImageButton) findViewById(R.id.imgStarttest);
        btnResult = (ImageButton) findViewById(R.id.imgResult);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgPersonal:
                objintent = new Intent(MainMenu.this,PersonalActivity.class);
                startActivity(objintent);
                break;
            case R.id.imgStarttest:
                objintent = new Intent(MainMenu.this,TestMenuActivity.class);
                startActivity(objintent);
                break;
            case R.id.imgResult:
                objintent = new Intent(MainMenu.this,ResultActiviity.class);
                startActivity(objintent);
                break;
        }

    }
}