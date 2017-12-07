package id.hilal.hafizhquran.feature.ayahlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.hilal.hafizhquran.R
import id.hilal.hafizhquran.model.Ayah

/*
 * Created by littleflower on 8/13/17.
 */
class AyahListAdapter(val ayahs: List<Ayah>) : RecyclerView.Adapter<AyahListViewHolder>() {

    override fun onBindViewHolder(holder: AyahListViewHolder?, position: Int) {
        holder?.bindData(ayahs.get(position), position)
    }

    override fun getItemCount(): Int {
        return ayahs.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AyahListViewHolder {
        return AyahListViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_ayah_list, parent, false))
    }
}