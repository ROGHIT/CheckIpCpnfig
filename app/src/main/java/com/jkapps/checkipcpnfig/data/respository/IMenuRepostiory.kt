package com.jkapps.checkipcpnfig.data.respository

import android.content.Context
import com.jkapps.checkipcpnfig.data.api.MenuApi
import com.jkapps.checkipcpnfig.data.api.response.MenuResponse
import com.jkapps.checkipcpnfig.data.api.response.SampleResponse
import com.jkapps.checkipcpnfig.data.utiliy.Provider
import com.jkapps.checkipcpnfig.data.utiliy.onError
import com.jkapps.checkipcpnfig.data.utiliy.onSuccess
import java.lang.IllegalArgumentException

interface IMenuRepostiory {

    fun getMenuList(id:String,onSuccess: onSuccess<SampleResponse>, onError: onError<Any>)
    fun getSampleList(onSuccess: onSuccess<SampleResponse>, onError: onError<Any>)


    companion object : Provider<MenuRepostiory>() {
        override fun create(args: Array<out Any>): MenuRepostiory {
            if (args.size != 2) throw  IllegalArgumentException("MenuRepostiory must contain 2 args")
            val context =
                if (args[0] !is Context) throw  IllegalArgumentException("args[0] must context")
                else args[0] as Context

            val api =
                if (args[1] !is MenuApi) throw  IllegalArgumentException("args[1] is not MenuApi")
                else args[1] as MenuApi
            return MenuRepostiory(context, api)
        }

    }

}