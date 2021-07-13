package dalian.razvan.cucer.twitterusersearch.repository

import dalian.razvan.cucer.twitterusersearch.repository.models.Tweet
import dalian.razvan.cucer.twitterusersearch.repository.models.TwitterUser

interface Repository {

    //API calls functions
    fun getUsers(query: String): ArrayList<TwitterUser>
    fun getUserTweets(): ArrayList<Tweet>

    //select user function
    fun setSelectedUser(user: TwitterUser)
    fun getSelectedUser(): TwitterUser
}