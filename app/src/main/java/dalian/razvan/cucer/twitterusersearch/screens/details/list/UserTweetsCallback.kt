package dalian.razvan.cucer.twitterusersearch.screens.details.list

import dalian.razvan.cucer.twitterusersearch.core.repository.models.Tweet
import dalian.razvan.cucer.twitterusersearch.core.repository.models.TwitterUser

interface UserTweetsCallback {
    fun setItems(list: MutableList<Tweet>)
}
