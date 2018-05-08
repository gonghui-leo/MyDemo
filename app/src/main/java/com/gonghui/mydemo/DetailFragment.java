package com.gonghui.mydemo;

import android.animation.LayoutTransition;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    private TextView textView;
    private LinearLayout linearLayout;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        model.getSelected().observe(this, item -> {
            // Update the UI.
            textView.setText(item);
//            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
//            layoutParams.leftMargin = 300;
//            linearLayout.setLayoutParams(layoutParams);
//
            TextView textView = new TextView(getContext());
            textView.setText(item);
            linearLayout.addView(textView,0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
            layoutParams2.gravity = Gravity.CENTER;
            this.textView.setLayoutParams(layoutParams2);
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_master, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.textView);
        linearLayout = view.findViewById(R.id.linearLayout);
        LayoutTransition layoutTransition = linearLayout.getLayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGE_APPEARING);
        layoutTransition.setStagger(LayoutTransition.CHANGE_APPEARING ,800);
    }
}