package com.example.uisample.Fragment

import android.annotation.SuppressLint
import android.graphics.Color.green
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.uisample.R
import com.example.uisample.data.DailyModel
import com.example.uisample.data.repository.RepoModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.card_row.*
import kotlinx.android.synthetic.main.fragment_add.*


class AddFragment : Fragment() {


    //val Clickitem:List<View> = listOf(btn_green,btn_red)

    private lateinit var viewmodel:RepoModel      //Remember
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)

        viewmodel=ViewModelProvider(this).get(RepoModel::class.java)

        //seT OPtion Menu



        setHasOptionsMenu(true)

        return view

    }






    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.add_menu){
            InsertDatatoDb()

        }
        return super.onOptionsItemSelected(item)
    }

    private fun InsertDatatoDb() {
        val mtitle = title_et.text.toString()
        val mdescription = description_et.text.toString()
        if (verifyDataFromUser(mtitle, mdescription)) {

            //insert data to Dstabase
            val newdata=DailyModel(0,mtitle,mdescription)
            viewmodel.addData(newdata)
            Toast.makeText(requireContext(),"Sucessfully Added",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }
        else
        {
            Toast.makeText(requireContext(),"Fill all details",Toast.LENGTH_LONG).show()
        }


    }

    private fun verifyDataFromUser(mtitle: String, mdescription: String): Boolean {
        return !(mtitle.isEmpty() || mdescription.isEmpty())


}
}
