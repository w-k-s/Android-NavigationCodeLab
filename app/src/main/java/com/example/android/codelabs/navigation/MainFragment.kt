/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.Button
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController

/**
 * Fragment used to show how to navigate to another destination
 */
class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    private val navigationButton: Button?
        get() = view?.findViewById(R.id.navigate_dest_bt)

    private val navigateWithActionButton: Button?
        get() = view?.findViewById(R.id.navigate_action_bt)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        applyNavigationUsingNavControllerWithOptions()
        applyNavigationUsingAction()
    }

    @SuppressWarnings("unused")
    private fun applyNavigationUsingNavigationClickListener() {
        navigationButton?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.flow_step_one, null))
    }

    @SuppressWarnings("unused")
    private fun applyNavigationUsingNavControllerWithOptions() {
        val options = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()

        navigationButton?.setOnClickListener {
            findNavController(it).navigate(R.id.flow_step_one, null, options)
        }
    }

    private fun applyNavigationUsingAction() {
        navigateWithActionButton?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next_action, null))
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){
            R.id.shopping_cart_animated -> {
                navigateToShoppingCart()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun navigateToShoppingCart(){
        view?.let {
            val options = NavOptions.Builder()
                    .setEnterAnim(R.anim.slide_in_right)
                    .setExitAnim(R.anim.slide_out_left)
                    .build()
            findNavController(it).navigate(R.id.shopping_cart,null,options)
        }
    }
}
