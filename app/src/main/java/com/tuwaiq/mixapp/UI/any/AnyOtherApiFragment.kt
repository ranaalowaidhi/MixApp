package com.tuwaiq.mixapp.UI.any

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuwaiq.mixapp.R

class AnyOtherApiFragment : Fragment() {

    companion object {
        fun newInstance() = AnyOtherApiFragment()
    }

    private lateinit var viewModel: AnyOtherApiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_any_other_api, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnyOtherApiViewModel::class.java)
        // TODO: Use the ViewModel
    }

}