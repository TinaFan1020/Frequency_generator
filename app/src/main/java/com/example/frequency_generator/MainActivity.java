package com.example.frequency_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioRecord;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.karlotoy.perfectune.instance.PerfectTune;
import android.media.projection.MediaProjection;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.projection.MediaProjectionManager;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button2;
    EditText frequency;
    MediaProjection mediaProjection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //editText = findViewById(R.id.editTextNumberSigned);
        PerfectTune perfectTune = new PerfectTune();
        perfectTune.setTuneFreq(15000);
        perfectTune.setTuneAmplitude(50000);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        frequency= findViewById(R.id.editTextNumberSigned2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sample.tone(16000, 10000);
                //start the tune
                String num = frequency.getText().toString();
                if(TextUtils.isEmpty(num)){
                    num= "15000";
                }
                perfectTune.setTuneFreq(Integer.valueOf(num));
                perfectTune.playTune();//stops the tune
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perfectTune.stopTune();
            }
        });
    }
}