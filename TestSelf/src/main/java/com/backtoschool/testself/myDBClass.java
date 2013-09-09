package com.backtoschool.testself;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    // Insert Data
    public long InsertDataMember(String strName, String strLastname, String strEmail, String strSex,String strAge) {
        // TODO Auto-generated method stub
        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data
            /**
             *  for API 11 and above
             SQLiteStatement insertCmd;
             String strSQL = "INSERT INTO " + TABLE_MEMBER
             + "(MemberID,Name,Tel) VALUES (?,?,?)";

             insertCmd = db.compileStatement(strSQL);
             insertCmd.bindString(1, strMemberID);
             insertCmd.bindString(2, strName);
             insertCmd.bindString(3, strTel);
             return insertCmd.executeInsert();
             */
            ContentValues Val = new ContentValues();
            Val.put("Name", strName);
            Val.put("Lastname", strLastname);
            Val.put("Email", strEmail);
            Val.put("Sex", strSex);
            Val.put("Age", strAge);

            long rows = db.insert(TABLE_MEMBER, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }
    // Select Data Member
    public String[] SelectDataMember(String strMemberID) {
        // TODO Auto-generated method stub

        try {
            String arrData[] = null;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            Cursor cursor = db.query(TABLE_MEMBER, new String[] { "*" },
                    "MemberID=?",
                    new String[] { String.valueOf(strMemberID) }, null, null, null, null);

            if(cursor != null)
            {
                if (cursor.moveToFirst()) {
                    arrData = new String[cursor.getColumnCount()];
                    /***
                     *  0 = MemberID
                     *  1 = Name
                     *  2 = Lastname
                     *  3 = Email
                     *  4 = Sex
                     *  5 = Age
                     */
                    arrData[0] = cursor.getString(0);
                    arrData[1] = cursor.getString(1);
                    arrData[2] = cursor.getString(2);
                    arrData[3] = cursor.getString(2);
                    arrData[4] = cursor.getString(2);
                    arrData[5] = cursor.getString(2);
                }
            }
            cursor.close();
            db.close();
            return arrData;

        } catch (Exception e) {
            return null;
        }

    }
}
