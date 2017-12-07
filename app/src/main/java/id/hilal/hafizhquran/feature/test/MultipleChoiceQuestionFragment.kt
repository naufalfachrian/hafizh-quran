package id.hilal.hafizhquran.feature.test


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.hilal.hafizhquran.R
import id.hilal.hafizhquran.model.Question
import kotlinx.android.synthetic.main.fragment_multiple_choice_question.*


/**
 * A simple [Fragment] subclass.
 */
class MultipleChoiceQuestionFragment : Fragment(), QuestionFragment {

    var _isAnswered = false

    var _isTrue = false

    override fun isAnswered(): Boolean {
        return _isAnswered
    }

    override fun isTrue(): Boolean {
        return _isTrue
    }

    var question : Question? = null

    companion object {

        fun init(question: Question) : MultipleChoiceQuestionFragment {
            val bundle = Bundle()
            bundle.putSerializable("question", question)
            val fragment = MultipleChoiceQuestionFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_multiple_choice_question, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        question = arguments.getSerializable("question") as Question

        questionTitle.setText(question?.title)

        radioButton1.setText(question?.options?.get(0)?.string)
        radioButton1.setOnClickListener {
            _isTrue = question!!.options!![0].isTrue
            _isAnswered = true
        }

        radioButton2.setText(question?.options?.get(1)?.string)
        radioButton2.setOnClickListener {
            _isTrue = question!!.options!![1].isTrue
            _isAnswered = true
        }

        radioButton3.setText(question?.options?.get(2)?.string)
        radioButton3.setOnClickListener {
            _isTrue = question!!.options!![2].isTrue
            _isAnswered = true
        }
    }

}// Required empty public constructor
