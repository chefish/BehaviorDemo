package com.fish.behaviordemo.collapsing;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fish.behaviordemo.R;
import com.fish.behaviordemo.util.Constant;

/**
 * 参考CoordinatorExamples/FlexibleSpaceExampleActivity
 */
public class CollapsImageOverlapActivity extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_overlap_activity);

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
            String s = Constant.getName(i);
            if (s == null) {
                s = "" + i;
            }
            tv.setText(s);
            tv.setTextSize(40);
            tv.setBackgroundColor(Color.argb(255,255,255,0));
            ll.addView(tv);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
