package org.mobile_development.marcellis.learnandroidbyandroid;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText editText;
    Button buttonSnackbar;
    TextView textView;
    Spinner spinner;
    String clickedItem;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = (EditText) findViewById(R.id.editTextSnackbar);
        buttonSnackbar = (Button) findViewById(R.id.buttonSnackbar);
        textView = (TextView) findViewById(R.id.textViewOutput);
        spinner = (Spinner) findViewById(R.id.spinnerSnackbar);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.snackbar_duration, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);


        buttonSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();

                Snackbar.make(v, message, i)
                        .setAction("Action", null).show();

                textView.setText("Snackbar.make(v," + message + ","+ clickedItem+" )setAction(\"Action\", null).show()");

            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        clickedItem = (parent.getItemAtPosition(position)).toString();

        switch (clickedItem) {
            case "Snackbar.LENGTH_INDEFINITE":
                i = Snackbar.LENGTH_INDEFINITE;
                break;
            case "Snackbar.LENGTH_LONG":
                i = Snackbar.LENGTH_LONG;
                break;
            case "Snackbar.LENGTH_SHORT":
                i = Snackbar.LENGTH_SHORT;
                break;

        }
        }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
