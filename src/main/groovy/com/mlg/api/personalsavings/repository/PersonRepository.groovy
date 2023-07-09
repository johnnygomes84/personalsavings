package com.mlg.api.personalsavings.repository

import com.mlg.api.personalsavings.models.Person
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository extends MongoRepository<Person, String> {
}
