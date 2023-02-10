package com.kotlinspringrestkafka.consumer

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class CompraConsumer {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @KafkaListener(topics = ["compra-events"], groupId = "1")
    fun listener(message: String) {
        Thread.sleep(3000)
        logger.info("Message received: [$message]")
    }
}