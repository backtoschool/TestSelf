package com.backtoschool.testself;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
kkkkk
/**
 * Created by MiracleLife on 6/9/2556.
 */
public class PersonalActivity extends Activity {


    private String strSex;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_layout);

        // btnSave (Save)
        final Button save = (Button) findViewById(R.id.btnSaveData);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // If Save Complete
                if(SaveData())
                {
                    // Open Form Main
                    Intent newActivity = new Intent(PersonalActivity.this,PersonalActivity.class);
                    startActivity(newActivity);
                }
            }
        });
    }

    public boolean SaveData()
    {
        // txtMemberID, txtName, txtTel
        final EditText tName = (EditText) findViewById(R.id.edtName);
        final EditText tEmail = (EditText) findViewById(R.id.edtEmail);
        final EditText tAge = (EditText) findViewById(R.id.edtAge);
        final RadioButton rdMale = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton rdFemale = (RadioButton) findViewById(R.id.radioButton2);
        // Dialog
        final AlertDialog.Builder adb = new AlertDialog.Builder(this);
        AlertDialog ad = adb.create();
        // Check tName
        if(tName.getText().length() == 0)
        {
            ad.setMessage("Please input Your name! ");
            ad.show();
            tName.requestFocus();
            return false;
        }
        // Check Email
        if(tEmail.getText().length() == 0){
            ad.setMessage("Please input Your E-mail! ");
            ad.show();
            tEmail.requestFocus();
            return false;
        }
        // Check tAge
        if(tAge.getText().length() == 0)
        {
            ad.setMessage("Please input Age! ");
            ad.show();
            tAge.requestFocus();
            return false;
        }

        if(rdMale.isChecked()){
            strSex = "Male";
        }
        if(rdFemale.isChecked()){
            strSex = "Female";
        }
        // Check Sex
        if(strSex == "" )
        {
            ad.setMessage("Please Select Sex ");
            ad.show();
            return false;
        }
        // new Class DB
        final myDBClass myDb = new myDBClass(this);


        long saveStatus ;
        try{
            // Save Data
            saveStatus = myDb.Insert_Data_Member(tName.getText().toString(),
                    null,
                    tEmail.getText().toString(),
                    strSex,
                    tAge.getText().toString(),
                    null);

        }catch (Exception e){

            Log.d("saveStatus", "saveStatus : " + e);


        }

       // if(saveStatus <=  0)
       // {
      //      ad.setMessage("Error!! ");
       //     ad.show();
        //    return false;
       // }

        Toast.makeText(PersonalActivity.this, "Add Data Successfully. ",
                Toast.LENGTH_SHORT).show();

        return true;
    }


}