package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by MiracleLife on 6/9/2556.
 */
public class TestMenuActivity extends Activity implements View.OnClickListener {

    private ImageView btntest1,btntest2;
    private Intent objIntent;
    private String MemberID;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        initialWidget();
        btntest1.setOnClickListener(this);
        btntest2.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            MemberID = extras.getString("MemberID");
        }

    }

    private void initialWidget() {
        try{
            btntest1 = (ImageView) findViewById(R.id.imgtest1);
            btntest2 = (ImageView) findViewById(R.id.imgtest2);
            Log.i("MainMenu", "initialWidget");
        }
        catch (Exception e){
            Log.i("MainMenu", e.toString());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgtest1:
                objIntent = new Intent(TestMenuActivity.this,Sci1Test1Activity.class);
                objIntent.putExtra("MemberID",MemberID);
                startActivity(objIntent);
                break;
            case R.id.imgtest2:
                objIntent = new Intent(TestMenuActivity.this,Art1Test1Activity.class);
                objIntent.putExtra("MemberID",MemberID);
                startActivity(objIntent);
                break;

        }
    }
}