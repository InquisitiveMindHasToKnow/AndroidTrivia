package org.ohmstheresistance.androidtrivia.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import org.ohmstheresistance.androidtrivia.R
import org.ohmstheresistance.androidtrivia.databinding.TitleFragmentBinding


class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<TitleFragmentBinding>(inflater, R.layout.title_fragment, container, false)

        binding.playButton.setOnClickListener (

            Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment))

        return binding.root
    }
}
