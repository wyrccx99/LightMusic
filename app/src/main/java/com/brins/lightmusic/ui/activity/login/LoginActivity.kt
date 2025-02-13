package com.brins.lightmusic.ui.activity.login

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.brins.lib_common.utils.SpUtils
import com.brins.lightmusic.R
import com.brins.lightmusic.common.AppConfig
import com.brins.lightmusic.common.AppConfig.PASSWORD
import com.brins.lightmusic.common.AppConfig.USERNAME
import com.brins.lightmusic.model.userlogin.UserLoginRequest
import com.brins.lightmusic.model.userlogin.UserLoginResult
import com.brins.lightmusic.ui.base.BaseActivity
import com.brins.lightmusic.utils.*
import kotlinx.android.synthetic.main.activity_unlogin.*

class LoginActivity : BaseActivity(), LoginContract.View, View.OnClickListener {

    private lateinit var mPresenter: LoginContract.Presenter
    private var isLogin = false

    companion object {
        val IS_LOGIN = "isLogin"
        val LOGIN_SUCCESS_CODE = 1002
        val LOGIN_FAIL_CODE = 1001

        fun startThisActivity(
            fragment: Fragment,
            login: Boolean
        ) {
            val intent = Intent(fragment.activity, LoginActivity::class.java)
            intent.putExtra(IS_LOGIN, login)
            fragment.startActivityForResult(intent, 1)
        }
    }


    override fun onClick(v: View?) {
        USERNAME = et_username.text.toString()
        PASSWORD = et_password.text.toString()
        if (USERNAME.isEmpty() || PASSWORD.isEmpty()) {
            Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show()
            return
        }
        val request =
            UserLoginRequest(LoginPresenter.Companion.LOGIN_TYPE.TYPE_EMAIL, USERNAME, PASSWORD)
        mPresenter.startLogin(request)
    }

    override fun getLayoutResId(): Int {
        return if(isLogin)R.layout.activity_login else R.layout.activity_unlogin
    }


    override fun onCreateBeforeBinding(savedInstanceState: Bundle?) {
        super.onCreateBeforeBinding(savedInstanceState)
        isLogin = intent.getBooleanExtra(IS_LOGIN,false)
    }


    override fun onCreateAfterBinding(savedInstanceState: Bundle?) {
        super.onCreateAfterBinding(savedInstanceState)
        LoginPresenter.instance.subscribe(this)
        if (btn_login != null){
            btn_login.setOnClickListener(this)
        }
    }


    override fun showLoading() {
        val weight = btn_login.measuredWidth.toFloat()
        val height = btn_login.measuredHeight.toFloat()
        input_layout_name.visibility = View.INVISIBLE
        input_layout_psw.visibility = View.INVISIBLE
        val set = inputAnimator(input_layout, weight, height)
        set.start()
        set.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {}
            override fun onAnimationEnd(animation: Animator?) {
                layout_progress.visibility = View.VISIBLE
                progressAnimator(layout_progress)
                input_layout.visibility = View.INVISIBLE
            }

            override fun onAnimationCancel(animation: Animator?) {}

            override fun onAnimationStart(animation: Animator?) {}

        })
    }

    override fun hideLoading() {
        layout_progress.visibility = View.GONE
        input_layout.visibility = View.VISIBLE
        input_layout_name.visibility = View.VISIBLE
        input_layout_psw.visibility = View.VISIBLE
        recovery(input_layout)
    }


    fun saveUserAccount(info: UserLoginResult) {
        AppConfig.userAccount = info.account
        AppConfig.userProfile = info.profile
        SpUtils.obtain(SP_USER_INFO, this).save(KEY_IS_LOGIN, true)
        AppConfig.isLogin = true
        setResult(LOGIN_SUCCESS_CODE)
        finish()
    }


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unsubscribe()
    }

    //MVP View
    override fun handleError(error: Throwable) {
    }

    override fun onLoginSuccess(respone: UserLoginResult) {
        saveUserAccount(respone)
        Log.d(TAG, "success :")
    }

    override fun onLoginFail() {
        hideLoading()
        setResult(LOGIN_FAIL_CODE)
        finish()
    }

    override fun setPresenter(presenter: LoginContract.Presenter?) {
        mPresenter = presenter!!

    }

    override fun getLifeActivity(): AppCompatActivity {
        return this
    }
}
