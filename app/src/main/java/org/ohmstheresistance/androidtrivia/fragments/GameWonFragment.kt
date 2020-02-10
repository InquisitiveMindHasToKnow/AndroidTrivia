package org.ohmstheresistance.androidtrivia.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import org.ohmstheresistance.androidtrivia.R
import org.ohmstheresistance.androidtrivia.databinding.GameWonFragmentBinding

class GameWonFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       val binding: GameWonFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.game_won_fragment, container, false)

        binding.nextMatchButton.setOnClickListener{ view: View ->

            //view.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
            view.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())

        }

        var winningInfoArgs = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        Toast.makeText(context, "Number Correct: ${winningInfoArgs!!.numCorrect}, Total:${winningInfoArgs.numQuestions}", Toast.LENGTH_SHORT).show()

        return binding.root
    }


}
