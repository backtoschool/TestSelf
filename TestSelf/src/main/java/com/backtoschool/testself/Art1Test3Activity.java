package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by MiracleLife on 7/9/2556.
 */
public class Art1Test3Activity extends Activity {

    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4, radChoice5, radChoice6;
    private String strAns = "",strMenberID;
    private myDBClass objMyDBClass;

    private Intent objIntent;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.art1test3_layout);
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

                strAns = "0";

            }else if(radChoice2.isChecked()){

                strAns = "2";

            }else if(radChoice3.isChecked()){

                strAns = "3";

            }else if(radChoice4.isChecked()){

                strAns = "4";

            }


            if(strAns.equals("")){

                Log.d("Database", "Have Check Button !!!!!");

                Toast.makeText(Art1Test3Activity.this, "กรุณาเลือกคำตอบด้วยค่ะ",
                        Toast.LENGTH_SHORT).show();


            }else{



                UpdateDataSQLite();

                objIntent = new Intent(Art1Test3Activity.this, Art1Test4Activity.class);
                objIntent.putExtra("MemberID",strMenberID);
                startActivity(objIntent);

            }


        }catch (Exception e){

            Log.d("Database", "Art1Test3Activity Error " + e.toString());

        }

    }


    public void UpdateDataSQLite(){

        objMyDBClass = new myDBClass(this);
        long insertID = objMyDBClass.Update_Data_artscore_t1(strMenberID, null, strAns, null, null, null);

        Log.d("Database", "Art1Test3Activity insert DB Success !!!!!" + strAns);

    }
}