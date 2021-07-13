package dalian.razvan.cucer.twitterusersearch.networking

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import dalian.razvan.cucer.twitterusersearch.networking.error.ErrorResponse

object VolleyManager: API {

    private lateinit var queue: RequestQueue

    fun initialise(context: Context) {
        queue = Volley.newRequestQueue(context)
    }

    private suspend fun get(url: String, callback: APICallbackInterface) {
        queue.add(TwitterUserSearchJsonObjectRequest(url, null,
            {
                callback.onSuccess(it)
            },
            {
                callback.onError(parseError(it))
            }
        ))
    }

    private fun parseError(it: VolleyError): String = ErrorResponse(Gson().fromJson(it.networkResponse.data.toString(), ErrorResponse::class.java)).toString()

    override suspend fun getUser(query: String, callback: APICallbackInterface) {
        get(Endpoints.BASE_URL + Endpoints.USERS + Endpoints.BY_USERNAMES + query, callback)
    }

    override suspend fun getUserTweets(userId: String, callback: APICallbackInterface) {
        get(Endpoints.BASE_URL + Endpoints.USERS + userId + Endpoints.TWEETS, callback)
    }
}