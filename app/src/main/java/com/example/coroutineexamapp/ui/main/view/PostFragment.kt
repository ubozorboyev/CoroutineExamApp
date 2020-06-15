package com.example.coroutineexamapp.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.coroutineexamapp.App
import com.example.coroutineexamapp.R
import com.example.coroutineexamapp.data.model.PostItemData
import com.example.coroutineexamapp.databinding.PostFragmentBinding
import com.example.coroutineexamapp.ui.main.adapter.PostAdapter
import com.example.coroutineexamapp.ui.main.viewmodel.PostViewModel
import com.example.coroutineexamapp.utils.Status
import javax.inject.Inject

class PostFragment :Fragment(){


    private lateinit var binding: PostFragmentBinding
    private val adapter = PostAdapter()

    @Inject lateinit var  viewmodel:PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = PostFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        App.component.inject(this)
        binding.recycView.adapter = adapter

        viewmodel.getPosts().observe(viewLifecycleOwner, Observer {

            when(it.status){

                Status.SUCCSESS -> {
                    binding.recycView.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.INVISIBLE
                    adapter.setData(it.data as List<PostItemData>)
                }
                Status.LOADING -> {
                    binding.recycView.visibility = View.INVISIBLE
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    binding.recycView.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(context,it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_postFragment_to_userFragment)
        }

    }
}