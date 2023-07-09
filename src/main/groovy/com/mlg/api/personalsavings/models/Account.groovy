package com.mlg.api.personalsavings.models

import groovy.transform.Canonical
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType

@Canonical
@Document
class Account implements Serializable {

    private static final long serialVersionUID = 5024206235730384233L

    @Id
    String id
    Long accountId
    @DBRef(lazy = true)
    Person accountHolder
    @Field(targetType = FieldType.DECIMAL128)
    BigDecimal currentBalance
    @Transient
    List<Transaction> transactions
}
