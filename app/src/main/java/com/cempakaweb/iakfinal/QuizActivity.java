package com.cempakaweb.iakfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends BaseActivity {
    int answer = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Bundle bundle = getIntent().getExtras();
        String player_name = bundle.getString("name");
        String answer1 = bundle.getString("answer1");
        String answer2 = bundle.getString("answer2");
        resultTest(player_name,answer1,answer2);
        Button expl = (Button) findViewById(R.id.expl_btn);
        expl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this,ExplanationActivity.class);
                startActivity(intent);
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

    private void resultTest(String player_name, String answer1, String answer2)
    {

        String a1 = new String("A. Amfibi");
        String a2 = new String("B. Everest");
        if(answer1.equals( a1) ){
            answer = answer + 10;
        }
        if(answer2.equals(a2)  ){
            answer = answer + 10;
        }
        TextView player = (TextView) findViewById(R.id.player_name);
        TextView score = (TextView) findViewById(R.id.score);
        if(answer > 0){
            player.setText("Selamat : "+player_name);
        }else{
            player.setText("Maaf : "+player_name + "\nAnda Gagal..!!");
        }

        score.setText("Score Anda: "+answer);
    }
}
