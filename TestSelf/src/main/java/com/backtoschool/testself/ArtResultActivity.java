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

    private String strMenberID, TypeResult, Sex;
    private Intent objIntent;
    myDBClass objMyDBClass;

    private ImageView imgSci;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artresult_layout);

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


    public void onClick(){

        objIntent = new Intent(ArtResultActivity.this, ArtResultDetailActivity.class);
        objIntent.putExtra("MemberID",strMenberID);
        objIntent.putExtra("TypeResult",TypeResult);
        startActivity(objIntent);

        Log.d("Database", "go to art result detail");

    }


    public  void ShowResult(){


        try{

            objMyDBClass = new myDBClass(this);
            final ArrayList<HashMap<String, String>> SciTest1DataList = objMyDBClass.SelectDataMemberID(strMenberID);

            Sex = SciTest1DataList.get(0).get("Sex").toString();
            TypeResult = SciTest1DataList.get(0).get("ResultArt").toString();

                    if(Sex.equals("Male")){
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

                    }else if(Sex.equals("Female")){
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


        }catch (Exception e){

            Log.d("Database", "ShowResult sex "+Sex+" result "+TypeResult+" Error "+ e.toString());

        }

    }






}
