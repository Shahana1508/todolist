package com.example.taskexam

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskexam.databinding.AlertdialogBinding
import com.example.taskexam.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding:FragmentHomeBinding?=null
    private val binding get()=_binding!!
    private var tasks= arrayListOf<TaskModel>()
    private val taskAdapter=TaskAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter=taskAdapter
        binding.add.setOnClickListener{
            taskAdapter.updatelist(tasks)
            val alertDialog=AlertDialog.Builder(requireContext()).create()
            val alertbinding=AlertdialogBinding.inflate(layoutInflater)
            alertDialog.setView(alertbinding.root)
            alertbinding.button.setOnClickListener{
                val task:String=alertbinding.editTextText.text.toString()
                if(alertbinding.radioButton.isChecked){

                    val image=R.drawable.images
                    tasks.add(TaskModel(image,task))
                    taskAdapter.updatelist(tasks)
                }else if (alertbinding.radioButton2.isChecked){

                    val image=R.drawable.unnamed
                    tasks.add(TaskModel(image,task))
                    taskAdapter.updatelist(tasks)
                }else{

                    val image=R.drawable.green
                    tasks.add(TaskModel(image,task))
                    taskAdapter.updatelist(tasks)
                }
                alertDialog.dismiss()
            }
            alertDialog.show()
        }
        taskAdapter.clickitem={
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(it))
        }
        taskAdapter.deleteitem={
            val alertDialog=AlertDialog.Builder(requireContext())
            alertDialog.setMessage("Are you sure you want to remove?")
            alertDialog.setPositiveButton("Yes"){_,_->
                tasks.remove(it)
                taskAdapter.updatelist(tasks)
            }
            alertDialog.setNegativeButton("No"){_,_->

            }
            alertDialog.create().show()

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}