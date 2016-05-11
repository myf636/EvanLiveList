package com.EvanMao.Tool;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class MAAnimationSet {

    public static class ScaleAnimationMiddle extends Animation {
        int mCenterX;//记录View的中间坐标
        int mCenterY;

        public ScaleAnimationMiddle() {
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            //初始化中间坐标值
            mCenterX = width / 2;
            mCenterY = height / 2;
            setDuration(300);
            setFillAfter(true);
            setInterpolator(new LinearInterpolator());
        }

        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {
            final Matrix matrix = t.getMatrix();
            matrix.setScale(interpolatedTime, interpolatedTime);
            //通过坐标变换，把参考点（0,0）移动到View中间
            matrix.preTranslate(-mCenterX, -mCenterY);
            //动画完成后再移回来
            matrix.postTranslate(mCenterX, mCenterY);
        }
    }

    public static Animation getScaleAnimationMiddle() {
        return new ScaleAnimationMiddle();
    }

    //
    //

    public static class ScaleAnimationLeftTop extends Animation {
        public ScaleAnimationLeftTop() {
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            setDuration(300);
            setFillAfter(true);
            setInterpolator(new LinearInterpolator());
        }

        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {
            final Matrix matrix = t.getMatrix();
            matrix.setScale(interpolatedTime, interpolatedTime);
        }
    }

    public static Animation getScaleAnimationLeftTop() {
        return new ScaleAnimationLeftTop();
    }

    public static class ScaleAnimationLeftSide extends Animation {
        int mCenterX;
        int mCenterY;

        public ScaleAnimationLeftSide() {
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            //初始化中间坐标值
            mCenterX = width;
            mCenterY = height;
            setDuration(300);
            setFillAfter(true);
            setInterpolator(new LinearInterpolator());
        }

        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {
            final Matrix matrix = t.getMatrix();
            matrix.setTranslate((-mCenterX + (interpolatedTime * mCenterX)), interpolatedTime * 0);
        }
    }

    public static Animation getScaleAnimationLeftSide() {
        return new ScaleAnimationLeftSide();
    }

    public static class ScaleAnimationRightSide extends Animation {
        int mCenterX;
        int mCenterY;

        public ScaleAnimationRightSide() {
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            //初始化中间坐标值
            mCenterX = width;
            mCenterY = height;
            setDuration(300);
            setFillAfter(true);
            setInterpolator(new LinearInterpolator());
        }

        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {
            final Matrix matrix = t.getMatrix();
            matrix.setTranslate((mCenterX - (interpolatedTime * mCenterX)), interpolatedTime * 0);
        }
    }

    public static Animation getScaleAnimationRightSide() {
        return new ScaleAnimationRightSide();
    }

    public static class ScaleAnimationTopSide extends Animation {
        int mCenterX;
        int mCenterY;

        public ScaleAnimationTopSide() {
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            //初始化中间坐标值
            mCenterX = width;
            mCenterY = height;
            setDuration(300);
            setFillAfter(true);
            setInterpolator(new LinearInterpolator());
        }

        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {
            final Matrix matrix = t.getMatrix();
            matrix.setTranslate(interpolatedTime * 0, (-mCenterY + (interpolatedTime * mCenterY)));
        }
    }

    public static Animation getScaleAnimationTopSide() {
        return new ScaleAnimationTopSide();
    }

    public static class ScaleAnimationTopSideBack extends Animation {
        int mCenterX;
        int mCenterY;

        public ScaleAnimationTopSideBack() {
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            //初始化中间坐标值
            mCenterX = width;
            mCenterY = height;
            setDuration(300);
            setFillAfter(true);
            setInterpolator(new LinearInterpolator());
        }

        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {
            final Matrix matrix = t.getMatrix();
            matrix.setTranslate(interpolatedTime * 0, (0 - (interpolatedTime * mCenterY)));
        }
    }

    public static Animation getScaleAnimationTopSideBack() {
        return new ScaleAnimationTopSideBack();
    }

    public static class ScaleAnimationRightTop extends Animation {
        int mCenterX;
        int mCenterY;

        public ScaleAnimationRightTop() {
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            //初始化中间坐标值
            mCenterX = width;
            mCenterY = height;
            setDuration(300);
            setFillAfter(true);
            setInterpolator(new LinearInterpolator());
        }

        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {
            final Matrix matrix = t.getMatrix();
            matrix.setScale(interpolatedTime, interpolatedTime);
            matrix.preTranslate(-mCenterX, 0);
            matrix.postTranslate(mCenterX, 0);
        }
    }

    /**
     * 从右上角增大出现
     *
     * @return
     */
    public static Animation getScaleAnimationRightTop() {
        return new ScaleAnimationRightTop();
    }

    public static class ScaleAnimationLeftBottom extends Animation {
        int mCenterX;
        int mCenterY;

        public ScaleAnimationLeftBottom() {
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            //初始化中间坐标值
            mCenterX = width;
            mCenterY = height;
            setDuration(300);
            setFillAfter(true);
            setInterpolator(new LinearInterpolator());
        }

        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {
            final Matrix matrix = t.getMatrix();
            matrix.setScale(interpolatedTime, interpolatedTime);
            matrix.preTranslate(0, -mCenterY);
            matrix.postTranslate(0, mCenterY);
        }
    }

    /**
     * 从左下角增大
     *
     * @return
     */
    public static Animation getScaleAnimationLeftBottom() {
        return new ScaleAnimationLeftBottom();
    }

    public static class ScaleAnimationRightBottom extends Animation {
        int mCenterX;
        int mCenterY;

        public ScaleAnimationRightBottom() {
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            //初始化中间坐标值
            mCenterX = width;
            mCenterY = height;
            setDuration(300);
            setFillAfter(true);
            setInterpolator(new LinearInterpolator());
        }

        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {
            final Matrix matrix = t.getMatrix();
            matrix.setScale(interpolatedTime, interpolatedTime);
            matrix.preTranslate(-mCenterX, -mCenterY);
            matrix.postTranslate(mCenterX, mCenterY);
        }
    }

    /**
     * 从右下角增大
     *
     * @return
     */
    public static Animation getScaleAnimationRightBottom() {
        return new ScaleAnimationRightBottom();
    }

    //
    //

    public static class ScaleAndRote3DAnimation extends Animation {
        int mCenterX;//记录View的中间坐标
        int mCenterY;
        Camera camera = new Camera();

        public ScaleAndRote3DAnimation() {
        }

        @Override
        public void initialize(int width, int height, int parentWidth,
                               int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            //初始化中间坐标值
            mCenterX = width / 2;
            mCenterY = height / 2;
            setDuration(500);
            setFillAfter(true);
            setInterpolator(new LinearInterpolator());
        }

        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {
            final Matrix matrix = t.getMatrix();
            camera.save();
            camera.translate(0.0f, 0.0f, (1300 - 1300.0f * interpolatedTime));
            camera.rotateY(360 * interpolatedTime);
            camera.getMatrix(matrix);
            matrix.preTranslate(-mCenterX, -mCenterY);
            matrix.postTranslate(mCenterX, mCenterY);
            camera.restore();
        }
    }

    /**
     * 3D旋转
     *
     * @return
     */
    public static Animation getScaleAndRote3DAnimation() {
        return new ScaleAndRote3DAnimation();
    }


    public static class ScaleAnimationTop extends Animation {
        int mCenterX;
        int mCenterY;

        public ScaleAnimationTop() {
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            //初始化中间坐标值
            mCenterX = width;
            mCenterY = height;
            setDuration(300);
            setFillAfter(true);
            setInterpolator(new LinearInterpolator());
        }

        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {
            final Matrix matrix = t.getMatrix();
            matrix.setScale(interpolatedTime, interpolatedTime);
            matrix.preTranslate(-mCenterX, -mCenterY);
            matrix.postTranslate(mCenterX, mCenterY);
        }
    }

    /**
     * 从上增大出现
     *
     * @return
     */
    public static Animation getScaleAnimationTop() {
        return new ScaleAnimationRightTop();
    }

}
