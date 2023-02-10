package com.kotlinspringrestkafka.producer

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlinspringrestkafka.domain.Compra
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class CompraProducer {

    @Autowired
    private lateinit var template: KafkaTemplate<Any, Any>

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Value("\${compra-topic}")
    private lateinit var topic: String

    fun produceMsg(number: Int, msg: Compra) {
        val value = objectMapper.writeValueAsString(msg)
        template.send(topic,value)
    }
}