package dalian.razvan.cucer.twitterusersearch.repository.models

import com.google.gson.annotations.SerializedName
import dalian.razvan.cucer.twitterusersearch.utils.Constants

data class Tweet(@SerializedName(Constants.ID) val id: String,
                 @SerializedName(Constants.TEXT) val text: String)
