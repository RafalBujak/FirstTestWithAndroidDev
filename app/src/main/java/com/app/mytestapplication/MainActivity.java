package com.app.mytestapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView helloText;
    Button buttonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloText = findViewById(R.id.helloText);
        helloText.setText("Jestem zmieniony");

        buttonClick = findViewById(R.id.buttonClick);
        buttonClick.setText(R.string.zmienilem_text);
        buttonClick.setOnClickListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Kliknieto mnie!", Toast.LENGTH_SHORT).show();
    }
}
