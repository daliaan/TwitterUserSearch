package dalian.razvan.cucer.twitterusersearch.screens.list

import dalian.razvan.cucer.twitterusersearch.core.repository.models.TwitterUser

interface TwitterUsersCallback {
    fun setItems(list: MutableList<TwitterUser>)
}
