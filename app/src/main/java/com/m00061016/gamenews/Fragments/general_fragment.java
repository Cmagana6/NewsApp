

package com.m00061016.gamenews.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m00061016.gamenews.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class general_fragment extends Fragment {


    public general_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_general_fragment, container, false);
    }

}
