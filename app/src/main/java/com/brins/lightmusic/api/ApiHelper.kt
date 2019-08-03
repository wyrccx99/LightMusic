package com.brins.lightmusic.api

import com.brins.lightmusic.api.service.MusicService
import com.brins.lightmusic.common.AppConfig.BASEURL
import com.brins.lightmusic.model.*
import com.brins.lightmusic.model.musicvideo.LastestMvData
import com.brins.lightmusic.model.musicvideo.MvMetaData
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiHelper {

        private fun getRetrofitFactory(baseurl : String): MusicService {
            val retrofit = Retrofit.Builder().baseUrl(baseurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build()
            return retrofit.create(MusicService::class.java)
        }

        fun  getClient() : OkHttpClient {
            val builder : OkHttpClient.Builder = OkHttpClient().newBuilder()
            val client = builder.connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build()
            return client
        }


    fun getArtist(i: Int): Observable<Data> {
        return getRetrofitFactory(BASEURL).getArtist(i)
    }

    fun getPlayList(i : Int): Observable<Data>{
        return getRetrofitFactory(BASEURL).getPlayList(i)
    }

    fun getPlayListDetail(id : String) : Observable<MusicListDetail>{
        return getRetrofitFactory(BASEURL).getPlayListDetail(id)
    }

    fun getMusicDetail(ids : String): Observable<MusicMetaData>{
        return getRetrofitFactory(BASEURL).getAlbum(ids)
    }

    fun getMusicUrl(ids : String): Observable<Songs>{
        return getRetrofitFactory(BASEURL).getUrl(ids)
    }

    fun getLatestMvData(limit: String = "10"): Observable<LastestMvData>{
        return getRetrofitFactory(BASEURL).getLatestMusicVideo(limit)
    }

    fun getMvMetaData(id : String): Observable<MvMetaData>{
        return getRetrofitFactory(BASEURL).getMvMetaData(id)
    }
}