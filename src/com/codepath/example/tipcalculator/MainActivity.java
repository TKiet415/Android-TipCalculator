package com.codepath.example.tipcalculator;

import java.math.BigDecimal;
import java.math.MathContext;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public EditText etEnterAmount;
	public TextView tvTipAmount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etEnterAmount = (EditText) findViewById(R.id.etEnterAmount);
		tvTipAmount = (TextView) findViewById(R.id.tvTipAmount);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onSubmit(View v) {
		String FieldValue = etEnterAmount.getText().toString();
		
		MathContext mc = new MathContext(4);
		
		if (!FieldValue.matches("[-+]?\\d*\\.?\\d+")) {
			Toast.makeText(this, "Invalid input. Please try again.", Toast.LENGTH_SHORT).show();
		}
		else {
			
			BigDecimal bd = new BigDecimal(FieldValue);
			
			String tipAmount;
			
			switch (v.getId()) {
			case R.id.btnTenPct:
				bd = bd.multiply(new BigDecimal("0.10"), mc);
				tipAmount = "10%";
				break;
			case R.id.btnFifteenPct:
				bd = bd.multiply(new BigDecimal("0.15"), mc);
				tipAmount = "15%";
				break;
			case R.id.btnTwentyPct:
				bd = bd.multiply(new BigDecimal("0.20"), mc);
				tipAmount = "20%";
				break;
			default:
				throw new RuntimeException("Unknown button ID");
			}
			// Fire when the button is pressed
			Toast.makeText(this, tipAmount + " tip of total amount is:  $" + bd, Toast.LENGTH_SHORT).show();
			
			// Change the text label
			tvTipAmount.setText(tipAmount + " tip of total amount is:  $" + bd);
		}
	}

}
