package hu.kotlin.pizzashop.service

import hu.kotlin.pizzashop.model.Order
import hu.kotlin.pizzashop.model.OrderRequest
import hu.kotlin.pizzashop.model.OrderStatus
import hu.kotlin.pizzashop.repository.OrderReactiveRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.OffsetDateTime
import java.util.UUID

@Service
class OrderService @Autowired constructor(
    val orderRepository: OrderReactiveRepository
) {
    fun getOrders(): Flux<Order> {
        return orderRepository.findAll()
    }

    fun placeOrder(orderRequest: OrderRequest): Mono<Order> {
        val newOrder = Order(
            orderId = UUID.randomUUID().toString(),
            email = orderRequest.email,
            phone = orderRequest.phone,
            status = transformStatus(orderRequest.status),
            pizzasIds = orderRequest.pizzasIds
        )
        return orderRepository.save(newOrder)
    }

    fun updateOrderStatus(id: String, newStatus: String): Mono<Order> {
        val newStatusEnum = transformStatus(newStatus)
        return orderRepository.findById(id)
            .flatMap {
                orderRepository.save(it.copy(status = newStatusEnum))
            }
    }

    private fun changeStatus(order: Order, status: OrderStatus): Mono<Order> {
        order.status = status
        return Mono.just(order)
    }

    private fun transformStatus(newStatus: String) = when(newStatus) {
        "placed" -> OrderStatus.PLACED
        "inprogress" -> OrderStatus.IN_PROGRESS
        "underdelivery" -> OrderStatus.UNDER_DELIVERY
        "delivered" -> OrderStatus.DELIVERED
        else -> {
            throw Exception("Unknown status")
        }
    }
}