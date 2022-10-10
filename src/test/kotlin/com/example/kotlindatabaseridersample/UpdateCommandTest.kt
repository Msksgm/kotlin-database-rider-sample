package com.example.kotlindatabaseridersample

import com.github.database.rider.core.api.dataset.DataSet
import com.github.database.rider.core.api.dataset.ExpectedDataSet
import com.github.database.rider.junit5.api.DBRider
import org.junit.jupiter.api.Test

class UpdateCommandTest {
    @Test
    @DBRider
    @DataSet("datasets/yml/given/common.yml")
    @ExpectedDataSet(
        value = ["datasets/yml/then/update-success.yml"],
        orderBy = ["id"]
    )
    // NOTE: @ExportDataSetはgivenの@DataSetが変更用に残しておく
    // @ExportDataSet(
    //     format = DataSetFormat.YML,
    //     outputName = "src/test/resources/datasets/yml/then/update-success.yml",
    //     includeTables = ["customer"]
    // )
    fun `正常系`() {
        val updateCommand = UpdateCommandImpl(DbConnection.namedParameterJdbcTemplate)
        updateCommand.perform("Sample2")
    }
}
