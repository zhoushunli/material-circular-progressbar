package com.example.administrator.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/12/30.
 */

public class ProgressView extends View {

    private Paint mPaint;
    private float start;
    private float sweep;
    private RectF rectF;

    public ProgressView(Context context) {
        this(context, null);
    }

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        rectF = new RectF(110, 110, 290, 290);
    }

    boolean flag = true;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        start +=4;
        if (flag){
            sweep +=5f;
        }else {
            sweep-=3;
            start+=2;
        }
        if (start>=360){
            start-=360;
        }
        if (sweep>=270){
            flag=false;
        }
        if (!flag&&sweep<=45){
            flag=true;
        }

        canvas.save();
        canvas.drawArc(rectF, start, sweep, false, mPaint);
        canvas.restore();
        invalidate();
    }
}
