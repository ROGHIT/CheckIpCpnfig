package com.jkapps.checkipcpnfig.data.utiliy

abstract class Provider<T> {
    @Volatile
    var instance: T? = null

    var override: T? = null

    protected abstract fun create(args: Array<out Any> = emptyArray()): T

    fun get(vararg args: Any): T = override ?: instance ?: synchronized(this) {
        instance ?: create(args).also { instance = it }
    }
}