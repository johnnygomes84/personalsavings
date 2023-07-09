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

    static Account generateNewBalance(Transaction transaction, Account account) {

        switch (transaction.type) {
            case TransactionType.DEBIT:
                if (!hasFunds(transaction, account)) {
                    throw new AccountException("Transaction exceeds current balance")
                }
                account.currentBalance -= transaction.amount
                break
            case TransactionType.CREDIT:
                account.currentBalance += transaction.amount
                break
            default:
                account
        }
        account
    }

    static Boolean hasFunds(Transaction transaction, Account account) {
        account.currentBalance - transaction.amount < 0 ? false : true
    }
}
