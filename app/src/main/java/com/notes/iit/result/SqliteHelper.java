package com.notes.iit.result;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by amardeep on 10/26/2017.
 */

public class SqliteHelper extends SQLiteOpenHelper {

    //DATABASE NAME
    public static final String DATABASE_NAME = "studentdb";

    //DATABASE VERSION
    public static final int DATABASE_VERSION = 1;

    //TABLE NAME
    public static final String TABLE_USERS = "users";

    //TABLE USERS COLUMNS
    //ID COLUMN @primaryKey
    public static final String KEY_ID = "id";

    //COLUMN user name
    public static final String KEY_USER_NAME = "username";

    //COLUMN email
    public static final String KEY_EMAIL = "email";

    //COLUMN password
    public static final String KEY_PASSWORD = "password";

    //SQL for creating users table
    public static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_USERS
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_EMAIL + " TEXT, "
            + KEY_PASSWORD + " TEXT"
            + " ) ";
    //SQL for creating students table
    public static final String TABLE_STUDENTS ="student" ;
    public static final String KEY_NAME ="name" ;
    public static final String KEY_ROLL ="roll" ;
    public static final String KEY_CLASS ="clas" ;
    public static final String KEY_BATCH ="batch" ;
    public static final String KEY_DEPARTMENT ="dept" ;
    public static final String KEY_ADDRESS ="address" ;
    public static final String SQL_TABLE_STUDENTS = " CREATE TABLE " + TABLE_STUDENTS
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_NAME + " TEXT, "+ KEY_ROLL + " TEXT, "+ KEY_CLASS + " TEXT, "+ KEY_BATCH + " TEXT, "
            + KEY_DEPARTMENT + " TEXT, "+ KEY_ADDRESS + " TEXT "
            + " ) ";
    //SQL for creating results table
    public static final String TABLE_RESULTS ="results" ;
    public static final String KEY_EXAM ="exam" ;
    public static final String KEY_YEAR ="year" ;
    public static final String KEY_GPA ="cgpa" ;
    public static final String KEY_POSITION ="position" ;
    public static final String SQL_TABLE_RESULTS  = " CREATE TABLE " + TABLE_RESULTS
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_NAME + " TEXT, "+ KEY_ROLL + " TEXT, "
            + KEY_EXAM + " TEXT, "+ KEY_YEAR + " INTEGER, "
            + KEY_GPA + " TEXT, "+ KEY_POSITION + " TEXT "
            + " ) ";

    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_TABLE_USERS);
        sqLiteDatabase.execSQL(SQL_TABLE_STUDENTS);
        sqLiteDatabase.execSQL(SQL_TABLE_RESULTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
    }

    public void addStudent(Student student) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, student.name);
        values.put(KEY_ROLL, student.roll);
        values.put(KEY_CLASS, student.clas);
        values.put(KEY_BATCH, student.batch);
        values.put(KEY_DEPARTMENT, student.dept);
        values.put(KEY_ADDRESS, student.address);
        db.insert(TABLE_STUDENTS, null, values);
    }

    public Cursor retriveAllStudentsCursor() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur =  db.rawQuery( "select rowid as _id,"
                +KEY_NAME+","+KEY_ROLL +","
                +KEY_CLASS +","+KEY_BATCH +","+KEY_DEPARTMENT +","
                +KEY_ADDRESS +" from "+ TABLE_STUDENTS, null);
        return cur;
    }
    public void addResult(Results results) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, results.name);
        values.put(KEY_ROLL, results.roll);
        values.put(KEY_EXAM, results.exam);
        values.put(KEY_YEAR, results.year);
        values.put(KEY_GPA, results.cgpa);
        values.put(KEY_POSITION, results.position);
        db.insert(TABLE_RESULTS, null, values);
    }

    public Cursor retriveAllResultsCursor() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur =  db.rawQuery( "select rowid as _id,"+KEY_NAME+","+KEY_ROLL +","
                +KEY_EXAM +","+KEY_YEAR +","+KEY_GPA +","
                +KEY_POSITION +" from "+ TABLE_RESULTS, null);
        return cur;
    }
    public void addUser(User user) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, user.email);
        values.put(KEY_PASSWORD, user.password);
        long todo_id = db.insert(TABLE_USERS, null, values);
    }

    public Cursor retriveUser() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur =  db.rawQuery( "select rowid as _id,"+KEY_EMAIL+","+KEY_PASSWORD+" from "+ TABLE_USERS, null);
        return cur;
    }
    public void updateUserProfile(Integer usrID, String usrEmail, String usrPass) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues  values = new ContentValues();
        values.put(KEY_EMAIL , usrEmail);
        values.put(KEY_PASSWORD , usrPass);
        db.update(TABLE_USERS ,  values ,
                "id=?" , new String[ ] {usrID.toString() } );
    }

    public User retreiveUserByEmail(String email){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.query(TABLE_USERS,null,KEY_EMAIL+"=?",new String[]{email},null,null,null);
        if(cursor!=null&&cursor.getCount()>0){
            cursor.moveToFirst();
            String mail=cursor.getString(cursor.getColumnIndex(KEY_EMAIL));
            String password=cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
            User retreivedUser=new User(mail,password);
            return retreivedUser;
        }
        return null;
    }

    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, // Selecting Table
                null,
                KEY_EMAIL + "=?",
                new String[]{email},
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            return true;
        }
        return false;
    }
}
