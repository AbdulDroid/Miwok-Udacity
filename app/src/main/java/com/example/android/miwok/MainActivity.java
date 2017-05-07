/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        TextView numbers = (TextView)findViewById(R.id.numbers);
        TextView colors = (TextView)findViewById(R.id.colors);
        TextView family = (TextView)findViewById(R.id.family);
        TextView phrases = (TextView)findViewById(R.id.phrases);

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbers = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbers);
            }
        });

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent family = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(family);
            }
        });

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colors = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colors);
            }
        });

        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrases = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrases);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MainActivity: ","MainActivity started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("MainActivity: ","MainActivity has paused");
        releaseMediaPlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MainActivity: ","MainActivity has stopped");
        releaseMediaPlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
