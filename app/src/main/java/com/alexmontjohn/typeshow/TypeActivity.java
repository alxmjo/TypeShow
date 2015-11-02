package com.alexmontjohn.typeshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TypeActivity extends Activity {

    private String typedString;
    public String isNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        final EditText field = (EditText) findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.saveButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typedString = field.getText().toString();
                startShow(typedString);
            }
        };
        button.setOnClickListener(listener);
    }

    private void startShow(String typedString) {
        Intent intent = new Intent(this, ShowActivity.class);
        intent.putExtra("enteredText", typedString);
        startActivity(intent);
    }
}
