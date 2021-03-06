package com.example.msise.journeyplanner.collections

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msise.journeyplanner.R

class CollectionsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_collections, container, false)

    companion object {
        fun newInstance(): CollectionsFragment = CollectionsFragment()
    }
}