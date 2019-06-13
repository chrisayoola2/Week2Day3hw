package com.example.week2day3hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText etFirstName;
    EditText etLastName;
    EditText etAddress;
    EditText etCity;
    EditText etState;
    EditText etZip;
    Button btnSave;
    Button btnGoToResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etAddress = findViewById(R.id.etAddress);
        etCity = findViewById(R.id.etCity);
        etState = findViewById(R.id.etState);
        etZip = findViewById(R.id.etZip);
        btnSave = findViewById(R.id.btnSave);
        btnGoToResult = findViewById(R.id.btnGoToResult);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSave:
                goToSavedInfoActivity();

            case R.id.btnGoToResult:
                Intent intent = new Intent(this, SavedInfoActivity.class);
                startActivity(intent);
        }
    }

    public void goToSavedInfoActivity(){ // this happens onclick of save button
        String fName = etFirstName.getText().toString();
        String lName = etLastName.getText().toString();
        String address = etAddress.getText().toString();
        String city = etCity.getText().toString();
        String state = etState.getText().toString();
        String zip = etZip.getText().toString();


        sharedPreferences = getSharedPreferences("shared_pref", MODE_PRIVATE);
        storeToSharedPref("first_name",fName);
        storeToSharedPref("last_name",lName);
        storeToSharedPref("address",address);
        storeToSharedPref("city",city);
        storeToSharedPref("state",state);
        storeToSharedPref("zip",zip);

        Intent intent = new Intent(this,SavedInfoActivity.class);
        startActivity(intent);
    }

private final void storeToSharedPref(String akey, String aString){ // method takes my key and the string

SharedPreferences.Editor editor = sharedPreferences.edit();
editor.putString(akey, aString);
editor.apply();

}


}
