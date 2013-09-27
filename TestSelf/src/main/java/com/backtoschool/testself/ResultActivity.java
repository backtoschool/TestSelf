package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by MiracleLife on 6/9/2556.
 */
public class ResultActivity extends Activity {
    private ImageView btnResultart,btnResultSci;
    private Intent objIntent;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
        initialWidget();
    }

    private void initialWidget() {
        try{
            btnResultSci = (ImageView) findViewById(R.id.imgresultsci);
            btnResultart = (ImageView) findViewById(R.id.imgResult);
        }
        catch (Exception e){
            Log.i("Result", e.toString());
        }
    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgresultsci:
                objIntent = new Intent(ResultActivity.this,PersonalActivity.class);
                startActivity(objIntent);
                break;
            case R.id.imgResult:
                objIntent = new Intent(ResultActivity.this,TestMenuActivity.class);
                startActivity(objIntent);
                break;
        }

    }
}