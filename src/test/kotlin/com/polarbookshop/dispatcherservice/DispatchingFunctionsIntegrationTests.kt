package com.polarbookshop.dispatcherservice

/*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.function.context.FunctionCatalog
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest
import reactor.core.publisher.*
import reactor.test.StepVerifier
import java.util.function.Function

@FunctionalSpringBootTest
class DispatchingFunctionsIntegrationTests(@Autowired private val catalog: FunctionCatalog) {

    @Test
    fun packAndLabelOrder() {
        val packAndLabel: Function<OrderAcceptedMessage, Flux<OrderDispatchedMessage>> =
            catalog.lookup(Function::class.java, "pack|label")

        val orderId: Long = 121

        StepVerifier.create(packAndLabel.apply(OrderAcceptedMessage(orderId)))
            .expectNextMatches { it.equals(OrderDispatchedMessage(orderId)) }
            .verifyComplete()
    }
}*/
