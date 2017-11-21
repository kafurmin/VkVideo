package com.kif.vkvideo.inject;

import com.kif.vkvideo.ui.videoplayer.VideoPlayerActivity;
import com.kif.vkvideo.ui.login.LoginActivity;
import com.kif.vkvideo.ui.login.LoginActivityModule;
import com.kif.vkvideo.ui.main.MainActivity;
import com.kif.vkvideo.ui.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class AndroidBindingModule {

    @ContributesAndroidInjector(modules = {ActivityModule.class, LoginActivityModule.class})
    abstract LoginActivity bindHelloActivity();

    @ContributesAndroidInjector(modules = {ActivityModule.class, MainActivityModule.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {ActivityModule.class})
    abstract VideoPlayerActivity bindVideoViewActivity();
}
