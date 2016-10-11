package com.cornez.shadesii;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebViewFragment;


public class MyActivity extends Activity implements
        InformationFragment.OnItemSelectedListener,MyListFragment.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }
    public void onWebBtnClicked(int i){
        WebFragment wvf = new WebFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.ReservedSlot,wvf);
        transaction.commit();
        fm.executePendingTransactions();
        wvf.setWebSite(1);

    }
    public void onColorItemSelected(String link,int index) {

        //CHECK IF FRAGMENT2 EXISTS IN THIS LAYOUT
        InformationFragment fragment2 = (InformationFragment) getFragmentManager()
                .findFragmentById(R.id.fragment2);

        //A TWO PANE CONFIGURATION
        if (fragment2 != null && fragment2.isInLayout()) {
            fragment2.setText(link);
            DisplayFragment DisplayPic = new DisplayFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();


            transaction.replace(R.id.ReservedSlot,DisplayPic);
            transaction.commit();
            fm.executePendingTransactions();
            DisplayPic.setPic(index);
        }
        //A SINGLE-PANE CONFIGURATION -
        //  IF FRAGMENT 2 DOES NOT EXIST IN THIS LAYOUT, THEN ACTIVATE THE NEXT ACTIVITY
        else {
            Intent intent = new Intent (this, InformationActivity.class);
            intent.putExtra("Information", link);
            startActivity (intent);
        }
    }

}
