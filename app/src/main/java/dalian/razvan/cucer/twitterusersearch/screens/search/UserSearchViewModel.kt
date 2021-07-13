package dalian.razvan.cucer.twitterusersearch.screens.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dalian.razvan.cucer.twitterusersearch.core.networking.APICallbackInterface
import dalian.razvan.cucer.twitterusersearch.core.networking.error.ErrorCallback
import dalian.razvan.cucer.twitterusersearch.core.repository.Repository
import dalian.razvan.cucer.twitterusersearch.screens.list.TwitterUsersAdapter
import kotlinx.coroutines.launch
import org.json.JSONObject

class UserSearchViewModel(private val repository: Repository): ViewModel() {

    val errorText = MutableLiveData<String>()
    val adapter = TwitterUsersAdapter()

    fun onTextChanged(text: String) {
        Log.e(javaClass.simpleName, text)
        if (text.length > 2) {
            viewModelScope.launch {
                repository.getUsers(text, adapter, object: ErrorCallback{
                    override fun onError(error: String) {
                        errorText.postValue(error)
                    }
                })
            }
        }
    }
}