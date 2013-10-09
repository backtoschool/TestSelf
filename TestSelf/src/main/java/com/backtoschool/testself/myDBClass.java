package com.backtoschool.testself;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

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
    private static final String TABLE_SCIENCESCORE_T2 = "sciencescore_t2";

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
                " AgE TEXT(100),"+
                " ResultScience TEXT(1000),"+
                " ResultArt TEXT(1000)"+
                ");");
        Log.d("Database", "Create Table Successfully."+TABLE_MEMBER);
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
        Log.d("Database", "Create Table Successfully."+TABLE_ARTSCORE_T1);
        //Second Table - ArtScore2
        db.execSQL("CREATE TABLE " + TABLE_ARTSCORE_T2 +
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
                " Q11 Integer,"+
                " Q12 Integer,"+
                " ResultGroup TEXT(1)"+
                ");");
        Log.d("Database", "Create Table Successfully."+TABLE_ARTSCORE_T2);
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
        Log.d("Database", "Create Table Successfully."+TABLE_SCIENCESCORE_T1);
        //Four Table - ScienceScore_t2
        db.execSQL("CREATE TABLE " + TABLE_SCIENCESCORE_T2 +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " MemberID Integer," +
                " ScienceGroup TEXT(100),"+
                " Q1 Integer,"+
                " Q2 Integer,"+
                " Q3 Integer,"+
                " Q4 Integer,"+
                " Q5 Integer,"+
                " Q6 Integer,"+
                " Q7 Integer,"+
                " Q8 Integer,"+
                " ResultType TEXT(100)"+
                ");");
        Log.d("Database", "Create Table Successfully."+TABLE_SCIENCESCORE_T2);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // Insert Data TABLE_ARTSCORE_T1
    public long Insert_Data_artscore_t1(String strMemberID,
                                        String strQ1) {
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
            Val.put("MemberID", strMemberID);
            Val.put("Q1", strQ1);
            long rows = db.insert(TABLE_ARTSCORE_T1, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }
    // Update Data TABLE_ARTSCORE_T1
    public long Update_Data_artscore_t1(String strMemberID,
                                        String strQ2,String strQ3, String strQ4,
                                        String strQ5, String strResultType) {
        // TODO Auto-generated method stub

        try {

            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            ContentValues Val = new ContentValues();

            if(strQ2 != "" && strQ2 != null){
                Val.put("Q2", strQ2);
            }
            if(strQ3 != "" && strQ3 != null){
                Val.put("Q3", strQ3);
            }
            if(strQ4 != "" && strQ4 != null){
                Val.put("Q4", strQ4);
            }
            if(strQ5 != "" && strQ5 != null){
                Val.put("Q5", strQ5);
            }
            if(strResultType != "" && strResultType != null){
                Val.put("ResultType", strResultType);

            }
            long rows = db.update(TABLE_ARTSCORE_T1, Val, " MemberID = ?",
                    new String[] { String.valueOf(strMemberID) });
            //}
            db.close();
            return rows; // return rows updated.

        } catch (Exception e) {
            return -1;
        }
    }



    // Insert Data TABLE_ARTSCORE_T2
    public long Insert_Data_artscore_t2(String strMemberID,
                                        String strQ1 ) {
        // TODO Auto-generated method stub

        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            ContentValues Val = new ContentValues();
            Val.put("MemberID", strMemberID);
            Val.put("Q1", strQ1);
            long rows = db.insert(TABLE_ARTSCORE_T2, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }
    // Update Data TABLE_ARTSCORE_T2
    public long Update_Data_artscore_t2(String strMemberID,
                                        String strQ2,String strQ3, String strQ4,
                                        String strQ5, String strQ6, String strQ7,String strQ8,
                                        String strQ9,String strQ10, String strQ11, String strQ12,String strResultGroup) {
        // TODO Auto-generated method stub

        try {

            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            ContentValues Val = new ContentValues();

            if(strQ2 != "" && strQ2 != null){
                Val.put("Q2", strQ2);
            }
            if(strQ3 != "" && strQ3 != null){
                Val.put("Q3", strQ3);
            }
            if(strQ4 != "" && strQ4 != null){
                Val.put("Q4", strQ4);
            }
            if(strQ5 != "" && strQ5 != null){
                Val.put("Q5", strQ5);
            }
            if(strQ6 != "" && strQ6 != null){
                Val.put("Q6", strQ6);
            }
            if(strQ7 != "" && strQ7 != null){
                Val.put("Q7", strQ7);
            }
            if(strQ8 != "" && strQ8 != null){
                Val.put("Q8", strQ8);
            }
            if(strQ9 != "" && strQ9 != null){
                Val.put("Q9", strQ9);
            }
            if(strQ10 != "" && strQ10 != null){
                Val.put("Q10", strQ10);
            }
            if(strQ11 != "" && strQ11 != null){
                Val.put("Q11", strQ11);
            }
            if(strQ12 != "" && strQ12 != null){
                Val.put("Q12", strQ12);
            }
            if(strResultGroup != "" && strResultGroup != null){
                Val.put("ResultGroup", strResultGroup);
            }

            long rows = db.update(TABLE_ARTSCORE_T2, Val, " MemberID = ?",
                    new String[] { String.valueOf(strMemberID) });
            //}
            db.close();
            return rows; // return rows updated.

        } catch (Exception e) {
            return -1;
        }
    }

    // Insert Data TABLE_SCIENCESCORE_T1
    public long Insert_Data_sciencescore_t1(String strMemberID,
                                            String strQ1) {
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
            Val.put("MemberID", strMemberID);
            Val.put("Q1", strQ1);
            long rows = db.insert(TABLE_SCIENCESCORE_T1, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }
    // Update Data TABLE_SCIENCESCORE_T1
    public long Update_Data_sciencescore_t1(String strMemberID,
                                           String strQ2,String strQ3,String strQ4,String strQ5,
                                           String strQ6, String strQ7,String strQ8, String strQ9,String strQ10,
                                           String strResultType) {
        // TODO Auto-generated method stub

        try {

            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data
            /**
             *  for API 11 and above
             SQLiteStatement insertCmd;
             String strSQL = "UPDATE " + TABLE_MEMBER
             + " SET Name = ? "
             + " , Tel = ? "
             + " WHERE MemberID = ? ";

             insertCmd = db.compileStatement(strSQL);
             insertCmd.bindString(1, strName);
             insertCmd.bindString(2, strTel);
             insertCmd.bindString(3, strMemberID);

             return insertCmd.executeUpdateDelete();
             *
             */
            ContentValues Val = new ContentValues();


            if(strQ2 != "" && strQ2 != null){
                Val.put("Q2", strQ2);
            }
            if(strQ3 != "" && strQ3 != null){
                Val.put("Q3", strQ3);
            }
            if(strQ4 != "" && strQ4 != null){
                Val.put("Q4", strQ4);
            }
            if(strQ5 != "" && strQ5 != null){
                Val.put("Q5", strQ5);
            }
            if(strQ6 != "" && strQ6 != null){
                Val.put("Q6", strQ6);
            }
            if(strQ7 != "" && strQ7 != null){
                Val.put("Q7", strQ7);
            }
            if(strQ8 != "" && strQ8 != null){
                Val.put("Q8", strQ8);
            }
            if(strQ9 != "" && strQ9 != null){
                Val.put("Q9", strQ9);
            }
            if(strQ10 != "" && strQ10 != null){
                Val.put("Q10", strQ10);
            }
            if(strResultType != "" && strResultType != null){
                Val.put("ResultType", strResultType);

            }
            long rows = db.update(TABLE_SCIENCESCORE_T1, Val, " MemberID = ?",
                    new String[] { String.valueOf(strMemberID) });
            db.close();
            return rows; // return rows updated.

        } catch (Exception e) {
            return -1;
        }
    }

    // select data on TABLE_SCIENCESCORE_T1 where MemberID
    public ArrayList<HashMap<String, String>> SelectDataSciTest1(String strMemberID) {

        try {

            ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            Cursor cursor = db.query(TABLE_SCIENCESCORE_T1, new String[] { "*" },
                    "MemberID=?",
                    new String[] { String.valueOf(strMemberID) }, null, null, null, null);

            if(cursor != null)
            {
                if (cursor.moveToLast()) {

                    do {

                        map = new HashMap<String, String>();
                        map.put("id", cursor.getString(0));
                        map.put("MemberID", cursor.getString(1));
                        map.put("Q1", cursor.getString(2));
                        map.put("Q2", cursor.getString(3));
                        map.put("Q3", cursor.getString(4));
                        map.put("Q4", cursor.getString(5));
                        map.put("Q5", cursor.getString(6));
                        map.put("Q6", cursor.getString(7));
                        map.put("Q7", cursor.getString(8));
                        map.put("Q8", cursor.getString(9));
                        map.put("Q9", cursor.getString(10));
                        map.put("Q10", cursor.getString(11));
                        map.put("ResultType", cursor.getString(12));
                        MyArrList.add(map);

                    }while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MyArrList;

        } catch (Exception e) {
            return null;
        }

    }


    // Insert Data TABLE_SCIENCESCORE_T2
    public long Insert_Data_sciencescore_t2(String strMemberID,String strQPre) {
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
            Val.put("MemberID", strMemberID);
            Val.put("ScienceGroup", strQPre);
            long rows = db.insert(TABLE_SCIENCESCORE_T2, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }
    // Update Data TABLE_SCIENCESCORE_T2
    public long Update_Data_sciencescore_t2(String strMemberID,
                                            String strQ1,
                                            String strQ2,String strQ3,
                                            String strQ4,String strQ5,String strQ6, String strQ7,String strQ8,
                                            String strResultType) {
        // TODO Auto-generated method stub

        try {

            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data
            /**
             *  for API 11 and above
             SQLiteStatement insertCmd;
             String strSQL = "UPDATE " + TABLE_MEMBER
             + " SET Name = ? "
             + " , Tel = ? "
             + " WHERE MemberID = ? ";

             insertCmd = db.compileStatement(strSQL);
             insertCmd.bindString(1, strName);
             insertCmd.bindString(2, strTel);
             insertCmd.bindString(3, strMemberID);

             return insertCmd.executeUpdateDelete();
             *
             */
            ContentValues Val = new ContentValues();
            if(strQ1 != "" && strQ1 != null){
                Val.put("Q1", strQ1);
            }
            if(strQ2 != "" && strQ2 != null){
                Val.put("Q2", strQ2);
            }
            if(strQ3 != "" && strQ3 != null){
                Val.put("Q3", strQ3);
            }
            if(strQ4 != "" && strQ4 != null){
                Val.put("Q4", strQ4);
            }
            if(strQ5 != "" && strQ5 != null){
                Val.put("Q5", strQ5);
            }
            if(strQ6 != "" && strQ6 != null){
                Val.put("Q6", strQ6);
            }
            if(strQ7 != "" && strQ7 != null){
                Val.put("Q7", strQ7);
            }
            if(strQ8 != "" && strQ8 != null){
                Val.put("Q8", strQ8);
            }
            if(strResultType != "" && strResultType != null){
                Val.put("ResultType", strResultType);

            }
            long rows = db.update(TABLE_SCIENCESCORE_T2, Val, " MemberID = ?",
                    new String[] { String.valueOf(strMemberID) });
            db.close();
            return rows; // return rows updated.

        } catch (Exception e) {
            return -1;
        }
    }


    // select data on TABLE_SCIENCESCORE_T2 where MemberID
    public ArrayList<HashMap<String, String>> SelectDataSciTest2(String strMemberID) {

        try {

            ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            Cursor cursor = db.query(TABLE_SCIENCESCORE_T2, new String[] { "*" },
                    "MemberID=?",
                    new String[] { String.valueOf(strMemberID) }, null, null, null, null);

            if(cursor != null)
            {
                if (cursor.moveToLast()) {

                    do {

                        map = new HashMap<String, String>();
                        map.put("id", cursor.getString(0));
                        map.put("MemberID", cursor.getString(1));
                        map.put("ScienceGroupType", cursor.getString(2));
                        map.put("Q1", cursor.getString(3));
                        map.put("Q2", cursor.getString(4));
                        map.put("Q3", cursor.getString(5));
                        map.put("Q4", cursor.getString(6));
                        map.put("Q5", cursor.getString(7));
                        map.put("Q6", cursor.getString(8));
                        map.put("Q7", cursor.getString(9));
                        map.put("Q8", cursor.getString(10));
                        map.put("ResultType", cursor.getString(11));
                        MyArrList.add(map);

                    }while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MyArrList;

        } catch (Exception e) {
            return null;
        }

    }



    // Insert Data Member
    public long Insert_Data_Member(String strName, String strLastname, String strEmail,
                                   String strSex,String strAge,String strResultScience, String strResultArt) {
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
            Val.put("ResultScience", strResultScience);
            Val.put("ResultArt", strResultArt);

            long rows = db.insert(TABLE_MEMBER, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }

    // Update Data TABLE_Update_Data_Member
    public long Update_Data_Member(String strMemberID,String strName, String strLastname,
                                   String strEmail, String strSex,String strAge,String strResultScience, String strResultArt) {
        // TODO Auto-generated method stub

        try {

            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data
            /**
             *  for API 11 and above
             SQLiteStatement insertCmd;
             String strSQL = "UPDATE " + TABLE_MEMBER
             + " SET Name = ? "
             + " , Tel = ? "
             + " WHERE MemberID = ? ";

             insertCmd = db.compileStatement(strSQL);
             insertCmd.bindString(1, strName);
             insertCmd.bindString(2, strTel);
             insertCmd.bindString(3, strMemberID);

             return insertCmd.executeUpdateDelete();
             *
             */
            ContentValues Val = new ContentValues();
            if(strName != "" && strName != null){
                Val.put("Name", strName);
            }
            if(strLastname != "" && strLastname != null){
                Val.put("Lastname", strLastname);
            }
            if(strEmail != "" && strEmail != null){
                Val.put("Email", strEmail);
            }
            if(strSex != "" && strSex != null){
                Val.put("Sex", strSex);
            }
            if(strAge != "" && strAge != null){
                Val.put("Age", strAge);
            }

            if(strResultScience != "" && strResultScience != null){
                Val.put("ResultScience", strResultScience);
            }
            if(strResultArt != "" && strResultArt != null){
                Val.put("ResultArt", strResultArt);
            }

            long rows = db.update(TABLE_MEMBER, Val, " MemberID = ?",
                    new String[] { String.valueOf(strMemberID) });
            db.close();
            return rows; // return rows updated.

        } catch (Exception e) {
            return -1;
        }
    }

    // select all Data Member
    public ArrayList<HashMap<String, String>> SelectAllDataMember() {
        // TODO Auto-generated method stub

        try {

            ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            String strSQL = "SELECT  * FROM " + TABLE_MEMBER;
            Cursor cursor = db.rawQuery(strSQL, null);
            /***
             *  0 = MemberID
             *  1 = Name
             *  2 = Lastname
             *  3 = Email
             *  4 = Sex
             *  5 = Age
             *  6 = ResultScience
             *  7 = ResultArt
             */

            if(cursor != null)
            {
                if (cursor.moveToLast()) {
                    do {
                        map = new HashMap<String, String>();
                        map.put("MemberID", cursor.getString(0));
                        map.put("Name", cursor.getString(1));
                        map.put("Lastname", cursor.getString(2));
                        map.put("Email", cursor.getString(3));
                        map.put("Sex", cursor.getString(4));
                        map.put("Age", cursor.getString(5));
                        map.put("ResultScience", cursor.getString(6));
                        map.put("ResultArt", cursor.getString(7));
                        MyArrList.add(map);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MyArrList;

        } catch (Exception e) {
            return null;
        }

    }


        // select Data Member by MemberID

    public ArrayList<HashMap<String, String>> SelectDataMemberID(String strMemberID) {
        // TODO Auto-generated method stub
        //strMemberID = "1";
        try {
            String arrData[] = null;
            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data


            ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            Cursor cursor = db.query(TABLE_MEMBER, new String[] { "*" },
                    "MemberID=?",
                    new String[] { String.valueOf(strMemberID) }, null, null, null, null);

            /***
             *  0 = MemberID
             *  1 = Name
             *  2 = Lastname
             *  3 = Email
             *  4 = Sex
             *  5 = Age
             *  6 = ResultScience
             *  7 = ResultArt
             */

            if(cursor != null)
            {
                if (cursor.moveToLast()) {
                    do {
                        map = new HashMap<String, String>();
                        map.put("MemberID", cursor.getString(0));
                        map.put("Name", cursor.getString(1));
                        map.put("Lastname", cursor.getString(2));
                        map.put("Email", cursor.getString(3));
                        map.put("Sex", cursor.getString(4));
                        map.put("Age", cursor.getString(5));
                        map.put("ResultScience", cursor.getString(6));
                        map.put("ResultArt", cursor.getString(7));
                        MyArrList.add(map);
                    } while (cursor.moveToNext());
                }
            }

            cursor.close();
            db.close();
            return MyArrList;

        } catch (Exception e) {
            return null;
        }

    }


        // select Data Member by Email
    public String[] SelectDataMember(String strEmail) {
        // TODO Auto-generated method stub
        //strMemberID = "1";
        try {
            String arrData[] = null;
            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            Cursor cursor = db.query(TABLE_MEMBER, new String[] { "*" },
                    "Email=?",
                    new String[] { String.valueOf(strEmail) }, null, null, null, null);
            if(cursor != null)
            {
                if (cursor.moveToLast()) {
                    arrData = new String[cursor.getColumnCount()];
                    /***
                     *  0 = MemberID
                     *  1 = Name
                     *  2 = Lastname
                     *  3 = Email
                     *  4 = Sex
                     *  5 = Age
                     *  6 = ResultScience
                     *  7 = ResultArt
                     */
                    arrData[0] = cursor.getString(0);
                    arrData[1] = cursor.getString(1);
                    arrData[2] = cursor.getString(2);
                    arrData[3] = cursor.getString(3);
                    arrData[4] = cursor.getString(4);
                    arrData[5] = cursor.getString(5);
                    arrData[6] = cursor.getString(6);
                    arrData[7] = cursor.getString(7);
                }
            }
            cursor.close();
            db.close();
            return arrData;

        } catch (Exception e) {
            return null;
        }

    }

    // select data on TABLE_ARTSCORE_T1 where MemberID
    public ArrayList<HashMap<String, String>> SelectDataArt1(String strMemberID) {

        try {

            ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            Cursor cursor = db.query(TABLE_ARTSCORE_T1, new String[] { "*" },
                    "MemberID=?",
                    new String[] { String.valueOf(strMemberID) }, null, null, null, null);

            if(cursor != null)
            {
                if (cursor.moveToLast()) {

                    do {

                        map = new HashMap<String, String>();
                        map.put("id", cursor.getString(0));
                        map.put("MemberID", cursor.getString(1));
                        map.put("Q1", cursor.getString(2));
                        map.put("Q2", cursor.getString(3));
                        map.put("Q3", cursor.getString(4));
                        map.put("Q4", cursor.getString(5));
                        map.put("Q5", cursor.getString(6));
                        map.put("ResultType", cursor.getString(7));
                        MyArrList.add(map);

                    }while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MyArrList;

        } catch (Exception e) {
            return null;
        }

    }

    // select data on TABLE_ARTSCORE_T2 where MemberID
    public ArrayList<HashMap<String, String>> SelectDataArt2(String strMemberID) {

        try {

            ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            Cursor cursor = db.query(TABLE_ARTSCORE_T2, new String[] { "*" },
                    "MemberID=?",
                    new String[] { String.valueOf(strMemberID) }, null, null, null, null);

            if(cursor != null)
            {
                if (cursor.moveToLast()) {

                    do {

                        map = new HashMap<String, String>();
                        map.put("id", cursor.getString(0));
                        map.put("MemberID", cursor.getString(1));
                        map.put("Q1", cursor.getString(2));
                        map.put("Q2", cursor.getString(3));
                        map.put("Q3", cursor.getString(4));
                        map.put("Q4", cursor.getString(5));
                        map.put("Q5", cursor.getString(6));
                        map.put("Q6", cursor.getString(7));
                        map.put("Q7", cursor.getString(8));
                        map.put("Q8", cursor.getString(9));
                        map.put("Q9", cursor.getString(10));
                        map.put("Q10", cursor.getString(11));
                        map.put("Q11", cursor.getString(12));
                        map.put("Q12", cursor.getString(13));
                        map.put("ResultType", cursor.getString(14));
                        MyArrList.add(map);

                    }while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MyArrList;

        } catch (Exception e) {
            return null;
        }

    }


}
