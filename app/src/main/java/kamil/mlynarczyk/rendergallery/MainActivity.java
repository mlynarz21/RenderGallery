package kamil.mlynarczyk.rendergallery;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindDrawable(R.drawable.render1) Drawable render1;
    @BindDrawable(R.drawable.render2) Drawable render2;
    @BindDrawable(R.drawable.render3) Drawable render3;
    @BindDrawable(R.drawable.render4) Drawable render4;
    @BindDrawable(R.drawable.render5) Drawable render5;
    @BindDrawable(R.drawable.render6) Drawable render6;
    @BindDrawable(R.drawable.render7) Drawable render7;
    @BindDrawable(R.drawable.render8) Drawable render8;
    @BindDrawable(R.drawable.render9) Drawable render9;
    @BindDrawable(R.drawable.render10) Drawable render10;
    @BindDrawable(R.drawable.render11) Drawable render11;
    @BindDrawable(R.drawable.render12) Drawable render12;
    @BindDrawable(R.drawable.render13) Drawable render13;
    @BindDrawable(R.drawable.render14) Drawable render14;
    @BindDrawable(R.drawable.render15) Drawable render15;
    @BindDrawable(R.drawable.render16) Drawable render16;

    private ArrayList<Drawable> renderList = new ArrayList<>();
    private RenderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        prepareRenderData();
        setRecyclerView();
    }

    private void prepareRenderData() {
        renderList.add(render1);
        renderList.add(render2);
        renderList.add(render3);
        renderList.add(render4);
        renderList.add(render5);
        renderList.add(render6);
        renderList.add(render7);
        renderList.add(render8);
        renderList.add(render9);
        renderList.add(render10);
        renderList.add(render11);
        renderList.add(render12);
        renderList.add(render13);
        renderList.add(render14);
        renderList.add(render15);
        renderList.add(render16);
    }

    private void setRecyclerView() {
        mAdapter = new RenderAdapter(renderList, MainActivity.this);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
