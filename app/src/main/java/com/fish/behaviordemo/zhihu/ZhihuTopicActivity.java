package com.fish.behaviordemo.zhihu;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fish.behaviordemo.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 仿知乎专题页
 */
public class ZhihuTopicActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private AppBarLayout appbar;
    private Button attention;
    private CircleImageView image;
    private TextView attentionNumTv;
    private TextView detailTv;

    private int mMaxScrollSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zh_topic);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        attention= (Button) findViewById(R.id.attention);
        image= (CircleImageView) findViewById(R.id.profile_image);
        attentionNumTv= (TextView) findViewById(R.id.attention_num);
        detailTv= (TextView) findViewById(R.id.detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        LinearLayout ll = (LinearLayout) findViewById(R.id.linear);

        for (int i = 0; i < 30; i++) {
            TextView tv = new TextView(this);
            tv.setText("" + i);
            tv.setTextSize(40);
            ll.addView(tv);
        }

        appbar = (AppBarLayout) findViewById(R.id.appbar);
        appbar.addOnOffsetChangedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (mMaxScrollSize == 0){
            mMaxScrollSize = appBarLayout.getTotalScrollRange();
        }
        int currentScrollPercentage = (Math.abs(verticalOffset)) * 100
                / mMaxScrollSize;
        float alpha=(float) (1 - currentScrollPercentage/100.0);
        attention.setAlpha(alpha);
        image.setAlpha(alpha);
        attentionNumTv.setAlpha(alpha);
        detailTv.setAlpha(alpha);

    }
}
