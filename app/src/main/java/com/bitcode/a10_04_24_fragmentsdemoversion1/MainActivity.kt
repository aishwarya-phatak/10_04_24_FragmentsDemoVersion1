package com.bitcode.a10_04_24_fragmentsdemoversion1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private lateinit var counterFragment: CounterFragment
    private lateinit var btnAdd : Button
    private lateinit var btnRemove : Button
    private val fragmentManager = supportFragmentManager
    private lateinit var fragmentTransaction1 : FragmentTransaction
    private lateinit var fragmentTransaction2 : FragmentTransaction

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd = findViewById(R.id.btnAdd)
        btnRemove = findViewById(R.id.btnRemove)

        btnAdd.setOnClickListener {
            //you can add fragment on button click
            fragmentTransaction1 = fragmentManager.beginTransaction()
            fragmentTransaction1.add(R.id.counterFragment,CounterFragment())
            fragmentTransaction1.commit()
        }

        btnRemove.setOnClickListener {
            //you can remove fragment on button click
            fragmentTransaction2 = fragmentManager.beginTransaction()
            fragmentTransaction2.remove(CounterFragment())
            fragmentTransaction2.commit()
        }
//        counterFragment = supportFragmentManager.findFragmentById(R.id.counterFragment)
//                as CounterFragment
    }
}