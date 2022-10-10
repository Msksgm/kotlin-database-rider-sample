package com.example.kotlindatabaseridersample

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

interface UpdateCommand {
    fun perform(lastName: String)
}

class UpdateCommandImpl(val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) : UpdateCommand {
    override fun perform(lastName: String) {
        val updateCustomerSql = """
            UPDATE
                customer
            SET
                first_name = 'EVE'
                , last_name = 'Sample4'
            WHERE
                last_name = :last_name
        """.trimIndent()
        val updateCustomerSqlParams = MapSqlParameterSource()
            .addValue("last_name", lastName)
        namedParameterJdbcTemplate.update(updateCustomerSql, updateCustomerSqlParams)
    }
}
