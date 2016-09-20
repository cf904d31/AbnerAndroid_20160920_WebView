package iii.org.tw.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Page2Activity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        webView = (WebView) findViewById(R.id.page2_WebView);
        initWebview();
    }

    private void initWebview() {
        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.loadUrl("file:///android_asset/Page2.html");
    }
}
