package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignment.databinding.ActivityLogin2Binding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLogin2Binding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)
            firebaseAuth = FirebaseAuth.getInstance()
            binding.loginBtn.setOnClickListener {
                val email = binding.email.text.toString()
                val password = binding.password.text.toString()

                if(email.isNotEmpty() && password.isNotEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this){
                            task->
                            if(task.isSuccessful){
                                val intent = Intent(this@Login, OTPx::class.java)
                                startActivity(intent)
                                finish()
                            }
                            else{
                                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                            }
                        }

                }

                else{
                    Toast.makeText(this, "Empty Fields", Toast.LENGTH_SHORT).show()
                }
            }
        binding.RegisterText.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)

        }
    }
}