package com.planetquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class AnswersFragment : Fragment() {

    companion object {
        private const val ARG_CORRECT = "arg_correct"
        private const val ARG_CORRECT_ANSWER = "arg_correct_answer"
        private const val ARG_DETAIL = "arg_detail"

        fun newInstance(isCorrect: Boolean, correctAnswer: String, detail: String) =
            AnswersFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_CORRECT, isCorrect)
                    putString(ARG_CORRECT_ANSWER, correctAnswer)
                    putString(ARG_DETAIL, detail)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_answers, container, false)
        val resultText = view.findViewById<TextView>(R.id.result_text)
        val detailText = view.findViewById<TextView>(R.id.detail_text)

        val isCorrect = arguments?.getBoolean(ARG_CORRECT) ?: false
        val correctAnswer = arguments?.getString(ARG_CORRECT_ANSWER) ?: ""
        val detail = arguments?.getString(ARG_DETAIL) ?: ""

        resultText.text = if (isCorrect) {
            getString(R.string.correct)
        } else {
            getString(R.string.wrong, correctAnswer)
        }

        detailText.text = detail

        return view
    }
}
