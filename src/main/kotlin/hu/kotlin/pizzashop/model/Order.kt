package hu.kotlin.pizzashop.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Order (
    @Id
    val orderId: String,
    val email: String,
    val phone: String,
    var status: OrderStatus,
    val pizzasIds: List<Int>
)