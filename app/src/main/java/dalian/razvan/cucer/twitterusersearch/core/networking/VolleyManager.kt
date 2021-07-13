package dalian.razvan.cucer.twitterusersearch.core.networking

import android.content.Context
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import dalian.razvan.cucer.twitterusersearch.core.networking.error.ErrorResponse

object VolleyManager: API {

    private lateinit var queue: RequestQueue

    fun initialise(context: Context) {
        queue = Volley.newRequestQueue(context)
    }

    private fun get(url: String, callback: APICallbackInterface) {
        Log.e(javaClass.simpleName, "Volley request for $url")
        queue.add(TwitterUserSearchJsonObjectRequest(url, null,
            {
                callback.onSuccess(it)
            },
            {
                callback.onError(parseError(it))
            }
        ))
    }

    private fun parseError(it: VolleyError): String = ErrorResponse(Gson().fromJson(it.localizedMessage?:"", ErrorResponse::class.java)).toString()

    override suspend fun getUser(query: String, callback: APICallbackInterface) {
        get(Endpoints.BASE_URL + Endpoints.USERS + Endpoints.BY_USERNAMES + query, callback)
    }

    override suspend fun getUserTweets(userId: String, callback: APICallbackInterface) {
        get(Endpoints.BASE_URL + Endpoints.USERS + userId + Endpoints.TWEETS, callback)
    }
}