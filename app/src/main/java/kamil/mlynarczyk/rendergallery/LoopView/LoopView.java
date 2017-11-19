package kamil.mlynarczyk.rendergallery.LoopView;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by mlyna on 19.11.2017.
 */

public class LoopView extends ViewPager {
    public LoopView(Context context) {
        super(context);
    }

    public LoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);
        setCurrentItem(1);
        addOnPageChangeListener(new LoopViewChangeListener(this));
    }
}
