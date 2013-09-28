package com.backtoschool.testself;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by COM on 25/9/2556.
 */
public class csFunction {
    public static int score1,score2,score3,score4,score5,score6,score7,score8,score9,score10,score11,score12,sum;
    public static String ArtResult1(int sum2)
    {
        String Resulttype = "";
        //sum = GetDataArt1(strID);

        if(sum2 <= 9)
        {
            Resulttype = "1";
        }
        else if(sum2 >= 10 && sum2 <=13)
        {
            Resulttype = "2";
        }
        else
        {
            Resulttype = "3";
        }
        return Resulttype;
    }

    public static String ArtResult2(int sum2)
    {
        String Resulttype = "";
        //sum = GetDataArt2(strID);

        Log.d("test1",String.valueOf(sum2));
        if(sum2 >= 36)
        {
            Resulttype = "A";
        }
        else if(sum2 >= 23 && sum2 <=35)
        {
            Resulttype = "B";
        }
        else if(sum2 <= 35)
        {
            Resulttype = "C";
        }
        return Resulttype;
    }

    private static int GetDataArt1(String strID) {
        // new Class DB
        final myDBClass objMyDBClass = new myDBClass(null);

        // Show Data
        final ArrayList<HashMap<String, String>> Art1DataList = objMyDBClass.SelectDataArt1(strID);
       // if(!Art1DataList.get(0).get("id").toString().equals(""))
        //{
            Log.d("test1",Art1DataList.get(0).get("Q1").toString());
           // if(Art1DataList.get(0).get("Q1").toString() != null && Art1DataList.get(0).get("Q1").toString() != "")
                score1 = Integer.valueOf(Art1DataList.get(0).get("Q1").toString()) ;

         //   if(Art1DataList.get(0).get("Q2").toString() != null && Art1DataList.get(0).get("Q2").toString() != "")
                score2 = Integer.valueOf(Art1DataList.get(0).get("Q2").toString()) ;

           // if(Art1DataList.get(0).get("Q3").toString() != null && Art1DataList.get(0).get("Q3").toString() != "")
                score3 = Integer.valueOf(Art1DataList.get(0).get("Q3").toString()) ;

          //  if(Art1DataList.get(0).get("Q4").toString() != null && Art1DataList.get(0).get("Q4").toString() != "")
                score4 = Integer.valueOf(Art1DataList.get(0).get("Q4").toString()) ;

            //if(Art1DataList.get(0).get("Q5").toString() != null && Art1DataList.get(0).get("Q5").toString() != "")
                score5 = Integer.valueOf(Art1DataList.get(0).get("Q5").toString()) ;
       // }
        sum = score1+score2+score3+score4+score5;
        return sum;
    }

    private static int GetDataArt2(String strID) {
        // new Class DB
        final myDBClass objMyDBClass = new myDBClass(null);

        // Show Data
        final ArrayList<HashMap<String, String>> Art1DataList = objMyDBClass.SelectDataArt2(strID);
        //if(!Art1DataList.get(0).get("id").toString().equals(""))
        //{
            Log.d("test2",Art1DataList.get(0).get("Q1").toString());
            //if(Art1DataList.get(0).get("Q1").toString() != null && Art1DataList.get(0).get("Q1").toString() != "")
                score1 = Integer.valueOf(Art1DataList.get(0).get("Q1").toString()) ;

           // if(Art1DataList.get(0).get("Q2").toString() != null && Art1DataList.get(0).get("Q2").toString() != "")
                score2 = Integer.valueOf(Art1DataList.get(0).get("Q2").toString()) ;

           // if(Art1DataList.get(0).get("Q3").toString() != null && Art1DataList.get(0).get("Q3").toString() != "")
                score3 = Integer.valueOf(Art1DataList.get(0).get("Q3").toString()) ;

           // if(Art1DataList.get(0).get("Q4").toString() != null && Art1DataList.get(0).get("Q4").toString() != "")
                score4 = Integer.valueOf(Art1DataList.get(0).get("Q4").toString()) ;

           // if(Art1DataList.get(0).get("Q5").toString() != null && Art1DataList.get(0).get("Q5").toString() != "")
                score5 = Integer.valueOf(Art1DataList.get(0).get("Q5").toString()) ;

           // if(Art1DataList.get(0).get("Q6").toString() != null && Art1DataList.get(0).get("Q6").toString() != "")
                score6 = Integer.valueOf(Art1DataList.get(0).get("Q6").toString()) ;

           // if(Art1DataList.get(0).get("Q7").toString() != null && Art1DataList.get(0).get("Q7").toString() != "")
                score7 = Integer.valueOf(Art1DataList.get(0).get("Q7").toString()) ;

           // if(Art1DataList.get(0).get("Q8").toString() != null && Art1DataList.get(0).get("Q8").toString() != "")
                score8 = Integer.valueOf(Art1DataList.get(0).get("Q8").toString()) ;

            //if(Art1DataList.get(0).get("Q9").toString() != null && Art1DataList.get(0).get("Q9").toString() != "")
                score9 = Integer.valueOf(Art1DataList.get(0).get("Q9").toString()) ;

            //if(Art1DataList.get(0).get("Q10").toString() != null && Art1DataList.get(0).get("Q10").toString() != "")
                score10 = Integer.valueOf(Art1DataList.get(0).get("Q10").toString()) ;

            //if(Art1DataList.get(0).get("Q11").toString() != null && Art1DataList.get(0).get("Q11").toString() != "")
                score11 = Integer.valueOf(Art1DataList.get(0).get("Q11").toString()) ;

            //if(Art1DataList.get(0).get("Q12").toString() != null && Art1DataList.get(0).get("Q12").toString() != "")
                score12 = Integer.valueOf(Art1DataList.get(0).get("Q12").toString()) ;
       // }
        sum = score1+score2+score3+score4+score5+score6+score7+score8+score9+score10+score11+score12;
        return sum;
    }
}
