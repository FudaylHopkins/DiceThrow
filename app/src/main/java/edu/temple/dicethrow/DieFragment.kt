package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"
    lateinit var dieTextView: TextView

    private lateinit var viewModel: DieViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[DieViewModel::class.java]

        arguments?.getInt(DIESIDE)?.let {
            viewModel.setSides(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.currentRoll.observe(viewLifecycleOwner, Observer {
            dieTextView.text = it.toString()
        })

        if (viewModel.currentRoll.value == null) {
            viewModel.rollDie()
        }
    }

    fun rollDie() {
       viewModel.rollDie()
    }


    companion object{
        fun newInstance(sides:Int)= DieFragment().apply {
            arguments = Bundle().apply {
                putInt(DIESIDE,sides)
            }
        }
    }
}