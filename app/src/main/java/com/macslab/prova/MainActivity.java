package com.macslab.prova;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ArrayList<HkElement> mHkElementList = new ArrayList<HkElement>();
    static final int PICK_NEW_ELEM = 0;
    private HkArrayAdapterItem adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // to display main activity
        // res/layout/activity_main.xml --> R.layout.activity_main

        /* create button */
        View.OnClickListener handler = new View.OnClickListener() {
            public void onClick(View v) {
                /* Starting a new Activity to insert new Elements */
                Intent openCreateActivity = new Intent(MainActivity.this, HkCreateActivity.class);
                startActivityForResult(openCreateActivity, PICK_NEW_ELEM);
            }
        };
        findViewById(R.id.AddButton).setOnClickListener(handler);
        /* end create button */

        adapter = new HkArrayAdapterItem(this, R.layout.hk_list_view_row, mHkElementList);
        ListView listView = (ListView) findViewById(R.id.hkList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (null != adapter) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (PICK_NEW_ELEM == requestCode) {
            if (RESULT_OK == resultCode) {
                HkElement passedElem = (HkElement)data.getParcelableExtra("newElement");
                mHkElementList.add(passedElem);

                System.out.println("Arraylist " + passedElem.getHkElemId() + " --> " + mHkElementList);
            } else {
                // RESULT_CANCELED == resultCode
                System.out.println("CANCELED!!");
            }
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

    /* Edited by Macs */

}
