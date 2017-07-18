package developer.shivam.rateview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/*
 * Created by shivam on 18/7/17.
 */
public class AppRateView extends View {

    private int[] faceDrawables = new int[5];

    int cornerRadius = 0;

    int width = 0;
    int minWidth = 0;

    int height = 0;
    int minHeight = 0;

    private RectF viewDimension;

    private int color = Color.BLUE;
    private Paint paint;

    public AppRateView(Context context) {
        super(context);
        init(context, null);
    }

    public AppRateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        minWidth = (int) getResources().getDimension(R.dimen.view_minimum_width);
        minHeight = (int) getResources().getDimension(R.dimen.view_minimum_height);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);

        viewDimension = new RectF();
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // If {@widthMode} is MeasureSpec.EXACTLY the set view's width
        // to specified width. This mean user has explicitly defined width
        // value.
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            width = MeasureSpec.getSize(widthMeasureSpec);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(minWidth, MeasureSpec.getSize(widthMeasureSpec));
        } else {
            width = minWidth;
        }

        // If {@heightMode} is MeasureSpec.EXACTLY then set view's height
        // to specified height. Else height should be 25% of view's width.
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (heightMode == MeasureSpec.EXACTLY) {
            height = MeasureSpec.getSize(heightMeasureSpec);
        } else {
            int calculatedHeight = 25 * width / 100;
            height = Math.min(minHeight, calculatedHeight);
        }

        cornerRadius = height / 2;

        if (width > 0 && height > 0) {
            setMeasuredDimension(width, height);
            viewDimension.set(0, 0, width, height);
        }

    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRoundRect(viewDimension, cornerRadius, cornerRadius, paint);
    }
}
