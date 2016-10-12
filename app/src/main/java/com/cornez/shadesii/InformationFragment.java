package com.cornez.shadesii;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
public class InformationFragment extends Fragment {
    private Button btnWeb;
    private OnItemSelectedListener listener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.information_fragment, container, false);
        btnWeb = (Button) view.findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateWeb();
            }
        });
        return view;

    }

    public void setText (String item) {
        TextView view = (TextView) getView().findViewById(R.id.textView1);
        view.setMovementMethod(new ScrollingMovementMethod());
        view.setText(item);
    }

    public interface OnItemSelectedListener {
        //public void onColorItemSelected(String link,int i);
        public void onWebBtnClicked();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    public void updateWeb() {
        listener.onWebBtnClicked();
    }





}
