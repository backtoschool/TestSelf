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



/*
    public void onClickSci(View view){


        objMyDBClass = new myDBClass(this);
        final ArrayList<HashMap<String, String>> SciTest1DataList = objMyDBClass.SelectDataMemberID(MemberID);

        String ResultSci = SciTest1DataList.get(0).get("ResultScience").toString();


        if(ResultSci.equals("")){

            Log.d("Database", "no sci result");

            Toast.makeText(ResultActivity.this, "ยังไม่ได้ทำแบบทดสอบสายวิทย์",
                    Toast.LENGTH_SHORT).show();

        }else{
            objIntent = new Intent(ResultActivity.this,SciResultActivity.class);
            objIntent.putExtra("MemberID",MemberID);
            startActivity(objIntent);

            Log.d("Database", "go to sci result");

        }

    }


    public void onClickArt(View view){


        objMyDBClass = new myDBClass(this);
        final ArrayList<HashMap<String, String>> SciTest1DataList = objMyDBClass.SelectDataMemberID(MemberID);

        String ResultArt = SciTest1DataList.get(0).get("ResultArt").toString();


        if(ResultArt.equals("")){

            Log.d("Database", "no art result");

            Toast.makeText(ResultActivity.this, "ยังไม่ได้ทำแบบทดสอบสายศิลป์",
                    Toast.LENGTH_SHORT).show();

        }else{
            objIntent = new Intent(ResultActivity.this,ArtResultActivity.class);
            objIntent.putExtra("MemberID",MemberID);
            startActivity(objIntent);

            Log.d("Database", "go to art result");

        }


    }
*/

    private String ResultSci, ResultArt, test;

    private int result_count=0;

    public void onClick(View v) {


        try{

            objMyDBClass = new myDBClass(this);
            final ArrayList<HashMap<String, String>> allResultDataList = objMyDBClass.SelectDataMemberID(MemberID);

            result_count = allResultDataList.size();

           if(result_count==0){
                Toast.makeText(ResultActivity.this, "ยังไม่ได้ทำแบบทดสอบ",
                        Toast.LENGTH_SHORT).show();

            }else{

               ResultSci = allResultDataList.get(0).get("ResultScience").toString();
               ResultArt = allResultDataList.get(0).get("ResultArt").toString();

                switch (v.getId()){
                    case R.id.imgresultsci:
                        objIntent = new Intent(ResultActivity.this,SciResultActivity.class);
                        objIntent.putExtra("MemberID",MemberID);
                        startActivity(objIntent);
                        break;
                    case R.id.imgResult:
                        objIntent = new Intent(ResultActivity.this,ArtResultActivity.class);
                        objIntent.putExtra("MemberID",MemberID);
                        startActivity(objIntent);
                        break;
                }

            }





            //Log.i("Data",ResultSci + " : " + ResultArt);

            //if(ResultSci.equals(null)){

            //    Toast.makeText(ResultActivity.this, "ยังไม่ได้ทำแบบทดสอบสายวิทย์",
            //    Toast.LENGTH_SHORT).show();

            //}else if(ResultArt.equals(null)){

            //    Toast.makeText(ResultActivity.this, "ยังไม่ได้ทำแบบทดสอบสายศิลป์",
            //    Toast.LENGTH_SHORT).show();

            //}else{


            //    }

           // }

        }catch (Exception e){

            Log.d("Database", "MemID "+MemberID+" get "+ResultSci+" or "+ResultArt+" result error "  + e.toString());

        }


    }


}