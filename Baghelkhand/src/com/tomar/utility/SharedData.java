package com.tomar.utility;

import com.tomar.database.pojo.User;

public class SharedData {
	
	public boolean IS_USER_LOGGEDIN;
	public User USER;
	
	
	private static SharedData self;
	private SharedData(){}
	public static SharedData sharedData(){
		if(self == null)
			self = new SharedData();
		return self;
	}
}
