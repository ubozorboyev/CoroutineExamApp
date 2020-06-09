package com.example.coroutineexamapp.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.coroutineexamapp.App
import com.example.coroutineexamapp.data.model.UserData
import com.example.coroutineexamapp.databinding.UserFragmentBinding
import com.example.coroutineexamapp.ui.main.adapter.UserAdapter
import com.example.coroutineexamapp.ui.main.viewmodel.UserViewModel
import com.example.coroutineexamapp.utils.Resource
import com.example.coroutineexamapp.utils.Status
import javax.inject.Inject

class UserFragment :Fragment(){


    private val adapter by lazy { UserAdapter(requireContext()) }

    @Inject lateinit var viewModel: UserViewModel

    private  var _binding: UserFragmentBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= UserFragmentBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        App.component.inject(this)

        binding.recycView.adapter = adapter

        val userObserver=Observer<Resource<Any>>{

            it.let {resource->

                when(resource.status){

                    Status.SUCCSESS->{

                        binding.recycView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        resource.data.let {
                            adapter.setData(it as List<UserData>)
                        }
                    }

                    Status.LOADING->{

                        binding.progressBar.visibility = View.VISIBLE
                        binding.recycView.visibility = View.GONE
                    }

                    Status.ERROR->{

                        binding.recycView.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        viewModel.getUsers().observe(viewLifecycleOwner, userObserver)

    }
}