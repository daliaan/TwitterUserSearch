package dalian.razvan.cucer.twitterusersearch.core.repository

import dalian.razvan.cucer.twitterusersearch.core.networking.error.ErrorCallback
import dalian.razvan.cucer.twitterusersearch.core.repository.models.Tweet
import dalian.razvan.cucer.twitterusersearch.core.repository.models.TwitterUser
import dalian.razvan.cucer.twitterusersearch.screens.details.list.UserTweetsCallback
import dalian.razvan.cucer.twitterusersearch.screens.search.list.TwitterUsersCallback
import javax.security.auth.callback.Callback

interface Repository {

    //API calls functions
    suspend fun getUsers(query: String, callback: TwitterUsersCallback, errorCallback: ErrorCallback)
    suspend fun getUserTweets(callback: UserTweetsCallback, errorCallback: ErrorCallback)

    //select user function
    fun setSelectedUser(user: TwitterUser)
    fun getSelectedUser(): TwitterUser
}