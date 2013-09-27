package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Shana on 9/27/13.
 */

public class SciHeartArtActivity extends Activity {


    private Intent objIntent;
    private String strMenberID;


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sciheartart_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            strMenberID = extras.getString("MemberID");
        }

    }


    public void onClick(){

        objIntent = new Intent(SciHeartArtActivity.this, Art1Test1Activity.class);
        objIntent.putExtra("MemberID",strMenberID);
        startActivity(objIntent);

    }



}
