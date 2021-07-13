package dalian.razvan.cucer.twitterusersearch.networking

object Endpoints {

    const val BASE_URL = "https://api.twitter.com/2/"

    //User lookup API reference https://developer.twitter.com/en/docs/twitter-api/users/lookup/api-reference
    const val USERS = "users/"
    const val BY_USERNAMES = "by?usernames="

    //Tweets lookup API reference https://developer.twitter.com/en/docs/twitter-api/tweets/timelines/api-reference
    const val TWEETS = "/tweets/"
}