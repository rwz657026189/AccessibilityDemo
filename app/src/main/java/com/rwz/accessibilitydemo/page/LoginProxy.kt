package com.rwz.accessibilitydemo.page

import android.os.Handler
import android.os.Looper
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.rwz.accessibilitydemo.Help
import com.rwz.accessibilitydemo.LogUtil

/**
 * date： 2020/10/8 12:15
 * author： rwz
 * description：登录页面
 **/
class LoginProxy : IPageProxy{

    private val handler = Handler(Looper.getMainLooper())

    override fun onWindowChanged(rootNode: AccessibilityNodeInfo, event: AccessibilityEvent) {

    }

    override fun onClickView(rootNode: AccessibilityNodeInfo, event: AccessibilityEvent) {

    }

    override fun onViewFocused(rootNode: AccessibilityNodeInfo, event: AccessibilityEvent) {
        val currNodeInfo = rootNode.findFocus(AccessibilityNodeInfo.FOCUS_INPUT)
        LogUtil.d("LoginProxy onViewFocused：currNodeInfo = $currNodeInfo")
        when (currNodeInfo?.text) {
            "用户名" -> Help.setText(currNodeInfo, "landon")
            "密码" -> {
                Help.setText(currNodeInfo, "Huawei@123")
                // 点击登录
                handler.postDelayed({
                    Help.findNodeByText(rootNode, "登录")
                        ?.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                }, CLICK_DELAY)
            }
        }
    }



}