package com.kotlinspringrestkafka.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class AutoCreateConfig {

    @Value("\${compra-topic}")
    lateinit var topic: String

    @Bean
    fun purchaseEvents(): NewTopic {
        return TopicBuilder.name(topic)
            .partitions(3)
//            .replicas(0)
            .build()
    }
}