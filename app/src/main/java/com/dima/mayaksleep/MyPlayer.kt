package com.dima.mayaksleep

import android.content.Context
import android.media.AudioManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

open class MyPlayer(val context: Context)  {

    private var player: SimpleExoPlayer

    init {

        val radioUrl = "https://icecast-vgtrk.cdnvideo.ru/mayakfm_aac_64kbps"
        val dataSourceFactory: DefaultHttpDataSource.Factory = DefaultHttpDataSource.Factory()
        val uri = Uri.parse(radioUrl)

        val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(uri))

        player = SimpleExoPlayer.Builder(context).build()
        player.setMediaSource(mediaSource)
    }

    fun play() {
        player.prepare()
        player.playWhenReady = true
    }

    fun stop() {
        player.stop()
    }
}