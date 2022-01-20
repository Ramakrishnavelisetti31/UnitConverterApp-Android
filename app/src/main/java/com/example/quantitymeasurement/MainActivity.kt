package com.example.quantitymeasurement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertQuantity = findViewById<Button>(R.id.convert_button)
        val addQuantity = findViewById<Button>(R.id.add_button)

        convertQuantity.setOnClickListener {
            replaceFragment(ConvertQuantityFragment())
        }

        addQuantity.setOnClickListener {
            replaceFragment(AddQuantityFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
    }
}