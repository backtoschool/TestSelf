package com.backtoschool.testself;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MiracleLife on 9/27/13.
 */
public class PersonalDetailActivity extends Activity {
    private String Email;

    private String


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_det_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Email = extras.getString("Email");
        }
        ShowDataMember(Email);
        Log.i("DATA",Email);
    }

    private void ShowDataMember(String email) {
        final TextView txtDet = (TextView) findViewById(R.id.txtData);
        final ImageView imgProfile = (ImageView) findViewById(R.id.imgMe);

        if(email.isEmpty()){
            // new Class DB
            final myDBClass myDb = new myDBClass(this);

            // Show Data
            String arrData[] = myDb.SelectDataMember(email);
            if(arrData != null)
            {
                //MemberID = arrData[0];
                //Name = arrData[1];
               // Lastname = arrData[2];
                //Email = arrData[3];
               // Sex = arrData[4];
                //Age = arrData[5];
               // Result = arrData[6];

                txtDet.setText("ฉันชื่อ ... " + arrData[1].toString() + "ตอนนี้อายุ "+arrData[5].toString() + " ขวบ");
                //Log.i("DATA",arrData[1]);
                if(arrData[4].toString().equals("Male")){
                    imgProfile.setImageResource(R.drawable.boy);


                }else if(arrData[4].toString().equals("Female")){
                    imgProfile.setImageResource(R.drawable.girl);

                }



            }
            //return arrData;

        }
    }
}