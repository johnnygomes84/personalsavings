package com.mlg.api.personalsavings.service

import com.mlg.api.personalsavings.exception.AccountException
import com.mlg.api.personalsavings.models.Account
import com.mlg.api.personalsavings.models.SearchContext
import com.mlg.api.personalsavings.models.Transaction
import com.mlg.api.personalsavings.repository.AccountRepository
import groovy.transform.TupleConstructor
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import static com.mlg.api.personalsavings.utils.AccountUtils.*

@Service
@TupleConstructor(includeFields = true, defaults = false)
class AccountService {

    private final AccountRepository accountRepository

    Account createNew(Account account) {
        account.accountId = generateAccount()
        accountRepository.save(account)
    }

    Page<Account> findAll(SearchContext searchContext) {
        accountRepository.findAll(PageRequest.of(searchContext.page, searchContext.size))
    }

    Account findById(String id) {
        accountRepository.findById(id)
                .orElseThrow(() -> new AccountException("Account not found for id: $id"))
    }

    @Transactional
    Account updateBalance(Account account) {
        def updateAccount = accountRepository.findById(account.id)
                .orElseThrow(() -> new AccountException("Account not found for id: $account.id"))
        updateAccount.currentBalance = account.currentBalance
        accountRepository.save(updateAccount)
    }
}
