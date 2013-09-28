package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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


    public void onClick(View view){

        try{

            objIntent = new Intent(SciHeartArtActivity.this, Art1Test1Activity.class);
            objIntent.putExtra("MemberID",strMenberID);
            startActivity(objIntent);

            Log.d("Database", "go to art test");

        }catch (Exception e){

            Log.d("Database", "invalidate go to art test");

        }

    }

}
