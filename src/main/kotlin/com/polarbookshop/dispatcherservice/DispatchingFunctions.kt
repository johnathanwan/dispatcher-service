package com.polarbookshop.dispatcherservice

import org.slf4j.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.*
import java.util.function.Function

@Configuration
class DispatchingFunctions {

    @Bean
    fun pack(): Function<OrderAcceptedMessage, Long> = Function { (orderId): OrderAcceptedMessage ->
        log.info("The order with id $orderId is packed.")
        orderId
    }

    @Bean
    fun label(): Function<Flux<Long>, Flux<OrderDispatchedMessage>> = Function { orderFlux ->
        orderFlux.map {
            log.info("The order with id $it is labeled.")
            OrderDispatchedMessage(it)
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(DispatchingFunctions::class.java)
    }
}