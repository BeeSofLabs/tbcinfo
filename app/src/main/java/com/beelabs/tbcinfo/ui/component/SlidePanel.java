package com.beelabs.tbcinfo.ui.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.beelabs.tbcinfo.R;


/**
 * Created by arysuryawan on 1/31/18.
 */

public class SlidePanel {

    public static View showBottomPanel(Context context, ViewGroup attachedRoot, int resourcePanelID) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View panelSlide = (View) inflater.inflate(resourcePanelID, attachedRoot, false); // (View) root.findViewById(R.id.panel_background_slide);

        attachedRoot.addView(panelSlide);


        ViewGroup panelContent = panelSlide.findViewById(R.id.panel_content);
        // buttons panel
        Animation bottomUp = AnimationUtils.loadAnimation(context, R.anim.slide_up);
        panelContent.startAnimation(bottomUp);

        panelSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                panelContent.setVisibility(View.GONE);
                attachedRoot.removeView(panelSlide);

            }
        });


        panelContent.setVisibility(View.VISIBLE);


        return panelSlide;

    }

    public static View showTopPanel(Context context, ViewGroup attachedRoot, int resourcePanelID, OnAttachedDataSlidePanel onAttachedDataSlidePanel) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup panelSlide = (ViewGroup) inflater.inflate(resourcePanelID, attachedRoot, false); // (View) root.findViewById(R.id.panel_background_slide);


        if (onAttachedDataSlidePanel != null) {
            onAttachedDataSlidePanel.onBindDataPanel(panelSlide);
        } else {
            attachedRoot.addView(panelSlide);
        }


        ViewGroup panelContent = panelSlide.findViewById(R.id.panel_content);
        // buttons panel
        Animation topDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);
        panelContent.startAnimation(topDown);


        panelContent.setVisibility(View.VISIBLE);

        return panelSlide;
    }

    public static View showPanel(Context context, ViewGroup container) {
        if (container.getVisibility() == View.GONE) {
            Animation topDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);
            container.startAnimation(topDown);

            container.setVisibility(View.VISIBLE);
        } else container.setVisibility(View.GONE);

        return container;
    }

    public static class OnAttachedDataSlidePanel {

        public void onBindDataPanel(ViewGroup panel) {

        }
    }
}
