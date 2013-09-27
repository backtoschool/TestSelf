package com.backtoschool.testself;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Shana on 9/28/13.
 */
public class ArtResultDetailActivity extends Activity {

    private String strMenberID, TypeResult, Sex, ResultScience;
    myDBClass objMyDBClass;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artresult_de_layout);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            strMenberID = extras.getString("MemberID");
            TypeResult = extras.getString("TypeResult");
        }


    }

    public String ShowResultDetail(){


        String ShResult = null;

        try{


            if(TypeResult == "sci-2A"){

                ShResult = "art_1a.png";

            }else if(TypeResult == "sci-2B"){

                ShResult = "art_1b.png";

            }else if(TypeResult == "sci1-1A"){

                ShResult = "art_1c.png";

            }else if(TypeResult == "sci1-1B"){

                ShResult = "art_2a.png";

            }else if(TypeResult == "sci1-1C"){

                ShResult = "art_2b.png";

            }else if(TypeResult == "sci1-1D"){

                ShResult = "art_2c.png";

            }else if(TypeResult == "sci1-2A"){

                ShResult = "art_3a.png";

            }else if(TypeResult == "sci1-2B"){

                ShResult = "art_3b.png";

            }else if(TypeResult == "sci1-2C"){

                ShResult = "art_3c.png";

            }else{

                Log.d("Database", "invalidate TypeResult " + TypeResult);

            }



        }catch (Exception e){

            Log.d("Database", "ShowResult Error " + e.toString());

        }

        return ShResult;
    }


}