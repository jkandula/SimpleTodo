package com.codepath.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends Activity {

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String editText = getIntent().getStringExtra("edittext");
        this.position = getIntent().getIntExtra("position", 0);
        EditText et = (EditText) findViewById(R.id.editText);
        et.setText(editText);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSave(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);

        Intent returnIntent = new Intent();
        returnIntent.putExtra("edittext", editText.getText().toString());
        returnIntent.putExtra("position", position);
        setResult(RESULT_OK, returnIntent);

        this.finish();
    }
}
