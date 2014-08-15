package com.example.mewalik;

import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText t1,t2;
	private Button btnEx,btnWalik,btnSend,btnReset;
	
	private String kata,hasil;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		t1 = (EditText) findViewById(R.id.text_Input);
		t2 = (EditText) findViewById(R.id.text_Output);
		btnEx = (Button) findViewById(R.id.btnExit);
		btnWalik = (Button) findViewById(R.id.btnWalik);
		btnSend = (Button) findViewById(R.id.btnSend);
		btnReset = (Button) findViewById(R.id.btnReset);
		
		t2.setKeyListener(null);
		
		btnWalik.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				kata = t1.getText().toString();
				if(kata.isEmpty()){
					Toast.makeText(v.getContext(),"Kata Input Kosong!", Toast.LENGTH_SHORT).show();
					t1.requestFocus();
				}else{
					Walik w = new Walik();
					w.ProsesWalik(kata);
					w.Tampilin(t2);
				}
			}
		});
		
		btnReset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder ab = new AlertDialog.Builder(v.getContext());
				ab.setMessage("Reset Mewalik ?")
				.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						t1.setText("");
						t2.setText("");
					}
				})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface di, int arg1) {
						di.dismiss();
					}
				})
				.show();
			}
		});
		
		btnSend.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				hasil = t2.getText().toString();
				if(hasil.isEmpty()){
					Toast.makeText(v.getContext(),"Walik dulu sam!!", Toast.LENGTH_SHORT).show();
					t1.requestFocus();
				}else{
					Intent itt = new Intent("android.intent.action.VIEW");
					Uri data = Uri.parse("sms:");
					itt.putExtra("sms_body", hasil);
					itt.setData(data);
					startActivity(itt);
				}
			}
		});
		
		btnEx.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder ab = new AlertDialog.Builder(v.getContext());
				ab.setMessage("Keluar dari Aplikasi ?")
				.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						System.exit(0);
					}
				})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface di, int arg1) {
						di.dismiss();
					}
				})
				.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
