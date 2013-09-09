package com.backtoschool.testself;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by MiracleLife on 7/9/2556.
 */
public class myDBClass extends SQLiteOpenHelper{

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "eduzonetest";
    // Table Name
    private static final String TABLE_MEMBER = "members";
    private static final String TABLE_ARTSCORE_T1 = "artscore_t1";
    private static final String TABLE_ARTSCORE_T2 = "artscore_t2";
    private static final String TABLE_SCIENCESCORE_T1 = "sciencescore_t1";

    public myDBClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        // First Table - members
        db.execSQL("CREATE TABLE " + TABLE_MEMBER +
                "(MemberID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT(100)," +
                " LastName TEXT(100),"+
                " Email TEXT(100),"+
                " Sex TEXT(100),"+
                " AgE TEXT(100)"+
                ");");
        Log.d("CREATE TABLE", "Create Table Successfully."+TABLE_MEMBER);
        //Second Table - ArtScore1
        db.execSQL("CREATE TABLE " + TABLE_ARTSCORE_T1 +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " MemberID Integer," +
                " Q1 Integer,"+
                " Q2 Integer,"+
                " Q3 Integer,"+
                " Q4 Integer,"+
                " Q5 Integer,"+
                " ResultType Integer"+
                ");");
        Log.d("CREATE TABLE", "Create Table Successfully."+TABLE_ARTSCORE_T1);
        //Second Table - ArtScore2
        db.execSQL("CREATE TABLE " + TABLE_ARTSCORE_T2 +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " MemberID Integer," +
                " _id_artscore_t1 Integer,"+
                " Q1 Integer,"+
                " Q2 Integer,"+
                " Q3 Integer,"+
                " Q4 Integer,"+
                " Q5 Integer,"+
                " Q6 Integer,"+
                " Q7 Integer,"+
                " Q8 Integer,"+
                " Q9 Integer,"+
                " Q10 Integer,"+
                " Q11 Integer,"+
                " Q12 Integer,"+
                " ResultGroup TEXT(1)"+
                ");");
        Log.d("CREATE TABLE", "Create Table Successfully."+TABLE_ARTSCORE_T2);
        //Three Table - ScienceScore_t1
        db.execSQL("CREATE TABLE " + TABLE_SCIENCESCORE_T1 +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " MemberID Integer," +
                " Q1 Integer,"+
                " Q2 Integer,"+
                " Q3 Integer,"+
                " Q4 Integer,"+
                " Q5 Integer,"+
                " Q6 Integer,"+
                " Q7 Integer,"+
                " Q8 Integer,"+
                " Q9 Integer,"+
                " Q10 Integer,"+
                " ResultType TEXT(100)"+
                ");");
        Log.d("CREATE TABLE", "Create Table Successfully."+TABLE_SCIENCESCORE_T1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
