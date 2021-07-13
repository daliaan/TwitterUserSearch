package dalian.razvan.cucer.twitterusersearch.core.repository.models

import com.google.gson.annotations.SerializedName
import dalian.razvan.cucer.twitterusersearch.utils.Constants
import org.json.JSONObject

data class TwitterUser(@SerializedName(Constants.ID) val id: String,
                       @SerializedName(Constants.NAME) val name: String,
                       @SerializedName(Constants.USERNAME) val username: String) {
    constructor(jsonObject: JSONObject): this(jsonObject.optString(Constants.ID), jsonObject.optString(Constants.NAME), jsonObject.optString(Constants.USERNAME))
}