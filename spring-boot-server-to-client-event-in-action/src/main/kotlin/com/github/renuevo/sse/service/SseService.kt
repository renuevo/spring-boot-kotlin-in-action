package com.github.renuevo.sse.service

import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@Service
class SseService {

    fun subscribe(lastEventId: String): SseEmitter {
        return SseEmitter(1000 * 3600)
    }
}