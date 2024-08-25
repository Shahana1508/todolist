package com.example.taskexam

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.taskexam.databinding.FragmentDetailBinding
import com.example.taskexam.databinding.FragmentHomeBinding


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding?=null
    private val binding get()=_binding!!
    private val args:DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val task=args.task
        binding.taskadi.text=task.task
        if(task.image==R.drawable.images){
            binding.vaciblik.text="vacib"
        }else if (task.image==R.drawable.green){
            binding.vaciblik.text="rahat"
        }else{
            binding.vaciblik.text="orta"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}