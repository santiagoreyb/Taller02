package com.example.taller_0202

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE_LOCATION_PERMISSION = 1
    lateinit var imageViewListener: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val camaraImageButtonListener:ImageButton = findViewById(R.id.camaraImageButtonID)
        camaraImageButtonListener.setOnClickListener {
            val camaraIntent = Intent(this,CamaraActivity::class.java)
            startActivity(camaraIntent)
        }
        val contactosImageButtonListener:ImageButton = findViewById(R.id.contactosImageButtonID)
        contactosImageButtonListener.setOnClickListener {
            val contactosIntent = Intent(this,ContactosActivity::class.java)
            startActivity(contactosIntent)
        }
        val mapsImageButtonListener:ImageButton = findViewById(R.id.mapaImageButtonID)
        mapsImageButtonListener.setOnClickListener {
            val mapsIntent = Intent(this,MapsActivity::class.java)
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_CODE_LOCATION_PERMISSION)
            } else {
                startActivity(mapsIntent)
            }
        }
    }

}