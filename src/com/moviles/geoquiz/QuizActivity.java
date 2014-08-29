package com.moviles.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private TextView mQuestionTextView;
	private trueFalse[] mQuestionBank =new trueFalse[]{
			new trueFalse(R.string.question_ocean,true),
			new trueFalse(R.string.question_mideast,false),
			new trueFalse(R.string.question_africa,true),
			new trueFalse(R.string.question_americas,true),
			new trueFalse(R.string.question_asia,true),
			
	};
	private int  mCurrentIndex=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		mQuestionTextView=(TextView)findViewById(R.id.question_text_view);
		int question=mQuestionBank[mCurrentIndex].getmQuestion();
		mQuestionTextView.setText(question);
		
		mTrueButton=(Button)findViewById(R.id.true_button);
		mTrueButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();				
				checkAnswer(true);
			}
		});
		mNextButton=(Button)findViewById(R.id.next_button);
		mNextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
				int question=mQuestionBank[mCurrentIndex].getmQuestion();
				mQuestionTextView.setText(question);
				
			}
		});
		mFalseButton=(Button)findViewById(R.id.false_button);	
		mFalseButton.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				//Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
				checkAnswer(false);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}
	private void checkAnswer(boolean userPressedTrue){
		boolean answerIsTrue=mQuestionBank[mCurrentIndex].ismTrueQuestion();
		int messageResId=0;
		if(userPressedTrue==answerIsTrue){
			messageResId=R.string.correct_toast;
			
		}else{
			messageResId=R.string.incorrect_toast;
		}
		Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
		}

}
