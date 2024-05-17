package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignment.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)


        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signup.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val username = binding.username.text.toString()

            if(email.isNotEmpty()&& password.isNotEmpty()&&username.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this){
                        task ->

                        if (task.isSuccessful) {

                            Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, Login::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else{
                            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            else{
                Toast.makeText(this, "Empty Fields", Toast.LENGTH_SHORT).show()
            }

        }
        binding.loginText.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }

    }
}