package com.ecea.resonance15.Utlis;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by goku on 21-08-2015.
 * <com.vision.ecea.org.Utlis.CustomFontTextView
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:text="@string/hello_world"
 android:textColor="#000"
 android:textSize="25dp"
 customAttrs:customFont="nexa_b" />
 */
public class CustomFontTextView extends TextView {

    private static final String sScheme =
            "http://schemas.android.com/apk/res-auto";
    private static final String sAttribute = "customFont";
    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (isInEditMode()) {
            return;
        } else {
            final String fontName = attrs.getAttributeValue(sScheme, sAttribute);

            if (fontName == null) {
                throw new IllegalArgumentException("You must provide \"" + sAttribute + "\" for your text view");
            } else {
                final Typeface customTypeface = Typeface.createFromAsset(context.getAssets(), fontName);
                setTypeface(customTypeface);
            }
        }
    }
}