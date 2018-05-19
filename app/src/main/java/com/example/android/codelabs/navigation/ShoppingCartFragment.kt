package com.example.android.codelabs.navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ShoppingCartFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ShoppingCartFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ShoppingCartFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance() = ShoppingCartFragment()
    }
}
