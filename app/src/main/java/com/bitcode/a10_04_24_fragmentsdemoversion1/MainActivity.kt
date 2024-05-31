package com.bitcode.a10_04_24_fragmentsdemoversion1

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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
    private val counterFragments = ArrayList<CounterFragment>()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd = findViewById(R.id.btnAdd)
        btnRemove = findViewById(R.id.btnRemove)

        btnAdd.setOnClickListener {
            //you can add fragment on button click
            val counterFragment = CounterFragment()
            fragmentTransaction1 = fragmentManager.beginTransaction()
            fragmentTransaction1.add(R.id.counterFragment,counterFragment)
            fragmentTransaction1.commit()
            counterFragments.add(counterFragment)       //we need to add the fragment to arraylist
        }

        btnRemove.setOnClickListener {
            //you can remove fragment on button click
            if(counterFragments.size == 0){
                return@setOnClickListener
            }
            val counterFragmentIndex = counterFragments.size - 1
            val counterFragment = counterFragments[counterFragmentIndex]    //calculating lastIndex
            Log.e("tag","$counterFragmentIndex" +"")
            fragmentTransaction2 = fragmentManager.beginTransaction()
            fragmentTransaction2.remove(counterFragment)
            fragmentTransaction2.commit()

            counterFragments.remove(counterFragment)    //we need to remove the fragment from an arraylist
        }
//        counterFragment = supportFragmentManager.findFragmentById(R.id.counterFragment)
//                as CounterFragment
    }
}