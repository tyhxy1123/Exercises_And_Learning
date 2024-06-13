package com.javacode2020.lesson000.account_annoioc.config

import com.javacode2020.lesson000.JdbcConfig
import org.springframework.context.annotation.*


@ComponentScan("com.javacode2020.lesson000.account_annoioc")
@Import(JdbcConfig::class)
@PropertySource("classpath:jdbcConfig.properties")
open class SpringConfig {

}