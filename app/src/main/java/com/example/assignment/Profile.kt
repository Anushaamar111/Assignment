package com.example.assignment

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignment.databinding.ActivityProfileBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.auth.FirebaseAuth

class Profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


            // Get current user's email and display it
            val currentUser = FirebaseAuth.getInstance().currentUser
            val emailTextView = binding.email
            val logoutButton = binding.button
            currentUser?.let {
                val email = it.email
                emailTextView.text = email

            }


            // Handle logout button click
            logoutButton.setOnClickListener {
                // Sign out the user
                FirebaseAuth.getInstance().signOut()

                // Navigate to the login activity
                val intent = Intent(this@Profile, Login::class.java)
                startActivity(intent)

                // Finish the current activity to prevent going back to it via back button
                finish()
            }
        }
    }


