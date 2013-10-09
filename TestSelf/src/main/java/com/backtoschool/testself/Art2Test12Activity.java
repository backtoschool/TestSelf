package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by MiracleLife on 7/9/2556.
 */
public class Art2Test12Activity extends Activity {

    //Cerate By KAE 21/9/2556
    public static int score1,score2,score3,score4,score5,score6,score7,score8,score9,score10,score11,score12,sum;
    private RadioButton rad1, rad2, rad3, rad4;
    private String strAns,strMenberID;
    private myDBClass objMyDBClass;

    private Intent objIntent;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.art2test12_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            strMenberID = extras.getString("MemberID");
        }
        initialWidget();

    }


    public void initialWidget(){

        rad1 = (RadioButton) findViewById(R.id.radioButton);
        rad2 = (RadioButton) findViewById(R.id.radioButton2);
        rad3 = (RadioButton) findViewById(R.id.radioButton3);
        rad4 = (RadioButton) findViewById(R.id.radioButton4);
    }


    public void onClickNext(View view){


        try{

            if(rad1.isChecked()){

                strAns = "1";

            }else if(rad2.isChecked()){

                strAns = "2";

            }else if(rad3.isChecked()){

                strAns = "3";

            }else if(rad4.isChecked()){

                strAns = "4";

            }


            if(strAns.equals("")){

                Log.d("Database", "Have Check Button !!!!!");

                Toast.makeText(Art2Test12Activity.this, "กรุณาเลือกคำตอบด้วยค่ะ",
                        Toast.LENGTH_SHORT).show();


            }else{

                UpdateDataSQLite();

                objIntent = new Intent(Art2Test12Activity.this, ArtResultActivity.class);
                objIntent.putExtra("MemberID",strMenberID);
                startActivity(objIntent);

            }


        }catch (Exception e){

            Log.d("Database", "Art2Test12Activity Error " + e.toString());

        }

    }


    public void UpdateDataSQLite(){

        try{

        objMyDBClass = new myDBClass(this);
        long insertID = objMyDBClass.Update_Data_artscore_t2(strMenberID,null,null,null,null,null,null,null,null,null,null,strAns,null);

        final ArrayList<HashMap<String, String>> Art2DataList = objMyDBClass.SelectDataArt2(strMenberID);

        score1 = Integer.valueOf(Art2DataList.get(0).get("Q1").toString());
        score2 = Integer.valueOf(Art2DataList.get(0).get("Q2").toString());
        score3 = Integer.valueOf(Art2DataList.get(0).get("Q3").toString());
        score4 = Integer.valueOf(Art2DataList.get(0).get("Q4").toString());
        score5 = Integer.valueOf(Art2DataList.get(0).get("Q5").toString());
        score6 = Integer.valueOf(Art2DataList.get(0).get("Q6").toString());
        score7 = Integer.valueOf(Art2DataList.get(0).get("Q7").toString());
        score8 = Integer.valueOf(Art2DataList.get(0).get("Q8").toString());
        score9 = Integer.valueOf(Art2DataList.get(0).get("Q9").toString());
        score10 = Integer.valueOf(Art2DataList.get(0).get("Q10").toString());
        score11 = Integer.valueOf(Art2DataList.get(0).get("Q11").toString());
        score12 = Integer.valueOf(Art2DataList.get(0).get("Q12").toString());

        sum = score1+score2+score3+score4+score5+score6+score7+score8+score9+score10+score11+score12;

        csFunction fun = new csFunction();
        String Test2Result = fun.ArtResult2(sum); // result art test2

        // get result art test 1
        final ArrayList<HashMap<String, String>> Art1DataList = objMyDBClass.SelectDataArt1(strMenberID);
        String Test1Result = Art1DataList.get(0).get("ResultType").toString(); // result test1

        String result = Test2Result+Test1Result;

        // insert result test2 in art2 database
        long insert_result_test2 = objMyDBClass.Update_Data_artscore_t2(strMenberID,null,null,null,null,null,null,null,null,null,null,null,result);

        // insert result test2 in member database
        long insert_result_member = objMyDBClass.Update_Data_Member(strMenberID,null,null,null,null,null,null,result);

        Log.d("Database", "art total " + sum + " art result " + result);

        }catch (Exception e){

            Log.d("Database", "Art2Test12Activity "+sum+" UpdateDataSQLite Error " + e.toString());

        }

    }

}