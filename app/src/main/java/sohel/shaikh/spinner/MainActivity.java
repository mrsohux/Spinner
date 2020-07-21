package sohel.shaikh.spinner;

import androidx.appcompat.app.AppCompatActivity;      /// support library action bar features.

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;                                 ///display the text to the user
    EditText editText;                               ///editable
    Spinner spinner;                                ///Spinner provides a quick way to select one value from a set of values
    static String string,string1;                   ////getting a string as static
    RadioButton radioButton,radioButton1;           /////Radio Button is a two-states button that can be either checked or unchecked
    RadioGroup radioGroup;                           ////Radio Group is used to group one or more radio buttons
    CheckBox checkBox;                               ////choice between one of two possible checked unchecked
    @Override
    protected void onCreate(Bundle savedInstanceState) {         // savedInstat states reference to a Bundle object
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                      //r.id allocates resources
        spinner=findViewById(R.id.spinner);
        textView=findViewById(R.id.textView);
        editText=findViewById(R.id.editTextTextPersonName);
        radioButton=findViewById(R.id.radioButton);
        radioButton1=findViewById(R.id.radioButton2);
        radioGroup=findViewById(R.id.radio_may);
        checkBox=findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {            //setOnCheckedChangeListener is a method in android basically used with checkboxes, radio button
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked())
                {
                    editText.setVisibility(View.INVISIBLE);         //setVisible ( ) controls whether a Componenent dispaly on screen
                    radioGroup.setVisibility(View.INVISIBLE);
                    spinner.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.INVISIBLE);
                }else
                {
                    editText.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    spinner.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                }

            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {   ////setOnItemSelectedListener () method on spinner to get selected spinner item value dynamically from string.xml
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s= editText.getText().toString().trim();
                string= String.valueOf(adapterView.getItemAtPosition(i));
                string=string + "\n Welcome " +s +string1;
                textView.setText(string);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {   ///AdapterView is responsible for displaying the data  bridge between components

            }
        });

    }

    public void onRadioButtonClicked(View view) {         ////Radio Button is a two-states button that can be either checked or unchecked
        boolean status_checked=((RadioButton)view).isChecked();
        switch (view.getId())
        {
            case R.id.radioButton:
                if(status_checked)
                {
                    string1= "\n"+"Gender "+radioButton.getText().toString().trim();
                }

                break;
            case R.id.radioButton2:
                if(status_checked) {
                    string1 = "\n"+"Gender " + radioButton1.getText().toString().trim() + "\n";
                }
                break;
        }

    }
}