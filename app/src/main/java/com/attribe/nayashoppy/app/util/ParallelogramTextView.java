package com.attribe.nayashoppy.app.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Sabih Ahmed on 02-Aug-16.
 */
public class ParallelogramTextView extends TextView{

    private Paint mBorderPaint;
    private Paint mInnerPaint;

    public ParallelogramTextView(Context context) {
        super(context);
        init();

    }

    public ParallelogramTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ParallelogramTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBorderPaint = new Paint();
        mBorderPaint.setAntiAlias(true);
        mBorderPaint.setColor(Color.BLACK);
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setStrokeWidth(2);

        mInnerPaint = new Paint();
        mInnerPaint.setAntiAlias(true);
        mInnerPaint.setColor(Color.parseColor("#13a89e"));
        mInnerPaint.setStyle(Paint.Style.FILL);
        mInnerPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        path.moveTo(getWidth(),0);
        path.lineTo(getWidth()/2, 0);
        path.lineTo(0, getHeight());
        path.lineTo(getWidth()/2,getHeight());
        path.lineTo(getWidth(), 0);
        canvas.drawPath(path, mInnerPaint);
        canvas.drawPath(path, mBorderPaint);
    }
}
