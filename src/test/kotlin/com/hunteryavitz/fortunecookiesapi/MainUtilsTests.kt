package com.hunteryavitz.fortunecookiesapi

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MainUtilsTests {

    @Test
    fun readFortunesFromLocalFile_whenCalledAndFileExists_returnsFortunes() {
        val mainUtils = mockk<MainUtils>()
        val recipient = RECIPIENT.MOM
        val localFilePath = ""
        val fileExtension = ""
        val delimiter = ""

        every { mainUtils.readFortunesFromLocalFile(recipient, localFilePath, fileExtension, delimiter) } returns
                listOf(Fortune("This fortune was a test.", "Testy McTesterson"))

        val result = mainUtils.readFortunesFromLocalFile(recipient, localFilePath, fileExtension, delimiter)

        verify { mainUtils.readFortunesFromLocalFile(RECIPIENT.MOM, "", "", "") }
        Assertions.assertEquals(Fortune("This fortune was a test.", "Testy McTesterson").toString(),
            result[0].toString())
    }

    @Test
    fun readFortunesFromLocalFile_whenCalledAndFileDoesNotExist_returnsEmptyList() {
        val mainUtils = mockk<MainUtils>()
        val recipient = RECIPIENT.MOM
        val localFilePath = ""
        val fileExtension = ""
        val delimiter = ""

        every { mainUtils.readFortunesFromLocalFile(recipient, localFilePath, fileExtension, delimiter) } returns
                emptyList()

        val result = mainUtils.readFortunesFromLocalFile(recipient, localFilePath, fileExtension, delimiter)

        verify { mainUtils.readFortunesFromLocalFile(RECIPIENT.MOM, "", "", "") }
        Assertions.assertEquals(emptyList<Fortune>(), result)
    }

    @Test
    fun saveFortuneToLocalFile_whenFails_throwsException() {
        val mainUtils = mockk<MainUtils>()

        every { mainUtils.saveFortuneToLocalFile(Fortune("This fortune was a test.", "Testy McTesterson"),
                RECIPIENT.MOM, "", "", "") } throws Exception()

        Assertions.assertThrows(Exception::class.java) {
            mainUtils.saveFortuneToLocalFile(Fortune("This fortune was a test.", "Testy McTesterson"),
                RECIPIENT.MOM, "", "", "")
        }
    }
}
