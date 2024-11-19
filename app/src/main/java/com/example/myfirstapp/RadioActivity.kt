package com.example.myfirstapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioActivity : AppCompatActivity() {
    lateinit var apple: RadioButton
    lateinit var mango: RadioButton
    lateinit var grapes: RadioButton
    lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio)
        apple = findViewById(R.id.btnApple)
        mango = findViewById(R.id.btnMango)
        grapes = findViewById(R.id.btnGrapes)
        image = findViewById(R.id.imageView)

        mango.setOnClickListener{
            image.setImageResource(R.drawable.apple)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.backArrow)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}