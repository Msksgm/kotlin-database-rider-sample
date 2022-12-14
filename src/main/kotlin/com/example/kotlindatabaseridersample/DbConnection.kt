package com.example.kotlindatabaseridersample

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import javax.sql.DataSource

object DbConnection {
    @Suppress("MagicNumber")
    fun dataSource(): DataSource {
        val hikariConfig = HikariConfig()
        hikariConfig.jdbcUrl = "jdbc:postgresql://127.0.0.1:5432/sample-db"
        hikariConfig.username = "sample-user"
        hikariConfig.password = "sample-pass"
        hikariConfig.connectionTimeout = java.lang.Long.valueOf(500)
        hikariConfig.isAutoCommit = true
        hikariConfig.transactionIsolation = "TRANSACTION_READ_COMMITTED"
        hikariConfig.poolName = "realworldPool01"
        hikariConfig.maximumPoolSize = 10
        return HikariDataSource(hikariConfig)
    }

    val namedParameterJdbcTemplate = NamedParameterJdbcTemplate(dataSource())
}
