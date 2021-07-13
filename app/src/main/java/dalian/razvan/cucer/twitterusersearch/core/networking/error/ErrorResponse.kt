package dalian.razvan.cucer.twitterusersearch.core.networking.error

import com.google.gson.annotations.SerializedName
import dalian.razvan.cucer.twitterusersearch.utils.Constants

data class ErrorResponse(@SerializedName(Constants.TITLE) val title: String = "",
                         @SerializedName(Constants.DETAIL) val detail: String = "",
                         @SerializedName(Constants.TYPE) val type: String = "") {

    constructor(errorResponse: ErrorResponse): this(errorResponse.title, errorResponse.detail, errorResponse.type)

    override fun toString(): String {
        return title + '\n' + detail
    }
}
