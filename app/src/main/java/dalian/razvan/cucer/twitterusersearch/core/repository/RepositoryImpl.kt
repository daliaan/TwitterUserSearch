package dalian.razvan.cucer.twitterusersearch.core.repository

import android.util.Log
import dalian.razvan.cucer.twitterusersearch.core.networking.API
import dalian.razvan.cucer.twitterusersearch.core.networking.APICallbackInterface
import dalian.razvan.cucer.twitterusersearch.core.networking.error.ErrorCallback
import dalian.razvan.cucer.twitterusersearch.core.repository.models.Tweet
import dalian.razvan.cucer.twitterusersearch.core.repository.models.TwitterUser
import dalian.razvan.cucer.twitterusersearch.screens.list.TwitterUsersCallback
import dalian.razvan.cucer.twitterusersearch.utils.Constants
import org.json.JSONObject

class RepositoryImpl(val api: API): Repository {

    private val users = arrayListOf<TwitterUser>()

    override suspend fun getUsers(
        query: String,
        callback: TwitterUsersCallback,
        errorCallback: ErrorCallback
    ) {
        api.getUser(query, object : APICallbackInterface{
            override fun onSuccess(jsonObject: JSONObject) {
                users.clear()
                Log.e(javaClass.simpleName, jsonObject.toString())
                val jsonArray = jsonObject.optJSONArray(Constants.DATA)
                (0 until jsonArray.length()).forEach { i ->
                    users.add(TwitterUser(jsonArray.optJSONObject(i)))
                }
                callback.setItems(users)
            }

            override fun onError(error: String) {
                errorCallback.onError(error)
            }

        })
    }

    override suspend fun getUserTweets(): ArrayList<Tweet> {
        TODO("Not yet implemented")
    }

    override fun setSelectedUser(user: TwitterUser) {
        TODO("Not yet implemented")
    }

    override fun getSelectedUser(): TwitterUser {
        TODO("Not yet implemented")
    }
}