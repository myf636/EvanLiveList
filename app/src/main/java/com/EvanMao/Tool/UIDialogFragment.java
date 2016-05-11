package com.EvanMao.Tool;

import android.support.v4.app.DialogFragment;

/**
 * Created by Administrator on 2015/7/17.
 */
public class UIDialogFragment extends DialogFragment {

    public static interface IDoSomething {


        public void do_dialog1(UIDialogFragment view, Object pamW, Object pamL);

        public void do_dialog2(UIDialogFragment view, Object[] params);
    }

    private IDoSomething doSomethingListener = null;

    public void setDoSomethingListener(IDoSomething aListener) {
        doSomethingListener = aListener;
    }

    protected void doInternal1(Object pamW, Object pamL) {
        if (doSomethingListener != null) {
            doSomethingListener.do_dialog1(this, pamW, pamL);
        }
    }

    protected void doInternal2(Object[] params) {
        if (doSomethingListener != null) {
            doSomethingListener.do_dialog2(this, params);
        }
    }

}
