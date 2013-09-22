package com.backtoschool.testself;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MiracleLife on 9/21/13.
 */
public class PersonalDetActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_det_layout);

        try{
            ShowData();
        }catch (Exception e){
            Log.i("ShowData",e.toString());
        }





    }

    private void ShowData() {

        // txtMemberID, txtName, txtTel
        final TextView tName = (TextView) findViewById(R.id.txtData);
        final ImageView imgMe = (ImageView) findViewById(R.id.imgMe);
        // new Class DB
        final myDBClass myDb = new myDBClass(this);
        // Show Data
        String arrData[] = myDb.SelectDataMember("1");

        if(arrData != null)
        {
            //tName.setText(arrData[0]);
            /***
             *  0 = MemberID
             *  1 = Name
             *  2 = Lastname
             *  3 = Email
             *  4 = Sex
             *  5 = Age
             *  6 = Result
             */

            tName.setText("ฉันชื่อ " + arrData[1].toString() + "อาย " + arrData[4].toString());

        }



    }
}
