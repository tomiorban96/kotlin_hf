package hu.kotlin.pizzashop.repository

import hu.kotlin.pizzashop.model.Pizza
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PizzaReactiveRepository : ReactiveMongoRepository<Pizza, String> {
}