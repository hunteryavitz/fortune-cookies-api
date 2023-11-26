package com.hunteryavitz.fortunecookiesapi

import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

@Component
class MainUtils {

    fun readFortunesFromLocalFile(recipient: RECIPIENT, localFilePath: String, fileExtension: String,
                                  delimiter: String): List<Fortune> {
        val path = Paths.get(localFilePath)
        val filePath = path.resolve(recipient.name + fileExtension)

        if (!Files.exists(filePath)) {
            return emptyList()
        }

        val fortunes = Files.readAllLines(filePath)
                .map { it.split(delimiter) }
                .map { Fortune(it[0], it[1]) }

        Files.newBufferedWriter(filePath, StandardOpenOption.TRUNCATE_EXISTING)
            .use { }

        return fortunes
    }

    fun saveFortuneToLocalFile(fortune: Fortune, recipient: RECIPIENT, localFilePath: String,
                               fileExtension: String, delimiter: String): Boolean {

        try {
            val path = Paths.get(localFilePath)
            val filePath = path.resolve(recipient.name + fileExtension)

            if (!Files.exists(filePath)) {
                Files.createDirectory(filePath)
            }

            val content = fortune.message + delimiter + fortune.author + "\n"

            Files.write(path.resolve(recipient.name + fileExtension),
                content.toByteArray(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            )

        } catch (e: Exception) {
            return false
        }

        return true
    }
}
