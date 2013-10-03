package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Shana on 9/28/13.
 */
public class ArtResultDetailActivity extends Activity {

    private String strMenberID, TypeResult, Sex, ResultScience;
    private Intent objIntent;
    myDBClass objMyDBClass;

    private ImageView imgSci;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artresult_de_layout);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            strMenberID = extras.getString("MemberID");
            TypeResult = extras.getString("TypeResult");
        }

        initialWidget();
        ShowResultDetail();

    }


    private void initialWidget() {
        imgSci = (ImageView) findViewById(R.id.imgSci);
    }

    public void onClick(View view){

        objIntent = new Intent(ArtResultDetailActivity.this, MainMenu.class);
        objIntent.putExtra("MemberID",strMenberID);
        objIntent.putExtra("TypeResult",TypeResult);
        startActivity(objIntent);

        Log.d("Database", "go to main menu");

    }

    public void ShowResultDetail(){


        try{


            if(TypeResult.equals("A1")){
                imgSci.setImageResource(R.drawable.art1ad);
            }else if(TypeResult.equals("A2")){
                imgSci.setImageResource(R.drawable.art2ad);
            }else if(TypeResult.equals("A3")){
                imgSci.setImageResource(R.drawable.art3ad);
            }else if(TypeResult.equals("B1")){
                imgSci.setImageResource(R.drawable.art1bd);
            }else if(TypeResult.equals("B2")){
                imgSci.setImageResource(R.drawable.art2bd);
            }else if(TypeResult.equals("B3")){
                imgSci.setImageResource(R.drawable.art3bd);
            }else if(TypeResult.equals("C1")){
                imgSci.setImageResource(R.drawable.art1cd);
            }else if(TypeResult.equals("C2")){
                imgSci.setImageResource(R.drawable.art2cd);
            }else if(TypeResult.equals("C3")){
                imgSci.setImageResource(R.drawable.art3cd);
            }else{

                Log.d("Database", "invalidate TypeResult detail" + TypeResult);

            }

        }catch (Exception e){

            Log.d("Database", "ShowResult Error " + e.toString());

        }

    }


}