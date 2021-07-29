package org.equipo18.money_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val twUser = findViewById<TextView>(R.id.user)

        val user = intent.extras?.getString(USER_NAME)

        twUser.text = user

    }
}