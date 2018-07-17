package uas.wendi.wahyu.restorumputhijau;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("SetJavaScriptEnabled") public class MainActivity extends Activity {
	private static String url = "http://192.168.43.28/pemesanan";
	public static final String TAG = MainActivity.class.getSimpleName();
	WebView view;
	WebSettings setting;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        view = (WebView)findViewById(R.id.web_view);
        setting = (WebSettings)view.getSettings();
        
        view.setWebViewClient(new WebViewClient());
        view.setWebChromeClient(new WebChromeClient());
        view.setInitialScale(getRequestedOrientation());
        
        setting.setUseWideViewPort(true);
        setting.setJavaScriptEnabled(true);
        view.loadUrl(url);
        
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		view = (WebView)findViewById(R.id.web_view);
		if((keyCode == KeyEvent.KEYCODE_BACK) && view.canGoBack()) {
			view.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	public class WebChromeClientActivity extends WebChromeClient {
		
		@Override
		public boolean onConsoleMessage(ConsoleMessage cm) {
			// TODO Auto-generated method stub
			Log.v(TAG, cm.message() + " log from line "+cm.lineNumber()+ " of " + cm.sourceId());
			return true;
		}
	}
	
	public class WebViewClientActivity extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			view.loadUrl(url);
			return true;
		}
    }
}
