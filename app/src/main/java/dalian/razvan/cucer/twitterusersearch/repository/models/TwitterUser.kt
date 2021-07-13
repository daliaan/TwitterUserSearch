package dalian.razvan.cucer.twitterusersearch.repository.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import dalian.razvan.cucer.twitterusersearch.utils.Constants

data class TwitterUser(@SerializedName(Constants.ID) val id: String,
                       @SerializedName(Constants.NAME) val name: String,
                       @SerializedName(Constants.USERNAME) val username: String)
