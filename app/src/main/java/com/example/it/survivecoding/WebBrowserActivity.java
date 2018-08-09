package com.example.it.survivecoding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WebBrowserActivity extends AppCompatActivity {

    private WebView myWebView;
    private EditText mUrlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);

        //http://를 붙여야 검색가능
        myWebView = findViewById(R.id.web_view);
        mUrlEditText = findViewById(R.id.urlEdit);

        //웹에서 자바스크립트를 얻어옴
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //일반
//      myWebView.setWebViewClient(new WebViewClient());

        //기능 확장(앱 내에서 해당 url실행)
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                Toast.makeText(WebBrowserActivity.this, "로딩 완료", Toast.LENGTH_SHORT).show();
            }
        });
        //키보드 이벤트 검출
        mUrlEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    myWebView.loadUrl(mUrlEditText.getText().toString());

                    //키보드 내리기
                    InputMethodManager imm = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mUrlEditText.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });
    }

    public void Search(View view) {
        myWebView.loadUrl(mUrlEditText.getText().toString());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
