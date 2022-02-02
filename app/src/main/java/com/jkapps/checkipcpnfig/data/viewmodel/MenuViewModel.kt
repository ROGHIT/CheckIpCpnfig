package com.jkapps.checkipcpnfig.data.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jkapps.checkipcpnfig.data.api.MenuApi
import com.jkapps.checkipcpnfig.data.api.response.MenuResponse
import com.jkapps.checkipcpnfig.data.api.response.SampleResponse
import com.jkapps.checkipcpnfig.data.networkmanager.NetworkManager
import com.jkapps.checkipcpnfig.data.respository.IMenuRepostiory
import com.jkapps.checkipcpnfig.data.utiliy.onError
import com.jkapps.checkipcpnfig.data.utiliy.onSuccess

class MenuViewModel(var context: Context, var repostiory: IMenuRepostiory) : ViewModel() {

    fun getMenuList(id:String,onSuccess: onSuccess<SampleResponse>, onError: onError<Any>) {
        repostiory.getMenuList(id,onSuccess, onError)
    }

    fun getSampleList(onSuccess: onSuccess<SampleResponse>, onError: onError<Any>){
        repostiory.getSampleList(onSuccess,onError)
    }

    class  Factory( private var context: Context,url:String) :ViewModelProvider.NewInstanceFactory(){
        private val respository=IMenuRepostiory.get(
            context,
            NetworkManager.createApi<MenuApi>(context,url)
        )

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")return MenuViewModel(context,respository) as T
        }
    }

}