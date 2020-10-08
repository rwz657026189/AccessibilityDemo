package com.rwz.accessibilitydemo.page

import android.os.Bundle
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.rwz.accessibilitydemo.LogUtil


/**
 * date： 2020/10/8 12:15
 * author： rwz
 * description：
 **/
class LoginProxy : IPageProxy{
    override fun onWindowChanged(rootNode: AccessibilityNodeInfo, event: AccessibilityEvent) {

    }

    override fun onClickView(rootNode: AccessibilityNodeInfo, event: AccessibilityEvent) {

    }

    override fun onViewFocused(rootNode: AccessibilityNodeInfo, event: AccessibilityEvent) {
        val currNodeInfo = rootNode.findFocus(AccessibilityNodeInfo.FOCUS_INPUT)
        LogUtil.d("LoginProxy onViewFocused：currNodeInfo = $currNodeInfo")
        when (currNodeInfo?.text) {
            "请输入手机号" -> setText(currNodeInfo, "18380205254")
            "密码" -> setText(currNodeInfo, "Huawei@123")
        }
    }

    private fun setText(node: AccessibilityNodeInfo, text: String) {
        var arguments = Bundle()
        arguments.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, text)
        node.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments)
    }

}