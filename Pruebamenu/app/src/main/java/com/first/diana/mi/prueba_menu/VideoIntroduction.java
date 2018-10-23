package com.first.diana.mi.prueba_menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.afdroid.mi.prueba_menu.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class VideoIntroduction extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerFragment youTubePlayerFragment;
    public static final String DEVELOPER_KEY = "AIzaSyAimNw7U6n5o4ffZkVAF9xUJsA0ZGt0MTU";
    private static final String V_ID  = "nTmqswCsS-Q";
    private static final int REC_DIA_REQ = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_introduction);

        youTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager().findFragmentById(R.id.videoView);
        youTubePlayerFragment.initialize(DEVELOPER_KEY, this);
    }


    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult erroReason ) {
        if (erroReason.isUserRecoverableError()){
            erroReason.getErrorDialog(this, REC_DIA_REQ).show();
        }else {
            String erroMessage = String.format("Error al iniciar YouTubePlayer (%1$s)", erroReason.toString());
            Toast.makeText(this, erroMessage, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (b) {
            youTubePlayer.cueVideo(V_ID);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REC_DIA_REQ) {
            getYouTubePlayerProvider().initialize(DEVELOPER_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView)findViewById(com.example.afdroid.mi.prueba_menu.R.id.videoView);
    }


    public void goToLogin(View v) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }

    private void goToMainActivity(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null){
            goToMainActivity();
        }
    }
}
