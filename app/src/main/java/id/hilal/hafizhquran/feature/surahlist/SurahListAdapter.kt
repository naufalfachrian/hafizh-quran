package id.hilal.hafizhquran.feature.surahlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.hilal.hafizhquran.R
import id.hilal.hafizhquran.content.content
import id.hilal.hafizhquran.model.Surah

/*
 * Created by littleflower on 8/12/17.
 */
class SurahListAdapter : RecyclerView.Adapter<SurahListViewHolder>() {

    var surahList: ArrayList<Surah> = content

    override fun onBindViewHolder(holder: SurahListViewHolder?, position: Int) {
        holder?.bindData(surahList.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SurahListViewHolder {
        return SurahListViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_surah_list, parent, false))
    }

    override fun getItemCount(): Int {
        return surahList.count()
    }
}