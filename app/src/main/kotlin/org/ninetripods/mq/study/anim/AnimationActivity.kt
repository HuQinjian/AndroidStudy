package org.ninetripods.mq.study.anim

import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import org.ninetripods.mq.study.BaseActivity
import org.ninetripods.mq.study.R
import org.ninetripods.mq.study.kotlin.ktx.id

/**
 * Created by mq on 2022/10/23 下午9:46
 * mqcoder90@gmail.com
 */
class AnimationActivity : BaseActivity() {
    private val mTvTarget: ImageView by id(R.id.iv_target)
    private val mBtnRotate: Button by id(R.id.btn_rotate)
    private val mBtnTranslate: Button by id(R.id.btn_translate)
    private val mBtnAlpha: Button by id(R.id.btn_alpha)
    private val mBtnScale: Button by id(R.id.btn_scale)
    private val mBtnStop: Button by id(R.id.btn_stop)
    private val mBtnAnimSet: Button by id(R.id.btn_anim_set)
    private val mToolBar: Toolbar by id(R.id.toolbar)

    override fun getLayoutId(): Int = R.layout.layout_activity_animation

    override fun initViews() {
        initToolBar(mToolBar, "补间动画", true, false, TYPE_BLOG)
    }

    override fun initEvents() {
        mBtnRotate.setOnClickListener { mTvTarget.startAnimation(loadRotationAnim()) }
        mBtnScale.setOnClickListener {  }
        mBtnTranslate.setOnClickListener {  }
        mBtnAlpha.setOnClickListener {  }
        mBtnAnimSet.setOnClickListener {  } //组合动画
        mBtnStop.setOnClickListener { mTvTarget.clearAnimation() }
    }


    /**
     * 旋转动画
     */
    private fun loadRotationAnim(): Animation {
        //方式1：代码动态生成
        val rotateAnim: Animation = RotateAnimation(
            0f,
            360f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        ).apply {
            duration = 2000
            interpolator = LinearInterpolator()
            fillAfter = true //动画结束后，是否停留在动画结束状态
            repeatCount = Animation.INFINITE //重复次数 INFINITE为无限重复
            startOffset = 0L //动画延迟开始时间 ms
            repeatMode =
                Animation.RESTART // RESTART：正序重新开始、REVERSE：倒序重新开始，默认是RESTART。注意：repeatCount(count)设置的count值必须>0或者是INFINITE才会生效
        }
        return rotateAnim
        // 方式2：通过XML创建
        // return AnimationUtils.loadAnimation(this, R.anim.view_rotate)
    }


}