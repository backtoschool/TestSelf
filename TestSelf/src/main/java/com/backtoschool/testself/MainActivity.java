package com.backtoschool.testself;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    //Database
    SQLiteDatabase db;

    private final int SPLASH_DISPLAY_LENGHT = 2000;

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            //Database Create
            myDBClass myDb = new myDBClass(this);
            myDb.getWritableDatabase();//First method
            //End Database
        }
        catch (Exception e){
            Log.i("DB",e.toString());

        }

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        try {
            new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);

            Log.i("splash","gotoComplete");
        }catch (Exception  e){
            Log.i("splash",e.toString());

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
