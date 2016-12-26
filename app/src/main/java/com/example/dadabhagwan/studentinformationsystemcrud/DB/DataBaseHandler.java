package com.example.dadabhagwan.studentinformationsystemcrud.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import com.example.dadabhagwan.studentinformationsystemcrud.pojo.StudentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agile on 24-Oct-16.
 */

public class DataBaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    public static final int DATABASE_VERSION = 6;


    // Database Name
    public static final String DATABASE_NAME = "studentDataBase";

    // Contacts table name
    public static final String STUDENT_TABLE = "student";



    // Contacts Table Columns names
    public static final String STUDENT_ID = "_id";
    public static final String STUDENT_FIRST_NAME = "fname";
    public static final String STUDENT_LAST_NAME = "lname";
    public static final String STUDENT_DIV = "div";
    public static final String STUDENT_STD = "std";
    public static final String STUDENT_RESULT = "result";
    public static final String STUDENT_PERCENTAGE = "percentage";


    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + STUDENT_TABLE + "( "
                + STUDENT_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," + STUDENT_FIRST_NAME + " TEXT,"
                + STUDENT_LAST_NAME + " TEXT," + STUDENT_DIV + " TEXT," + STUDENT_STD +" TEXT," + STUDENT_RESULT + " TEXT," + STUDENT_PERCENTAGE + " TEXT" + ")";

        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);

        // Create tables again
        onCreate(db);
    }

    public void addStudent(StudentModel student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(STUDENT_FIRST_NAME, student.getFirstName());
        values.put(STUDENT_LAST_NAME, student.getLasttName());
        values.put(STUDENT_DIV, student.getDiv());
        values.put(STUDENT_STD, student.getStd());
        values.put(STUDENT_RESULT, student.getResult());
        values.put(STUDENT_PERCENTAGE, student.getPercentage());


        // Inserting Row
        db.insert(STUDENT_TABLE, null, values);
        db.close(); // Closing database connection
    }

    public Cursor getAllData()
    {
      SQLiteDatabase db1=this.getReadableDatabase();
      Cursor cursor=db1.query(STUDENT_TABLE,new String[] {STUDENT_ID,STUDENT_FIRST_NAME,STUDENT_LAST_NAME,STUDENT_STD,STUDENT_DIV,STUDENT_RESULT,STUDENT_PERCENTAGE},null,null,null,null,null);
      if(cursor!=null)
      {
        cursor.moveToFirst();
        return cursor;
      }
      else
      {
        return null;
      }

    }

    public Cursor getDivA()
    {

        String[] seleArgs={"A"};
        SQLiteDatabase db1=this.getReadableDatabase();
        String selection=STUDENT_DIV+" =? ";

        Cursor cursor=db1.query(STUDENT_TABLE,new String[] {STUDENT_ID,STUDENT_FIRST_NAME,STUDENT_LAST_NAME,STUDENT_STD,STUDENT_DIV,STUDENT_RESULT,STUDENT_PERCENTAGE},selection,seleArgs,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            return cursor;
        }
        else
        {
            return null;
        }

    }

    public Cursor getDivB()
    {

        String[] seleArgs={"B"};
        SQLiteDatabase db1=this.getReadableDatabase();
        String selection=STUDENT_DIV+" =? ";

        Cursor cursor=db1.query(STUDENT_TABLE,new String[] {STUDENT_ID,STUDENT_FIRST_NAME,STUDENT_LAST_NAME,STUDENT_STD,STUDENT_DIV,STUDENT_RESULT,STUDENT_PERCENTAGE},selection,seleArgs,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            return cursor;
        }
        else
        {
            return null;
        }

    }
    public Cursor getDivC()
    {

        String[] seleArgs={"C"};
        SQLiteDatabase db1=this.getReadableDatabase();
        String selection=STUDENT_DIV+" =? ";

        Cursor cursor=db1.query(STUDENT_TABLE,new String[] {STUDENT_ID,STUDENT_FIRST_NAME,STUDENT_LAST_NAME,STUDENT_STD,STUDENT_DIV,STUDENT_RESULT,STUDENT_PERCENTAGE},selection,seleArgs,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            return cursor;
        }
        else
        {
            return null;
        }

    }
    public Cursor getDivD()
    {

        String[] seleArgs={"D"};
        SQLiteDatabase db1=this.getReadableDatabase();
        String selection=STUDENT_DIV+" =? ";

        Cursor cursor=db1.query(STUDENT_TABLE,new String[] {STUDENT_ID,STUDENT_FIRST_NAME,STUDENT_LAST_NAME,STUDENT_STD,STUDENT_DIV,STUDENT_RESULT,STUDENT_PERCENTAGE},selection,seleArgs,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            return cursor;
        }
        else
        {
            return null;
        }

    }
    public Cursor getDivE()
    {

        String[] seleArgs={"E"};
        SQLiteDatabase db1=this.getReadableDatabase();
        String selection=STUDENT_DIV+" =? ";

        Cursor cursor=db1.query(STUDENT_TABLE,new String[] {STUDENT_ID,STUDENT_FIRST_NAME,STUDENT_LAST_NAME,STUDENT_STD,STUDENT_DIV,STUDENT_RESULT,STUDENT_PERCENTAGE},selection,seleArgs,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            return cursor;
        }
        else
        {
            return null;
        }

    }
    public Cursor resultPass()
    {

        String[] seleArgs={"Pass"};
        SQLiteDatabase db1=this.getReadableDatabase();
        String selection=STUDENT_RESULT+" =? ";

        Cursor cursor=db1.query(STUDENT_TABLE,new String[] {STUDENT_ID,STUDENT_FIRST_NAME,STUDENT_LAST_NAME,STUDENT_STD,STUDENT_DIV,STUDENT_RESULT,STUDENT_PERCENTAGE},selection,seleArgs,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            return cursor;
        }
        else
        {
            return null;
        }

    }
    public Cursor resultFail()
    {

        String[] seleArgs={"Fail"};
        SQLiteDatabase db1=this.getReadableDatabase();
        String selection=STUDENT_RESULT+" =? ";

        Cursor cursor=db1.query(STUDENT_TABLE,new String[] {STUDENT_ID,STUDENT_FIRST_NAME,STUDENT_LAST_NAME,STUDENT_STD,STUDENT_DIV,STUDENT_RESULT,STUDENT_PERCENTAGE},selection,seleArgs,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            return cursor;
        }
        else
        {
            return null;
        }

    }
    public Cursor resultLess35()
    {

        String[] seleArgs={"35"};
        SQLiteDatabase db1=this.getReadableDatabase();
        String selection=STUDENT_PERCENTAGE+" <=? ";

        Cursor cursor=db1.query(STUDENT_TABLE,new String[] {STUDENT_ID,STUDENT_FIRST_NAME,STUDENT_LAST_NAME,STUDENT_STD,STUDENT_DIV,STUDENT_RESULT,STUDENT_PERCENTAGE},selection,seleArgs,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            return cursor;
        }
        else
        {
            return null;
        }

    }

    public Cursor resultEql35()
    {

        String[] seleArgs={"50"};
        SQLiteDatabase db1=this.getReadableDatabase();
        String selection=STUDENT_PERCENTAGE+" =? ";

        Cursor cursor=db1.query(STUDENT_TABLE,new String[] {STUDENT_ID,STUDENT_FIRST_NAME,STUDENT_LAST_NAME,STUDENT_STD,STUDENT_DIV,STUDENT_RESULT,STUDENT_PERCENTAGE},selection,seleArgs,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            return cursor;
        }
        else
        {
            return null;
        }

    }
    public Cursor resultGrat50()

    {

        String[] seleArgs={"50"};
        SQLiteDatabase db1=this.getReadableDatabase();
        String selection=STUDENT_PERCENTAGE+" >=? ";

        Cursor cursor=db1.query(STUDENT_TABLE,new String[] {STUDENT_ID,STUDENT_FIRST_NAME,STUDENT_LAST_NAME,STUDENT_STD,STUDENT_DIV,STUDENT_RESULT,STUDENT_PERCENTAGE},selection,seleArgs,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            return cursor;
        }
        else
        {
            return null;
        }

    }
    public Cursor resultGrat70()
    {

        String[] seleArgs={"70"};
        SQLiteDatabase db1=this.getReadableDatabase();
        String selection=STUDENT_PERCENTAGE+" <=? ";

        Cursor cursor=db1.query(STUDENT_TABLE,new String[] {STUDENT_ID,STUDENT_FIRST_NAME,STUDENT_LAST_NAME,STUDENT_STD,STUDENT_DIV,STUDENT_RESULT,STUDENT_PERCENTAGE},selection,seleArgs,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            return cursor;
        }
        else
        {
            return null;
        }

    }
    public Cursor resultGrater90()
    {

        String[] seleArgs={"70"};
        SQLiteDatabase db1=this.getReadableDatabase();
        String selection=STUDENT_PERCENTAGE+" >=? ";

        Cursor cursor=db1.query(STUDENT_TABLE,new String[] {STUDENT_ID,STUDENT_FIRST_NAME,STUDENT_LAST_NAME,STUDENT_STD,STUDENT_DIV,STUDENT_RESULT,STUDENT_PERCENTAGE},selection,seleArgs,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            return cursor;
        }
        else
        {
            return null;
        }

    }




}


//
//    // Updating single contact
//    public int updateContact(UserModel userModel) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(STUDENT_FIRST_NAME, userModel.getFirstName());
//        values.put(STUDENT_LAST_NAME, userModel.getLastName());
//        values.put(STUDENT_AGE, userModel.getAge());
//        values.put(STUDENT_EDUCATION, userModel.getQualification());
//
//        // updating row
//        return db.update(STUDENT_TABLE, values, STUDENT_ID + " = ?", new String[]{String.valueOf(userModel.getId())});
//    }
//
//
//    // Deleting single contact
//    public void deleteContact(UserModel contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(STUDENT_TABLE, STUDENT_ID + " = ?",
//                new String[]{String.valueOf(contact.getId())});
//        db.close();
//    }
//
//    public void showSqlDB() {
//        sqdb=this.getWritableDatabase();
//        cursor=sqdb.rawQuery("SELECT * FROM contacts",null);
//        fname_ArrayList.clear();
//        lname_ArrayList.clear();
//        age_ArrayList.clear();
//        edu_ArrayList.clear();
//        id_ArrayList.clear();
//
//        if (cursor.moveToFirst()) {
//            do {
//                id_ArrayList.add(cursor.getInt(cursor.getColumnIndex(DataBaseHandler.STUDENT_ID)));
//
//                fname_ArrayList.add(cursor.getString(cursor.getColumnIndex(DataBaseHandler.STUDENT_FIRST_NAME)));
//
//                lname_ArrayList.add(cursor.getString(cursor.getColumnIndex(DataBaseHandler.STUDENT_LAST_NAME)));
//
//                age_ArrayList.add(cursor.getString(cursor.getColumnIndex(DataBaseHandler.STUDENT_AGE)));
//
//                edu_ArrayList.add(cursor.getString(cursor.getColumnIndex(DataBaseHandler.STUDENT_EDUCATION)));
//
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//    }
