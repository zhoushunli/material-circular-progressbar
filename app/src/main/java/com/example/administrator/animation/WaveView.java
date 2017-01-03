package com.example.administrator.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/12/30.
 */

public class WaveView extends View {

    private Paint mPaint;
    private Path mPath;
    private int height;
    private int width;
    private float y;

    public WaveView(Context context) {
        this(context,null);
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(getResources().getColor(R.color.colorPrimary));

        mPath=new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        height = getMeasuredHeight();
        width = getMeasuredWidth();
        y=height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        y-=1;
        if (y<=1){
            y=height;
        }
        mPath.reset();
        mPath.moveTo(0,height);
        mPath.lineTo(0,y);
        mPath.quadTo(width/2, (float) (y+200*Math.sin(y*Math.PI*2/height)),width,y);
        mPath.lineTo(width,height);
        mPath.close();
        canvas.drawPath(mPath,mPaint);
        invalidate();
    }
}
