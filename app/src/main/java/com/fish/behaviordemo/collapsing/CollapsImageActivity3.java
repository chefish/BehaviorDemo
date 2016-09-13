package com.fish.behaviordemo.collapsing;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fish.behaviordemo.R;
import com.fish.behaviordemo.ToastUtil;

/**
 * 刚进去ImageView就占据了状态栏
 */
public class CollapsImageActivity3 extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    COLLASP_MODE currentMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_image_activity3);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
        currentMode = COLLASP_MODE.SCROLL_DEFAULT;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_collapsing, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        switch (currentMode) {
            case SCROLL_DEFAULT:
                menu.findItem(R.id.scroll).setChecked(true);
                break;
            case SCROLL_EXIT_COLLAPSE:
                menu.findItem(R.id.scroll_exit).setChecked(true);
                break;

        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.scroll_exit) {
            currentMode = COLLASP_MODE.SCROLL_EXIT_COLLAPSE;
            AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) collapsingToolbarLayout.getLayoutParams();
            params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
            collapsingToolbarLayout.setLayoutParams(params);
            ToastUtil.showToast(this, "scroll_exit_collapse");
            return true;

        } else if (id == R.id.scroll) {
            currentMode = COLLASP_MODE.SCROLL_DEFAULT;
            AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) collapsingToolbarLayout.getLayoutParams();
            params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
            collapsingToolbarLayout.setLayoutParams(params);
            ToastUtil.showToast(this, "scroll");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    static enum COLLASP_MODE {SCROLL_DEFAULT, SCROLL_EXIT_COLLAPSE}
}
