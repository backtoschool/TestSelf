package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by MiracleLife on 6/9/2556.
 */
public class ResultActivity extends Activity {
    private String MemberID,Email;
    private ImageView btnResultart,btnResultSci;
    private Intent objIntent;
    public static  String Result,sex;
    myDBClass objMyDBClass;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Email = extras.getString("Email");
            MemberID = extras.getString("MemberID");
        }

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

        objMyDBClass = new myDBClass(this);
        final ArrayList<HashMap<String, String>> SciTest1DataList = objMyDBClass.SelectDataMemberID(MemberID);

        String ResultSci = SciTest1DataList.get(0).get("ResultScience").toString();
        String ResultArt = SciTest1DataList.get(0).get("ResultArt").toString();




        switch (v.getId()){
            case R.id.imgresultsci:


                    if(ResultSci.equals("")){

                        Toast.makeText(ResultActivity.this, "ยังไม่ได้ทำแบบทดสอบสายวิทย์",
                                Toast.LENGTH_SHORT).show();

                    }else{
                        objIntent = new Intent(ResultActivity.this,SciResultActivity.class);
                        objIntent.putExtra("MemberID",MemberID);
                        startActivity(objIntent);
                    }

                break;
            case R.id.imgResult:

                if(ResultArt.equals("")){

                    Toast.makeText(ResultActivity.this, "ยังไม่ได้ทำแบบทดสอบสายศิลป์",
                            Toast.LENGTH_SHORT).show();


                }else{
                    objIntent = new Intent(ResultActivity.this,ArtResultActivity.class);
                    objIntent.putExtra("MemberID",MemberID);
                    startActivity(objIntent);
                }

                break;
        }
    }


}