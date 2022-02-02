package com.jkapps.checkipcpnfig.data.api.response

import com.google.gson.annotations.SerializedName

data class MenuResponse(

	@SerializedName("storereferenceId")
	val storereferenceId: String? = null,

	@SerializedName("addon")
	val addon: List<AddonItem?>? = null,

	@SerializedName("menutype")
	val menutype: String? = null,

	@SerializedName("addonitemgroup")
	val addonitemgroup: List<AddonitemgroupItem?>? = null,

	@SerializedName("categories")
	val categories: List<CategoriesItem?>? = null,

	@SerializedName("items")
	val items: List<ItemsItem?>? = null,

	@SerializedName("table")
	val table: List<TableItem?>? = null,

	@SerializedName("storeCode")
	val storeCode: String? = null
)

data class CategoriesItem(

	@SerializedName("ref_id")
	val refId: String? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("description")
	val description: String? = null,

	@SerializedName("active")
	val active: Boolean? = null,

	@SerializedName("sort_order")
	val sortOrder: Int? = null
)

data class ItemsItem(

	@SerializedName("ref_id")
	val refId: String? = null,

	@SerializedName("ref_title")
	val refTitle: String? = null,

	@SerializedName("foodtype")
	val foodtype: String? = null,

	@SerializedName("img_url")
	val imgUrl: String? = null,

	@SerializedName("serves")
	val serves: String? = null,

	@SerializedName("price")
	val price: String? = null,

	@SerializedName("description")
	val description: String? = null,

	@SerializedName("sortorder")
	val sortorder: String? = null,

	@SerializedName("categoryrefids")
	val categoryrefids: String? = null
)

data class AddonitemgroupItem(

	@SerializedName("ref_id")
	val refId: String? = null,

	@SerializedName("price")
	val price: String? = null,

	@SerializedName("description")
	val description: String? = null,

	@SerializedName("food_type")
	val foodType: String? = null,

	@SerializedName("optgrprefids")
	val optgrprefids: String? = null,

	@SerializedName("title")
	val title: String? = null
)

data class AddonItem(

	@SerializedName("ref_id")
	val refId: String? = null,

	@SerializedName("item_ref_ids")
	val itemRefIds: String? = null,

	@SerializedName("minselectable")
	val minselectable: String? = null,

	@SerializedName("maxselectable")
	val maxselectable: String? = null,

	@SerializedName("reftitle")
	val reftitle: String? = null
)

data class TableItem(

	@SerializedName("tableno")
	val tableno: String? = null,

	@SerializedName("capacity")
	val capacity: String? = null
)
