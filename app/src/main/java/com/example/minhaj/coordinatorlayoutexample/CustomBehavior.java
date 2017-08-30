package com.example.minhaj.coordinatorlayoutexample;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by minhaj on 16/08/2017.
 */

public class CustomBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

    public CustomBehavior(){}
    public CustomBehavior(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        //Log.d("example","depends on");
        //Log.d("example",(dependency instanceof AppBarLayout)+"");
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        //Log.d("example","changed");

        return false;
    }
}
