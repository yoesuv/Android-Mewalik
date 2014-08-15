package com.example.mewalik;

import java.util.Stack;

import android.widget.EditText;

public class Walik {

	private int x;
	private String hasil;
	
	public Walik(){
		super();
	}
	
	public void ProsesWalik(String kalimat){
		hasil = "";
		Stack<String> tumpuk = new Stack<String>();
		String[] split = kalimat.split(" ");
		
		for(String kata:split){
			kata = kata + " ";
			for(x=0;x<kata.length();x++){
				tumpuk.push(kata.substring(x, x+1));
			}
			while(!tumpuk.isEmpty()){
				hasil = hasil + tumpuk.pop();
			}
		}
	}
	
	public void Tampilin(EditText et){
		et.setText(hasil);
	}
}
