package com.EvanMao.Tool;


import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2015/7/2.
 */
public class UIFragmentControl extends Fragment {

    public static interface IDoSomething {


        public void do1(UIFragmentControl view, Object pamW, Object pamL);

        public void do2(UIFragmentControl view, Object pamW, Object pamL);

        public void do3(UIFragmentControl view, Object pamW, Object pamL);

        public void do4(UIFragmentControl view, Object[] params, Object pamL);

        public void do5(UIFragmentControl view, int[] params);

        public void do6(UIFragmentControl view, Object pamW, Object pamL);
    }

    private IDoSomething doSomethingListener = null;

    public void setDoSomethingListener(IDoSomething aListener) {
        doSomethingListener = aListener;
    }

    protected void doInternal1(Object pamW, Object pamL) {
        if (doSomethingListener != null) {
            doSomethingListener.do1(this, pamW, pamL);
        }
    }

    protected void doInternal2(Object pamW, Object pamL) {
        if (doSomethingListener != null) {
            doSomethingListener.do2(this, pamW, pamL);
        }
    }

    protected void doInternal3(Object pamW, Object pamL) {
        if (doSomethingListener != null) {
            doSomethingListener.do3(this, pamW, pamL);
        }
    }

    protected void doInternal4(Object[] params, Object pamL) {
        if (doSomethingListener != null) {
            doSomethingListener.do4(this, params, pamL);
        }
    }

    protected void doInternal5(int[] params) {
        if (doSomethingListener != null) {
            doSomethingListener.do5(this, params);
        }
    }

    protected void doInternal6(Object pamW, Object pamL) {
        if (doSomethingListener != null) {
            doSomethingListener.do6(this, pamW, pamL);
        }
    }
}
