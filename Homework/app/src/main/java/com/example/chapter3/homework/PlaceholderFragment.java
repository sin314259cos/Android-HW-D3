package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;


public class PlaceholderFragment extends Fragment {

    private AnimatorSet animatorSet;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final View target1 = getView().findViewById(R.id.animation_view);
        final View target2 = getView().findViewById(R.id.scroll_view);
        target2.setAlpha(0f);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator alphaAnimator1 = ObjectAnimator.ofFloat(target1,
                        "alpha",1f,0f);
                alphaAnimator1.setDuration(500);
                ObjectAnimator alphaAnimator2 = ObjectAnimator.ofFloat(target2,
                        "alpha",0f,1f);
                alphaAnimator2.setDuration(500);
                animatorSet = new AnimatorSet();
                animatorSet.playTogether(alphaAnimator1,alphaAnimator2);
                animatorSet.start();
            }
        }, 5000);
    }
}
