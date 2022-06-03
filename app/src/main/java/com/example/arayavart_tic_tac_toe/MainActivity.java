package com.example.arayavart_tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   boolean isWinner=false;
   int imageClicked=-1;
    int[][] ws = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},{0,3,6},{1,4,5},{2,6,8},{0,4,8},{2,5,6}};
    int[] gs = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    int player=1;

    public void load(View view) {
            ImageView v = (ImageView) view;

            int tag = Integer.parseInt(v.getTag().toString());

            imageClicked=gs[tag];
        if (isWinner == false && imageClicked == -1) {

            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                gs[tag] = player;
                Toast.makeText(this, tag + " " + "CROSS", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                Toast.makeText(this, tag + " " + "ZERO", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < ws.length; i++) {
                if (gs[ws[i][0]] == gs[ws[i][1]] && gs[ws[i][1]] == gs[ws[i][2]] && gs[ws[i][0]] > -1) {
                    Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                isWinner=true;
                }
            }
        }
    }

    public void reset(View view){
        GridLayout girdLayout=findViewById(R.id.gridLayout);
        int total_images=girdLayout.getChildCount();
        for(int i=0;i<total_images;i++)
        {
            ImageView vie=(ImageView) girdLayout.getChildAt(i);
            vie.setImageDrawable(null);
        }
        isWinner=false;
        imageClicked=-1;
        for(int i=0;i<gs.length;i++)
            gs[i]=-1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}