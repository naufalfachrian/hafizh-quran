package id.hilal.hafizhquran.feature.test

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import id.hilal.hafizhquran.R
import id.hilal.hafizhquran.model.Ayah
import id.hilal.hafizhquran.model.Question
import id.hilal.hafizhquran.model.QuestionType
import id.hilal.hafizhquran.model.Surah
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    var surah: Surah = Surah("", ArrayList<Ayah>(), ArrayList<Question>())

    var fragments: ArrayList<Fragment>? = null

    var currentPosition = 0

    // statistic

    var answeredQuestion = 0

    var trueAnswer = 0

    var displayAlert: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        surah = intent.extras.getSerializable("surah") as Surah
        title = "Uji Hafalan " + surah.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fragments = ArrayList<Fragment>()
        surah.test.forEach { question ->
            val fragment: Fragment
            when (question.type) {
                QuestionType.MultipleChoice -> {
                    fragment = MultipleChoiceQuestionFragment.init(question)
                }
                QuestionType.Audio -> {
                    fragment = AudioQuestionFragment.init(question)
                }
            }
            fragments?.add(fragment)
        }

        buttonNext.setOnClickListener {
            currentPosition += 1
            if (!replaceFragment()) {
                showFinishQuizAlert()
                currentPosition -= 1
            }
        }

        buttonPrev.setOnClickListener {
            currentPosition -= 1
            if (!replaceFragment()) {
                Toast.makeText(this, "Ini pertanyaan pertama.", Toast.LENGTH_SHORT).show()
                currentPosition += 1
            }
        }

        replaceFragment()
    }

    @SuppressLint("SetTextI18n")
    private fun replaceFragment(): Boolean {
        updateStatistic()
        if (currentPosition >= 0 && currentPosition < fragments!!.count()) {
            val fragment: Fragment? = fragments?.get(currentPosition)
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment, fragment)
                    .commit()
            questionCounterLabel.text = (currentPosition + 1).toString() + " / " + fragments?.count()
            return true
        }
        return false
    }

    private fun updateStatistic() {
        answeredQuestion = 0
        trueAnswer = 0
        fragments!!.forEach { fragment ->
            val questionFragment = fragment as QuestionFragment
            answeredQuestion += if (questionFragment.isAnswered()) 1 else 0
            trueAnswer += if (questionFragment.isTrue()) 1 else 0
        }
    }

    private fun showFinishQuizAlert() {
        if (displayAlert == null || !displayAlert!!.isShowing) {
            displayAlert = AlertDialog.Builder(this)
                    .setMessage("Selesaikan kuis sekarang juga?")
                    .setPositiveButton("Ya", { dialogInterface, i ->
                        displayAlert?.dismiss()
                        showResult()
                    })
                    .setNeutralButton("Saya mau periksa kembali", null)
                    .setCancelable(false)
                    .show()
        }
    }

    private fun showResult() {
        val message = "Anda menjawab " + answeredQuestion.toString() + " pertanyaan.\n" +
                "Anda meraih " + (trueAnswer * 100 / surah.test.count()) + " poin."
        if (displayAlert == null || !displayAlert!!.isShowing) {
            displayAlert = AlertDialog.Builder(this)
                    .setTitle("Perolehan Anda")
                    .setMessage(message)
                    .setPositiveButton("Kembali ke menu", { dialogInterface, i ->
                        finish()
                    })
                    .setCancelable(false)
                    .show()
        }
    }
}
