package org.ohmstheresistance.androidtrivia.fragments


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

import org.ohmstheresistance.androidtrivia.R
import org.ohmstheresistance.androidtrivia.databinding.GameWonFragmentBinding

class GameWonFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       val binding: GameWonFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.game_won_fragment, container, false)

        binding.nextMatchButton.setOnClickListener{ view: View ->

            //view.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
            view.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)

        //hide share option if no available apps to use the intent
        if (null == getShareIntent()?.resolveActivity(activity!!.packageManager)) {
            menu.findItem(R.id.share)?.setVisible(false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getShareIntent(): Intent? {

        var winningInfoArgs = arguments?.let { GameWonFragmentArgs.fromBundle(it) }

        return activity?.let {
            ShareCompat.IntentBuilder.from(it)
                .setText(getString(R.string.share_success_text,
                    winningInfoArgs?.numCorrect, winningInfoArgs?.numQuestions
                ))
                .setType("text/plain")
                .intent
        }
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

}
