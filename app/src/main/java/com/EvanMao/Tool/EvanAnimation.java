package com.EvanMao.Tool;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;

/**
 * Created by Administrator on 2015/12/22.
 */
public class EvanAnimation {
    static EvanAnimation instance;

    public static EvanAnimation getInstance() {
        if (instance == null) {
            synchronized (EvanAnimation.class) {
                if (instance == null) {
                    instance = new EvanAnimation();
                }
            }
        }
        return instance;
    }

    private void Animation3Dturn(View view) {
        ObjectAnimator
                .ofFloat(view, "rotationX", 0.0F, 360.0F)//
                .setDuration(500)//
                .start();

    }

    public void set3DturnAnimation(View v) {
        Animation3Dturn(v);
    }

    public void setNarrowFadeAnimation(View v) {
        rotateyAnimRun(v);
    }

    private void rotateyAnimRun(final View view) {
        ObjectAnimator anim = ObjectAnimator//
                .ofFloat(view, "zhy", 1.0F, 0.0F)//
                .setDuration(500);//
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                view.setAlpha(cVal);
                view.setScaleX(cVal);
                view.setScaleY(cVal);
            }
        });
    }

    public void propertyValuesHolder(View view) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
                0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
                0, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
                0, 1f);
        PropertyValuesHolder pvhq = PropertyValuesHolder.ofFloat("rotationX", 0, 360f, 0);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY, pvhZ, pvhq).setDuration(1000).start();
    }

}
