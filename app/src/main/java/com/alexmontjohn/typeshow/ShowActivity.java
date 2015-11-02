package com.alexmontjohn.typeshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alexmontjohn.typeshow.R;

public class ShowActivity extends Activity {

    TextView mTextView;
    Button mButton;
    String mEnteredText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        mTextView = (TextView) findViewById(R.id.enteredText);
        mButton = (Button) findViewById(R.id.startOverButton);

        Intent intent = getIntent();
        mEnteredText = intent.getStringExtra("enteredText");

        if (mEnteredText.matches("")) {
            mEnteredText = "You didn\'t type anything.";
        } else {
            mTextView.setText(mEnteredText);
        }

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TypeActivity.class);
                startActivity(intent);
            }
        };
        mButton.setOnClickListener(listener);
    }
}
