package org.equipo18.money_manager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class FirstOpen : AppCompatActivity() {
    private lateinit var buttonRegister : Button
    private lateinit var buttonIniciar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        runBlocking {
            setTheme(R.style.Theme_MoneyManager)
            delay(3000L)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_open)

        buttonRegister = findViewById(R.id.buttonRegister)
        buttonIniciar = findViewById(R.id.buttonInicio)

        buttonRegister.setOnClickListener{
            val intentReg = Intent(this,RegisterActivity::class.java)
            startActivity(intentReg)
        }

        buttonIniciar.setOnClickListener {
            val intentLog = Intent(this, LoginActivity::class.java)
            startActivity(intentLog)
        }
    }
}