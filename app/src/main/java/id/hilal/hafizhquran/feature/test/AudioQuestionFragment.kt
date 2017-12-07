package id.hilal.hafizhquran.feature.test


import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import id.hilal.hafizhquran.R
import id.hilal.hafizhquran.model.Question
import kotlinx.android.synthetic.main.fragment_audio_question.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class AudioQuestionFragment : Fragment(), QuestionFragment {

    private val REQ_CODE_SPEECH_INPUT = 100

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

        fun init(question: Question) : AudioQuestionFragment {
            val bundle = Bundle()
            bundle.putSerializable("question", question)
            val fragment = AudioQuestionFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_audio_question, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        question = arguments.getSerializable("question") as Question

        questionTitle.setText(question?.title)

        button.setOnClickListener {
            promptSpeechInput()
        }
    }

    /**
     * Showing google speech input dialog
     */
    private fun promptSpeechInput() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, question!!.title)
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT)
        } catch (a: ActivityNotFoundException) {
            Toast.makeText(context,
                    "Ponsel Anda tidak mendukung fitur ini.",
                    Toast.LENGTH_SHORT).show()
        }

    }

    /**
     * Receiving speech input
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQ_CODE_SPEECH_INPUT -> {
                if (resultCode == Activity.RESULT_OK && null != data) {
                    _isAnswered = true
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    _isTrue = result[0].toLowerCase() == question!!.answer!!.toLowerCase()
                    Toast.makeText(context, "Jawaban Anda : " + result[0].toLowerCase()
                            + "\nJawaban Benar : " + question!!.answer!!.toLowerCase(), Toast.LENGTH_SHORT)
                            .show()
                }
            }
        }
    }

}// Required empty public constructor
