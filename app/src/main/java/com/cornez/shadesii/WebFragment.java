package com.cornez.shadesii;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebFragment extends Fragment {

    List<String> wikiPages;

    public WebFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web, container, false);
        wikiPages = new ArrayList<String>(Arrays.asList(DummyData.wiki_page));
        //WebView WebCharacter = (WebView) view.findViewById(R.id.WebCharacter);
//        WebCharacter.setHorizontalScrollBarEnabled(false);
//        WebCharacter.getSettings().setJavaScriptEnabled(true);
//        WebCharacter.getSettings().setUseWideViewPort(true);
//        WebCharacter.getSettings().setDomStorageEnabled(true);
        return view;

    }

    public void setWebSite(int pic) {
        final int index = pic;
        WebView WebCharacter = (WebView) getView().findViewById(R.id.WebCharacter);
        WebCharacter.setHorizontalScrollBarEnabled(false);
        WebCharacter.getSettings().setJavaScriptEnabled(true);
        WebCharacter.getSettings().setUseWideViewPort(true);
        WebCharacter.getSettings().setDomStorageEnabled(true);
        WebCharacter.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url){
//                view.loadUrl(wikiPages.get(index));
//                return true;
//            }
        });
        WebCharacter.loadUrl(wikiPages.get(index));

    }

}
