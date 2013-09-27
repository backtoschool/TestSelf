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
                objIntent = new Intent(ResultActivity.this,PersonalActivity.class);
                startActivity(objIntent);
                break;
            case R.id.imgResult:
                getDataMember(MemberID);
                if(MemberID.equals(Result))
                {
                    if (Result == "1A")
                    {
                        if(sex == "male")
                            objIntent = new Intent(ResultActivity.this,Art1Result1MaleActivity.class);
                        else
                            objIntent = new Intent(ResultActivity.this,Art1Result1FemaleActivity.class);

                        startActivity(objIntent);
                    }
                }
                break;
        }

    }

    private void getDataMember(String strID) {
        // new Class DB
        final myDBClass myDb = new myDBClass(this);

        // Show Data
        String arrData[] = myDb.SelectDataArt1(strID);
        if(arrData != null)
        {
            Result = arrData[6];
        }

        final myDBClass myDb2 = new myDBClass(this);
        // Show Data
        String arrData2[] = myDb.SelectDataMember(strID);
        if(arrData != null)
        {
            sex = arrData[4];
        }
        //return arrData;

    }
}