package org.ohmstheresistance.androidtrivia.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import org.ohmstheresistance.androidtrivia.R

class GameOverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.game_over_fragment, container, false)
    }


}
