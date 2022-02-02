package com.jkapps.checkipcpnfig.data.networkmanager

import android.content.Context
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jkapps.checkipcpnfig.data.utiliy.Provider
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.IllegalArgumentException
import java.util.concurrent.TimeUnit

class NetworkManager(var context: Context) : INetworkManager {
    override val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .callTimeout(60, TimeUnit.SECONDS)
            .callTimeout(60, TimeUnit.SECONDS).build()
    }

    companion object :Provider<NetworkManager>(){
        override fun create(args: Array<out Any>): NetworkManager {
            if (args.isEmpty()) throw IllegalArgumentException("NetworkManager must contain args")
            if (args[0] !is Context) throw IllegalArgumentException("args[0] must be context")
            return NetworkManager(context = args[0] as Context)
        }
        inline fun<reified T> createApi( context: Context,url:String):T {

            return if(T::class.java .isInterface){
                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
                Retrofit.Builder()
               .addCallAdapterFactory(CoroutineCallAdapterFactory())
               .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
               .baseUrl(url).client(client).build().create(T::class.java)

            }
            else throw  IllegalArgumentException("${T::class.java} is not interface")
        }

    }
}

interface INetworkManager {
    val okHttpClient: OkHttpClient

}