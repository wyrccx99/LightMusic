package com.brins.lightmusic.ui.fragment.myfragment

import com.brins.lightmusic.model.userplaylist.UserPlayListResult
import com.brins.lightmusic.ui.base.BasePresenter
import com.brins.lightmusic.ui.base.BaseView

interface MyContract {
    interface View : BaseView<Presenter> {
        fun onUserProfileLoad()

        fun onUserMusicListLoad(result : UserPlayListResult)

        fun showLoading()

        fun hideLoading()

        fun onLoadFail()

    }

    interface Presenter : BasePresenter<View> {
        /*
        * 获得用户歌单
        * */
        fun loadUserMusicList(id : String)

        /*
         * 更新用户歌单
         * */
        fun updateUserMusicList()
        /*
        * 获得用户电台
        * */
        fun loadUserRadio()
        /*
        * 获得用户最近播放
        * */
        fun loadRecord()


    }
}