package dalian.razvan.cucer.twitterusersearch.koin

import dalian.razvan.cucer.twitterusersearch.networking.API
import dalian.razvan.cucer.twitterusersearch.networking.VolleyManager
import dalian.razvan.cucer.twitterusersearch.repository.Repository
import dalian.razvan.cucer.twitterusersearch.repository.RepositoryImpl
import org.koin.dsl.module



val repositoryModule = module {
    single { RepositoryImpl(get()) as Repository }
}

val networkModule = module {
    single { VolleyManager as API }
}