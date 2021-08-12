package org.equipo18.money_manager.controller

class Expenses(private val name: String,
               private val description: String,
               private val amount: Float,
                private val date: String) : Movement(name, description, amount, date) {

    override fun getAmount() :Float {
        return amount
    }

}