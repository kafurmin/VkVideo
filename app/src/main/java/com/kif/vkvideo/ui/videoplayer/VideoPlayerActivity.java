package com.kif.vkvideo.ui.videoplayer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kif.vkvideo.R;
import com.kif.vkvideo.ui.base.BaseActivity;
import com.kif.vkvideo.ui.main.MainActivity;

import butterknife.BindView;
public class VideoPlayerActivity extends BaseActivity{

    public static int LAYOUT = R.layout.activity_fullscreen;

    @BindView(R.id.web_view)
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.VIDEO_PATH);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(message);
        webView.getSettings().setJavaScriptEnabled(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onResume() {
        super.onResume();
        hide();
    }

    @Override
    public int getLayout() {
        return LAYOUT;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void hide() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        webView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    @Override
    protected void onPause() {
        super.onPause();
        webView.onPause();
    }
}
