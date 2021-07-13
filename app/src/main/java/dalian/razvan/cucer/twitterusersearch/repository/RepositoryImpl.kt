package dalian.razvan.cucer.twitterusersearch.repository

import dalian.razvan.cucer.twitterusersearch.networking.API
import dalian.razvan.cucer.twitterusersearch.repository.models.Tweet
import dalian.razvan.cucer.twitterusersearch.repository.models.TwitterUser

class RepositoryImpl(api: API): Repository {
    override fun getUsers(query: String): ArrayList<TwitterUser> {
        TODO("Not yet implemented")
    }

    override fun getUserTweets(): ArrayList<Tweet> {
        TODO("Not yet implemented")
    }

    override fun setSelectedUser(user: TwitterUser) {
        TODO("Not yet implemented")
    }

    override fun getSelectedUser(): TwitterUser {
        TODO("Not yet implemented")
    }
}