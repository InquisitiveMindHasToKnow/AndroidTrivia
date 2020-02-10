package org.ohmstheresistance.androidtrivia.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import org.ohmstheresistance.androidtrivia.R
import org.ohmstheresistance.androidtrivia.databinding.GameOverFragmentBinding

class GameOverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: GameOverFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.game_over_fragment, container, false)

        binding.tryAgainButton.setOnClickListener { view: View ->

            //both lines below do the same thing!

            //view.findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment)
            view.findNavController().navigate(GameOverFragmentDirections.actionGameOverFragmentToGameFragment())

        }

            return binding.root
    }


}
