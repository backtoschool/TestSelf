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
public class Sci1Test1Activity extends Activity {

    private RadioButton radThai, radEng, radMath, radPhy, radChe, radBio;
    private String strAns = "";
    private myDBClass objMyDBClass;

    private Intent objIntent;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sci1test1_layout);

        initialWidget();

    }


    public void initialWidget(){

        radThai = (RadioButton) findViewById(R.id.radThai);
        radEng = (RadioButton) findViewById(R.id.radEng);
        radMath = (RadioButton) findViewById(R.id.radMath);
        radPhy = (RadioButton) findViewById(R.id.radPhy);
        radChe = (RadioButton) findViewById(R.id.radChe);
        radBio = (RadioButton) findViewById(R.id.radBio);

    }


    public void onClickNext(View view){


        try{

            if(radThai.isChecked()){

                strAns = "1";

            }else if(radEng.isChecked()){

                strAns = "2";

            }else if(radMath.isChecked()){

                strAns = "3";

            }else if(radPhy.isChecked()){

                strAns = "4";

            }else if(radChe.isChecked()){

                strAns = "5";

            }else if(radBio.isChecked()){

                strAns = "6";

            }


            if(strAns.equals("")){

                Log.d("insertDB", "Have Check Button !!!!!");

                Toast.makeText(Sci1Test1Activity.this, "กรุณาเลือกคำตอบด้วยค่ะ",
                Toast.LENGTH_SHORT).show();


            }else{

                Log.d("insertDB", "insert DB Success !!!!!" + strAns);

                UpdateDataSQLite();

                objIntent = new Intent(Sci1Test1Activity.this, Sci1Test2Activity.class);
                startActivity(objIntent);

            }


        }catch (Exception e){

            Log.d("insertDB", "Sci1Test1Activity Error " + e.toString());

        }

    }


    public void UpdateDataSQLite(){

        objMyDBClass = new myDBClass(this);
        long insertID = objMyDBClass.Insert_Data_sciencescore_t1(null, strAns, null, null, null, null, null, null, null, null, null, null);

    }


}


