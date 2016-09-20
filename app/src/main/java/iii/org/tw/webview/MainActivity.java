package iii.org.tw.webview;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mesg;
    private WebView webView;
    private EditText inputName;
    private UIHandler handler;
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
        handler = new UIHandler();
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
        webView.addJavascriptInterface(new MyJSInterface() , "Abner");
        webView.loadUrl("file:///android_asset/Abner.html");
    }

    public class MyJSInterface {
        @JavascriptInterface
        public String showMesg(String webMesg) {
            Log.d("Abner",webMesg);
            Toast.makeText(MainActivity.this,webMesg,Toast.LENGTH_SHORT).show();
            Message msg = new Message();
            Bundle data = new Bundle();
            data.putString("mesg",webMesg);
            msg.setData(data);
            handler.sendMessage(msg);
            return "";
        }
        @JavascriptInterface
        public void gotoPage2() {
            Intent it = new Intent(MainActivity.this,Page2Activity.class);
            startActivity(it);
        }
    }

    private class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mesg.setText(msg.getData().getString("mesg"));
        }
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
