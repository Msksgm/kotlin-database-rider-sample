package com.example.kotlindatabaseridersample

import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import java.sql.ResultSet

data class Customer(
    val id: Int,
    val firstName: String,
    val lastName: String,
)

class CustomerRowMapper : RowMapper<Customer> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Customer? {
        return Customer(
            rs.getInt("id"),
            rs.getString("first_name"),
            rs.getString("last_name"),
        )
    }
}

interface SelectAllQuery {
    fun perform(): List<Customer>
}

class SelectAllQueryImpl(private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) : SelectAllQuery {
    override fun perform(): List<Customer> {
        val selectAllCustomerSql = """
            SELECT
                id
                , first_name
                , last_name
            FROM
                customer
            ;
        """.trimIndent()
        val selectAllQuerySqlParams = MapSqlParameterSource()
        val customersMap = namedParameterJdbcTemplate.queryForList(selectAllCustomerSql, selectAllQuerySqlParams)
        return customersMap.map {
            Customer(
                it["id"].toString().toInt(),
                it["first_name"].toString(),
                it["last_name"].toString(),
            )
        }
    }
}
