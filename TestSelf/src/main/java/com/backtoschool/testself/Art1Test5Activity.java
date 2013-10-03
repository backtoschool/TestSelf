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
public class Art1Test5Activity extends Activity {
    public static int score1,score2,score3,score4,score5,score6,score7,score8,score9,score10,score11,score12,sum;
    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4, radChoice5, radChoice6;
    private String strAns = "",strMenberID;
    private myDBClass objMyDBClass;

    private Intent objIntent;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.art1test5_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            strMenberID = extras.getString("MemberID");
        }
        initialWidget();

    }


    public void initialWidget(){

        radChoice1 = (RadioButton) findViewById(R.id.radioButton);
        radChoice2 = (RadioButton) findViewById(R.id.radioButton2);
        radChoice3 = (RadioButton) findViewById(R.id.radioButton3);
        radChoice4 = (RadioButton) findViewById(R.id.radioButton4);

    }


    public void onClickNext(View view){


        try{

            if(radChoice1.isChecked()){

                strAns = "4";

            }else if(radChoice2.isChecked()){

                strAns = "3";

            }else if(radChoice3.isChecked()){

                strAns = "3";

            }else if(radChoice4.isChecked()){

                strAns = "0";

            }


            if(strAns.equals("")){

                Log.d("Database", "Have Check Button !!!!!");

                Toast.makeText(Art1Test5Activity.this, "กรุณาเลือกคำตอบด้วยค่ะ",
                        Toast.LENGTH_SHORT).show();


            }else{



                UpdateDataSQLite();

                objIntent = new Intent(Art1Test5Activity.this, Art2Test1Activity.class);
                objIntent.putExtra("MemberID",strMenberID);
                startActivity(objIntent);

            }


        }catch (Exception e){

            Log.d("Database", "Art1Test5Activity Error " + e.toString());

        }

    }


    public void UpdateDataSQLite(){

        objMyDBClass = new myDBClass(this);
        //csFunction fun = new csFunction();
        //String result = fun.ArtResult1(strMenberID);
        final myDBClass objMyDBClass = new myDBClass(this);
        long insertID = objMyDBClass.Update_Data_artscore_t1(strMenberID, null, null, null, strAns, null);

        Log.d("Database", "Art1Test5Activity insert DB Success !!!!!" + strAns);


        // cal resulte of test
        final ArrayList<HashMap<String, String>> Art1DataList = objMyDBClass.SelectDataArt1(strMenberID);

        score1 = Integer.valueOf(Art1DataList.get(0).get("Q1").toString()) ;
        score2 = Integer.valueOf(Art1DataList.get(0).get("Q2").toString()) ;
        score3 = Integer.valueOf(Art1DataList.get(0).get("Q3").toString()) ;
        score4 = Integer.valueOf(Art1DataList.get(0).get("Q4").toString()) ;
        score5 = Integer.valueOf(Art1DataList.get(0).get("Q5").toString()) ;

        sum = score1+score2+score3+score4+score5;

        csFunction fun = new csFunction();
        String result = fun.ArtResult1(sum);

        long insertID_resulte = objMyDBClass.Update_Data_artscore_t1(strMenberID, null, null, null, null, result);

        Log.d("Database", "art total "+ sum +" result " + result);

    }
}