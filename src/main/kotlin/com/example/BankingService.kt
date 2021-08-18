package com.example

class BankingService (var shouldTransactionSucceed: Boolean) {
    var totalAmount=0
    fun withdraw(amount: Int){
        totalAmount=amount
        if (shouldTransactionSucceed == false||totalAmount==0) throw Exception()

    }
}
