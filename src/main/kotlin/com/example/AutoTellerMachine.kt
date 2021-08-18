package com.example
//var Balance=10000
class AutoTellerMachine (private val printer:Printer,private val banking:BankingService) {
    fun withdraw(amount: Int) {
        try {
            banking.withdraw(amount)
            printer.print("$amount withdrawn successfully")
        }catch(exception:Exception)
        {
            printer.print("error withdrawing amount")
        }
    }

}
