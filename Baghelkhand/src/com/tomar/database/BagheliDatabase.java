package com.tomar.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BagheliDatabase extends SQLiteOpenHelper implements DatabaseConstants {
	private static Context context;
	private static BagheliDatabase self;
	private static CursorFactory factory;
	
	public static BagheliDatabase getInstance(Context ctx){
		context = ctx;
		if(self == null)
			self = new BagheliDatabase(ctx);
		return self;
	}
	
	private BagheliDatabase(Context context) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
