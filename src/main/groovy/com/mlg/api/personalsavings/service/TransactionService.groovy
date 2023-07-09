package com.mlg.api.personalsavings.service

import com.mlg.api.personalsavings.models.SearchContext
import com.mlg.api.personalsavings.models.Transaction
import com.mlg.api.personalsavings.repository.TransactionRepository
import groovy.transform.TupleConstructor
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import static com.mlg.api.personalsavings.utils.AccountUtils.*

@Service
@TupleConstructor(includeFields = true, defaults = false)
class TransactionService {

    private final TransactionRepository transactionRepository
    private final AccountService accountService

    @Transactional
    Transaction createTransaction(Transaction transaction) {
        transaction.account = accountService.findById(transaction.account.id)
        generateNewBalance(transaction)
        accountService.updateBalance(transaction.account)
        transactionRepository.save(transaction)
    }

    Page<Transaction> findAll(SearchContext searchContext) {
        transactionRepository.findAll(PageRequest.of(searchContext.page, searchContext.size))
    }
}
