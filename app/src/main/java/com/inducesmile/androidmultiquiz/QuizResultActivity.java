package com.inducesmile.androidmultiquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.pavlospt.CircleView;

public class QuizResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        setTitle(getString(R.string.quiz_result));

        final String resultString = getIntent().getExtras().getString("RESULT_OBJECT");
        String userScore = getIntent().getExtras().getString("TOTAL_SCORE");

        double passResult = Double.parseDouble(userScore);
        int userPassMark = new Double(passResult).intValue();

        CircleView userPassScore = (CircleView)findViewById(R.id.pass);

        userPassScore.setTitleText(String.valueOf(userPassMark) + "%");

        Button retakeQuizButton = (Button)findViewById(R.id.retake_quiz);
        assert retakeQuizButton != null;
        retakeQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retakeQuizIntent = new Intent(QuizResultActivity.this, QuizCategoryActivity.class);
                startActivity(retakeQuizIntent);
            }
        });

        Button viewQuizResultButton = (Button)findViewById(R.id.view_result);
        assert viewQuizResultButton != null;
        viewQuizResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(QuizResultActivity.this, ResultAnalysisActivity.class);
                resultIntent.putExtra("RESULT", resultString);
                startActivity(resultIntent);
            }
        });

    }

    @Override
    public void onBackPressed() {
    }
}
