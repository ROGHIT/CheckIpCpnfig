package com.jkapps.checkipcpnfig.data.api

import com.jkapps.checkipcpnfig.data.api.response.MenuResponse
import com.jkapps.checkipcpnfig.data.api.response.SampleResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MenuApi {
    //api/Get details?Id=196.57.1.50

    @GET("api/getdetails")
    fun getMenuList(
        @Query("id") id: String
    ):Deferred<Response<SampleResponse>>

    @GET("SampleConnectjson")
    fun getSampleList():Deferred<Response<SampleResponse>>
}