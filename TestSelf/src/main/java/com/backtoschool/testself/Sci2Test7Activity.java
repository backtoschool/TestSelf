package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by refill on 9/13/13.
 */
public class Sci2Test7Activity extends Activity {

    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4;
    private String strAns = "";
    private myDBClass objMyDBClass;

    private Intent objIntent;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sci2test7_layout);

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

                strAns = "1";

            }else if(radChoice2.isChecked()){

                strAns = "2";

            }else if(radChoice3.isChecked()){

                strAns = "3";

            }else if(radChoice4.isChecked()){

                strAns = "4";

            }


            if(strAns.equals("")){

                Log.d("Database", "Have Check Button !!!!!");

                Toast.makeText(Sci2Test7Activity.this, "กรุณาเลือกคำตอบด้วยค่ะ",
                        Toast.LENGTH_SHORT).show();


            }else{

                UpdateDataSQLite();

                objIntent = new Intent(Sci2Test7Activity.this, Sci2Test8Activity.class);
                startActivity(objIntent);

            }


        }catch (Exception e){

            Log.d("Database", "Sci2Test7Activity Error " + e.toString());

        }

    }


    public void UpdateDataSQLite(){

        /*
        Update_Data_sciencescore_t2(String strMemberID,String strid_sciencescore_t1,
                String strQ2,String strQ3,
                String strQ4,String strQ5,String strQ6, String strQ7,String strQ8,
                String strScienceGroupType)
        */

        objMyDBClass = new myDBClass(this);
        long updateData = objMyDBClass.Update_Data_sciencescore_t2("1", "1", null, null, null, null, null, strAns, null, null);

        Log.d("Database", "insert DB Success !!!!!" + strAns);

    }

}