package com.example.uisample.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.uisample.R
import com.example.uisample.data.repository.RepoModel
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

 private lateinit var viewmodel:RepoModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        //Recycle View

        val adapter = ListAdapter()
        val reycycleview = view.recyclerView
        reycycleview.adapter = adapter
        reycycleview.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            //StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //recyclerView.itemAnimator = SlideInUpAnimator().apply {
            //addDuration = 300

            viewmodel=ViewModelProvider(this).get(RepoModel::class.java)
            viewmodel.getAlldata.observe(viewLifecycleOwner, Observer {
                data->adapter.setData(data)
            })




            view.floatingActionButton.setOnClickListener() {
                findNavController().navigate(R.id.action_listFragment_to_addFragment)
            }

            return view
        }

    }

