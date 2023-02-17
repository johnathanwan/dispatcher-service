package com.polarbookshop.dispatcherservice

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.binder.test.InputDestination
import org.springframework.cloud.stream.binder.test.OutputDestination
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration
import org.springframework.context.annotation.Import
import org.springframework.integration.support.MessageBuilder

@SpringBootTest
@Import(TestChannelBinderConfiguration::class)
class FunctionsStreamIntegrationTests(
    @Autowired private val input: InputDestination,
    @Autowired private val output: OutputDestination,
    @Autowired private val objectMapper: ObjectMapper,
) {
    @Test
    fun `when order accepted then dispatched`() {
        val orderId: Long = 121
        val inputMessage = MessageBuilder.withPayload(OrderAcceptedMessage(orderId)).build()
        val expectedOutputMessage = MessageBuilder.withPayload(OrderDispatchedMessage(orderId)).build()

        input.send(inputMessage)
        assertThat(objectMapper.readValue(output.receive().payload, OrderDispatchedMessage::class.java))
            .isEqualTo(expectedOutputMessage.payload)
    }
}