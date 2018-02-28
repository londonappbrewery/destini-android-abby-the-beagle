package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    private int mStage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        if (savedInstanceState != null) {
            mStage = savedInstanceState.getInt("StageKey");
        } else {
            mStage = 1;
        }
        showStage(mStage);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStage == 1 || mStage == 2) {
                    mStage = 3;
                } else if (mStage == 3) {
                    mStage = 6;
                }
                showStage(mStage);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStage == 1) {
                    mStage = 2;
                } else if (mStage == 2) {
                    mStage = 4;
                } else if (mStage == 3) {
                    mStage = 5;
                }
                showStage(mStage);
            }
        });
    }

    private void showStage(int stage) {
        int story = 0;
        int ans1 = 0;
        int ans2 = 0;

        switch (stage) {
            case 1: story = R.string.T1_Story;
                    ans1 = R.string.T1_Ans1;
                    ans2 = R.string.T1_Ans2;
                    break;
            case 2: story = R.string.T2_Story;
                    ans1 = R.string.T2_Ans1;
                    ans2 = R.string.T2_Ans2;
                    break;
            case 3: story = R.string.T3_Story;
                    ans1 = R.string.T3_Ans1;
                    ans2 = R.string.T3_Ans2;
                    break;
            case 4: story = R.string.T4_End;
                    break;
            case 5: story = R.string.T5_End;
                    break;
            case 6: story = R.string.T6_End;
                    break;
        }

        mStoryTextView.setText(story);

        if (stage < 4) {
            mButtonTop.setText(ans1);
            mButtonBottom.setText(ans2);
        } else {
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("StageKey", mStage);
    }
}
