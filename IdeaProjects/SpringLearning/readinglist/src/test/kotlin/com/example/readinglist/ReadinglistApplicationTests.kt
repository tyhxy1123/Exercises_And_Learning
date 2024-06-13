package com.journaldev.spring.di.test

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
class ReadinglistApplicationTests {

    @Test
    @ContextConfiguration(value= ["com.journaldev.spring.di.DIConfiguration"])
    fun contextLoads() {

    }
}
