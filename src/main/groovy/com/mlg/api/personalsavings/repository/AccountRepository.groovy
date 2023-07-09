package com.mlg.api.personalsavings.repository

import com.mlg.api.personalsavings.models.Account
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findByAccountId(Long accountId)
}