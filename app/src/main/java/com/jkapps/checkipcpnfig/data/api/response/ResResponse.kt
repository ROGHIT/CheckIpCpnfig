package com.jkapps.checkipcpnfig.data.api.response

import com.google.gson.annotations.SerializedName

data class ResResponse(

	@field:SerializedName("error_code")
	val error_code: Int? = null,

	@field:SerializedName("Message")
	val Message: String? = null
)
