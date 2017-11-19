package kamil.mlynarczyk.rendergallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

import java.util.List;

import butterknife.ButterKnife;
import kamil.mlynarczyk.rendergallery.LoopView.LoopView;
import kamil.mlynarczyk.rendergallery.LoopView.LoopViewAdapter;

public class CircularActivity extends AppCompatActivity {
    List<Drawable> renderImageList;
    LoopView loopView;
    RenderProvider renderProvider;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postponeEnterTransition();
        setContentView(R.layout.activity_circular);
        ButterKnife.bind(this);
        initializePager();
    }

    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        postponeEnterTransition();
    }

    private void initializePager() {
        renderProvider = new RenderProvider(CircularActivity.this);
        this.renderImageList = renderProvider.getRenderList();
        this.loopView.setAdapter(new LoopViewAdapter(this, getLayoutInflater(), this.renderImageList));
        this.loopView.setCurrentItem(getIntent().getExtras().getInt("Image") + 1);
    }

    public void scheduleStartPostponedTransition(final View sharedElement) {
        sharedElement.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                sharedElement.getViewTreeObserver().removeOnPreDrawListener(this);
                CircularActivity.this.startPostponedEnterTransition();
                return true;
            }
        });
    }
}
