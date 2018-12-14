package com.app.mytestapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {


    Button buttonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClick = findViewById(R.id.buttonClick);
        buttonClick.setOnClickListener(this);

        //createDialog();

        createCustomeDialog();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Toast.makeText(this, data.getStringExtra("someData"), Toast.LENGTH_SHORT).show();
        }
    }

    public void createDialog() {
        Dialog dialog = new AlertDialog.Builder(this)
                .setTitle("Test")
                .setMessage("You like this :)")
                .setCancelable(false)
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("Nie", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "What is not OK ", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }).show();
    }


    public void createCustomeDialog() {
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dialog_test);
        dialog.setTitle("test");


        Button exit = dialog.findViewById(R.id.buttonExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
