package com.example.myfirstapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.sql.Date
import java.util.Calendar

class SignupActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner: Spinner
    lateinit var display: TextView
    lateinit var autoCompleteTextView: AutoCompleteTextView

    lateinit var datepick: EditText

    val city = arrayOf("kat", "lat", "Kanchanpur", "Bhadrapur", "lainchaur")
    val countries = arrayOf("Nepal", "China", "India")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        spinner = findViewById(R.id.spinner)
        display = findViewById(R.id.displayDropdown)
        autoCompleteTextView = findViewById(R.id.autoComplete)

        datepick= findViewById(R.id.datePick)

        spinner.onItemSelectedListener = this

        val adapter = ArrayAdapter(
            this@SignupActivity,
            android.R.layout.simple_spinner_item,
            countries
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        val autoCompleteAdapter = ArrayAdapter(
            this@SignupActivity,
            android.R.layout.simple_spinner_dropdown_item,
            city
        )

        autoCompleteTextView.setAdapter(autoCompleteAdapter)
        autoCompleteTextView.threshold = 1

        datepick.isFocusable= false;
        datepick.isClickable= true;
        datepick.setOnClickListener{
            loadCalender()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadCalender() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month= c.get(Calendar.MONTH)
        val day= c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(
            this@SignupActivity,
            DatePickerDialog.OnDateSetListener
            {d,year,month,day ->

                datepick.setText("$day/${month+1}/$year")
            },year,month,day
        )
        dialog.show();
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (p0 != null) {
            display.text = p0.getItemAtPosition(p2).toString()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}