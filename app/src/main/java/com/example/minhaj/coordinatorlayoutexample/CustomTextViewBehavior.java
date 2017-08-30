package com.example.minhaj.coordinatorlayoutexample;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Attr;

/**
 * Created by minhaj on 16/08/2017.
 */

public class CustomTextViewBehavior extends CoordinatorLayout.Behavior<TextView> {

    public CustomTextViewBehavior(){}
    public CustomTextViewBehavior(Context context, AttributeSet attr){
        super(context,attr);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        //Log.d("example",(dependency instanceof AppBarLayout)+"");
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {

        //Log.d("example",Math.abs(dependency.getX())+"");
        //Log.d("example",Math.abs(dependency.getY())+"");
        if (dependency.getY() >-300){
            //child.setVisibility(View.VISIBLE);
        }else {
            //child.setVisibility(View.GONE);
        }
        //child.setX(Math.abs(dependency.getX()));
        //child.setY(Math.abs(dependency.getY()));
        //child.setTextScaleX(Math.abs(dependency.getX()));
        //child.setTextScaleX(Math.abs(dependency.getY()));
        return false;
    }
}
