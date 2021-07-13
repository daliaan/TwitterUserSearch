package dalian.razvan.cucer.twitterusersearch.screens.search

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import dalian.razvan.cucer.twitterusersearch.R
import dalian.razvan.cucer.twitterusersearch.core.base.BaseFragment
import dalian.razvan.cucer.twitterusersearch.databinding.FragmentUserSearchBinding
import kotlinx.android.synthetic.main.fragment_user_search.*
import org.koin.core.inject

class UserSearchFragment: BaseFragment<UserSearchViewModel, FragmentUserSearchBinding>() {

    override val viewModel: UserSearchViewModel by inject()

    override fun whichLayout(): Int = R.layout.fragment_user_search

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        username_input_edit_text.doOnTextChanged { text, start, before, count ->
            viewModel.onTextChanged(text.toString())
        }
    }
}