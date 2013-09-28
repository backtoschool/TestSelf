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


                    if(TypeResult == "sci-2A"){

                        ShResult = "sci2a_de.png";

                    }else if(TypeResult == "sci-2B"){

                        ShResult = "sci2b_de.png";

                    }else if(TypeResult == "sci1-1A"){

                        ShResult = "sci1-1a_de.png";

                    }else if(TypeResult == "sci1-1B"){

                        ShResult = "sci1-1b_de.png";

                    }else if(TypeResult == "sci1-1C"){

                        ShResult = "sci1-1c_de.png";

                    }else if(TypeResult == "sci1-1D"){

                        ShResult = "sci1-1d_de.png";

                    }else if(TypeResult == "sci1-2A"){

                        ShResult = "sci1-2a_de.png";

                    }else if(TypeResult == "sci1-2B"){

                        ShResult = "sci1-2b_de.png";

                    }else if(TypeResult == "sci1-2C"){

                        ShResult = "sci1-2c_de.png";

                    }else if(TypeResult == "sci1-3A"){

                        ShResult = "sci1-3a_de.png";

                    }else if(TypeResult == "sci1-3B"){

                        ShResult = "sci1-3b_de.png";

                    }else if(TypeResult == "sci1-3C"){

                        ShResult = "sci1-3c_de.png";

                    }else{

                        Log.d("Database", "invalidate TypeResult " + TypeResult);

                    }



        }catch (Exception e){

            Log.d("Database", "ShowResult Error " + e.toString());

        }

        return ShResult;
    }




}