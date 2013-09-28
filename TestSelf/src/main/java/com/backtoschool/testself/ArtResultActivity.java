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
public class ArtResultActivity extends Activity {

    private String strMenberID, TypeResult, Sex, ResultArt;
    private Intent objIntent;
    myDBClass objMyDBClass;

    private ImageView imgSci;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artresult_layout);

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

        objIntent = new Intent(ArtResultActivity.this, ArtResultDetailActivity.class);
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
            ResultArt = SciTest1DataList.get(0).get("ResultScience").toString();
            Log.i("DATA",Sex + ResultArt);

            if(TypeResult.equals(ResultArt)){
                    if(Sex.equals("male")){
                        if(TypeResult.equals("A1")){
                            imgSci.setImageResource(R.drawable.art1amale);
                        }else if(TypeResult.equals("A2")){
                            imgSci.setImageResource(R.drawable.art2amale);
                        }else if(TypeResult.equals("A3")){
                            imgSci.setImageResource(R.drawable.art3amale);
                        }else if(TypeResult.equals("B1")){
                            imgSci.setImageResource(R.drawable.art1bmale);
                        }else if(TypeResult.equals("B2")){
                            imgSci.setImageResource(R.drawable.art1bmale);
                        }else if(TypeResult.equals("B3")){
                            imgSci.setImageResource(R.drawable.art3bmale);
                        }else if(TypeResult.equals("C1")){
                            imgSci.setImageResource(R.drawable.art1cmale);
                        }else if(TypeResult.equals("C2")){
                            imgSci.setImageResource(R.drawable.art2cmale);
                        }else if(TypeResult.equals("C3")){
                            imgSci.setImageResource(R.drawable.art3cmale);
                        }else{
                            Log.d("Database", "invalidate TypeResult " + TypeResult);
                        }

                    }else if(Sex.equals("female")){
                        if(TypeResult.equals("A1")){
                            imgSci.setImageResource(R.drawable.art1afemale);
                        }else if(TypeResult.equals("A2")){
                            imgSci.setImageResource(R.drawable.art2afemale);
                        }else if(TypeResult.equals("A3")){
                            imgSci.setImageResource(R.drawable.art3afemale);
                        }else if(TypeResult.equals("B1")){
                            imgSci.setImageResource(R.drawable.art1bfemale);
                        }else if(TypeResult.equals("B2")){
                            imgSci.setImageResource(R.drawable.art1bfemale);
                        }else if(TypeResult.equals("B3")){
                            imgSci.setImageResource(R.drawable.art3bfemale);
                        }else if(TypeResult.equals("C1")){
                            imgSci.setImageResource(R.drawable.art1cfemale);
                        }else if(TypeResult.equals("C2")){
                            imgSci.setImageResource(R.drawable.art2cfemale);
                        }else if(TypeResult.equals("C3")){
                            imgSci.setImageResource(R.drawable.art3cfemale);
                        }else{
                            Log.d("Database", "invalidate TypeResult " + TypeResult);
                        }

                    }else{

                        Log.d("Database", "invalidate Sex " + Sex);

                    }


            }else{

                Log.d("Database", "Both TypeResult ("+TypeResult+") and ResultScience ("+ResultArt+") are not equal");

            }

        }catch (Exception e){

            Log.d("Database", "ShowResult Error " + e.toString());

        }

        return ShResult;
    }






}
