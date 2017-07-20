package eu.thiscounts.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ResizableImageView extends ImageView {

    public static interface OnSizeChangedListener {

        void onSizeChanged(int width, int height);
    }

    private OnSizeChangedListener onSizeChangedListener = null;

    public ResizableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width * getDrawable().getIntrinsicHeight() / getDrawable().getIntrinsicWidth();
        setMeasuredDimension(width, height);
        if (onSizeChangedListener != null) {
            onSizeChangedListener.onSizeChanged(width, height);
        }
    }

    public void setOnSizeChangedListener(OnSizeChangedListener listener) {
        this.onSizeChangedListener = listener;
    }
}