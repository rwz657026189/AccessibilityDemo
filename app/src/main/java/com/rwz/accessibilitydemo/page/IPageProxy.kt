package com.rwz.accessibilitydemo.page

import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

/**
 * date： 2020/10/8 12:13
 * author： rwz
 * description：
 **/
const val CLICK_DELAY = 300L

interface IPageProxy {
    
    fun onWindowChanged(rootNode: AccessibilityNodeInfo, event: AccessibilityEvent)

    fun onClickView(rootNode: AccessibilityNodeInfo, event: AccessibilityEvent)

    fun onViewFocused(rootNode: AccessibilityNodeInfo, event: AccessibilityEvent)

}