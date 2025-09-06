package com.planetquiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Button
import androidx.core.content.ContextCompat


class MultipleChoiceFragment : Fragment() {

    companion object {
        private const val ARG_QUESTION = "arg_question"
        private const val ARG_CORRECT_ANSWER = "arg_correct"

        fun newInstance(question: String, correctAnswer: String) =
            MultipleChoiceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_QUESTION, question)
                    putString(ARG_CORRECT_ANSWER, correctAnswer)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_multiple_choice, container, false)

        // Get views
        val questionText = view.findViewById<TextView>(R.id.question_text)
        val answersContainer = view.findViewById<LinearLayout>(R.id.answers_container)

        // Get arguments from QuestionsFragment
        val question = arguments?.getString(ARG_QUESTION) ?: ""
        val correctAnswer = arguments?.getString(ARG_CORRECT_ANSWER) ?: ""

        // Set question text
        questionText.text = question

        // Load planets from strings.xml
        val planets = resources.getStringArray(R.array.planets_array)

        // Create a button for each planet
        planets.forEach { planet ->
            val button = Button(requireContext()).apply {
                text = planet
                setTextColor(ContextCompat.getColor(requireContext(), R.color.planet_button_text_color)) // text color

                // Set the rounded background
                background = ContextCompat.getDrawable(requireContext(), R.drawable.planet_button_bg)

                // Add layout parameters so buttons have spacing
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(16, 16, 16, 0) // add margin between buttons
                layoutParams = params

                setOnClickListener {
                    val isCorrect = planet == correctAnswer
                    val detailText = when (correctAnswer) {
                        "JUPITER" -> getString(R.string.answer_largest)
                        "SATURN" -> getString(R.string.answer_moons)
                        "URANUS" -> getString(R.string.answer_spins)
                        else -> ""
                    }

                    // Navigate to AnswersFragment
                    val answerFragment = AnswersFragment.newInstance(isCorrect, correctAnswer, detailText)
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, answerFragment)
                        .addToBackStack(null)
                        .commit()
                }
            }

            // Add button to container
            answersContainer.addView(button)
        }

        return view
    }
}
