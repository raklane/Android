package com.rakeshautomation.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int teamAScore = 0;
    private int teamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * Display the Team A score
     */
    private void displayTeamAScore() {
        TextView team_a_Score = (TextView) findViewById(R.id.team_a_score_text_view);
        team_a_Score.setText(String.valueOf(teamAScore));
    }

    /*
     * Display the Team A score
     */
    private void displayTeamBScore() {
        TextView team_b_Score = (TextView) findViewById(R.id.team_b_score_text_view);
        team_b_Score.setText(String.valueOf(teamBScore));
    }

    /*
     * Increase Team A's score
     */
    public void increaseTeamAScoreOnePoint(View view) {
        teamAScore = teamAScore + 1;
        displayTeamAScore();
    }

    public void increaseTeamAScoreTwoPoint(View view) {
        teamAScore = teamAScore + 2;
        displayTeamAScore();
    }

    public void increaseTeamAScoreThreePoint(View view) {
        teamAScore = teamAScore + 3;
        displayTeamAScore();
    }

    /*
     * Increase Team B's score
     */
    public void increaseTeamBScoreOnePoint(View view) {
        teamBScore = teamBScore + 1;
        displayTeamBScore();
    }

    public void increaseTeamBScoreTwoPoint(View view) {
        teamBScore = teamBScore + 2;
        displayTeamBScore();
    }

    public void increaseTeamBScoreThreePoint(View view) {
        teamBScore = teamBScore + 3;
        displayTeamBScore();
    }

    /*
     * Reset the scores
     */
    public void resetScores(View view) {
        teamAScore = 0;
        teamBScore = 0;
        displayTeamAScore();
        displayTeamBScore();
    }

}
