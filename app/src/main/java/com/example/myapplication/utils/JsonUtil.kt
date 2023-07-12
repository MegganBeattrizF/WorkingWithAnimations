package com.example.myapplication.utils

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.InputStreamReader

class JsonUtil {

    fun getJsonFromResource(fileName: String): String = getJSONStream(fileName).run {
        val stringBuilder = StringBuilder()
        var line = this.readLine()
        while (line.isNullOrBlank().not()) {
            stringBuilder.append(line)
            line = this.readLine()
        }
        stringBuilder.toString()
    }

    private fun getJSONStream(fileName: String): BufferedReader {
        val filePath = "../app/src/main/java/com/example/myapplication/assets/$fileName"

        return try {
            BufferedReader(InputStreamReader(FileInputStream(filePath)))
        } catch (e: FileNotFoundException) {
            BufferedReader(InputStreamReader(FileInputStream("../$filePath")))
        }
    }
}


