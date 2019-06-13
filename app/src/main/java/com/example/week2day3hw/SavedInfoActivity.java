package com.example.week2day3hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SavedInfoActivity extends AppCompatActivity {
    TextView tvFirstDisplay;
    TextView tvLastDisplay;
    TextView tvAddressDisplay;
    TextView tvCityDisplay;
    TextView tvStateDisplay;
    TextView tvZipDisplay;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("shared_pref",MODE_PRIVATE); // gets shared prefrences
        setContentView(R.layout.activity_saved_info);
        tvFirstDisplay = findViewById(R.id.tvFirstDisplay);
        tvLastDisplay = findViewById(R.id.tvLastDisplay);
        tvAddressDisplay = findViewById(R.id.tvAddressDisplay);
        tvCityDisplay = findViewById(R.id.tvCityDisplay);
        tvStateDisplay = findViewById(R.id.tvStateDisplay);
        tvZipDisplay= findViewById(R.id.tvZipDisplay);

       tvFirstDisplay.setText( sharedPreferences.getString("first_name","NO NAME HERE"));
       tvLastDisplay.setText(sharedPreferences.getString("last_name" , "No Last Name"));
       tvAddressDisplay.setText(sharedPreferences.getString("address", "No ADDRESS"));
        tvCityDisplay.setText(sharedPreferences.getString("city", "NO CITY"));
        tvStateDisplay.setText(sharedPreferences.getString("state", "NO STATE"));
        tvZipDisplay.setText(sharedPreferences.getString("zip", "NO ZIP"));
    }
}
