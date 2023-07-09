package com.mlg.api.personalsavings.utils

import com.mlg.api.personalsavings.enums.TransactionType
import com.mlg.api.personalsavings.exception.AccountException
import com.mlg.api.personalsavings.models.Account
import com.mlg.api.personalsavings.models.Transaction
import org.apache.commons.math3.random.RandomDataGenerator

final class AccountUtils {

    static Long generateAccount() {
        new RandomDataGenerator().nextLong(000000, 999999)
    }

    static Account generateNewBalance(Transaction transaction) {

        switch (transaction.type) {
            case TransactionType.DEBIT:
                if (!hasFunds(transaction)) {
                    throw new AccountException("Transaction exceeds current balance")
                }
                transaction.account.currentBalance -= transaction.amount
                return
            case TransactionType.CREDIT:
                transaction.account.currentBalance += transaction.amount
                return
            default:
                transaction.account.currentBalance
        }
    }

    static Boolean hasFunds(Transaction transaction) {
        transaction.account.currentBalance - transaction.amount < 0 ? false : true
    }
}
