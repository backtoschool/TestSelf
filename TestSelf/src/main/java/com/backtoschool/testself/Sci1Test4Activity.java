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
public class Sci1Test4Activity extends Activity {

    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4;
    private String strAns = "", strMenberID = "1";
    private myDBClass objMyDBClass;

    private Intent objIntent;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sci1test4_layout);

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

                strAns = "3";

            }else if(radChoice2.isChecked()){

                strAns = "2";

            }else if(radChoice3.isChecked()){

                strAns = "1";

            }else if(radChoice4.isChecked()){

                strAns = "0";

            }


            if(strAns.equals("")){

                Log.d("Database", "Have Check Button !!!!!");

                Toast.makeText(Sci1Test4Activity.this, "กรุณาเลือกคำตอบด้วยค่ะ",
                        Toast.LENGTH_SHORT).show();


            }else{

                UpdateDataSQLite();

                objIntent = new Intent(Sci1Test4Activity.this, Sci1Test5Activity.class);
                startActivity(objIntent);

            }


        }catch (Exception e){

            Log.d("Database", "Sci1Test4Activity Error " + e.toString());

        }

    }


    public void UpdateDataSQLite(){

        objMyDBClass = new myDBClass(this);

        /*
            Update_Data_sciencescore_t1(String _id_TABLE_SCIENCESCORE_T1,String strMemberID,
                                                       String strQ1, String strQ2,String strQ3,String strQ4,String strQ5,
                                                       String strQ6, String strQ7,String strQ8, String strQ9,String strQ10,
                                                       String strResultType)
        */


        long updateData = objMyDBClass.Update_Data_sciencescore_t1(strMenberID, null, null, strAns, null, null, null, null, null, null, null);

        Log.d("Database", "update DB Success !!!!!" + strAns);

    }


}