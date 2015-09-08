package com.tomar.database;

public interface DatabaseConstants {
	public static final String DATABASE_NAME = "baghelidb";
	public static final int DATABASE_VERSION = 1;
	
	
	public static final String TABLE_CATEGORY = "tourism";
	public static final String[] TABLE_CATEGORY_FIELDS = new String[]{
		"id",				//	AUTOINCREMENT
		"super",			//	TOURISM/EDUCATION/TRAVEL/GOVTDEPT
		"category",			//	
		""
	};
	
	public static final String TABLE_TOURISM = "tourism";
	public static final String[] TABLE_TOURISM_FIELDS = new String[]{
		"id",				//	AUTOINCREMENT
		"type_id",				//	MUSIUM/WATERFALL/TEMPAL/FORT//NATURAL
		"name",				//	
		"history",			//	HI
		"about",			//	AUTOINCREMENT
		"latitude",
		"longitude"
	};
	public static final String TABLE_EDUCATION = "education";
	public static final String[] TABLE_EDUCATION_FIELDS = new String[]{
		"id",			//	AUTOINCREMENT
		"type_id",			//	SCHOOL/COLLEGE/UNIVERSITY/COACHING
		"name",			//	
		"about",		//	
		"since",		// 	WHEN IT STARTED
		"is_govt",		//	IS INSTITUTE IS PRIVATE OR GOVT.
		"latitude",
		"longitude",
		""
	};
	
	public static final String TABLE_TRAVEL = "travel";
	public static final String[] TABLE_TRAVEL_FIELDS = new String[]{
		"id",			//	AUTOINCREMENT
		"type_id",		//	BUS/TRAIN/CAB/AUTO
		"name",			//	
		"about",
		""
	};
	
	public static final String TABLE_GOVTDEPT = "govt_dept";
	public static final String[] TABLE_GOVTDEPT_FIELDS = new String[]{
		
	};
	static final String TABLE_5 = "sub_gov_dept";`
	static final String[] TABLE_5_FIELDS = new String[]{};
	
	public static enum TABLES  {
		TABLE_CATEGORY,
		TABLE_EDUCATION,
		TABLE_TOURISM,
		TABLE_GOVTDEPT
	};
	public static enum TABLE_FIELDS  {
		TABLE_CATEGORY_FIELDS,
		TABLE_EDUCATION_FIELDS,
		TABLE_TOURISM_FIELDS,
		TABLE_GOVTDEPT_FIELDS
	};
}
