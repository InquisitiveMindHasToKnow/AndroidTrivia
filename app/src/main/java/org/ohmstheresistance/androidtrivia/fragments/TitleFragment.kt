package org.ohmstheresistance.androidtrivia.fragments


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.ohmstheresistance.androidtrivia.R
import org.ohmstheresistance.androidtrivia.databinding.TitleFragmentBinding


class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<TitleFragmentBinding>(inflater, R.layout.title_fragment, container, false)

        //both lines below do the same thing.

//      binding.playButton.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment))
        binding.playButton.setOnClickListener {v: View ->
            v.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }


        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController()) || super.onOptionsItemSelected(item)
    }
}
