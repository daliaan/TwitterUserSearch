package dalian.razvan.cucer.twitterusersearch.koin

import dalian.razvan.cucer.twitterusersearch.networking.API
import dalian.razvan.cucer.twitterusersearch.networking.VolleyManager
import dalian.razvan.cucer.twitterusersearch.repository.Repository
import dalian.razvan.cucer.twitterusersearch.repository.RepositoryImpl
import dalian.razvan.cucer.twitterusersearch.screens.details.UserDetailsViewModel
import dalian.razvan.cucer.twitterusersearch.screens.search.UserSearchViewModel
import org.koin.dsl.module

val viewModelsModule = module{
    single { UserSearchViewModel(get()) }
    single { UserDetailsViewModel(get()) }
}

val repositoryModule = module {
    single { RepositoryImpl(get()) as Repository }
}

val networkModule = module {
    single { VolleyManager as API }
}