package edu.uchicago.cs;

import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	SharedPreferences shp;
	TextView txtShow;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtShow = (TextView) findViewById(R.id.txtShow);
		shp = PreferenceManager.getDefaultSharedPreferences(this);

	}

	@Override
	protected void onRestart() {
		super.onRestart();
		StringBuilder stb = new StringBuilder();
		Map<String, ?> map = shp.getAll();
		for(Map.Entry<String,?> entry : map.entrySet()){
			 String strKey = entry.getKey();
			 Object  objValue = entry.getValue();
			 stb.append(strKey + " : ");
			 stb.append(objValue.toString() + "\n");
		}
		txtShow.setText(stb.toString());
		
	}
	// ********************************
	// The following two methods are used to create the action-bar menu items
	// ********************************
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.act_bar, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.action_prefs:
			startActivity(new Intent(this, FragPrefsActivity.class));

			break;
		case R.id.action_exit:
			finish();

			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);

	}

}
