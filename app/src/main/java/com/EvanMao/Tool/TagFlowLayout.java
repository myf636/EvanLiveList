package com.EvanMao.Tool;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


import com.EvanMao.LiveList.R;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhy on 15/9/10.
 */
public class TagFlowLayout extends FlowLayout implements TagAdapter.OnDataChangedListener {
    private TagAdapter mTagAdapter;
    private boolean mSupportMulSelected = true;
    private int mSelectedMax = -1;//-1为不限制数量
    private static final String TAG = "TagFlowLayout";
    private MotionEvent mMotionEvent;

    private Set<Integer> mSelectedView = new HashSet<Integer>();


    public TagFlowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TagFlowLayout);
        mSupportMulSelected = ta.getBoolean(R.styleable.TagFlowLayout_multi_suppout, true);
        mSelectedMax = ta.getInt(R.styleable.TagFlowLayout_max_select, -1);
        ta.recycle();

        if (mSupportMulSelected) {
            setClickable(true);
        }
    }

    public TagFlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagFlowLayout(Context context) {
        this(context, null);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int cCount = getChildCount();

        for (int i = 0; i < cCount; i++) {
            TagView tagView = (TagView) getChildAt(i);
            if (tagView.getVisibility() == View.GONE) continue;
            if (tagView.getTagView().getVisibility() == View.GONE) {
                tagView.setVisibility(View.GONE);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public interface OnSelectListener {
        void onSelected(Set<Integer> selectPosSet);
    }

    private OnSelectListener mOnSelectListener;

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        mOnSelectListener = onSelectListener;
        if (mOnSelectListener != null) setClickable(true);
    }

    public interface OnTagClickListener {
        boolean onTagClick(View view, int position, FlowLayout parent);
    }

    private OnTagClickListener mOnTagClickListener;


    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        mOnTagClickListener = onTagClickListener;
        if (onTagClickListener != null) setClickable(true);
    }


    public void setAdapter(TagAdapter adapter) {
        if (mTagAdapter == adapter)
            return;
        mTagAdapter = adapter;
        mTagAdapter.setOnDataChangedListener(this);
        changeAdapter();

    }

    private void changeAdapter() {
        removeAllViews();
        TagAdapter adapter = mTagAdapter;
        TagView tagViewContainer = null;

        for (int i = 0; i < adapter.getCount(); i++) {
            View tagView = adapter.getView(this, i, adapter.getItem(i));
            tagViewContainer = new TagView(getContext());
            MarginLayoutParams clp = (MarginLayoutParams) tagView.getLayoutParams();
            MarginLayoutParams lp = new MarginLayoutParams(clp);
            lp.width = LayoutParams.WRAP_CONTENT;
            lp.height = LayoutParams.WRAP_CONTENT;
            lp.topMargin = clp.topMargin;
            lp.bottomMargin = clp.bottomMargin;
            lp.leftMargin = clp.leftMargin;
            lp.rightMargin = clp.rightMargin;
            tagView.setDuplicateParentStateEnabled(true);
            tagViewContainer.setLayoutParams(lp);
            tagViewContainer.addView(tagView);
            addView(tagViewContainer);
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            mMotionEvent = MotionEvent.obtain(event);
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean performClick() {
        if (mMotionEvent == null) return super.performClick();

        int x = (int) mMotionEvent.getX();
        int y = (int) mMotionEvent.getY();
        mMotionEvent = null;

        TagView child = findChild(x, y);
        int pos = findPosByView(child);
        if (child != null) {
            doSelect(child, pos);
            if (mOnTagClickListener != null) {
                return mOnTagClickListener.onTagClick(child.getTagView(), pos, this);
            }
        }
        return super.performClick();
    }


    public void setMaxSelectCount(int count) {
        if (mSelectedView.size() > count) {
            Log.w(TAG, "you has already select more than " + count + " views , so it will be clear .");
            mSelectedView.clear();
        }
        mSelectedMax = count;
    }

    public Set<Integer> getSelectViewPos() {
        return new HashSet<Integer>(mSelectedView);
    }

    private TagView old_child = null;
    private int old_position = -1;

    private void doSelect(TagView child, int position) {
        if (mSupportMulSelected) {
            if (!child.isChecked()) {
                if (mSelectedMax > 0 && mSelectedView.size() >= mSelectedMax) {//myf636
                    old_child.setChecked(false);
                    mSelectedView.remove(old_position);
                    child.setChecked(true);
                    mSelectedView.add(position);
                    old_child = child;
                    old_position = position;
                    return;
                }
                old_child = child;
                old_position = position;
                child.setChecked(true);
                mSelectedView.add(position);
            } else {
                child.setChecked(false);
                mSelectedView.remove(position);
            }
            if (mOnSelectListener != null) {
                mOnSelectListener.onSelected(new HashSet<Integer>(mSelectedView));
            }
        }
    }

    private static final String KEY_CHOOSE_POS = "key_choose_pos";
    private static final String KEY_DEFAULT = "key_default";


    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_DEFAULT, super.onSaveInstanceState());

        String selectPos = "";
        if (mSelectedView.size() > 0) {
            for (int key : mSelectedView) {
                selectPos += key + "|";
            }
            selectPos = selectPos.substring(0, selectPos.length() - 1);
        }
        bundle.putString(KEY_CHOOSE_POS, selectPos);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            String mSelectPos = bundle.getString(KEY_CHOOSE_POS);
            if (!TextUtils.isEmpty(mSelectPos)) {
                String[] split = mSelectPos.split("\\|");
                for (String pos : split) {
                    int index = Integer.parseInt(pos);
                    mSelectedView.add(index);
                    old_position = index;
                    TagView tagView = (TagView) getChildAt(index);
                    old_child = tagView;
                    tagView.setChecked(true);
                }

            }
            super.onRestoreInstanceState(bundle.getParcelable(KEY_DEFAULT));
            return;
        }
        super.onRestoreInstanceState(state);
    }

    private int findPosByView(View child) {
        final int cCount = getChildCount();
        for (int i = 0; i < cCount; i++) {
            View v = getChildAt(i);
            if (v == child) return i;
        }
        return -1;
    }

    private TagView findChild(int x, int y) {
        final int cCount = getChildCount();
        for (int i = 0; i < cCount; i++) {
            TagView v = (TagView) getChildAt(i);
            if (v.getVisibility() == View.GONE) continue;
            Rect outRect = new Rect();
            v.getHitRect(outRect);
            if (outRect.contains(x, y)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public void onChanged() {
        changeAdapter();
    }


}
