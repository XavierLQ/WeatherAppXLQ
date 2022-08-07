package com.example.weatherapp

import com.example.weatherapp.dataSource.LocalData
import com.example.weatherapp.model.Forecast
import com.example.weatherapp.model.Period
import com.example.weatherapp.viewModel.ForecastViewModel
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.*
import java.io.InputStream
import kotlin.reflect.typeOf
import kotlin.test.assertFails
import kotlin.test.assertNotNull

@ExperimentalCoroutinesApi
class ViewModelTest {

    private val mockLocalData = mockk<LocalData>(relaxed = true)
    private var testObject: ForecastViewModel? = null

    @After
    fun shutdown() {
        clearAllMocks()
    }

    @Test
    fun `viewModel not created due to exception`() {
        val mockIS = mockk<InputStream>(relaxed = true)
        var exception: Exception? = null

        every {
            mockLocalData.jsonToPojoConverter(mockIS)
        } throws Exception()

        try {testObject = ForecastViewModel(mockLocalData
            .jsonToPojoConverter(mockIS)
            .periods)
        }
        catch(e: Exception){
            exception = e
        }
        finally{
            assertNotNull(exception)
            assertNull(testObject)
        }
    }

    @Test
    fun `viewModel receives proper data and gets created`(){
        val mockIS = mockk<InputStream>(relaxed = true)
        var exception: Exception? = null
        val mockForecast = mockk<Forecast>(relaxed = true)

        every {
            mockLocalData.jsonToPojoConverter(mockIS)
        } returns mockForecast

        try {testObject = ForecastViewModel(mockLocalData
            .jsonToPojoConverter(mockIS)
            .periods)
        }
        catch(e: Exception){
            exception = e
        }
        finally{
            assertNull(exception)
            assertNotNull(testObject)
        }
    }
}