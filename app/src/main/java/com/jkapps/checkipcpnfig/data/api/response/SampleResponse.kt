package com.jkapps.checkipcpnfig.data.api.response

import com.google.gson.annotations.SerializedName

data class SampleResponse(

	@field:SerializedName("StoreIpConfigured")
	val storeIpConfigured: String? = null,

	@field:SerializedName("Reachable")
	val reachable: String? = null
)
