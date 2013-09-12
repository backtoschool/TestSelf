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
                " Result TEXT(1000)"+
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
                " ResultType TEXT(100),"+
                ");");
        Log.d("CREATE TABLE", "Create Table Successfully."+TABLE_SCIENCESCORE_T1);
        //Four Table - ScienceScore_t2
        db.execSQL("CREATE TABLE " + TABLE_SCIENCESCORE_T2 +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " MemberID Integer," +
                " _id_ScienceScore_t1"+
                " ScienceGroup TEXT(100),"+
                " QS1 Integer,"+
                " QS2 Integer,"+
                " QS3 Integer,"+
                " QS4 Integer,"+
                " QS5 Integer,"+
                " QS6 Integer,"+
                " QS7 Integer,"+
                " QS8 Integer,"+
                " ScienceGroupType TEXT(100)"+
                ");");
        Log.d("CREATE TABLE", "Create Table Successfully."+TABLE_SCIENCESCORE_T2);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // Insert Data TABLE_ARTSCORE_T1
    public long Insert_Data_artscore_t1(String strMemberID,
                                        String strQ1, String strQ2,String strQ3,
                                        String strQ4, String strQ5, String strResultType) {
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
            Val.put("Q2", strQ2);
            Val.put("Q3", strQ3);
            Val.put("Q4", strQ4);
            Val.put("Q5", strQ5);
            Val.put("ResultType",strResultType);
            long rows = db.insert(TABLE_ARTSCORE_T1, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }
    // Update Data TABLE_ARTSCORE_T1
    public long Update_Data_artscore_t1(String _id_TABLE_ARTSCORE_T1,String strMemberID,
                                        String strQ1,String strQ2,String strQ3, String strQ4,
                                        String strQ5, String strResultType) {
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
            if(strMemberID != ""){
                Val.put("MemberID", strMemberID);
            }
            if(strQ1 != ""){
                Val.put("Q1", strQ1);
            }
            if(strQ2 != ""){
                Val.put("Q2", strQ2);
            }
            if(strQ3 != ""){
                Val.put("Q3", strQ3);
            }
            if(strQ4 != ""){
                Val.put("Q4", strQ4);
            }
            if(strQ5 != ""){
                Val.put("Q5", strQ5);
            }
            if(strResultType != ""){
                Val.put("ResultType", strResultType);

            }
            long rows = db.update(TABLE_ARTSCORE_T1, Val, " _id = ?",
                    new String[] { String.valueOf(_id_TABLE_ARTSCORE_T1) });
            db.close();
            return rows; // return rows updated.

        } catch (Exception e) {
            return -1;
        }
    }
    // Insert Data TABLE_ARTSCORE_T2
    public long Insert_Data_artscore_t2(String strMemberID,String strid_artscore_t1,
                                        String strQ1, String strQ2,String strQ3, String strQ4, String strQ5,
                                        String strQ6, String strQ7,String strQ8, String strQ9,String strQ10,
                                        String strQ11, String strQ12,String strResultGroup) {
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
            Val.put("id_artscore_t1", strid_artscore_t1);
            Val.put("Q1", strQ1);
            Val.put("Q2", strQ2);
            Val.put("Q3", strQ3);
            Val.put("Q4", strQ4);
            Val.put("Q5", strQ5);
            Val.put("Q6", strQ6);
            Val.put("Q7", strQ7);
            Val.put("Q8", strQ8);
            Val.put("Q9", strQ9);
            Val.put("Q10", strQ10);
            Val.put("Q11", strQ11);
            Val.put("Q12", strQ12);
            Val.put("ResultType",strResultGroup);
            long rows = db.insert(TABLE_ARTSCORE_T2, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }
    // Update Data TABLE_ARTSCORE_T2
    public long Update_Data_artscore_t2(String _id_TABLE_ARTSCORE_T2,String strMemberID,String strid_artscore_t1,
                                        String strQ1, String strQ2,String strQ3, String strQ4,
                                        String strQ5, String strQ6, String strQ7,String strQ8,
                                        String strQ9,String strQ10, String strQ11, String strQ12,String strResultGroup) {
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
            if(strMemberID != ""){
                Val.put("MemberID", strMemberID);
            }
            if(strid_artscore_t1 != ""){
                Val.put("_id_artscore_t1", strid_artscore_t1);
            }
            if(strQ1 != ""){
                Val.put("Q1", strQ1);
            }
            if(strQ2 != ""){
                Val.put("Q2", strQ2);
            }
            if(strQ3 != ""){
                Val.put("Q3", strQ3);
            }
            if(strQ4 != ""){
                Val.put("Q4", strQ4);
            }
            if(strQ5 != ""){
                Val.put("Q5", strQ5);
            }
            if(strQ1 != ""){
                Val.put("Q6", strQ6);
            }
            if(strQ2 != ""){
                Val.put("Q7", strQ7);
            }
            if(strQ3 != ""){
                Val.put("Q8", strQ8);
            }
            if(strQ4 != ""){
                Val.put("Q9", strQ9);
            }
            if(strQ5 != ""){
                Val.put("Q10", strQ10);
            }
            if(strQ5 != ""){
                Val.put("Q11", strQ11);
            }
            if(strQ5 != ""){
                Val.put("Q12", strQ12);
            }
            if(strResultGroup != ""){
                Val.put("ResultGroup", strResultGroup);
            }

            long rows = db.update(TABLE_ARTSCORE_T2, Val, " _id = ?",
                    new String[] { String.valueOf(_id_TABLE_ARTSCORE_T2) });
            db.close();
            return rows; // return rows updated.

        } catch (Exception e) {
            return -1;
        }
    }

    // Insert Data TABLE_SCIENCESCORE_T1
    public long Insert_Data_sciencescore_t1(String strMemberID,
                                            String strQ1, String strQ2,String strQ3,String strQ4,String strQ5,
                                            String strQ6, String strQ7,String strQ8, String strQ9,String strQ10,
                                            String strResultType) {
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
            Val.put("Q2", strQ2);
            Val.put("Q3", strQ3);
            Val.put("Q4", strQ4);
            Val.put("Q5", strQ5);
            Val.put("Q6", strQ6);
            Val.put("Q7", strQ7);
            Val.put("Q8", strQ8);
            Val.put("Q9", strQ9);
            Val.put("Q10", strQ10);
            Val.put("ResultType",strResultType);
            long rows = db.insert(TABLE_SCIENCESCORE_T1, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }
    // Update Data TABLE_SCIENCESCORE_T1
    public long Update_Data_sciencescore_t1(String _id_TABLE_SCIENCESCORE_T1,String strMemberID,
                                           String strQ1, String strQ2,String strQ3,String strQ4,String strQ5,
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
            if(strMemberID != ""){
                Val.put("MemberID", strMemberID);
            }
            if(strQ1 != ""){
                Val.put("Q1", strQ1);
            }
            if(strQ2 != ""){
                Val.put("Q2", strQ2);
            }
            if(strQ3 != ""){
                Val.put("Q3", strQ3);
            }
            if(strQ4 != ""){
                Val.put("Q4", strQ4);
            }
            if(strQ5 != ""){
                Val.put("Q5", strQ5);
            }
            if(strQ1 != ""){
                Val.put("Q6", strQ6);
            }
            if(strQ2 != ""){
                Val.put("Q7", strQ7);
            }
            if(strQ3 != ""){
                Val.put("Q8", strQ8);
            }
            if(strQ4 != ""){
                Val.put("Q9", strQ9);
            }
            if(strQ5 != ""){
                Val.put("Q10", strQ10);
            }
            if(strResultType != ""){
                Val.put("ResultType", strResultType);

            }
            long rows = db.update(TABLE_SCIENCESCORE_T1, Val, " _id = ?",
                    new String[] { String.valueOf(_id_TABLE_SCIENCESCORE_T1) });
            db.close();
            return rows; // return rows updated.

        } catch (Exception e) {
            return -1;
        }
    }
    // Insert Data TABLE_SCIENCESCORE_T2
    public long Insert_Data_sciencescore_t2(String strMemberID,String strid_sciencescore_t1,
                                            String strQ1, String strQ2,String strQ3,
                                            String strQ4,String strQ5,String strQ6, String strQ7,String strQ8,
                                            String strScienceGroupType) {
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
            Val.put("_id_ScienceScore_t1", strid_sciencescore_t1);
            Val.put("Q1", strQ1);
            Val.put("Q2", strQ2);
            Val.put("Q3", strQ3);
            Val.put("Q4", strQ4);
            Val.put("Q5", strQ5);
            Val.put("Q6", strQ6);
            Val.put("Q7", strQ7);
            Val.put("Q8", strQ8);
            Val.put("ScienceGroupType",strScienceGroupType);
            long rows = db.insert(TABLE_SCIENCESCORE_T2, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }
    // Update Data TABLE_SCIENCESCORE_T2
    public long Update_Data_sciencescore_t2(String _id_TABLE_SCIENCESCORE_T2,String strMemberID,String strid_sciencescore_t1,
                                            String strQ1, String strQ2,String strQ3,
                                            String strQ4,String strQ5,String strQ6, String strQ7,String strQ8,
                                            String strScienceGroupType) {
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
            if(strMemberID != ""){
                Val.put("MemberID", strMemberID);
            }
            if(strid_sciencescore_t1 != ""){
                Val.put("_id_ScienceScore_t1", strid_sciencescore_t1);
            }
            if(strQ1 != ""){
                Val.put("Q1", strQ1);
            }
            if(strQ2 != ""){
                Val.put("Q2", strQ2);
            }
            if(strQ3 != ""){
                Val.put("Q3", strQ3);
            }
            if(strQ4 != ""){
                Val.put("Q4", strQ4);
            }
            if(strQ5 != ""){
                Val.put("Q5", strQ5);
            }
            if(strQ1 != ""){
                Val.put("Q6", strQ6);
            }
            if(strQ2 != ""){
                Val.put("Q7", strQ7);
            }
            if(strQ3 != ""){
                Val.put("Q8", strQ8);
            }
            if(strScienceGroupType != ""){
                Val.put("ScienceGroupType", strScienceGroupType);

            }
            long rows = db.update(TABLE_SCIENCESCORE_T2, Val, " _id = ?",
                    new String[] { String.valueOf(_id_TABLE_SCIENCESCORE_T2) });
            db.close();
            return rows; // return rows updated.

        } catch (Exception e) {
            return -1;
        }
    }


    // Insert Data Member
    public long Insert_Data_Member(String strName, String strLastname, String strEmail, String strSex,String strAge,String strResult) {
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
            Val.put("Result", strResult);

            long rows = db.insert(TABLE_MEMBER, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }

    // Update Data TABLE_SCIENCESCORE_T2
    public long Update_Data_Member(String strMemberID,String strName, String strLastname, String strEmail, String strSex,String strAge,String strResult) {
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
            if(strName != ""){
                Val.put("Name", strName);
            }
            if(strLastname != ""){
                Val.put("Lastname", strLastname);
            }
            if(strEmail != ""){
                Val.put("Email", strEmail);
            }
            if(strSex != ""){
                Val.put("Sex", strSex);
            }
            if(strAge != ""){
                Val.put("Age", strAge);
            }
            if(strResult != ""){
                Val.put("Result", strResult);
            }

            long rows = db.update(TABLE_MEMBER, Val, " MemberID = ?",
                    new String[] { String.valueOf(strMemberID) });
            db.close();
            return rows; // return rows updated.

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
                     *  6 = Result
                     */
                    arrData[0] = cursor.getString(0);
                    arrData[1] = cursor.getString(1);
                    arrData[2] = cursor.getString(2);
                    arrData[3] = cursor.getString(3);
                    arrData[4] = cursor.getString(4);
                    arrData[5] = cursor.getString(5);
                    arrData[6] = cursor.getString(6);
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
