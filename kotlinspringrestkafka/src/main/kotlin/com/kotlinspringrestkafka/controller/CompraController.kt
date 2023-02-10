package com.kotlinspringrestkafka.controller

import com.kotlinspringrestkafka.domain.Compra
import com.kotlinspringrestkafka.producer.CompraProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("compra")
class CompraController {

    @Autowired
    private lateinit var producer: CompraProducer

    @PostMapping("novo")
    fun criar(@RequestBody request: Compra): ResponseEntity<String> {
        producer.produceMsg(request.id, request)
        return ResponseEntity(HttpStatus.OK)
    }

}