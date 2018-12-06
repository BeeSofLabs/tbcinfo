package com.beelabs.tbcinfo.util;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

/**
 * Created by arysuryawan on 1/22/18.
 */

public class FontUtil {
    public static final String TITILLIUM_WEB_BOLD = "fonts/TitilliumWeb-Bold.ttf";
    public static final String SFPRO_TEXT_BOLD = "fonts/sfpro/SF-Pro-Text-Bold.otf";
    public static final String SFPRO_TEXT_LIGHT = "fonts/sfpro/SF-Pro-Text-Light.otf";
    public static final String SFPRO_TEXT_REGULAR = "fonts/sfpro/SF-Pro-Text-Regular.otf";
    public static final String VOLTEROUNDED_BOLD = "fonts/VolteRounded-Bold.otf";
    public static final String GELPEN = "fonts/GelPen.ttf";
    public static final String GELPEN_LIGHT = "fonts/GelPenLight.ttf";
    public static final String BROWNHILL_SCRIPT = "fonts/Brownhill-Script.ttf";


    public static Typeface fontTypeface(Context context, String fontpath) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontpath);
        return typeface;
    }


    public static void fontFace(int resourceID, String fontPath, View view) {
        ((TextView) view.findViewById(resourceID)).setTypeface(FontUtil.fontTypeface(view.getContext(), fontPath));
    }

    public static void fontFace(int[] resourceIDs, String fontPath, View view) {
        for (int resourceID : resourceIDs) {
            fontFace(resourceID, fontPath, view);
        }
    }
}
