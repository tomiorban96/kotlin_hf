package hu.kotlin.pizzashop.service

import hu.kotlin.pizzashop.model.Pizza
import hu.kotlin.pizzashop.repository.PizzaReactiveRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class PizzaService @Autowired constructor(
  val pizzaRepository: PizzaReactiveRepository
) {
    fun getMenu(): Flux<Pizza> {
        return pizzaRepository.findAll()
    }
}