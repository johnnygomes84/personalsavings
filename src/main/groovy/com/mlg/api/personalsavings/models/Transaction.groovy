package com.mlg.api.personalsavings.models

import com.mlg.api.personalsavings.enums.TransactionType
import groovy.transform.Canonical
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType

import java.time.LocalDateTime

@Canonical
@Document
class Transaction implements Serializable {
    private static final long serialVersionUID = -1318219944838935989L

    @Id
    String id
    LocalDateTime transactionDate = LocalDateTime.now()
    TransactionType type
    Long accountId
    String description
    @Field(targetType = FieldType.DECIMAL128)
    BigDecimal amount
}
