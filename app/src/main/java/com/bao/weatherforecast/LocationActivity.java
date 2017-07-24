package com.bao.weatherforecast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bao.preference.LocationPreference;

public class LocationActivity extends AppCompatActivity {
    private LocationPreference pref;
    private Intent intent;
    private EditText editLocation;
    private Button btnOk, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        intent = getIntent();
        pref = new LocationPreference(this);
        String city = pref.getCity();

        editLocation = (EditText) findViewById(R.id.editLocation);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        editLocation.setText(city);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newCity = editLocation.getText().toString();
                if (!newCity.isEmpty()) {
                    setResult(1, intent);
                    pref.setCity(newCity);
                    finish();
                } else {
                    Toast.makeText(LocationActivity.this, getString(R.string.error_empty), Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
