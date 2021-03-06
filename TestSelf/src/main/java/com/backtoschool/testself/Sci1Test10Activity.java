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
 * Created by refill on 9/13/13.
 */
public class Sci1Test10Activity extends Activity {

    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4;
    private String strAns = "", strMenberID, TypeTest;
    private myDBClass objMyDBClass;
    private long updateData, updateMember;
    private int IntQ1, IntQ2, IntQ3, IntQ4, IntQ5, IntQ6, IntQ7, IntQ8, IntQ9, IntQ10, IntTotal;

    private Intent objIntent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sci1test10_layout);
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

    private enum Fruit {
        sciheartart, sci2A, sci2B, scitype1;
    }
    String value; // assume input

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

                Toast.makeText(Sci1Test10Activity.this, "กรุณาเลือกคำตอบด้วยค่ะ",
                        Toast.LENGTH_SHORT).show();


            }else{

                UpdateDataSQLite();


                TypeTest = CalculateResult();

                Log.i("DATA", TypeTest + " " + strMenberID );

                Fruit fruit = Fruit.valueOf(TypeTest); // surround with try/catch

                switch(fruit) {
                    case sciheartart:
                        objIntent = new Intent(Sci1Test10Activity.this, SciHeartArtActivity.class);
                        objIntent.putExtra("MemberID",strMenberID);
                        startActivity(objIntent);
                        break;
                    case sci2A:
                        objIntent = new Intent(Sci1Test10Activity.this, SciResultActivity.class);
                        objIntent.putExtra("MemberID",strMenberID);
                        objIntent.putExtra("TypeResult",TypeTest);
                        startActivity(objIntent);
                        break;
                    case sci2B:
                        objIntent = new Intent(Sci1Test10Activity.this, SciResultActivity.class);
                        objIntent.putExtra("MemberID",strMenberID);
                        objIntent.putExtra("TypeResult",TypeTest);
                        startActivity(objIntent);
                        break;
                    case scitype1:
                        objIntent = new Intent(Sci1Test10Activity.this, Sci2BeginActivity.class);
                        objIntent.putExtra("MemberID",strMenberID);
                        objIntent.putExtra("TypeResult",TypeTest);
                        startActivity(objIntent);
                        break;
                }
            }


        }catch (Exception e){

            Log.d("Database", "Sci1Test10Activity Error " + e.toString());

        }

    }

    public void UpdateDataSQLite(){

        objMyDBClass = new myDBClass(this);
        updateData = objMyDBClass.Update_Data_sciencescore_t1(strMenberID, null, null, null, null, null, null, null, null, strAns, null);

        Log.d("Database", "Sci1Test10Activity update DB Success !!!!!" + strAns);

    }

    public String CalculateResult(){

            String result = null;

        try{

                objMyDBClass = new myDBClass(this);
                final ArrayList<HashMap<String, String>> SciTest1DataList = objMyDBClass.SelectDataSciTest1(strMenberID);

                IntQ1 = Integer.valueOf(SciTest1DataList.get(0).get("Q1").toString());
                IntQ2 = Integer.valueOf(SciTest1DataList.get(0).get("Q2").toString());
                IntQ3 = Integer.valueOf(SciTest1DataList.get(0).get("Q3").toString());
                IntQ4 = Integer.valueOf(SciTest1DataList.get(0).get("Q4").toString());
                IntQ5 = Integer.valueOf(SciTest1DataList.get(0).get("Q5").toString());
                IntQ6 = Integer.valueOf(SciTest1DataList.get(0).get("Q6").toString());
                IntQ7 = Integer.valueOf(SciTest1DataList.get(0).get("Q7").toString());
                IntQ8 = Integer.valueOf(SciTest1DataList.get(0).get("Q8").toString());
                IntQ9 = Integer.valueOf(SciTest1DataList.get(0).get("Q9").toString());
                IntQ10 = Integer.valueOf(SciTest1DataList.get(0).get("Q10").toString());

                IntTotal = IntQ1+IntQ2+IntQ3+IntQ4+IntQ5+IntQ6+IntQ7+IntQ8+IntQ9+IntQ10;


                /*
                    Update_Data_Member(String strMemberID,String strName, String strLastname,
                    String strEmail, String strSex,String strAge,String strResultScience, String strResultArt)
                */


                if(IntTotal > 15){
                    if((IntQ4==3 || IntQ4==2) && (IntQ8==2 || IntQ8==1) && (IntQ10==3 || IntQ10==0) && (IntTotal<=22 || IntTotal>=16)){
                        result = "sci2A";
                        updateMember = objMyDBClass.Update_Data_Member(strMenberID, null, null, null, null, null, result, null);
                    }else if((IntQ5==1 || IntQ5==0) && IntQ8==0 && IntQ10==1 && (IntTotal<=26 || IntTotal>=16)){
                        result = "sci2B";
                        updateMember = objMyDBClass.Update_Data_Member(strMenberID, null, null, null, null, null, result, null);
                    }else{
                        result = "scitype1";
                    }
                }else{
                    result = "sciheartart";
                    updateMember = objMyDBClass.Update_Data_Member(strMenberID, null, null, null, null, null, result, null);
                }

                updateData = objMyDBClass.Update_Data_sciencescore_t1(strMenberID, null, null, null, null, null, null, null, null, null, result);

                Log.d("Database", "CalculateResult " + result);

        }catch (Exception e){

            Log.d("Database", "CalculateResult Error " + e.toString());

        }

        return result;
    }


}