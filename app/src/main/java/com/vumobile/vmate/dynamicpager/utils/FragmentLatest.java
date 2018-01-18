package com.vumobile.vmate.dynamicpager.utils;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mklimek.frameviedoview.FrameVideoView;
import com.mklimek.frameviedoview.FrameVideoViewListener;
import com.vumobile.vmate.dynamicpager.R;

/**
 * Created by toukirul on 10/1/2018.
 */

public class FragmentLatest extends Fragment {

    private FrameVideoView frameVideoView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test, container, false);

        frameVideoView = (FrameVideoView) view.findViewById(R.id.frame_video_view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        String getText = getArguments().getString("key");

        frameVideoView.setup(Uri.parse(getText));
        frameVideoView.setFrameVideoViewListener(new FrameVideoViewListener() {
            @Override
            public void mediaPlayerPrepared(final MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }

            @Override
            public void mediaPlayerPrepareFailed(MediaPlayer mediaPlayer, String error ){
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}
