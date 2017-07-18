package developer.shivam.rateview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/*
 * Created by shivam on 18/7/17.
 */
public class AppRateView extends View {

    private Context mContext;

    private int[] faceDrawables = new int[5];

    public AppRateView(Context context) {
        super(context);
        init(context, null);
    }

    public AppRateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.mContext = context;
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
