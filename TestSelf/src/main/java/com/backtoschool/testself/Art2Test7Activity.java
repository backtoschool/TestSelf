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
public class Art2Test7Activity extends Activity {

    //Cerate By KAE 21/9/2556
    private RadioButton rad1, rad2, rad3, rad4;
    private String strAns,strMenberID;
    private myDBClass objMyDBClass;

    private Intent objIntent;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.art2test7_layout);
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

                Toast.makeText(Art2Test7Activity.this, "กรุณาเลือกคำตอบด้วยค่ะ",
                        Toast.LENGTH_SHORT).show();


            }else{

                UpdateDataSQLite();



                objIntent = new Intent(Art2Test7Activity.this, Art2Test8Activity.class);
                objIntent.putExtra("MemberID",strMenberID);
                startActivity(objIntent);

            }


        }catch (Exception e){

            Log.d("Database", "Art2Test7Activity Error " + e.toString());

        }

    }


    public void UpdateDataSQLite(){

        objMyDBClass = new myDBClass(this);
        long insertID = objMyDBClass.Update_Data_artscore_t2(strMenberID,null,null,null,null,null,strAns,null,null,null,null,null,null);
        Log.d("Database", "Art2Test7Activity insert DB Success !!!!!!!!!"+strAns);
    }


}