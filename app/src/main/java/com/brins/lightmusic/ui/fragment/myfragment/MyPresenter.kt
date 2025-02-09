package com.brins.lightmusic.ui.fragment.myfragment

import androidx.lifecycle.Lifecycle
import com.brins.lightmusic.api.ApiHelper
import com.brins.lightmusic.api.DefaultObserver
import com.brins.lightmusic.common.AsyncTransformer
import com.brins.lightmusic.model.userplaylist.UserPlayListResult
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import com.uber.autodispose.kotlin.autoDisposable

class MyPresenter : MyContract.Presenter {

    private var mView: MyContract.View? = null

    val provider: AndroidLifecycleScopeProvider by lazy {
        AndroidLifecycleScopeProvider.from(mView?.getLifeActivity(), Lifecycle.Event.ON_DESTROY)
    }

    companion object {
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder = MyPresenter()
    }

    override fun loadUserMusicList(id : String) {
        ApiHelper.getUserPlayListService().getUserPlayList(id)
            .compose(AsyncTransformer<UserPlayListResult>())
            .autoDisposable(provider)
            .subscribe(object : DefaultObserver<UserPlayListResult>(){
                override fun onSuccess(response: UserPlayListResult) {
                    mView?.onUserMusicListLoad(response)
                }

                override fun onFail(message: String) {
                    mView?.onLoadFail()
                }

            })
    }

    override fun updateUserMusicList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadUserRadio() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadRecord() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subscribe(view: MyContract.View) {
        mView = view
        mView!!.setPresenter(this)
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}