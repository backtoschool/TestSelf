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
    private String MemberID,Email;
    private ImageView btnResultart,btnResultSci;
    private Intent objIntent;
    public static  String Result,sex;
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
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Email = extras.getString("Email");
        }
        if (extras != null) {
            MemberID = extras.getString("MemberID");
        }
        switch (v.getId()){
            case R.id.imgresultsci:
                objIntent = new Intent(ResultActivity.this,SciResultActivity.class);
                startActivity(objIntent);
                break;
            case R.id.imgResult:
                objIntent = new Intent(ResultActivity.this,ArtResultActivity.class);
                startActivity(objIntent);
                break;
        }
    }


}