package com.example.inventorymvp.ui.dependency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventorymvp.R;

/**
 * Created by usuario on 23/11/17.
 */

public class DetailDependency extends Fragment{
    public static final String TAG = "detaildependency";

    public static Fragment newInstance(Bundle arguments) {
        DetailDependency detailDependency = new DetailDependency();
        if(arguments != null){
            detailDependency.setArguments(arguments);
        }
        return detailDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detaildependency, container, false);
        return rootView;
    }
}
