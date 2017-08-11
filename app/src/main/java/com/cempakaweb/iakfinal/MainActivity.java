package com.cempakaweb.iakfinal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    EditText inputName;
    RadioGroup radioGroup_1;
    RadioGroup radioGroup_2;
    RadioButton radioButton_1;
    RadioButton radioButton_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.start_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputName = (EditText) findViewById(R.id.input_name);
                String name = inputName.getText().toString();

                radioGroup_1 = (RadioGroup) findViewById(R.id.answer_1);
                int selectedId = radioGroup_1.getCheckedRadioButtonId();
                radioButton_1 = (RadioButton) findViewById(selectedId);
                String answer1 = radioButton_1.getText().toString();

                radioGroup_2 = (RadioGroup) findViewById(R.id.answer_2);
                int selectedId_2 = radioGroup_2.getCheckedRadioButtonId();
                radioButton_2 = (RadioButton) findViewById(selectedId_2);
                String answer2 = radioButton_2.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "input Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", name);
                    bundle.putString("answer1", answer1);
                    bundle.putString("answer2", answer2);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
