package dalian.razvan.cucer.twitterusersearch.screens.search.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dalian.razvan.cucer.twitterusersearch.R
import dalian.razvan.cucer.twitterusersearch.core.repository.models.TwitterUser
import kotlinx.android.synthetic.main.twitter_user_item.view.*

class TwitterUsersViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(user: TwitterUser, listener: TwitterUsersAdapter.SelectItem, clickListener: View.OnClickListener) {
        itemView.username.text = itemView.context.resources.getString(R.string.twitter_user, user.name, user.id, user.username)
        itemView.setOnClickListener {
            listener.select(user)
            clickListener.onClick(it)
        }
    }
}
