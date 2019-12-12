package hu.kotlin.pizzashop.controller

import hu.kotlin.pizzashop.model.Order
import hu.kotlin.pizzashop.model.OrderRequest
import hu.kotlin.pizzashop.model.Pizza
import hu.kotlin.pizzashop.service.OrderService
import hu.kotlin.pizzashop.service.PizzaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api")
class PizzashopController @Autowired constructor(
    val pizzaService: PizzaService,
    val orderService: OrderService
) {

    @GetMapping(value = ["/menu"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getMenu(): Flux<Pizza> {
        return pizzaService.getMenu()
    }

    @GetMapping(value = ["/orders"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getOrders(): Flux<Order> {
        return orderService.getOrders()
    }

    @PostMapping(value = ["/orders"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun placeOrder(@RequestBody orderRequest: OrderRequest): Mono<Order> {
        return orderService.placeOrder(orderRequest)
    }

    @PatchMapping(value = ["/orders/{id}/{status}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateOrderStatus(@PathVariable("id") id: String, @PathVariable("status") status: String): Mono<Order> {
        return orderService.updateOrderStatus(id, status)
    }
}