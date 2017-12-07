package id.hilal.hafizhquran.feature.ayahlist

import android.support.v7.widget.RecyclerView
import android.view.View
import id.hilal.hafizhquran.model.Ayah
import kotlinx.android.synthetic.main.item_ayah_list.view.*

/*
 * Created by littleflower on 8/13/17.
 */
class AyahListViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun bindData(ayah: Ayah, position: kotlin.Int) {
        itemView.ayahContent.text = ayah.content
        if (position == 0) {
            itemView.ayahContent.textAlignment = View.TEXT_ALIGNMENT_CENTER
        }
    }
}