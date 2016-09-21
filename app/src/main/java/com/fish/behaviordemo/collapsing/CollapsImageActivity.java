package com.fish.behaviordemo.collapsing;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fish.behaviordemo.R;


public class CollapsImageActivity extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    COLLASP_MODE currentMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_image_activity);

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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    static enum COLLASP_MODE {SCROLL_DEFAULT, SCROLL_EXIT_COLLAPSE}
}
