package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Shana on 9/28/13.
 */
public class SciResultActivity extends Activity {

    private String strMenberID, TypeResult, Sex, ResultScience;
    private Intent objIntent;
    myDBClass objMyDBClass;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sciresult_layout);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            strMenberID = extras.getString("MemberID");
            TypeResult = extras.getString("TypeResult");
        }







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

            if(TypeResult == ResultScience){



                    if(Sex == "male"){


                        if(TypeResult == "sci-2A"){

                            ShResult = "";

                        }else if(TypeResult == "sci-2B"){

                            ShResult = "";

                        }else if(TypeResult == "sci1-1A"){

                            ShResult = "sciece1_1_a_male.png";

                        }else if(TypeResult == "sci1-1B"){

                            ShResult = "sciece1_1_b_male.png";

                        }else if(TypeResult == "sci1-1C"){

                            ShResult = "sciece1_1_c_male.png";

                        }else if(TypeResult == "sci1-1D"){

                            ShResult = "sciece1_1_d_male.png";

                        }else if(TypeResult == "sci1-2A"){

                            ShResult = "sciece1_2_a_male.png";

                        }else if(TypeResult == "sci1-2B"){

                            ShResult = "sciece1_2_b_female.png";

                        }else if(TypeResult == "sci1-2C"){

                            ShResult = "sciece1_2_c_male.png";

                        }else if(TypeResult == "sci1-3A"){

                            ShResult = "sciece1_3_a_male.png";

                        }else if(TypeResult == "sci1-3B"){

                            ShResult = "sciece1_3_b_male.png";

                        }else if(TypeResult == "sci1-3C"){

                            ShResult = "sciece1_3_c_male.png";

                        }else{

                            Log.d("Database", "invalidate TypeResult " + TypeResult);

                        }

                    }else if(Sex == "female"){

                        if(TypeResult == "sci-2A"){

                            ShResult = "";

                        }else if(TypeResult == "sci-2B"){

                            ShResult = "";

                        }else if(TypeResult == "sci1-1A"){

                            ShResult = "sciece1_1_a_female.png";

                        }else if(TypeResult == "sci1-1B"){

                            ShResult = "sciece1_1_b_female.png";

                        }else if(TypeResult == "sci1-1C"){

                            ShResult = "sciece1_1_c_female.png";

                        }else if(TypeResult == "sci1-1D"){

                            ShResult = "sciece1_1_d_female.png";

                        }else if(TypeResult == "sci1-2A"){

                            ShResult = "sciece1_2_a_female.png";

                        }else if(TypeResult == "sci1-2B"){

                            ShResult = "sciece1_2_b_male.png";

                        }else if(TypeResult == "sci1-2C"){

                            ShResult = "sciece1_2_c_female.png";

                        }else if(TypeResult == "sci1-3A"){

                            ShResult = "sciece1_3_a_female.png";

                        }else if(TypeResult == "sci1-3B"){

                            ShResult = "sciece1_3_b_female.png";

                        }else if(TypeResult == "sci1-3C"){

                            ShResult = "sciece1_3_c_female.png";

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