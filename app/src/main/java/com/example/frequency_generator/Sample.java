package com.example.frequency_generator;

import android.media.AudioFormat;
import android.media.AudioTrack;
import android.media.AudioManager;
import android.util.Log;
import com.karlotoy.perfectune.instance.PerfectTune;
import com.karlotoy.perfectune.constants.TuneNote;

public class Sample{

    public static void tone(int hz, int ms){
        tone(hz, ms, 1.0);
    }

    public static void tone(int hz, int ms, double vol){
                byte[] buf = new byte[1];
                int buff_size = AudioTrack.getMinBufferSize(44000,
                        AudioFormat.CHANNEL_OUT_MONO,
                        AudioFormat.ENCODING_PCM_8BIT);
                AudioTrack track_player = new AudioTrack(AudioManager.STREAM_MUSIC, 44000,
                        AudioFormat.CHANNEL_OUT_MONO,
                        AudioFormat.ENCODING_PCM_8BIT,
                        buff_size,
                        AudioTrack.MODE_STREAM);
                track_player.play() ;
                for (int i = 0; i < ms * 8; i++) {
                    double angle = i / (44000f / hz) * 2.0 * Math.PI;
                    buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
                    //System.out.println(buf[0]);
                    track_player.write(buf, 0, 1);
                }
                float rate=track_player.getSampleRate();
                Log.v("msg","start: "+rate);
                System.out.println(rate);
                track_player.stop();
                track_player.release();
                Log.v("msg","end");
            }

    /*public static void main(String[] args) {
        Sample.tone(16000, 100000);
    }*/
}
