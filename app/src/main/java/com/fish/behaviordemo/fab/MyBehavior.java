package com.fish.behaviordemo.fab;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;

public class MyBehavior extends CoordinatorLayout.Behavior<View> {
    //此构造函数必须加入
    public MyBehavior(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

	//child就是绑定此behavior的view，dependency是发送变化的view
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        //此处child 就是fab，dependency是被依赖的view
        if (dependency instanceof Snackbar.SnackbarLayout) {
            //SnackbarLayout 变化了，A该如何变化在这里写
            child.setTranslationY(child.getTranslationY() - 100);
            return true;
        }
        return false;
    }

    @Override
    public void onDependentViewRemoved(CoordinatorLayout parent, View child, View dependency) {
        if (dependency instanceof Snackbar.SnackbarLayout) {
            //SnackbarLayout 变化了，fab该如何变化在这里写
            child.setTranslationY(child.getTranslationY() - 100);
        }
    }
}