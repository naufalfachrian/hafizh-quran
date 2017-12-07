package id.hilal.hafizhquran.model

import java.io.Serializable

/*
 * Created by littleflower on 8/12/17.
 */
data class Surah(
        val name: String,
        val ayahs: List<Ayah>,
        val test: List<Question>
) : Serializable {
    //
}