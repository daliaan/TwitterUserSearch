package dalian.razvan.cucer.twitterusersearch.screens.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import dalian.razvan.cucer.twitterusersearch.R
import dalian.razvan.cucer.twitterusersearch.core.repository.models.TwitterUser

class TwitterUsersAdapter: RecyclerView.Adapter<TwitterUsersViewHolder>(), TwitterUsersCallback {

    private val items = MutableLiveData<MutableList<TwitterUser>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwitterUsersViewHolder =
        TwitterUsersViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.twitter_user_item, parent, false))

    override fun onBindViewHolder(holder: TwitterUsersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = items.value?.size?: 0

    private fun getItem(position: Int): TwitterUser? = items.value?.get(position)

    override fun setItems(list: MutableList<TwitterUser>) {
        items.postValue(mutableListOf())
        items.postValue(list)
        notifyDataSetChanged()
    }
}