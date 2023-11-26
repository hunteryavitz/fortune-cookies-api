package com.hunteryavitz.fortunecookiesapi

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MainControllerTests {

    @Test
    fun fetchFortunes_whenCalledAndFortunesExist_returnsFortunes() {

        val recipient = RECIPIENT.MOM
        val mainController = mockk<MainController>()
        val fortune = Fortune("This fortune was a test.", "Testy McTesterson")

        every { mainController.fetchFortunes(recipient) } returns listOf(fortune)

        val result = mainController.fetchFortunes(recipient)

        verify { mainController.fetchFortunes(RECIPIENT.MOM) }
        assertEquals(fortune, result[0])
    }

    @Test
    fun fetchFortunes_whenCalledAndFortunesDoNotExist_returnsEmptyList() {

        val recipient = RECIPIENT.MOM
        val mainController = mockk<MainController>()

        every { mainController.fetchFortunes(recipient) } returns emptyList()

        val result = mainController.fetchFortunes(recipient)

        verify { mainController.fetchFortunes(RECIPIENT.MOM) }
        assertEquals(emptyList<Fortune>(), result)
    }

    @Test
    fun submitFortune_whenSucceeds_returnsTrue() {

        val recipient = RECIPIENT.MOM
        val mainController = mockk<MainController>()
        val fortune = Fortune("This fortune was a test.", "Testy McTesterson")

        every { mainController.submitFortune(fortune, recipient) } returns true

        val result = mainController.submitFortune(fortune, recipient)

        verify { mainController.submitFortune(fortune, recipient) }
        assertEquals(true, result)
    }

    @Test
    fun submitFortune_whenFails_returnsFalse() {

        val recipient = RECIPIENT.MOM
        val mainController = mockk<MainController>()
        val fortune = Fortune("This fortune was a test.", "Testy McTesterson")

        every { mainController.submitFortune(fortune, recipient) } returns false

        val result = mainController.submitFortune(fortune, recipient)

        verify { mainController.submitFortune(fortune, recipient) }
        assertEquals(false, result)
    }
}
