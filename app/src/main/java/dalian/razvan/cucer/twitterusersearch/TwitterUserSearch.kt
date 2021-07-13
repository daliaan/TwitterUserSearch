package dalian.razvan.cucer.twitterusersearch

import android.app.Application
import dalian.razvan.cucer.twitterusersearch.networking.VolleyManager

class TwitterUserSearch: Application() {

    override fun onCreate() {
        super.onCreate()

        VolleyManager.initialise(this)
    }
}