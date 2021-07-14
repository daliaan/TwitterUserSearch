package dalian.razvan.cucer.twitterusersearch.core.repository.models

import com.google.gson.annotations.SerializedName
import dalian.razvan.cucer.twitterusersearch.utils.Constants
import org.json.JSONObject

data class TwitterUser(@SerializedName(Constants.ID) val id: String = "",
                       @SerializedName(Constants.NAME) val name: String = "",
                       @SerializedName(Constants.USERNAME) val username: String = "",
                       @SerializedName(Constants.PROFILE_PICTURE) val profilePicture: String = "") {
    constructor(jsonObject: JSONObject):
            this(
                jsonObject.optString(Constants.ID)?:"",
                jsonObject.optString(Constants.NAME)?:"",
                jsonObject.optString(Constants.USERNAME)?:"",
                jsonObject.optString(Constants.PROFILE_PICTURE)?:""
            ) {
                this.jsonObject = jsonObject
            }
    private var jsonObject = JSONObject()

    override fun toString(): String {
        return jsonObject.toString()
    }

    override fun equals(other: Any?): Boolean {
        return other.toString() == toString()
    }
}
