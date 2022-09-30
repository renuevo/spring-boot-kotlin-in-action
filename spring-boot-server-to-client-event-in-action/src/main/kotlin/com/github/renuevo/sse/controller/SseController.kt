package com.github.renuevo.sse.controller

import com.github.renuevo.sse.service.SseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@RestController
@RequestMapping("/see")
class SseController(private val sseService: SseService) {


    @GetMapping("/subscribe")
    fun subscribe(@RequestHeader("Last-Event-ID", required = false, defaultValue = "") lastEventId: String): SseEmitter = sseService.subscribe(lastEventId)
}