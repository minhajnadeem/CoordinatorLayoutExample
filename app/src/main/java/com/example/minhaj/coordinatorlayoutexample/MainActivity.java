package com.example.minhaj.coordinatorlayoutexample;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.FloatingActionButton.OnVisibilityChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private TextView textView;
    private FloatingActionButton fab;
    private Animation animation1;
    private Animation animation2;
    private int toolBarHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //textView = (TextView) findViewById(R.id.textView);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        setSupportActionBar(toolbar);
        toolBarHeight = toolbar.getHeight();

        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        setListener();

        animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);

    }


    private void setListener() {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.d("example",verticalOffset+"|toolbar height"+toolbar.getHeight());
                if (verticalOffset > -300){
                    //toggleTextView(true);
                }else if (verticalOffset == toolBarHeight){
                    //toggleTextView(false);
                }
            }
        });

        new OnVisibilityChangedListener() {
            @Override
            public void onShown(FloatingActionButton fab) {
                super.onShown(fab);
                Toast.makeText(MainActivity.this, "shown", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onHidden(FloatingActionButton fab) {
                super.onHidden(fab);
                Toast.makeText(MainActivity.this, "hidden", Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void toggleTextView(boolean toogle) {
        if (toogle){
            textView.setVisibility(View.VISIBLE);
            //animScaleUp();
            fab.show();
        }else {

            textView.setVisibility(View.GONE);
            //animScaleDown();
            fab.hide();
        }

    }

    private void animScaleUp(){
        //Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        textView.startAnimation(animation1);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void animScaleDown(){
        //Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        textView.startAnimation(animation2);
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    class Floating extends FloatingActionButton.OnVisibilityChangedListener{

        @Override
        public void onHidden(FloatingActionButton fab) {
            super.onHidden(fab);
        }

        @Override
        public void onShown(FloatingActionButton fab) {
            super.onShown(fab);
        }
    }
}