package com.mlg.api.personalsavings.controller

import com.mlg.api.personalsavings.models.Account
import com.mlg.api.personalsavings.models.Person
import com.mlg.api.personalsavings.models.SearchContext
import com.mlg.api.personalsavings.models.Transaction
import com.mlg.api.personalsavings.service.AccountService
import groovy.transform.TupleConstructor
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@TupleConstructor(includeFields = true, defaults = false)
@RequestMapping("/api/account")
class AccountController {

    private final AccountService accountService

    @GetMapping("/all")
    ResponseEntity<Page<Account>> findAll(SearchContext searchContext) {
        ResponseEntity.ok(accountService.findAll(searchContext))
    }

    @GetMapping("/id/{id}")
    ResponseEntity<Account> findById(@PathVariable String id) {
        ResponseEntity.ok(accountService.findById(id))
    }

    @GetMapping("/accountId/{accountId}")
    ResponseEntity<Account> findByAccountId(@PathVariable Long accountId) {
        ResponseEntity.ok(accountService.findByAccountId(accountId))
    }

    @PostMapping("/new")
    ResponseEntity<Account> create(@RequestBody Account account) {
        ResponseEntity.ok(accountService.createNew(account))
    }
}
