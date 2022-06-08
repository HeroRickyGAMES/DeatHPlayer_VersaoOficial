package com.ldt.musicr.ui.maintab.subpages;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ldt.musicr.R;
import com.ldt.musicr.helper.LocaleHelper;
import com.ldt.musicr.loader.medialoader.SongLoader;
import com.ldt.musicr.model.Song;
import com.ldt.musicr.ui.maintab.MusicServiceNavigationFragment;
import com.ldt.musicr.util.Tool;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import es.dmoral.toasty.Toasty;

public class MoreOptionFragment extends MusicServiceNavigationFragment {
    private static final String TAG = "MoreOptionFragment";

    @BindView(R.id.status_bar)
    View mStatusBar;

    @BindView(R.id.root)
    View mRoot;

    @BindView(R.id.textViewClicavel)
    View view;

    public static MoreOptionFragment newInstance() {
        return new MoreOptionFragment();
    }

    @Nullable
    @Override
    protected View onCreateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.screen_setting_advance,container, false);
    }

    private Unbinder mUnbinder;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this,view);
        onPaletteChanged();
    }

    @Override
    public void onDestroyView() {
        if(mUnbinder!=null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
        super.onDestroyView();
    }

    @OnClick(R.id.back_button)
    void back() {
        getNavigationController().dismissFragment();
    }

    @OnClick(R.id.textViewClicavel)
    void googleplay() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=HeroRickyStudios")));
    }

    @Override
    public void onSetStatusBarMargin(int value) {
        mStatusBar.getLayoutParams().height = value;
    }

    @Override
    public void onPaletteChanged() {
        super.onPaletteChanged();
        int color = Tool.getBaseColor();
        ((TextView)mRoot.findViewById(R.id.title)).setTextColor(color);
        ((ImageView)mRoot.findViewById(R.id.back_button)).setColorFilter(color);

    }
}
