package com.bitcode.a10_04_24_fragmentsdemoversion1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewDebug.IntToString
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bitcode.a10_04_24_fragmentsdemoversion1.databinding.CounterFragmentBinding

class CounterFragment : Fragment() {

    private lateinit var txtCounterDisplay: TextView
    private lateinit var btnIncrement: Button
    private lateinit var btnDecrement: Button

    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.counter_fragment, null)
        txtCounterDisplay = view.findViewById(R.id.txtCounterDisplay)
        btnIncrement = view.findViewById(R.id.btnIncrement)
        btnDecrement = view.findViewById(R.id.btnDecrement)

        btnIncrement.setOnClickListener {
            count++
            txtCounterDisplay.text = "$count"
        }

        btnDecrement.setOnClickListener {
            if (count > 0) {
                count--
                txtCounterDisplay.text = "$count"
            }
        }
        return view
    }
}