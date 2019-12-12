package hu.kotlin.pizzashop.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Pizza (
    @Id
    val id: String,
    val name: String,
    val price: Int,
    val description: String
)