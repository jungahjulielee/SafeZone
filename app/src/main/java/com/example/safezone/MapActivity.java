package com.example.safezone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap map;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        alert.setPositiveButton("Stop", new DialogInterface.OnClickListener() {
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng Coffman = new LatLng(44.972983176, -93.2353068283);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Coffman, 17));
        map.addMarker(new MarkerOptions().position(Coffman).title("Coffman"));

    }
}