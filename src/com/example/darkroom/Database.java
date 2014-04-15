package com.example.darkroom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {
	private static final String NAME = "username";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String TABLE_NAME = "users";
	
	private static final String DATABASE = "myDatabase";
	private static final int DATABASE_VERSION = 1;
	
	private static final String TABLE_CREATE = 
			"CREATE TABLE users (username text not null, email text not null, password text not null)";
	
	DatabaseHelper dbHelper;
	Context ctx;
	SQLiteDatabase db;
	
	public Database(Context ctx){
		this.ctx= ctx;
		dbHelper = new DatabaseHelper(ctx);
	}
	
	private static class DatabaseHelper extends SQLiteOpenHelper{

		public DatabaseHelper(Context ctx){
			super(ctx, DATABASE, null, DATABASE_VERSION);
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			
			db.execSQL(TABLE_CREATE);
			
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			db.execSQL("DROP TABLE IF EXISTS uesrs");
			onCreate(db);
		}
		
		
		
	}
	public Database open(){
		db = dbHelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		dbHelper.close();
	}
	
	public long insertData(String username, String email, String pass){
		ContentValues content = new ContentValues();
		content.put(NAME, username);
		content.put(EMAIL, email);
		content.put(PASSWORD, pass);
		
		return db.insert(TABLE_NAME, null, content);
	}
	
	public Cursor queryUName(String uName){
		return db.query(TABLE_NAME, new String[] {NAME},"username = ?", new String[]{uName}, null, null, null, null);
	}
}
