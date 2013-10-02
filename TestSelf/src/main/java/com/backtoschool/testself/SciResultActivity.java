package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Shana on 9/28/13.
 */
public class SciResultActivity extends Activity {

    private String strMenberID, Sex, ResultScience;
    private Intent objIntent;
    myDBClass objMyDBClass;

    private ImageView imgSci;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sciresult_layout);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            strMenberID = extras.getString("MemberID");
        }
        initialWidget();
        ShowResult();
    }

    private void initialWidget() {
        imgSci = (ImageView) findViewById(R.id.imgSci);
    }


    public void onClick(View view){

        objIntent = new Intent(SciResultActivity.this, SciResultDetialActivity.class);
        objIntent.putExtra("MemberID",strMenberID);
        objIntent.putExtra("TypeResult",ResultScience);
        startActivity(objIntent);

        Log.d("Database", "go to sci result detail");

    }


    public String ShowResult(){


        String ShResult = null;

        try{

            objMyDBClass = new myDBClass(this);
            final ArrayList<HashMap<String, String>> SciTest1DataList = objMyDBClass.SelectDataMemberID(strMenberID);

            Sex = SciTest1DataList.get(0).get("Sex").toString();
            ResultScience = SciTest1DataList.get(0).get("ResultScience").toString();
            Log.i("database",Sex + ResultScience);


                    if(Sex.equals("Male")){
                        if(ResultScience.equals("sci2A")){
                            imgSci.setImageResource(R.drawable.sciece2amale);
                        }else if(ResultScience.equals("sci2B")){
                            imgSci.setImageResource(R.drawable.sciece2bmale);
                        }else if(ResultScience.equals("sci1-1A")){
                            imgSci.setImageResource(R.drawable.sciece11amale);
                        }else if(ResultScience.equals("sci1-1B")){
                            imgSci.setImageResource(R.drawable.sciece11bmale);
                        }else if(ResultScience.equals("sci1-1C")){
                            imgSci.setImageResource(R.drawable.sciece11cmale);
                        }else if(ResultScience.equals("sci1-1D")){
                            imgSci.setImageResource(R.drawable.sciece11dmale);
                        }else if(ResultScience.equals("sci1-2A")){
                            imgSci.setImageResource(R.drawable.sciece12amale);
                        }else if(ResultScience.equals("sci1-2B")){
                            imgSci.setImageResource(R.drawable.sciece12bmale);
                        }else if(ResultScience.equals("sci1-2C")){
                            imgSci.setImageResource(R.drawable.sciece12cmale);
                        }else if(ResultScience.equals("sci1-3A")){
                            imgSci.setImageResource(R.drawable.sciece13amale);
                        }else if(ResultScience.equals("sci1-3B")){
                            imgSci.setImageResource(R.drawable.sciece13bmale);
                        }else if(ResultScience.equals("sci1-3C")){
                            imgSci.setImageResource(R.drawable.sciece13cmale);
                        }

                    }else if(Sex.equals("Female")){

                        if(ResultScience.equals("sci2A")){

                            imgSci.setImageResource(R.drawable.sciece2afemale);

                        }else if(ResultScience.equals("sci2B")){

                            imgSci.setImageResource(R.drawable.sciece2bfemale);

                        }else if(ResultScience.equals("sci1-1A")){

                            imgSci.setImageResource(R.drawable.sciece11afemale);

                        }else if(ResultScience.equals("sci1-1B")){

                            imgSci.setImageResource(R.drawable.sciece11bfemale);

                        }else if(ResultScience.equals("sci1-1C")){

                            imgSci.setImageResource(R.drawable.sciece11cfemale);

                        }else if(ResultScience.equals("sci1-1D")){

                            imgSci.setImageResource(R.drawable.sciece11dfemale);

                        }else if(ResultScience.equals("sci1-2A")){

                            imgSci.setImageResource(R.drawable.sciece12afemale);

                        }else if(ResultScience.equals("sci1-2B")){

                            imgSci.setImageResource(R.drawable.sciece12bfemale);

                        }else if(ResultScience.equals("sci1-2C")){

                            imgSci.setImageResource(R.drawable.sciece12cfemale);

                        }else if(ResultScience.equals("sci1-3A")){

                            imgSci.setImageResource(R.drawable.sciece13afemale);

                        }else if(ResultScience.equals("sci1-3B")){

                            imgSci.setImageResource(R.drawable.sciece13bfemale);

                        }else if(ResultScience.equals("sci1-3C")){

                            imgSci.setImageResource(R.drawable.sciece13_c_female);

                        }else{

                            Log.d("Database", "invalidate TypeResult " + ResultScience);

                        }

                    }else{

                        Log.d("Database", "invalidate Sex " + Sex);

                    }

        }catch (Exception e){

            Log.d("Database", "ShowResult Error " + e.toString());

        }

        return ShResult;
    }






}