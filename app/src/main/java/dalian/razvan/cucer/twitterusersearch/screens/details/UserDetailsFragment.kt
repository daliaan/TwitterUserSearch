package dalian.razvan.cucer.twitterusersearch.screens.details

import android.os.Bundle
import android.view.View
import dalian.razvan.cucer.twitterusersearch.R
import dalian.razvan.cucer.twitterusersearch.core.base.BaseFragment
import dalian.razvan.cucer.twitterusersearch.databinding.FragmentUserDetailsBinding
import kotlinx.android.synthetic.main.fragment_user_details.*
import org.koin.core.inject

class UserDetailsFragment: BaseFragment<UserDetailsViewModel, FragmentUserDetailsBinding>() {

    override val viewModel: UserDetailsViewModel by inject()

    override fun whichLayout(): Int = R.layout.fragment_user_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadProfilePicture(profile_picture)
        viewModel.loadTweets()
    }
}