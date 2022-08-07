package com.example.weatherapp.viewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.model.Period
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ForecastViewModel(private val periodList: List<Period>): ViewModel() {

    private val _forecastLiveData: MutableLiveData<List<Period>> = MutableLiveData()
    val forecastLiveData: LiveData<List<Period>> get() = _forecastLiveData

    fun getForecastPeriods(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val response = periodList
                response.let{
                    _forecastLiveData.postValue(it)
                }
            }
            catch(e: Exception){
                Log.e(TAG, "Failed Collecting the Data from JSON file", e)
            }
        }
    }

}