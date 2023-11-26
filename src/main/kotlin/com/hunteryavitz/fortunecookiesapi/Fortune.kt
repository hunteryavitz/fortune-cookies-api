package com.hunteryavitz.fortunecookiesapi

import org.springframework.stereotype.Component

@Component
class Fortune {

    final var message: String = ""
    final var author: String = ""

    constructor() {
        this.message = "You will have a great day!"
        this.author = "World"
    }

    constructor(message: String, author: String) {
        this.message = message
        this.author = author
    }

    override fun toString(): String {
        return "Fortune(message='$message', author='$author')"
    }
}
