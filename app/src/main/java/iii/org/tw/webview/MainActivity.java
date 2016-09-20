package iii.org.tw.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mesg;
    private WebView webView;
    private EditText inputName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        webView = new WebView(this);
//        webView.loadUrl("http://www.iii.org.tw");
//        setContentView(webView);

        mesg = (TextView) findViewById(R.id.mesg);
        webView = (WebView) findViewById(R.id.webView);
        inputName = (EditText) findViewById(R.id.inputName);
        initWebview();

    }

    private void initWebview() {
        //webView.loadUrl("http://www.iii.org.tw");


        //webView.loadUrl("file:///android_asset/Abner.html");


//        String data = "<html>\n" +
//                "<body>\n" +
//                "<h1>Hello Abner Company</h1>\n" +
//                "Hello Good Morning!\n" +
//                "</body>\n" +
//                "</html>";
//        webView.loadData(data,null,null);


//        WebViewClient client = new WebViewClient();
//        webView.setWebViewClient(client);
//        webView.loadUrl("http://www.iii.org.tw");

        WebViewClient client = new WebViewClient();

        webView.setWebViewClient(client);
        //-----設定javascript可以在WebView中被使用
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //-----
        webView.loadUrl("file:///android_asset/Abner.html");
    }

    public void b1(View v) {
        //goPre();
        //-----
        String name = inputName.getText().toString();
        webView.loadUrl("javascript:test2('" + name +"')");
        //-----
    }

    public void b2(View v) {
        //goNext();
        //-----
        int x = 13,  y = 4;
        webView.loadUrl("javascript:test3(" + x + "," + y +")");
        //-----
    }

    public void b3(View v) {
        reLoad();
    }

    private void goPre() {
        webView.goBack();
    }

    private void goNext() {
        webView.goForward();
    }

    private void reLoad() {
        webView.reload();
    }
}
