package com.gm.a80066158.hanzitopinyintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gm.a80066158.hanzitopinyin.PinYin;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText originalDataEditText = null;
    private Button okButton = null;
    private TextView resultDataTextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initContent();
    }

    private void initContent() {
        Log.i(TAG, "<initContent> start");
        originalDataEditText = (EditText) findViewById(R.id.data);
        okButton = (Button) findViewById(R.id.okButton);
        resultDataTextView = (TextView) findViewById(R.id.info);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOkButtonClick();
            }
        });
    }

    private void onOkButtonClick() {
        Log.i(TAG, "<onOkButtonClick> start");

        final String originalData = originalDataEditText.getText().toString();
        String result = PinYin.getPinYin(originalData);
        resultDataTextView.setText(result);
    }
}
