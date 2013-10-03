package com.backtoschool.testself;

import android.util.Log;

/**
 * Created by COM on 25/9/2556.
 */
public class csFunction {

    public static int score1,score2,score3,score4,score5,score6,score7,score8,score9,score10,score11,score12,sum;
    public static String Resulttype = "";

    // cal result test 1
    public static String ArtResult1(int sum2)
    {

        if(sum2 >= 14)
        {
            Resulttype = "4";
        }
        else if(sum2 >9)
        {
            Resulttype = "2";
        }
        else
        {
            Resulttype = "1";
        }
        return Resulttype;

    }

    // cal result test 2
    public static String ArtResult2(int sum2)
    {

        try{

            if(sum2 > 35)
            {
                Resulttype = "A";
            }
            else if(sum2 >= 23)
            {
                Resulttype = "B";
            }
            else
            {
                Resulttype = "C";
            }

        }catch (Exception e){

            Log.d("database", "Art2Test12Activity ArtResult2 Error " + e.toString());

        }

        return Resulttype;
    }


}
