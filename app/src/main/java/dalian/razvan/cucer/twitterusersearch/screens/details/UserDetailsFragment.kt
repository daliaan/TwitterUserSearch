package dalian.razvan.cucer.twitterusersearch.screens.details

import dalian.razvan.cucer.twitterusersearch.R
import dalian.razvan.cucer.twitterusersearch.core.base.BaseFragment
import dalian.razvan.cucer.twitterusersearch.databinding.FragmentUserDetailsBinding
import org.koin.core.inject

class UserDetailsFragment: BaseFragment<UserDetailsViewModel, FragmentUserDetailsBinding>() {

    override val viewModel: UserDetailsViewModel by inject()

    override fun whichLayout(): Int = R.layout.fragment_user_details
}