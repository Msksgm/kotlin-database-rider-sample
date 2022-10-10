package com.example.kotlindatabaseridersample

import com.github.database.rider.core.api.dataset.DataSet
import com.github.database.rider.core.api.dataset.ExpectedDataSet
import com.github.database.rider.junit5.api.DBRider
import org.junit.jupiter.api.Test

class InsertCommandTest {
    @Test
    @DBRider
    @DataSet("datasets/yml/given/common.yml")
    @ExpectedDataSet(
        value = ["datasets/yml/then/insert-success.yml"],
        orderBy = ["id"],
        ignoreCols = ["id"],
    )
    // NOTE: @ExportDataSetはgivenの@DataSetが変更用に残しておく
    // @ExportDataSet(
    //     format = DataSetFormat.YML,
    //     outputName = "src/test/resources/datasets/yml/then/common.yml",
    //     includeTables = ["customer"]
    // )
    fun `正常系`() {
        val insertCommand = InsertCommandImpl(DbConnection.namedParameterJdbcTemplate)
        insertCommand.perform("firstName", "lastName")
    }
}
