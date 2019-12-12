package hu.kotlin.pizzashop.repository

import hu.kotlin.pizzashop.model.Order
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface OrderReactiveRepository : ReactiveMongoRepository<Order, String> {
    fun findByOrderId(orderId: String): Mono<Order>
}