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
public class Sci1Test2Activity extends Activity {

    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4, radChoice5, radChoice6;
    private String strAns = "", strMenberID = "1";
    private myDBClass objMyDBClass;

    private Intent objIntent;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sci1test2_layout);

        initialWidget();

    }


    public void initialWidget(){

        radChoice1 = (RadioButton) findViewById(R.id.radChoice1);
        radChoice2 = (RadioButton) findViewById(R.id.radChoice2);
        radChoice3 = (RadioButton) findViewById(R.id.radChoice3);
        radChoice4 = (RadioButton) findViewById(R.id.radChoice4);
        radChoice5 = (RadioButton) findViewById(R.id.radChoice5);
        radChoice6 = (RadioButton) findViewById(R.id.radChoice6);

    }


    public void onClickNext(View view){


        try{

            if(radChoice1.isChecked()){

                strAns = "5";

            }else if(radChoice2.isChecked()){

                strAns = "4";

            }else if(radChoice3.isChecked()){

                strAns = "2";

            }else if(radChoice4.isChecked()){

                strAns = "0";

            }else if(radChoice5.isChecked()){

                strAns = "1";

            }else if(radChoice6.isChecked()){

                strAns = "1";

            }


            if(strAns.equals("")){

                Log.d("Database", "Have Check Button !!!!!");

                Toast.makeText(Sci1Test2Activity.this, "กรุณาเลือกคำตอบด้วยค่ะ",
                        Toast.LENGTH_SHORT).show();


            }else{

                UpdateDataSQLite();



                objIntent = new Intent(Sci1Test2Activity.this, Sci1Test3Activity.class);
                startActivity(objIntent);

            }


        }catch (Exception e){

            Log.d("Database", "Sci1Test2Activity Error " + e.toString());

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

        long updateData = objMyDBClass.Update_Data_sciencescore_t1(strMenberID, strAns, null, null, null, null, null, null, null, null, null);

        Log.d("Database", "update DB Success !!!!!" + strAns);

    }





}