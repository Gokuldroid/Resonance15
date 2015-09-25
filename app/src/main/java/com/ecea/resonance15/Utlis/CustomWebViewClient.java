package com.ecea.resonance15.Utlis;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by goku on 22-09-2015.
 */
public class CustomWebViewClient extends WebViewClient {


    Context context;
    Intent dial = new Intent(Intent.ACTION_DIAL);
    Intent email = new Intent(Intent.ACTION_SENDTO);

    public CustomWebViewClient(Context context) {
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(url.contains("call"))
        {
            int index=url.lastIndexOf('/');
            String phno="tel:+91"+url.substring(index+1);
            phno=phno.trim();
            dial.setData(Uri.parse(phno));
            context.startActivity(dial);
            return true;

        }else if(url.contains("mail"))
        {
            int index=url.lastIndexOf('/');
            String emailstr=url.substring(index+1).trim();
            email.setData(Uri.parse("mailto:"));
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{emailstr});
            context.startActivity(Intent.createChooser(email, "Send mail ..."));
            return true;
        }
        else {
            Intent webview =new Intent(Intent.ACTION_VIEW,Uri.parse(url));
            webview.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(webview);
        }
        return true;
    }
}
