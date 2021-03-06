package com.gz.rentapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListView;

/**
 * @Package com.qianfeng.gz1411project.myview
 * @作 用:
 * @创 建 人: wuzhenyang
 * @日 期: 2015/3/2
 * @修 改 人:
 * @日 期:
 */
public class MyGridView extends GridView{
    public MyGridView(Context context) {
        super(context);
    }



    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
