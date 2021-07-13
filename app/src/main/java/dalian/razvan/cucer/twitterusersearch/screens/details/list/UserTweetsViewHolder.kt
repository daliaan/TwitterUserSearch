package dalian.razvan.cucer.twitterusersearch.screens.details.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dalian.razvan.cucer.twitterusersearch.core.repository.models.Tweet
import kotlinx.android.synthetic.main.simple_item.view.*

class UserTweetsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(item: Tweet) {
        itemView.text.text = item.text
    }
}
