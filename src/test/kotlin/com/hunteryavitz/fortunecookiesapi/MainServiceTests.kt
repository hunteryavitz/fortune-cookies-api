package com.hunteryavitz.fortunecookiesapi

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MainServiceTests {


    @Test
    fun fetchFortunes_whenCalledAndFortunesExist_returnsFortunes() {

        val mainService = mockk<MainService>()
        val recipient = RECIPIENT.MOM
        val fortune = Fortune("This fortune was a test.", "Testy McTesterson")

        every { mainService.fetchFortunes(recipient) } returns listOf(fortune)
        every { mainService.submitFortune(fortune, recipient) } returns true

        val result = mainService.fetchFortunes(recipient)

        verify { mainService.fetchFortunes(RECIPIENT.MOM) }
        Assertions.assertEquals(fortune, result[0])
    }

    @Test
    fun fetchFortunes_whenCalledAndFortunesDoNotExist_returnsEmptyList() {

        val mainService = mockk<MainService>()
        val recipient = RECIPIENT.MOM

        every { mainService.fetchFortunes(recipient) } returns emptyList()
        every { mainService.submitFortune(Fortune("This fortune was a test.", "Testy McTesterson"), recipient) } returns true

        val result = mainService.fetchFortunes(recipient)

        verify { mainService.fetchFortunes(RECIPIENT.MOM) }
        Assertions.assertEquals(emptyList<Fortune>(), result)
    }

    @Test
    fun submitFortune_whenSucceeds_returnsTrue() {

        val mainService = mockk<MainService>()
        val recipient = RECIPIENT.MOM
        val fortune = Fortune("This fortune was a test.", "Testy McTesterson")

        every { mainService.submitFortune(fortune, recipient) } returns true

        val result = mainService.submitFortune(fortune, recipient)

        verify { mainService.submitFortune(fortune, recipient) }
        Assertions.assertEquals(true, result)
    }

    @Test
    fun submitFortune_whenFails_returnsFalse() {

        val mainService = mockk<MainService>()
        val recipient = RECIPIENT.MOM
        val fortune = Fortune("This fortune was a test.", "Testy McTesterson")

        every { mainService.submitFortune(fortune, recipient) } returns false

        val result = mainService.submitFortune(fortune, recipient)

        verify { mainService.submitFortune(fortune, recipient) }
        Assertions.assertEquals(false, result)
    }
}
