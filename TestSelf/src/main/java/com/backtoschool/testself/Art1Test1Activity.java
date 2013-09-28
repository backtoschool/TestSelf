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
public class Art1Test1Activity extends Activity {
    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4, radChoice5, radChoice6;
    private String strAns = "",strMenberID;
    private myDBClass objMyDBClass;

    private Intent objIntent;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.art1test1_layout);
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

                strAns = "4";

            }else if(radChoice3.isChecked()){

                strAns = "2";

            }else if(radChoice4.isChecked()){

                strAns = "0";

            }


            if(strAns.equals("")){

                Log.d("insertDB", "Have Check Button !!!!!");

                Toast.makeText(Art1Test1Activity.this, "กรุณาเลือกคำตอบด้วยค่ะ",
                        Toast.LENGTH_SHORT).show();


            }else{

                Log.d("insertDB", "insert DB Success !!!!!" + strAns);

                UpdateDataSQLite();

                objIntent = new Intent(Art1Test1Activity.this, Art1Test2Activity.class);
                objIntent.putExtra("MemberID",strMenberID);
                startActivity(objIntent);

            }


        }catch (Exception e){

            Log.d("insertDB", "Art1Test1Activity Error " + e.toString());

        }

    }


    public void UpdateDataSQLite(){

        objMyDBClass = new myDBClass(this);

        final ArrayList<HashMap<String, String>> Art1DataList = objMyDBClass.SelectDataArt1(strMenberID);
        if(Art1DataList.get(0).get("id").toString().equals(""))
        {
            long insertID = objMyDBClass.Update_Data_artscore_t1(strMenberID, strAns,null,null,null,null,null);
        }
        else
        {
            long insertID = objMyDBClass.Insert_Data_artscore_t1(strMenberID, strAns);
        }


    }
}