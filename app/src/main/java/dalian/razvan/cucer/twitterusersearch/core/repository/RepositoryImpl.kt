package dalian.razvan.cucer.twitterusersearch.core.repository

import android.util.Log
import dalian.razvan.cucer.twitterusersearch.core.networking.API
import dalian.razvan.cucer.twitterusersearch.core.networking.APICallbackInterface
import dalian.razvan.cucer.twitterusersearch.core.networking.error.ErrorCallback
import dalian.razvan.cucer.twitterusersearch.core.repository.models.Tweet
import dalian.razvan.cucer.twitterusersearch.core.repository.models.TwitterUser
import dalian.razvan.cucer.twitterusersearch.screens.details.list.UserTweetsCallback
import dalian.razvan.cucer.twitterusersearch.screens.search.list.TwitterUsersCallback
import dalian.razvan.cucer.twitterusersearch.utils.Constants
import org.json.JSONObject

class RepositoryImpl(val api: API): Repository {

    private lateinit var selectedUser: TwitterUser
    private val users = arrayListOf<TwitterUser>()
    private val userTweets = arrayListOf<Tweet>()

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
                jsonArray?.let {
                    (0 until it.length()).forEach { i ->
                        users.add(TwitterUser(it.optJSONObject(i)))
                    }
                }
                callback.setItems(users)
                if (users.size == 0) {
                    errorCallback.onError("No users found!")
                } else {
                    errorCallback.onError("")
                }
            }

            override fun onError(error: String) {
                errorCallback.onError(error)
            }

        })
    }

    override suspend fun getUserTweets(callback: UserTweetsCallback, errorCallback: ErrorCallback) {
        api.getUserTweets(selectedUser.id, object : APICallbackInterface{
            override fun onSuccess(jsonObject: JSONObject) {
                userTweets.clear()
                Log.e(javaClass.simpleName, jsonObject.toString())
                val jsonArray = jsonObject.optJSONArray(Constants.DATA)
                jsonArray?.let {
                    (0 until it.length()).forEach { i ->
                        userTweets.add(Tweet(it.optJSONObject(i)))
                    }
                }
                callback.setItems(userTweets)
                if (userTweets.size == 0) {
                    errorCallback.onError("User didn't tweet.")
                }
            }

            override fun onError(error: String) {
                errorCallback.onError(error)
            }

        })
    }

    override fun setSelectedUser(user: TwitterUser) {
        selectedUser = user
    }

    override fun getSelectedUser(): TwitterUser  = selectedUser
}