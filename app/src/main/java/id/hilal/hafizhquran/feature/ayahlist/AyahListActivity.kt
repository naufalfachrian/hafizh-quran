package id.hilal.hafizhquran.feature.ayahlist

import android.content.Context
import android.content.DialogInterface
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import id.hilal.hafizhquran.R
import id.hilal.hafizhquran.model.Ayah
import id.hilal.hafizhquran.model.Question
import id.hilal.hafizhquran.model.Surah
import kotlinx.android.synthetic.main.activity_ayah_list.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class AyahListActivity : AppCompatActivity() {

    var surah: Surah = Surah("", ArrayList<Ayah>(), ArrayList<Question>())
    var mediaPlayer = MediaPlayer()
    var currentAyah = 0
    var isPaused = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayah_list)
        surah = intent.extras.getSerializable("surah") as Surah
        title = surah.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ayahList.layoutManager = LinearLayoutManager(this)
        ayahList.hasFixedSize()
        ayahList.adapter = AyahListAdapter(surah.ayahs)

        buttonPlay.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                isPaused = true
                buttonPlay.setBackgroundResource(R.drawable.button_play)
            } else {
                playSurah()
                isPaused = false
                buttonPlay.setBackgroundResource(R.drawable.button_pause)
            }
        }

        buttonStop.setOnClickListener {
            resetPlayer()
            buttonPlay.setBackgroundResource(R.drawable.button_play)
        }

        buttonRepeat.setOnClickListener {
            showRepeatAlert()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    private fun playSurah() {
        if (currentAyah < surah.ayahs.count()) {
            val ayahSound = surah.ayahs[currentAyah].sound
            if (!isPaused) {
                mediaPlayer = MediaPlayer.create(this, ayahSound)
            }
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener { mediaPlayer ->
                isPaused = false
                mediaPlayer.release()
                this.mediaPlayer = MediaPlayer()
                this.currentAyah++
                this.playSurah()
            }
        }
    }

    private fun resetPlayer() {
        isPaused = false
        currentAyah = 0
        mediaPlayer.stop()
        mediaPlayer.release()
        mediaPlayer = MediaPlayer()
    }

    private fun repeatPlayer() {
        resetPlayer()
        buttonPlay.setBackgroundResource(R.drawable.button_pause)
        playSurah()
    }

    private fun showRepeatAlert() {
        val alert = AlertDialog.Builder(this)
                .setTitle("Ulangi Surat")
                .setMessage("Apakah Anda yakin ingin mengulang pembacaan surat ini?")
                .setPositiveButton("Ya", { dialogInterface, i ->
                    repeatPlayer()
                })
                .setNegativeButton("Tidak", null)
                .setCancelable(true)
        alert.show()
    }

}
