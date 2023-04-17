package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  var amount:Float?=0f
    private var percentage:Float?=0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val array= arrayOf("2.0","3.0","5.0","7.0","10.0","15.0")
        percentage=array[0].trim().toFloat()
        val adapter= ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,array)
       val spinner=binding.spinner
        spinner.adapter=adapter
        spinner.onItemSelectedListener= object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                percentage=array[p2].trim().toFloat()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        val button=binding.button
        button.setOnClickListener {
           var text: String =binding.amt.text.toString()
           // Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            if(text.isEmpty()) {
                Toast.makeText(this, "Please Enter the amount", Toast.LENGTH_SHORT).show()
            }
            else
            {
                    amount=text.toFloat()
                   val ans= amount!! *(percentage!! /100)
                binding.textView3.text=ans.toString()
            }
        }
    }
}