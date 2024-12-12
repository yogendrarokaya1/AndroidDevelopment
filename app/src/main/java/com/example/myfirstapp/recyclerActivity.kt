package com.example.myfirstapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.adapter.FruitsAdapter

class recyclerActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    var imageList = ArrayList<Int>()
    var fruitsTitle = ArrayList<String>()
    var fruitsDesc = ArrayList<String>()
    lateinit var adapter: FruitsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler)

        recyclerView = findViewById(R.id.recyclerView)
        imageList.add(R.drawable.apple)
        imageList.add(R.drawable.mango)
        imageList.add(R.drawable.graapes)

        fruitsTitle.add("Apple")
        fruitsTitle.add("Mango")
        fruitsTitle.add("Grapes")

        fruitsDesc.add("This is Apple")
        fruitsDesc.add("This is Mango")
        fruitsDesc.add("This is Grapes")

    adapter = FruitsAdapter(
        this@recyclerActivity,
        imageList, fruitsTitle, fruitsDesc
    )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}