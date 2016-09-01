package com.fish.behaviordemo.scroll;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
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

/**
 * http://blog.csdn.net/litefish/article/details/52314254
 * 开头的例子
 */
public class ScrollActivity extends AppCompatActivity {

    public static final String ENTERALWAYS="enterAlways";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_activity);

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


        LinearLayout ll= (LinearLayout) findViewById(R.id.linear);

        for (int i = 0; i < 30; i++) {
            TextView tv=new TextView(this);
            tv.setText("" + i);
            tv.setTextSize(40);
            ll.addView(tv);
        }

        boolean enterAlways=getIntent().getBooleanExtra(ScrollActivity.ENTERALWAYS,true);
        AppBarLayout.LayoutParams params= (AppBarLayout.LayoutParams) toolbar.getLayoutParams();

        if(!enterAlways){
            params.setScrollFlags(params.getScrollFlags()&~AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        }

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
}
