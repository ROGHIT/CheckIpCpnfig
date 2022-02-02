package com.jkapps.checkipcpnfig.data.respository

import android.content.Context
import com.google.gson.Gson
import com.jkapps.checkipcpnfig.data.api.MenuApi
import com.jkapps.checkipcpnfig.data.api.response.MenuResponse
import com.jkapps.checkipcpnfig.data.api.response.ResResponse
import com.jkapps.checkipcpnfig.data.api.response.SampleResponse
import com.jkapps.checkipcpnfig.data.utiliy.onError
import com.jkapps.checkipcpnfig.data.utiliy.onSuccess
import kotlinx.coroutines.*
import java.lang.Exception

class MenuRepostiory(var context: Context, var api: MenuApi):IMenuRepostiory {

    var mJob= SupervisorJob()
    var mScope= CoroutineScope(mJob +Dispatchers.IO)

    override fun getMenuList(id:String,onSuccess: onSuccess<SampleResponse>, onError: onError<Any>) {
        mScope.launch {
            try {
                val response=api.getMenuList(id).await()
                if(response.isSuccessful){
                    response.body()?.let {
                        withContext(Dispatchers.Main){
                            onSuccess(it)
                        }
                    }
                }
                else{
                    withContext(Dispatchers.Main){
                        onError(
                            response.errorBody().toString()
                           // Gson().fromJson(response.errorBody().toString(),ResResponse::class.java)
                        )
                    }
                }
            }
            catch (e:Exception){
                e.printStackTrace()
                withContext(Dispatchers.Main){
                    onError(e.toString())
                }



            }
        }
    }

    override fun getSampleList(onSuccess: onSuccess<SampleResponse>, onError: onError<Any>) {
        mScope.launch {
            try {
                val response=api.getSampleList().await()
                if(response.isSuccessful){
                    response.body()?.let {
                        withContext(Dispatchers.Main){
                            onSuccess(it)
                        }
                    }
                }
                else{
                    withContext(Dispatchers.Main){
                        onError(
                            Gson().fromJson(response.errorBody().toString(),ResResponse::class.java)
                        )
                    }
                }
            }
            catch (e:Exception){
                e.printStackTrace()
                withContext(Dispatchers.Main){
                    onError(e.toString())
                }

            }
        }
    }
}