package com.assignmenttestandroid.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignmenttestandroid.R
import com.assignmenttestandroid.ui.ListPhotosAdapter
import com.assignmenttestandroid.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.custom_toolbar.*
import kotlinx.android.synthetic.main.show_list.*

@AndroidEntryPoint
class ShowListPhotosFragment : Fragment(R.layout.fragment_show_list_photos) {

    lateinit var listPhotosAdapter: ListPhotosAdapter

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setUpRecyclerView()
        observeLiveData()
        searchData()
    }

    private fun searchData() {
        et_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                loadData()
            }

        })
    }

    private fun loadData() {
        if (et_search.text.toString().length >= 3) {
            viewModel.getListPhotos(et_search.text.toString())
            observeLiveData()
        }
    }

    private fun observeLiveData() {
        viewModel.apply {
            listPhotosLiveData.observe(viewLifecycleOwner, Observer {
                listPhotosAdapter.differ.submitList(it)
            })
        }
    }

    private fun setUpRecyclerView() {
        listPhotosAdapter = ListPhotosAdapter()
        rv_list.apply {
            adapter = listPhotosAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}