package cn.levey.bannerlib.indicator.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import cn.levey.bannerlib.indicator.animation.data.Value;
import cn.levey.bannerlib.indicator.animation.data.type.ThinWormAnimationValue;
import cn.levey.bannerlib.indicator.draw.data.IndicatorConfig;
import cn.levey.bannerlib.indicator.draw.data.Orientation;

public class ThinWormDrawer extends WormDrawer {

    public ThinWormDrawer(@NonNull Paint paint, @NonNull IndicatorConfig indicatorConfig) {
        super(paint, indicatorConfig);
    }

    public void draw(
            @NonNull Canvas canvas,
            @NonNull Value value,
            int coordinateX,
            int coordinateY) {

        if (!(value instanceof ThinWormAnimationValue)) {
            return;
        }

        ThinWormAnimationValue v = (ThinWormAnimationValue) value;
        int rectStart = v.getRectStart();
        int rectEnd = v.getRectEnd();
        int height = v.getHeight() / 2;

        int radius = indicatorConfig.getRadius();
        int unselectedColor = indicatorConfig.getUnselectedColor();
        int selectedColor = indicatorConfig.getSelectedColor();

        if (indicatorConfig.getOrientation() == Orientation.HORIZONTAL) {
            rect.left = rectStart;
            rect.right = rectEnd;
            rect.top = coordinateY - height;
            rect.bottom = coordinateY + height;

        } else {
            rect.left = coordinateX - height;
            rect.right = coordinateX + height;
            rect.top = rectStart;
            rect.bottom = rectEnd;
        }

        paint.setColor(unselectedColor);
        canvas.drawCircle(coordinateX, coordinateY, radius, paint);

        paint.setColor(selectedColor);
        canvas.drawRoundRect(rect, radius, radius, paint);
    }
}
