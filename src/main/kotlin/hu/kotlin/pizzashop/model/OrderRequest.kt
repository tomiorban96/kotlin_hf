package hu.kotlin.pizzashop.model

import java.io.Serializable

data class OrderRequest (
    val email: String,
    val phone: String,
    val status: String,
    val pizzasIds: List<Int>
): Serializable
