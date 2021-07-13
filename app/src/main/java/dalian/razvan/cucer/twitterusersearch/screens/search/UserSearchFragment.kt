package dalian.razvan.cucer.twitterusersearch.screens.search

import dalian.razvan.cucer.twitterusersearch.R
import dalian.razvan.cucer.twitterusersearch.base.BaseFragment
import dalian.razvan.cucer.twitterusersearch.databinding.FragmentUserSearchBinding
import org.koin.core.inject

class UserSearchFragment: BaseFragment<UserSearchViewModel, FragmentUserSearchBinding>() {

    override val viewModel: UserSearchViewModel by inject()

    override fun whichLayout(): Int = R.layout.fragment_user_search
}