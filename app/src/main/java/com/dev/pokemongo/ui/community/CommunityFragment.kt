package com.dev.pokemongo.ui.community

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.dev.pokemongo.adapter.CommunityAdapter
import com.dev.pokemongo.adapter.FriendsCommunityAdapter
import com.dev.pokemongo.databinding.FragmentCommunityBinding
import com.dev.pokemongo.retrofit.response.communityresponse.Foes
import com.dev.pokemongo.retrofit.response.communityresponse.Friends
import com.dev.pokemongo.sharedpreference.AccountManager
import com.dev.pokemongo.ui.captured.CapturedViewModel
import com.example.urlshortenapp.utils.Status


class CommunityFragment : Fragment() {
    lateinit var binding: FragmentCommunityBinding
    val viewModel: CommunityViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCommunityBinding.inflate(inflater, container, false)
        val root = binding.root

        viewModel.getCommunity(AccountManager.getToken()).observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data.let {
                            // for (u in it?.foes!!)
                            binding.commfoeRecyclerview.adapter =
                                CommunityAdapter(it?.foes as ArrayList<Foes>)

                        }
                    }
                    Status.ERROR -> {
                        resource.message?.let { it1 -> Log.d("geterror", it1) }
                    }
                    Status.LOADING -> {
                        resource.message?.let { it1 -> Log.d("getmessage", it1) }

                    }
                }
            }
        })

        viewModel.getCommunity(AccountManager.getToken()).observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data.let {
                            binding.commfriendRecyclerview.adapter =
                                FriendsCommunityAdapter(it?.friends as ArrayList<Friends>)
                            Log.d("Myteam", it.toString())
                        }
                    }
                    Status.ERROR -> {
                        resource.message?.let { it1 -> Log.d("geterror", it1) }
                    }
                    Status.LOADING -> {
                        resource.message?.let { it1 -> Log.d("getmessage", it1) }

                    }
                }
            }
        })

        return root
    }

}