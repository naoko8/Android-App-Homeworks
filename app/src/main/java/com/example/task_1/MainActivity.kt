package com.example.task_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        logInButton.setOnClickListener {
            if (userName.text.toString().isEmpty() || password.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter a valid mail or password", Toast.LENGTH_SHORT)
                    .show()
                }
            else
            {
                Toast.makeText(this, "welcome...", Toast.LENGTH_SHORT)
                    .show()
            }
            }
    }
}
