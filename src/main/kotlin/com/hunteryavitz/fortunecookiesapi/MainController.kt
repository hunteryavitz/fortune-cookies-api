package com.hunteryavitz.fortunecookiesapi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(private val mainService: MainService) {

    @GetMapping("/fortunes/{recipient}")
    fun fetchFortunes(@PathVariable recipient: RECIPIENT): List<Fortune> {
        return mainService.fetchFortunes(recipient)
    }

    @PostMapping("/fortune/{recipient}")
    fun submitFortune(@RequestBody fortune: Fortune, @PathVariable recipient: RECIPIENT): Boolean {
        return mainService.submitFortune(fortune, recipient)
    }
}
