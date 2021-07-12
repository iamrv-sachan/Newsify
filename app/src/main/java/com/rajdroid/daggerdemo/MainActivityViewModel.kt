package com.rajdroid.daggerdemo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajdroid.daggerdemo.di.RetroServiceInterface
import com.rajdroid.daggerdemo.model.News
import kotlinx.coroutines.async
import javax.inject.Inject


class MainActivityViewModel @Inject constructor(val retroService: RetroServiceInterface) : ViewModel(){

    init {
        Log.d("ankit","View Mode working retro $retroService " )
    }

    val data : MutableLiveData<News> = MutableLiveData();

    suspend fun getUser(id:String): News? {


        val response = viewModelScope.async {
            retroService.getDataFromAPI(id)
        }
        var userRes:News?=null

        userRes = if (response.await().isSuccessful){
            response.await().body();

        }else{
            null;
        }

        return userRes
    }

}