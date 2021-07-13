package dalian.razvan.cucer.twitterusersearch.core.repository

import dalian.razvan.cucer.twitterusersearch.core.networking.APICallbackInterface
import dalian.razvan.cucer.twitterusersearch.core.networking.error.ErrorCallback
import dalian.razvan.cucer.twitterusersearch.core.repository.models.Tweet
import dalian.razvan.cucer.twitterusersearch.core.repository.models.TwitterUser
import dalian.razvan.cucer.twitterusersearch.screens.list.TwitterUsersCallback
import javax.security.auth.callback.Callback

interface Repository {

    //API calls functions
    suspend fun getUsers(query: String, callback: TwitterUsersCallback, errorCallback: ErrorCallback)
    suspend fun getUserTweets(): ArrayList<Tweet>

    //select user function
    fun setSelectedUser(user: TwitterUser)
    fun getSelectedUser(): TwitterUser
}