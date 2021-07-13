package dalian.razvan.cucer.twitterusersearch

import android.app.Application
import dalian.razvan.cucer.twitterusersearch.koin.networkModule
import dalian.razvan.cucer.twitterusersearch.koin.repositoryModule
import dalian.razvan.cucer.twitterusersearch.koin.viewModelsModule
import dalian.razvan.cucer.twitterusersearch.core.networking.VolleyManager
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TwitterUserSearch: Application() {

    override fun onCreate() {
        super.onCreate()

        VolleyManager.initialise(this)

        startKoin {
            androidContext(this@TwitterUserSearch)
            modules(listOf(viewModelsModule, repositoryModule, networkModule))
        }
    }
}