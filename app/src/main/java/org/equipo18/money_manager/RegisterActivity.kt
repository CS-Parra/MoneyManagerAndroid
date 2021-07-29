package org.equipo18.money_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val txtEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val txtPassword = findViewById<EditText>(R.id.editTextTextPassword)
        val txtPassword2 = findViewById<EditText>(R.id.editTextTextPassword2)
        val btnRegistrar = findViewById<Button>(R.id.buttonRegistrar)


        btnRegistrar.setOnClickListener {

        }
    }


}