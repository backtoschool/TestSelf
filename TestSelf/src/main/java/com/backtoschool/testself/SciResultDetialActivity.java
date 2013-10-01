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
public class SciResultDetialActivity extends Activity {

    private String strMenberID, TypeResult, Sex, ResultScience;
    private Intent objIntent;
    myDBClass objMyDBClass;

    private ImageView imgSci;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sciresult_de_layout);

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

        objIntent = new Intent(SciResultDetialActivity.this, MainMenu.class);
        objIntent.putExtra("MemberID",strMenberID);
        objIntent.putExtra("TypeResult",TypeResult);
        startActivity(objIntent);


    }


    public String ShowResultDetail(){


        String ShResult = null;

        try{

                if(TypeResult.equals("sci2A")){
                    imgSci.setImageResource(R.drawable.sci2ade);
                }else if(TypeResult.equals("sci2B")){
                    imgSci.setImageResource(R.drawable.sci2bde);
                }else if(TypeResult.equals("sci1-1A")){
                    imgSci.setImageResource(R.drawable.sci11ade);
                }else if(TypeResult.equals("sci1-1B")){
                    imgSci.setImageResource(R.drawable.sci11bde);
                }else if(TypeResult.equals("sci1-1C")){
                    imgSci.setImageResource(R.drawable.sci11cde);
                }else if(TypeResult.equals("sci1-1D")){
                    imgSci.setImageResource(R.drawable.sci11dde);
                }else if(TypeResult.equals("sci1-2A")){
                    imgSci.setImageResource(R.drawable.sci12ade);
                }else if(TypeResult.equals("sci1-2B")){
                    imgSci.setImageResource(R.drawable.sci12bde);
                }else if(TypeResult.equals("sci1-2C")){
                    imgSci.setImageResource(R.drawable.sci12cde);
                }else if(TypeResult.equals("sci1-3A")){
                    imgSci.setImageResource(R.drawable.sci13ade);
                }else if(TypeResult.equals("sci1-3B")){
                    imgSci.setImageResource(R.drawable.sci13bde);
                }else if(TypeResult.equals("sci1-3C")){
                    imgSci.setImageResource(R.drawable.sci13cde);
                }else{
                    Log.d("Database", "invalidate TypeResult " + TypeResult);
                }

        }catch (Exception e){

            Log.d("Database", "ShowResult detail Error " + e.toString());

        }

        return ShResult;
    }


}