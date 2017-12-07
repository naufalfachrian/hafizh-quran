package id.hilal.hafizhquran.feature.surahlist

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import id.hilal.hafizhquran.R
import id.hilal.hafizhquran.model.Surah
import kotlinx.android.synthetic.main.activity_surah_list.*

class SurahListActivity : AppCompatActivity() {

    var bottomSheetBehavior: BottomSheetBehavior<View>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surah_list)
        surahList.layoutManager = LinearLayoutManager(this)
        surahList.hasFixedSize()
        surahList.adapter = SurahListAdapter()
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior?.peekHeight = 0
    }

    fun surahItemClicked(surah: Surah) {
        val fragment = SurahListDialogFragment()
        val bundle = Bundle()
        bundle.putSerializable("surah", surah)
        fragment.arguments = bundle
        fragment.show(supportFragmentManager, "BottomSheet")
    }
}
