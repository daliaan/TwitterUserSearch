package dalian.razvan.cucer.twitterusersearch.screens.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import dalian.razvan.cucer.twitterusersearch.R
import dalian.razvan.cucer.twitterusersearch.core.networking.error.ErrorCallback
import dalian.razvan.cucer.twitterusersearch.core.repository.Repository
import dalian.razvan.cucer.twitterusersearch.core.repository.models.TwitterUser
import dalian.razvan.cucer.twitterusersearch.screens.search.list.TwitterUsersAdapter
import kotlinx.coroutines.launch

class UserSearchViewModel(private val repository: Repository): ViewModel() {

    val errorText = MutableLiveData<String>()
    val adapter = TwitterUsersAdapter().also { adapter ->
        adapter.addSelectItemListener(object : TwitterUsersAdapter.SelectItem {
            override fun select(item: TwitterUser) {
                repository.setSelectedUser(item)
            }
        })
        adapter.addSelectItemClickListener{
            Log.e(javaClass.simpleName, " Go To Details ")
            Navigation.findNavController(it).navigate(R.id.go_to_details)
        }
    }

    fun onTextChanged(text: String) {
        Log.e(javaClass.simpleName, text)
        if (text.length > 2) {
            errorText.postValue("")
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