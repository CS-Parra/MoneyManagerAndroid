package org.equipo18.money_manager.controller

abstract class Movement(
    private val name: String,
    private val description: String,
    private val amount: Float,
    private val date: String
) {
    abstract fun getAmount() : Float
}