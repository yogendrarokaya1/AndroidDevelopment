package com.example.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginFormActivity : AppCompatActivity() {
    // Find views by ID
    val firstNameInput = findViewById<EditText>(R.id.firstNameInput)
    val lastNameInput = findViewById<EditText>(R.id.lastNameInput)
    val emailInput = findViewById<EditText>(R.id.emailInput)
    val passwordInput = findViewById<EditText>(R.id.passwordInput)
    val signUpButton = findViewById<Button>(R.id.signUpButton)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_form)




        // Set click listener for the Sign Up button
        signUpButton.setOnClickListener {
            val firstName = firstNameInput.text.toString()
            val lastName = lastNameInput.text.toString()
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (firstName.isNotBlank() && lastName.isNotBlank() && email.isNotBlank() && password.isNotBlank()) {
                Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.backArrow)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}