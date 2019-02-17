package com.example.news;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static android.icu.lang.UProperty.NAME;
import static android.os.Build.ID;
import static android.provider.Contacts.SettingsColumns.KEY;
import static java.sql.Types.INTEGER;
import static java.text.Collator.PRIMARY;
import static org.xmlpull.v1.XmlPullParser.TEXT;
/**
 * Created by Admin on 5/9/2018.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "USER.db";
    public static final String TABLE_NAME = "SIGN_UP";
    public static final String col_1 = "ID" ;
    public static final String col_2 = "NAME" ;
    public static final String col_3 = "EMAIL" ;
    public static final String col_4 = "PASSWORD" ;
//public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactoryfactory, int version) {
public DatabaseHelper(Context context ) {
// super(context, name, factory, version);
            super(context, DATABASE_NAME, null, 1);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table "+TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT UNIQUE,PASSWORD TEXT)");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME );
            onCreate(db);
        }
        public boolean insertData (String name,String email,String password) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(col_2,name);
            contentValues.put(col_3,email);
            contentValues.put(col_4,password);
            long result = db.insert(TABLE_NAME,null,contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }
        public Cursor getAllData() {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
            return res;
        }
        public boolean updateData(String id,String name,String email,String password) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(col_1,id);
            contentValues.put(col_2,name);
            contentValues.put(col_3,email);
            contentValues.put(col_4,password);
            db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
            return true;
        }
        public Integer deleteData (String id) {
            SQLiteDatabase db = this.getWritableDatabase();
            return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
        }

    public Cursor getUser(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "select * from SIGN_UP WHERE EMAIL = '"+email+"'";
        Cursor cursor = db.rawQuery(sql,null);
        return cursor;

    }

    }