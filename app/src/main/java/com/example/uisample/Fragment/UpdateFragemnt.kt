package com.example.uisample.Fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.uisample.R
import com.example.uisample.data.DailyModel
import com.example.uisample.data.repository.RepoModel
import kotlinx.android.synthetic.main.fragment_update_fragemnt.*
import kotlinx.android.synthetic.main.fragment_update_fragemnt.view.*


class UpdateFragemnt : Fragment() {

    private lateinit var viewmodel:RepoModel

    private val args by navArgs<UpdateFragemntArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update_fragemnt, container, false)

        viewmodel=ViewModelProvider(this).get(RepoModel::class.java)

        view.update_title_et.setText(args.currentItem.title)
        view.update_description_et.setText(args.currentItem.description)
        //setMenu

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.update_menu -> Onupdatedata()
            R.id.delete_menu -> OndeleteData()

        }
        return super.onOptionsItemSelected(item)
    }

    private fun OndeleteData() {
        val builder=AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){
            _,_ ->
            viewmodel.deleteData(args.currentItem)
            Toast.makeText(requireContext(),"Sucessfully Delete",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragemnt_to_listFragment)

        }
        builder.setNegativeButton("No"){_,_ -> }
        builder.setTitle("Delete")
        builder.setMessage("Are you sure want to delete ?")
        builder.create().show()

    }

    private fun Onupdatedata() {

        val title = update_title_et.text.toString()
        val description = update_description_et.text.toString()

        if (inputcheck(title, description)) {
            val updateItem=DailyModel(args.currentItem.id,title,description)
            viewmodel.updateData(updateItem)
            Toast.makeText(requireContext(),"Sucessfully Updated",Toast.LENGTH_LONG)
            findNavController().navigate(R.id.action_updateFragemnt_to_listFragment)

        }
        else{
            Toast.makeText(requireContext(),"Fill All the Details",Toast.LENGTH_LONG)
        }
    }


    private fun inputcheck(title: String, description: String): Boolean {
        return !(title.isEmpty() || description.isEmpty())
    }
}
