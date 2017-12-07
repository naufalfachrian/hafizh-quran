package id.hilal.hafizhquran.feature.surahlist

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import id.hilal.hafizhquran.model.Surah
import kotlinx.android.synthetic.main.item_surah_list.view.*

/*
 * Created by littleflower on 8/12/17.
 */
class SurahListViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    @SuppressLint("SetTextI18n")
    fun bindData(surah: Surah) {
        itemView.surahName.text = surah.name
        var ayahCount = surah.ayahs.count()
        if (surah.name != "Al-Fatihah")  {
            ayahCount = ayahCount - 1
        }
        itemView.ayahCount.text = ayahCount.toString() + " ayat"
        itemView.setOnClickListener {
            (itemView.context as SurahListActivity).surahItemClicked(surah)
        }
    }
}