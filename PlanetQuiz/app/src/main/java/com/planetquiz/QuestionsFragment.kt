package com.planetquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class QuestionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_questions, container, false)

        val btnQ1 = view.findViewById<Button>(R.id.button_q1)
        val btnQ2 = view.findViewById<Button>(R.id.button_q2)
        val btnQ3 = view.findViewById<Button>(R.id.button_q3)

        btnQ1.setOnClickListener { openMultipleChoice(getString(R.string.question_largest), "JUPITER") }
        btnQ2.setOnClickListener { openMultipleChoice(getString(R.string.question_moons), "SATURN") }
        btnQ3.setOnClickListener { openMultipleChoice(getString(R.string.question_spins), "URANUS") }

        return view
    }

    private fun openMultipleChoice(question: String, correctAnswer: String) {
        val fragment = MultipleChoiceFragment.newInstance(question, correctAnswer)

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}




