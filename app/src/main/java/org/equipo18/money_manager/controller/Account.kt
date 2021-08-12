package org.equipo18.money_manager.controller

class Account(
    private var accountName : String,
    private var balance : Float = 0f,
    private var currency : String = "MXN") {

    private val expenses = mutableListOf<Expenses>()
    private var incomes = mutableListOf<Incomes>()

    private var totalAmountIncome = 0f;
    private var totalAmountExpenses = 0f;

    fun editBalance (newBalance : Float){
        balance = newBalance
    }

    fun getBalance() :Float {
        return balance + getTotal(incomes) - getTotal(expenses)
    }

    fun getAccountName() : String {
        return accountName
    }

    fun addExpense(movement : Expenses) {
        expenses.add(movement)
        totalAmountExpenses +=movement.getAmount()
        balance -= movement.getAmount()
    }

    fun addIncome(movement: Incomes) {
        incomes.add(movement)
        totalAmountIncome +=movement.getAmount()
        balance +=movement.getAmount()
    }

    private fun getTotal(Lista : List<Movement>) : Float {
        var total : Float = 0f
        Lista.map { total += it.getAmount() }
        return total
    }

    }