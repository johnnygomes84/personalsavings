package com.mlg.api.personalsavings.controller

import com.mlg.api.personalsavings.models.Account
import com.mlg.api.personalsavings.models.SearchContext
import com.mlg.api.personalsavings.models.Transaction
import com.mlg.api.personalsavings.service.TransactionService
import groovy.transform.TupleConstructor
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@TupleConstructor(includeFields = true, defaults = false)
@RequestMapping("/api/transaction")
class TransactionController {

    private final TransactionService transactionService

    @GetMapping("/all")
    ResponseEntity<Page<Transaction>> findAll(SearchContext searchContext) {
        ResponseEntity.ok(transactionService.findAll(searchContext))
    }

    @GetMapping("/account/{accountId}")
    ResponseEntity<List<Transaction>> findByAccountId(@PathVariable Long accountId) {
        ResponseEntity.ok(transactionService.getTransactionsByAccountId(accountId))
    }

    @PostMapping("/new")
    ResponseEntity<Transaction> create(@RequestBody Transaction transaction) {
        ResponseEntity.ok(transactionService.createTransaction(transaction))
    }
}
