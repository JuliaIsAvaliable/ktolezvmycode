package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements View.OnClickListener {//

    DBhelper dBhelper;
    EditText logg;
    EditText passs;
    Button buttonadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        dBhelper = new DBhelper(this);
        logg = findViewById(R.id.editTextTextPersonName);
        passs = findViewById(R.id.editTextTextPersonName2);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String log = logg.getText().toString();
                int pass = Integer.parseInt(passs.getText().toString());
                Toast.makeText( getApplicationContext(),"Я нажался", Toast.LENGTH_SHORT).show();

                Data data = new Data(log,pass);
                dBhelper.AddOne(data);
                break;
            case R.id.button2:
                String lo = logg.getText().toString();
                dBhelper.DeleteOne(lo);
                break;
                case R.id.button3:
                    String pa = passs.getText().toString();
                    String los = logg.getText().toString();
                    dBhelper.Update(los,pa);

                break;
            case R.id.button4:
                String l = logg.getText().toString();
                dBhelper.Select(l);

                break;
        }
        //Intent vac = new Intent(Registration.this, LoginActivity.class);
        //startActivity(vac);

    }
}