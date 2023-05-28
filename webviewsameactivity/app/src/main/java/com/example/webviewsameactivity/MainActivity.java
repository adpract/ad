package com.example.webviewsameactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient()); // Required to open links in the same WebView

        EditText urlEditText = findViewById(R.id.url_edittext);
        Button loadButton = findViewById(R.id.load_button);
        TextView validationErrorTextView = findViewById(R.id.validation_error_textview);

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlEditText.getText().toString();
                if (Patterns.WEB_URL.matcher(url).matches()) {
                    validationErrorTextView.setVisibility(View.GONE);
                    webView.loadUrl(url);
                } else {
                    validationErrorTextView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}