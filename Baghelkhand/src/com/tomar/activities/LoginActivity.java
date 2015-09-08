package com.tomar.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener{
	
	private Button btnLogin, btnSignup, btnCancel;
	private EditText txtUsername, txtPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		this.setTitle(R.string.login_title);
		initComponents();
	}
	
	private void initComponents() {
		btnLogin = (Button) findViewById(R.id.btn_login);
		btnSignup = (Button) findViewById(R.id.btn_signup);
		btnCancel = (Button) findViewById(R.id.btn_cancel);
		txtUsername = (EditText) findViewById(R.id.txt_username);
		txtPassword = (EditText) findViewById(R.id.txt_password);
		btnLogin.setOnClickListener(this);
		btnSignup.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
	}

	@Override
	public void onClick(View button) {
		if(button == btnLogin){
			authenticateUser();
		}else if(button == btnSignup) {
			txtUsername.setText("");
			txtPassword.setText("");
			Intent intent = new Intent(this,SignupActivity.class);
			startActivity(intent);
		}else if(button == btnCancel) {
			txtUsername.setText("");
			txtPassword.setText("");
			txtUsername.setFocusable(true);
		}	
	}
	
	@Override
	public void onBackPressed() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Confirmation");
		builder.setMessage("Confirm, Close the App?").setPositiveButton("Yes", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				LoginActivity.this.finish();
			}
		}).setNegativeButton("No", null);
		
		AlertDialog dialog = builder.create();
		dialog.show();
	}
	
	private void authenticateUser() {
		String username = txtUsername.getText().toString().trim();
		String password = txtPassword.getText().toString();
		if(username.length()>2 && password.length()>2){
			new AsyncLogin().execute(username, password);
		}else{
			if(username.length()>2)
				txtUsername.setFocusable(true);
			else{
				txtPassword.setText("");
				txtPassword.setFocusable(true);
			}	
			Toast.makeText(this, "Invalid Credential", Toast.LENGTH_SHORT).show();
		}
	}

	private class AsyncLogin extends AsyncTask<String, Void, Object> {
		private ProgressDialog dialog;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			Log.w("AsyncLogin", "onPreExecute");
			if(dialog != null){
				dialog = null;
			}
			dialog = new ProgressDialog(LoginActivity.this);
			dialog.setMessage("Logging In");
			dialog.setCancelable(false);
			if(!dialog.isShowing())
				dialog.show();
		};

		@Override
		protected Object doInBackground(String... params) {
			Log.w("AsyncLogin", "doInBackground");
			String username = params[0];
			String password = params[1];
			
			return params[0];
		}
		
		@Override
		protected void onPostExecute(Object result) {
			super.onPostExecute(result);
			Log.w("AsyncLogin", "onPostExecute");
			if(dialog != null && dialog.isShowing())
				dialog.dismiss();
		}
	}
}
