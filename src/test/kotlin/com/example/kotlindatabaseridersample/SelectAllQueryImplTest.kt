package com.example.kotlindatabaseridersample

import com.github.database.rider.core.api.dataset.DataSet
import com.github.database.rider.core.api.dataset.ExpectedDataSet
import com.github.database.rider.junit5.api.DBRider
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SelectAllQueryImplTest {
    @Test
    @DBRider
    @DataSet("datasets/yml/given/insert-success.yml")
    @ExpectedDataSet(
        value = ["datasets/yml/given/insert-success.yml"],
        ignoreCols = ["id"],
        orderBy = ["id"]
    )
    fun `正常系`() {
        /**
         * given:
         */
        val selectAllQuery = SelectAllQueryImpl(DbConnection.namedParameterJdbcTemplate)

        /**
         * when:
         */
        val actual = selectAllQuery.perform()

        /**
         * then:
         */
        val expected = listOf(
            Customer(
                1,
                "Alice",
                "Sample1"
            ),
            Customer(
                2,
                "Bob",
                "Sample2",
            ),
        )
        assertThat(actual == expected)
    }
}
