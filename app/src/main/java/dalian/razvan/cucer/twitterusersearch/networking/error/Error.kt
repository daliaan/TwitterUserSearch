package dalian.razvan.cucer.twitterusersearch.networking.error

import com.google.gson.annotations.SerializedName
import dalian.razvan.cucer.twitterusersearch.utils.Constants

data class Error(@SerializedName(Constants.PARAMETERS) val parameters: String,
                 @SerializedName(Constants.MESSAGE) val message: String)