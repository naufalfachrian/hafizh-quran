package id.hilal.hafizhquran.feature.surahlist

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.hilal.hafizhquran.R
import id.hilal.hafizhquran.feature.ayahlist.AyahListActivity
import id.hilal.hafizhquran.model.Surah
import id.hilal.hafizhquran.feature.test.QuizActivity

/*
 * Created by littleflower on 8/13/17.
 */
class SurahListDialogFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.bottom_sheet_activity_main, container, false)
        val surah: Surah = arguments.getSerializable("surah") as Surah
        view?.findViewById<TextView>(R.id.bottomSheetHeading)?.text = surah.name
        view?.findViewById<AppCompatButton>(R.id.closeBottomSheetButton)?.setOnClickListener {
            this.dismiss()
        }
        view?.findViewById<AppCompatButton>(R.id.readButton)?.setOnClickListener {
            this.dismiss()
            val intent = Intent(context, AyahListActivity::class.java)
            intent.putExtra("surah", surah)
            startActivity(intent)
        }
        view?.findViewById<AppCompatButton>(R.id.testButton)?.setOnClickListener {
            this.dismiss()
            val intent = Intent(context, QuizActivity::class.java)
            intent.putExtra("surah", surah)
            startActivity(intent)
        }
        return view
    }
}