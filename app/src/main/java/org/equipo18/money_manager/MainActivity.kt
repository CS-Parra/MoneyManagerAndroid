package org.equipo18.money_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        runBlocking {
            setTheme(R.style.Theme_MoneyManager)
            delay(3000L)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}