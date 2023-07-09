package com.mlg.api.personalsavings.utils

import com.mlg.api.personalsavings.enums.TransactionType
import com.mlg.api.personalsavings.exception.AccountException
import com.mlg.api.personalsavings.models.Account
import com.mlg.api.personalsavings.models.Transaction
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

import static com.mlg.api.personalsavings.utils.AccountUtils.*
import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertThrows

@ExtendWith(MockitoExtension)
class AccountUtilsTest {

    @Test
    void shouldCreateRandomLong() {
        def accountNumber = generateAccount()
        assert accountNumber
    }

    @Test
    void should_ThrowException() {
        Transaction transaction = new Transaction(id: "123", amount: 70.0, type: TransactionType.DEBIT, account: new Account(id: "32", currentBalance: 15.50))

        def ex = assertThrows(AccountException, () -> generateNewBalance(transaction))
        //Assert
        assertEquals("Transaction exceeds current balance", ex.message)
    }
}
