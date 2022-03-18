package com.example.flashcardapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Question;
    private TextView Answer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Question = findViewById(R.id.flashCardQuestion);
         Answer = findViewById(R.id.answer);

        Answer.setVisibility(View.INVISIBLE);
        Question.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view){
                Question.setVisibility(View.INVISIBLE);
                Answer.setVisibility(View.VISIBLE);
            }
        });
        Answer.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View view){
                Answer.setVisibility(View.INVISIBLE);
                Question.setVisibility(View.VISIBLE);

            }
        });

        ImageView addIcon = findViewById(R.id.add_icon);
        addIcon.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,AddCardActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 || resultCode==RESULT_OK || data != null){
            assert data != null;
            String questionString = data.getExtras().getString("QUESTION_KEY");
                String answerString = data.getExtras().getString("ANSWER_KEY");
                Question.setText(questionString);
                Answer.setText(answerString);
        }
    }

}