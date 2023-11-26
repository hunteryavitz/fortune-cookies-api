package com.hunteryavitz.fortunecookiesapi

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AppConstants {

    @Value("\${LOCAL_FILE_PATH}")
    lateinit var localFilePath: String

    @Value("\${FILE_EXTENSION}")
    lateinit var fileExtension: String

    @Value("\${DELIMITER}")
    lateinit var delimiter: String
}