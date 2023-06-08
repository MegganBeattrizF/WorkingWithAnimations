package com.example.myapplication

import com.example.myapplication.aprendendo.assets.Testano
import com.example.myapplication.utils.JsonUtil
import com.google.common.truth.Truth
import org.junit.Test
import kotlin.reflect.full.declaredMemberProperties

internal class JsonTest {

    private fun extractJsonKeysFromMockJson(): List<String> {
        """"([a-zA-Z0-9_-]+)":\s*""".toRegex().run {
            val mockJson = JsonUtil().getJsonFromResource("teste.json")
            return this.findAll(mockJson).map { it.groupValues[1] }.toList()
        }
    }

    @Test
    fun getJsonString() {
        Testano::class.declaredMemberProperties.forEach { property ->
            Truth.assertThat(extractJsonKeysFromMockJson()).contains(property.name)
        }
    }
}