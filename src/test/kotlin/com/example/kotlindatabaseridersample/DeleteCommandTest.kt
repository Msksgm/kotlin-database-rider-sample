package com.example.kotlindatabaseridersample

import com.github.database.rider.core.api.dataset.DataSet
import com.github.database.rider.core.api.dataset.ExpectedDataSet
import com.github.database.rider.junit5.api.DBRider
import org.junit.jupiter.api.Test

class DeleteCommandTest {
    @Test
    @DBRider
    @DataSet("datasets/yml/given/common.yml")
    @ExpectedDataSet(
        value = ["datasets/yml/then/delete-success.yml"],
        orderBy = ["id"]
    )
    // NOTE: @ExportDataSetはgivenの@DataSetが変更用に残しておく
    // @ExportDataSet(
    //     format = DataSetFormat.YML,
    //     outputName = "src/test/resources/datasets/yml/then/delete-success.yml",
    //     includeTables = ["customer"]
    // )
    fun `正常系`() {
        val deleteCommand = DeleteCommandImpl(DbConnection.namedParameterJdbcTemplate)
        deleteCommand.perform("Bob")
    }
}
