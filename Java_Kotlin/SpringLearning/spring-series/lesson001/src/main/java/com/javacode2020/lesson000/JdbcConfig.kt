package com.javacode2020.lesson000

import com.javacode2020.lesson000.account_annoioc.utils.ConnectionUtils
import com.mchange.v2.c3p0.ComboPooledDataSource
import org.apache.commons.dbutils.QueryRunner
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import javax.sql.DataSource


open class JdbcConfig {
    @Value("\${jdbc.driver}")
    private var driver:String?=null
    @Value("\${jdbc.url}")
    private var url:String?=null
    @Value("\${jdbc.user}")
    private var userName:String?=null
    @Bean(name=["runner"])
    @Scope("prototype")
    open fun createQueryRunner(): QueryRunner {
        return QueryRunner()
    }
    @Bean(name=["dataSourcec"])
    open fun createDataSource(): DataSource {
        val dataSource = ComboPooledDataSource()
        dataSource.driverClass=driver
        dataSource.jdbcUrl=url
        dataSource.user=userName
        return dataSource
    }
    @Bean
    open fun createConnectionUtils(dataSource: DataSource):ConnectionUtils{
        return ConnectionUtils(dataSource)
    }
}