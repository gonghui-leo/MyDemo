package com.gonghui.mydemo;

import dagger.Component;

@Component
public interface ActivityFactory {
    void inject(MainActivity mainActivity);
}
