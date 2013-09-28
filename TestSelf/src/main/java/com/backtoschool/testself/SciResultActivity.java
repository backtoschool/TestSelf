package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Shana on 9/28/13.
 */
public class SciResultActivity extends Activity {

    private String strMenberID, TypeResult, Sex, ResultScience;
    private Intent objIntent;
    myDBClass objMyDBClass;

    private ImageView imgSci;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sciresult_layout);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            strMenberID = extras.getString("MemberID");
            TypeResult = extras.getString("TypeResult");
        }
        initialWidget();







    }

    private void initialWidget() {
        imgSci = (ImageView) findViewById(R.id.imgSci);


    }


    private void onClick(){

        objIntent = new Intent(SciResultActivity.this, SciResultDetialActivity.class);
        objIntent.putExtra("MemberID",strMenberID);
        objIntent.putExtra("TypeResult",TypeResult);
        startActivity(objIntent);


    }


    public String ShowResult(){


        String ShResult = null;

        try{

            objMyDBClass = new myDBClass(this);
            final ArrayList<HashMap<String, String>> SciTest1DataList = objMyDBClass.SelectDataMemberID(strMenberID);

            Sex = SciTest1DataList.get(0).get("Sex").toString();
            ResultScience = SciTest1DataList.get(0).get("ResultScience").toString();
            Log.i("DATA",Sex + ResultScience);

            if(TypeResult.equals(ResultScience)){
                    if(Sex.equals("male")){
                        if(TypeResult.equals("sci-2A")){
                            imgSci.setImageResource(R.drawable.sciece11amale);
                        }else if(TypeResult.equals("sci-2B")){
                            imgSci.setImageResource(R.drawable.sciece11amale);
                        }else if(TypeResult.equals("sci1-1A")){
                            imgSci.setImageResource(R.drawable.sciece11amale);
                        }else if(TypeResult.equals("sci1-1B")){
                            imgSci.setImageResource(R.drawable.sciece11amale);
                        }else if(TypeResult.equals("sci1-1C")){
                            imgSci.setImageResource(R.drawable.sciece11amale);
                        }else if(TypeResult.equals("sci1-1D")){
                            imgSci.setImageResource(R.drawable.sciece11amale);
                        }else if(TypeResult.equals("sci1-2A")){
                            imgSci.setImageResource(R.drawable.sciece11amale);
                        }else if(TypeResult.equals("sci1-2B")){
                            imgSci.setImageResource(R.drawable.sciece11amale);
                        }else if(TypeResult.equals("sci1-2C")){
                            imgSci.setImageResource(R.drawable.sciece11amale);
                        }else if(TypeResult.equals("sci1-3A")){
                            imgSci.setImageResource(R.drawable.sciece11amale);
                        }else if(TypeResult.equals("sci1-3B")){
                            imgSci.setImageResource(R.drawable.sciece11amale);
                        }else if(TypeResult.equals("sci1-3C")){
                            imgSci.setImageResource(R.drawable.sciece11amale);
                        }else{
                            Log.d("Database", "invalidate TypeResult " + TypeResult);
                        }

                    }else if(Sex.equals("female")){

                        if(TypeResult.equals("sci-2A")){

                            imgSci.setImageResource(R.drawable.sciece11amale);

                        }else if(TypeResult.equals("sci-2B")){

                            imgSci.setImageResource(R.drawable.sciece11amale);

                        }else if(TypeResult.equals("sci1-1A")){

                            imgSci.setImageResource(R.drawable.sciece11amale);

                        }else if(TypeResult.equals("sci1-1B")){

                            imgSci.setImageResource(R.drawable.sciece11amale);

                        }else if(TypeResult.equals("sci1-1C")){

                            imgSci.setImageResource(R.drawable.sciece11amale);

                        }else if(TypeResult.equals("sci1-1D")){

                            imgSci.setImageResource(R.drawable.sciece11amale);

                        }else if(TypeResult.equals("sci1-2A")){

                            imgSci.setImageResource(R.drawable.sciece11amale);

                        }else if(TypeResult.equals("sci1-2B")){

                            imgSci.setImageResource(R.drawable.sciece11amale);

                        }else if(TypeResult.equals("sci1-2C")){

                            imgSci.setImageResource(R.drawable.sciece11amale);

                        }else if(TypeResult.equals("sci1-3A")){

                            imgSci.setImageResource(R.drawable.sciece11amale);

                        }else if(TypeResult.equals("sci1-3B")){

                            imgSci.setImageResource(R.drawable.sciece11amale);

                        }else if(TypeResult.equals("sci1-3C")){

                            imgSci.setImageResource(R.drawable.sciece11amale);

                        }else{

                            Log.d("Database", "invalidate TypeResult " + TypeResult);

                        }

                    }else{

                        Log.d("Database", "invalidate Sex " + Sex);

                    }


            }else{

                Log.d("Database", "Both TypeResult ("+TypeResult+") and ResultScience ("+ResultScience+") are not equal");

            }

        }catch (Exception e){

            Log.d("Database", "ShowResult Error " + e.toString());

        }

        return ShResult;
    }






}