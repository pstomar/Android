package com.tomar.webservices;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;

public class WebServices implements WebConstants {
	/******************  CONNECTION CONSTANTS  ************************/
	private static final int CONNECTION_TIMEOUT = 300*1000;		// IN MILISECONDS
	
	
	/******************  CONNECTION CONSTANTS  ************************/
	
	private DefaultHttpClient httpClient;
	private static WebServices self;
	private WebServices() {}
	public static WebServices self(){
		if(self == null){
			self = new WebServices();
		}
		return self;
	}
	
	
	
	
	public static void loginUser(String username, String password){
		List<NameValuePair> dictionary = new ArrayList<NameValuePair>();
		dictionary.add(new BasicNameValuePair("usernaem", username));
		dictionary.add(new BasicNameValuePair("password", password));
		try{
			HttpPost request = new HttpPost(WebConstants.BASE_URL+WebConstants.LOGIN_REST);
			request.addHeader("Content-Type", "application/x-www-form-urlencoded");
			request.setEntity(new UrlEncodedFormEntity(dictionary));
			
			
//		}catch(ConnectException connectException){
//			
		}catch(Exception e){
			
		}
	}
	
}
