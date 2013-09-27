package com.backtoschool.testself;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MiracleLife on 9/27/13.
 */
public class PersonalDetailActivity extends Activity {
    private String Email;
    TextView txtData;
    ImageView imgMe;
    private String strName, strLastname,strSex,strAge;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_det_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Email = extras.getString("Email");
        }
        InitialWidget();

        ShowDataMember(Email);
        //Log.i("DATA",Email+strName+strLastname+strSex+strAge);
        txtData.setText("....ฉันชื่อ "+ strName + " อายุ " + strAge);
        if(strSex.equals("Male")){
            imgMe.setImageResource(R.drawable.boy);

        }else if(strSex.equals("Female")){
            imgMe.setImageResource(R.drawable.girl);
        }

    }

    private void InitialWidget() {
        imgMe = (ImageView) findViewById(R.id.imgMe);
        txtData = (TextView) findViewById(R.id.txtData);
    }

    private void ShowDataMember(String email) {

            final myDBClass myDb = new myDBClass(this);

            // Show Data
            String arrData[] = myDb.SelectDataMember(email);
            if(arrData != null)
            {
                strName = arrData[1];
                strLastname  = arrData[2];
                strAge = arrData[5];
                strSex = arrData[4];
            }


    }
}