package com.example.safezone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    public void showAlertDialog(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Do you want to send out SOS messages?");
            alert.setMessage("Messages contain your location \n" +
                    "information will be sent to your pre-defined recipients.");
            alert.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(MapActivity.this,"SOS messages are sending out!", Toast.LENGTH_SHORT).show();
                }
            });
            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(MapActivity.this,"No messages are sending out!", Toast.LENGTH_SHORT).show();
                }
            });
            alert.create().show();
    }
    public void showAlertDialog1(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("The navigation is pausing");
        alert.setMessage("Timer for mass texts is pausing.");
        alert.setPositiveButton("Resume", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MapActivity.this,"Continue navigation.", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("Stop", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MapActivity.this,"Navigation is stopped.", Toast.LENGTH_SHORT).show();
            }
        });
        alert.create().show();
    }
    public void showAlertDialog2(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Do you want to quit the navigation?");
        alert.setPositiveButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MapActivity.this,"Navigation is stopped.", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("Resume", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MapActivity.this,"Continue navigation.", Toast.LENGTH_SHORT).show();
            }
        });
        alert.create().show();
    }
}