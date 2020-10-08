package com.rwz.accessibilitydemo

import android.os.Bundle
import android.text.TextUtils
import android.view.accessibility.AccessibilityNodeInfo

/**
 * date： 2020/10/8 14:46
 * author： rwz
 * description：
 **/
object Help {

    /**
     * 给控件设置文本属性
     */
    fun setText(node: AccessibilityNodeInfo, text: String) {
        val arguments = Bundle()
        arguments.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, text)
        node.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments)
    }

    /**
     * 通过字符串找到节点
     */
    fun findNodeByText(rootNode: AccessibilityNodeInfo, content: String): AccessibilityNodeInfo?{
        val list = rootNode.findAccessibilityNodeInfosByText(content)
        return list.find { TextUtils.equals(content, it.text.toString()) }
    }

}
