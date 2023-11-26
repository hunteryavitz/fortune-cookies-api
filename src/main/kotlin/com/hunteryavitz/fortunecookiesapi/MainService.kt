package com.hunteryavitz.fortunecookiesapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MainService {

    @Autowired
    lateinit var appConstants: AppConstants

    fun fetchFortunes(recipient: RECIPIENT): List<Fortune> {
        return try {
            MainUtils().readFortunesFromLocalFile(
                recipient, appConstants.localFilePath, appConstants.fileExtension,
                appConstants.delimiter)
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun submitFortune(fortune: Fortune, recipient: RECIPIENT): Boolean {
        try {
            MainUtils().saveFortuneToLocalFile(
                fortune, recipient, appConstants.localFilePath,
                appConstants.fileExtension, appConstants.delimiter)
        } catch (e: Exception) {
            return false
        }
        return true
    }
}
