package id.hilal.hafizhquran

import android.app.Application
import id.hilal.hafizhquran.content.initContent

/*
 * Created by littleflower on 8/13/17.
 */
class HafizhQuranApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initContent()
    }
}