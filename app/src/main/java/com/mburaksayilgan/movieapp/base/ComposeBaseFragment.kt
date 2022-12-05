package com.mburaksayilgan.movieapp.base

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.mburaksayilgan.movieapp.R
import com.mburaksayilgan.movieapp.databinding.FragmentComposeBinding
import dagger.Lazy
import javax.inject.Inject

abstract class ComposeBaseFragment : Fragment(R.layout.fragment_compose) {

    @Inject
    lateinit var composer: Lazy<Composer>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentComposeBinding.bind(requireView())
        val composeView = binding.composeView

        composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner))
            setContent {
                composer.get().Compose()
            }
        }
    }

}