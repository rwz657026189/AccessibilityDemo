package com.rwz.accessibilitydemo

/**
 * date： 2020/10/8 11:23
 * author： rwz
 * description：
 * 参考：https://blog.csdn.net/qq_45186002/article/details/104489291
 **/
import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import com.rwz.accessibilitydemo.page.IPageProxy
import com.rwz.accessibilitydemo.page.LoginProxy

class MyAccessibilityService : AccessibilityService() {

    private val mPageProxy = HashMap<String, IPageProxy>()
    private var currPage: String = ""
    private var isInit = false

    override fun onInterrupt() {
    }

    private fun init() {
        isInit = true
        mPageProxy["com.huawei.smartpvms.view.login.LoginActivity"] = LoginProxy()
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (!isInit) {
            init()
        }
        LogUtil.d("MyAccessibilityService onAccessibilityEvent：event = $event, currPage = $currPage")
        event?.let {
            when (it.eventType) {
                AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {
                    currPage = event.className.toString()
                    mPageProxy[currPage]?.onWindowChanged(rootInActiveWindow, event)
                }
                AccessibilityEvent.TYPE_VIEW_CLICKED -> mPageProxy[currPage]?.onClickView(rootInActiveWindow, event)
                AccessibilityEvent.TYPE_VIEW_FOCUSED -> {
                    LogUtil.d("MyAccessibilityService onAccessibilityEvent：currPage22 = ${mPageProxy[currPage]}, currPage = $currPage, mPageProxy = $mPageProxy")
                    mPageProxy[currPage]?.onViewFocused(rootInActiveWindow, event)
                }
                else -> LogUtil.d("MyAccessibilityService onAccessibilityEvent： = $" + it.action)
            }
        }
    }

}