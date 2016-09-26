package com.fish.behaviordemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;

import com.fish.behaviordemo.anchor.AnchorActivity;
import com.fish.behaviordemo.appbar.AppbarActivity;
import com.fish.behaviordemo.collapsing.CollapsFitSystemActivity;
import com.fish.behaviordemo.collapsing.CollapsImageActivity3;
import com.fish.behaviordemo.collapsing.CollapsImageActivity4;
import com.fish.behaviordemo.collapsing.CollapsImageActivity4_1;
import com.fish.behaviordemo.collapsing.CollapsImageOverlapActivity;
import com.fish.behaviordemo.collapsing.CollapsingActivity;
import com.fish.behaviordemo.collapsing.CollapsImageActivity;
import com.fish.behaviordemo.collapsing.CollapsImageActivity2;
import com.fish.behaviordemo.fab.FabSnackActivity;
import com.fish.behaviordemo.scroll.ScrollActivity;
import com.fish.behaviordemo.toolbartab.ToolbarTabActivity;
import com.fish.behaviordemo.zhihu.ZhihuCplusActivity;

public class MainActivity extends AppCompatActivity {

    AppBarLayout appBar;
    CheckBox enterAlwaysCb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appBar = (AppBarLayout) findViewById(R.id.barLayout);

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


        enterAlwaysCb = (CheckBox) findViewById(R.id.enterAlways);

        findViewById(R.id.fab_snack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FabSnackActivity.class);
                startActivity(intent);
            }
        });

        addClick(R.id.fab_snack, FabSnackActivity.class);
        findViewById(R.id.scroll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ScrollActivity.class);
                intent.putExtra(ScrollActivity.ENTERALWAYS, enterAlwaysCb.isChecked());
                startActivity(intent);
            }
        });
        addClick(R.id.toolbar_tab, ToolbarTabActivity.class);
        addClick(R.id.appbar, AppbarActivity.class);
        addClick(R.id.collapsing, CollapsingActivity.class);
        addClick(R.id.collapsing_image1, CollapsImageActivity.class);
        addClick(R.id.collapsing_image2, CollapsImageActivity2.class);
        addClick(R.id.collapsing_image3, CollapsImageActivity3.class);
        addClick(R.id.collapsing_fit_system, CollapsFitSystemActivity.class);

        addClick(R.id.collapsing_image4, CollapsImageActivity4.class);
        addClick(R.id.collapsing_image4_1, CollapsImageActivity4_1.class);
        addClick(R.id.collapsing_overlap, CollapsImageOverlapActivity.class);

        addClick(R.id.anchor, AnchorActivity.class);
        addClick(R.id.zhihuplus, ZhihuCplusActivity.class);


    }

    void addClick(int id, final Class clazz) {
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, clazz);
                startActivity(intent);
            }
        });
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
