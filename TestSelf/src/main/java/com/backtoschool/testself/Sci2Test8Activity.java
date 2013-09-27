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
public class Sci2Test8Activity extends Activity {

    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4;
    private String strScienceGroupType, TypeTest, strAns = "", strMenberID;
    private myDBClass objMyDBClass;
    private int IntQ1, IntQ2, IntQ3, IntQ4, IntQ5, IntQ6, IntQ7, IntQ8, IntTotal;
    private long updateData, updateMember;

    private Intent objIntent;

    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.art2test8_layout);
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

                Toast.makeText(Sci2Test8Activity.this, "กรุณาเลือกคำตอบด้วยค่ะ",
                        Toast.LENGTH_SHORT).show();


            }else{

                UpdateDataSQLite();

                TypeTest = CalculateResult();

                if(TypeTest!=null){

                    objIntent = new Intent(Sci2Test8Activity.this, ResultActivity.class);
                    objIntent.putExtra("MemberID",strMenberID);
                    objIntent.putExtra("TypeResult",TypeTest);
                    startActivity(objIntent);

                }
            }


        }catch (Exception e){

            Log.d("Database", "Sci2Test8Activity Error " + e.toString());

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
            updateData = objMyDBClass.Update_Data_sciencescore_t2("1", null, null, null, null, null, null, null, strAns, null);

        Log.d("Database", "Sci2Test8Activity insert DB Success !!!!!" + strAns);

    }



    public String CalculateResult(){

        String result = null;

        try{

            objMyDBClass = new myDBClass(this);
            final ArrayList<HashMap<String, String>> SciTest1DataList = objMyDBClass.SelectDataSciTest2(strMenberID);

            strScienceGroupType = SciTest1DataList.get(0).get("ScienceGroupType").toString();
            IntQ1 = Integer.valueOf(SciTest1DataList.get(0).get("Q1").toString());
            IntQ2 = Integer.valueOf(SciTest1DataList.get(0).get("Q2").toString());
            IntQ3 = Integer.valueOf(SciTest1DataList.get(0).get("Q3").toString());
            IntQ4 = Integer.valueOf(SciTest1DataList.get(0).get("Q4").toString());
            IntQ5 = Integer.valueOf(SciTest1DataList.get(0).get("Q5").toString());
            IntQ6 = Integer.valueOf(SciTest1DataList.get(0).get("Q6").toString());
            IntQ7 = Integer.valueOf(SciTest1DataList.get(0).get("Q7").toString());
            IntQ8 = Integer.valueOf(SciTest1DataList.get(0).get("Q8").toString());


            IntTotal = IntQ1+IntQ2+IntQ3+IntQ4+IntQ5+IntQ6+IntQ7+IntQ8;

            if(strScienceGroupType=="Sci1-1"){

                if(IntTotal>24){

                    result = "sci1-1A";

                }else if(IntTotal>=19){

                    result = "sci1-1B";

                }else if(IntTotal>=13){

                    result = "sci1-1C";

                }else{

                    result = "sci1-1D";

                }

            }else if(strScienceGroupType=="Sci1-2"){

                if(IntTotal>24){

                    result = "sci1-2A";

                }else if(IntTotal>=16){

                    result = "sci1-2B";

                }else{

                    result = "sci1-2C";

                }

            }else if(strScienceGroupType=="Sci1-3"){

                if(IntTotal>24){

                    result = "sci1-3A";

                }else if(IntTotal>=16){

                    result = "sci1-3B";

                }else{

                    result = "sci1-3C";

                }

            }


            updateData = objMyDBClass.Update_Data_sciencescore_t2(strMenberID, null, null, null, null, null, null, null, null, result);
            updateMember = objMyDBClass.Update_Data_Member(strMenberID, null, null, null, null, null, result, null);

            Log.d("Database", "CalculateResult " + result);

        }catch (Exception e){

            Log.d("Database", "CalculateResult Error " + e.toString());

        }

        return result;
    }



}