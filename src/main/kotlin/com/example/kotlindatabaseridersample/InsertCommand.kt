package com.example.kotlindatabaseridersample

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

interface InsertCommand {
    fun perform(firstName: String, lastName: String)
}

class InsertCommandImpl(private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) : InsertCommand {
    override fun perform(firstName: String, lastName: String) {
        val insertCustomerSql = """
            INSERT INTO
                customer (
                    first_name
                    , last_name
                )
            VALUES
                (
                    :first_name
                    , :last_name
                )
            ;
        """.trimIndent()
        val insertCustomerSqlParams = MapSqlParameterSource()
            .addValue("first_name", firstName)
            .addValue("last_name", lastName)
        namedParameterJdbcTemplate.update(insertCustomerSql, insertCustomerSqlParams)
    }
}
