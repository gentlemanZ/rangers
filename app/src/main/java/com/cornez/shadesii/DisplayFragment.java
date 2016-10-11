package com.cornez.shadesii;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {
    ArrayList<Drawable> drawables;

    public DisplayFragment() {
        // Required empty public constructor
    }
    private ImageView CharacterImage0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        CharacterImage0 = (ImageView) view.findViewById(R.id.imageView0);
        return view;

    }

    public void setPic(int pic) {
        getDrawables();
        CharacterImage0.setImageDrawable(drawables.get(pic+1));

    }

    public void getDrawables() {
        Field[] drawablesFields = com.cornez.shadesii.R.drawable.class.getFields();
        drawables = new ArrayList<>();

        String fieldName;
        for (Field field : drawablesFields) {
            try {
                fieldName = field.getName();
                Log.i("LOG_TAG", "com.cornez.shadesii.R.drawable." + fieldName);
                drawables.add(getResources().getDrawable(field.getInt(null)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
