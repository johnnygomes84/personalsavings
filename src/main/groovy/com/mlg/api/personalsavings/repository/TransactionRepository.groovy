package com.mlg.api.personalsavings.repository

import com.mlg.api.personalsavings.models.Transaction
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository extends MongoRepository<Transaction, String> {

}