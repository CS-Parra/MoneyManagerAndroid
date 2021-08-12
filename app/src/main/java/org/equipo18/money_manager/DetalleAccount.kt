package org.equipo18.money_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetalleAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_account)

        val imgAccount: ImageView = findViewById(R.id.ivAccount)
        val tvAccountName: TextView = findViewById(R.id.tvAccountName)
        val tvBalance: TextView = findViewById(R.id.tvBalance)
        val tvCurrency: TextView = findViewById(R.id.tvCurrency)

        val imageSrc = intent.extras?.get("image") as Int
        val accountName = intent.extras?.get("accountName") as String
        val balance = intent.extras?.get("balance") as Float
        val currency = intent.extras?.get("currency") as String

        imgAccount.setImageResource(imageSrc)
        tvAccountName.text = accountName
        tvBalance.text = balance.toString()
        tvCurrency.text = currency
    }
}