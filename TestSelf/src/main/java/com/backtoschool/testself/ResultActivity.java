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
public class ResultActivity extends Activity implements View.OnClickListener {

    private String MemberID,Email,ResultSci,ResultArt;
    private ImageView btnResultart,btnResultSci;
    private Intent objIntent;
    private int result_count=0;

    myDBClass objMyDBClass;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Email = extras.getString("Email");
            MemberID = extras.getString("MemberID");
        }

        Log.i("checkdata", Email + " : "+ MemberID);

        initialWidget();
        btnResultSci.setOnClickListener(this);
        btnResultart.setOnClickListener(this);



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

        try{

            objMyDBClass = new myDBClass(this);
            final ArrayList<HashMap<String, String>> allResultDataList = objMyDBClass.SelectDataMemberID(MemberID);


            ResultSci = allResultDataList.get(0).get("ResultScience").toString();
            ResultArt = allResultDataList.get(0).get("ResultArt").toString();

            Log.d("Database", "MemID "+MemberID+" get Sci "+ResultSci+" or Art "+ResultArt+" result");

            switch (v.getId()){
                case R.id.imgresultsci:

                    if(ResultSci.equals("none")){
                        Toast.makeText(ResultActivity.this, "ยังไม่ได้ทำแบบทดสอบวิทย์",
                        Toast.LENGTH_SHORT).show();
                        Log.d("Database", "none sci result");
                    }else{
                        objIntent = new Intent(ResultActivity.this,SciResultActivity.class);
                        objIntent.putExtra("MemberID",MemberID);
                        startActivity(objIntent);
                        Log.d("Database", "go to sci recently result");
                    }

                    break;
                case R.id.imgResult:

                    if(ResultArt.equals("none")){
                        Toast.makeText(ResultActivity.this, "ยังไม่ได้ทำแบบทดสอบศิลป์",
                        Toast.LENGTH_SHORT).show();
                        Log.d("Database", "none art result");
                    }else{
                        objIntent = new Intent(ResultActivity.this,ArtResultActivity.class);
                        objIntent.putExtra("MemberID",MemberID);
                        startActivity(objIntent);
                        Log.d("Database", "go to art recently result");
                    }

                    break;

            }

        }catch (Exception e){

            Log.d("Database", "MemID "+MemberID+" count "+result_count+" get Sci "+ResultSci+" or Art "+ResultArt+" result error " + e.toString());

        }

    }


}