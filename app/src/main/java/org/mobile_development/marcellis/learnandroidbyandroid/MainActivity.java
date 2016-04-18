package org.mobile_development.marcellis.learnandroidbyandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editTextAction;
    private Button buttonSnackbar;
    private TextView textView;
    private Spinner spinner;
    private String clickedItem;
    private int duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initialize widgets
        editText = (EditText) findViewById(R.id.editTextSnackbar);
        editTextAction = (EditText) findViewById(R.id.editTextAction);
        buttonSnackbar = (Button) findViewById(R.id.buttonSnackbar);
        textView = (TextView) findViewById(R.id.textViewOutput);
        spinner = (Spinner) findViewById(R.id.spinnerSnackbar);

        // get selected item of spinner
        buttonSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickedItem = String.valueOf(spinner.getSelectedItem());

                switch (clickedItem) {
                    case "Snackbar.LENGTH_INDEFINITE":
                        duration = Snackbar.LENGTH_INDEFINITE;
                        break;
                    case "Snackbar.LENGTH_LONG":
                        duration = Snackbar.LENGTH_LONG;
                        break;
                    case "Snackbar.LENGTH_SHORT":
                        duration = Snackbar.LENGTH_SHORT;
                        break;
                }

                String message = editText.getText().toString();
                String action = editTextAction.getText().toString();

                Snackbar snackbar = Snackbar.make(v, message, duration);
                if (!action.equals("")) {
                    snackbar.setAction(action, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(
                                    MainActivity.this,
                                    "snackbar clicked",
                                    Toast.LENGTH_LONG).show();

                        }
                    });
                }
                snackbar.show();

                textView.setText("Snackbar snackbar =  Snackbar.make( View ,\"" + message + "\", " + clickedItem + " );");
                if (!action.equals("")) {
                    textView.append("\nsnackbar.setAction(\"" + action + "\",");

                    textView.append ("new View.OnClickListener() \n { @Override \n public void onClick (View v) { \n  // You can put actions here \n "+
                            "    //We have choosen to use a toast message" +
                            "    Toast.makeText("+
                            "MainActivity.this," +
                            " \"snackbar clicked\"," +
                            "Toast.LENGTH_LONG).show(); } }); ");

                }
                textView.append("\nsnackbar.show();");


            }
        });
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
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
