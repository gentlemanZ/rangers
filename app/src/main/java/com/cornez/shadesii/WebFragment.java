package com.cornez.shadesii;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebFragment extends Fragment {

    public WebFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web, container, false);
        WebView WebCharacter = (WebView) view.findViewById(R.id.WebCharacter);
        WebCharacter.setHorizontalScrollBarEnabled(false);
        WebCharacter.getSettings().setJavaScriptEnabled(true);
        WebCharacter.getSettings().setUseWideViewPort(true);
        WebCharacter.getSettings().setDomStorageEnabled(true);
        return view;

    }

    public void setWebSite(int pic) {
        WebView WebCharacter = (WebView) getView().findViewById(R.id.WebCharacter);
        WebCharacter.setHorizontalScrollBarEnabled(false);
        WebCharacter.getSettings().setJavaScriptEnabled(true);
        WebCharacter.getSettings().setUseWideViewPort(true);
        WebCharacter.getSettings().setDomStorageEnabled(true);
        WebCharacter.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl("http://www.baidu.com");
                return true;
            }
        });
        WebCharacter.loadUrl("http://www.baidu.com");

    }

}
