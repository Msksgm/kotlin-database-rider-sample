package com.example.kotlindatabaseridersample

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

interface DeleteCommand {
    fun perform(firstName: String)
}

class DeleteCommandImpl(val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) : DeleteCommand {
    override fun perform(firstName: String) {
        val deleteCustomerSql = """
            DELETE FROM
                customer
            WHERE
                first_name = :first_name
        """.trimIndent()
        val deleteCustomerSqlParams = MapSqlParameterSource()
            .addValue("first_name", firstName)
        namedParameterJdbcTemplate.update(deleteCustomerSql, deleteCustomerSqlParams)
    }
}
