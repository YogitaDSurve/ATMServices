package com.example
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk

class AutoTellerMachineTest: StringSpec({

    "should call banking service with the right amount when withdraw is called" {
        val printer=Printer()
        val banking=BankingService(true)
        val atm=AutoTellerMachine(printer,banking)
        atm.withdraw(1000)
       banking.totalAmount shouldBe 1000

    }

    "should print a receipt if money is withdrawn successfully" {
        val printer=mockk<Printer>()
        val banking=mockk<BankingService>(true)
        val atm=AutoTellerMachine(printer,banking)
        atm.withdraw(1000)
        printer.count shouldBe 1
        printer.printMsg shouldBe "1000 withdrawn successfully"

    }

    "should print an error if banking service throws an exception" {
        val printer=Printer()
        val banking=BankingService(false)
        val atm=AutoTellerMachine(printer,banking)
        atm.withdraw(1000)
        printer.count shouldBe 1
        printer.printMsg shouldBe "error withdrawing amount"
    }

    "should print an error if amount is 0" {
        val printer=Printer()
        val banking=BankingService(true)
        val atm=AutoTellerMachine(printer,banking)
        atm.withdraw(0)
        printer.count shouldBe 1
        printer.printMsg shouldBe "error withdrawing amount"
    }
})