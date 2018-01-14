package com.adityadua.materialdesign5ndemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    String featuresKK ="Refreshed interface with white elements instead of blue\n" +
            "Clock no longer shows bold hours; all digits are thin. The H, M, and S markings for the stopwatch and timer have been removed, leaving just the numbers.\n" +
            "Ability for applications to trigger translucency in the navigation and status bars[148]\n" +
            "Ability for applications to use \"immersive mode\" to keep the navigation and status bars hidden while maintaining user interaction[149]\n" +
            "Action overflow menu buttons are always visible, even on devices with a \"Menu\" key, which was officially deprecated by Android 4.0.[150]\n" +
            "Restriction for applications when accessing external storage, except for their own directories\n" +
            "Optimizations for performance on devices with lower specifications, including zRAM support and \"low RAM\" device API[144]";

    String featuresJB="Bluetooth low energy support[132]\n" +
            "Bluetooth Audio/Video Remote Control Profile (AVRCP) 1.3 support\n" +
            "OpenGL ES 3.0 support, allowing for improved game graphics[132]\n" +
            "Restricted access mode for new user profiles[132]\n" +
            "Filesystem write performance improvement by running fstrim command while device is idle[133]\n" +
            "Dial pad auto-complete in the Phone application[132]\n" +
            "Volume for incoming calls (ringtone) and notification alerts is no longer adjustable separately\n" +
            "Improvements to Photo Sphere[134]\n" +
            "Reworked camera UI, previously introduced on Google Play edition phones[135]\n" +
            "Addition of \"App Ops\", a fine-grained application permissions control system (hidden by default)[136]\n" +
            "SELinux enabled by default\n" +
            "4K resolution support[137]\n" +
            "Numerous security updates, performance enhancements, and bugfixes[138]\n" +
            "System-level support for geofencing and Wi-Fi scanning APIs\n" +
            "Background Wi-Fi location still runs even when Wi-Fi is turned off\n" +
            "Developer logging and analyzing enhancements\n" +
            "Added support for five more languages";


    String featuresMM="Contextual search from keywords within apps.[207]\n" +
            "Introduction of Doze mode, which reduces CPU speed while the screen is off in order to save battery life[208]\n" +
            "App Standby feature\n" +
            "Alphabetically accessible vertical application drawer[209]\n" +
            "Application search bar and favorites\n" +
            "Native fingerprint reader support\n" +
            "Direct Share feature for target-specific sharing between apps[210]\n" +
            "Renamed \"Priority\" mode to \"Do Not Disturb\" mode\n" +
            "App Linking for faster instinctive opening of links with corresponding applications[211][212]\n" +
            "Larger Application folders with multiple pages\n" +
            "Post-install/run-time permission requests\n" +
            "USB Type-C support";

    String featuresO="Neural networks API\n" +
            "Shared memory API\n" +
            "WallpaperColors API\n" +
            "Bluetooth battery level for connected devices, accessible in Quick Settings\n" +
            "Android Oreo Go Edition, an optional lightweight distribution of Android for low-end devices with less than 1 GB of RAM\n" +
            "Autofill framework updates\n" +
            "Programmatic Safe Browsing actions\n" +
            "Navigation buttons dim when not in use\n" +
            "Visual changes to 'Power Off' and 'Restart' including a new screen and floating toolbar\n" +
            "Toast messages are now white in color with same existing transparency\n" +
            "Automatic light and dark themes";


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemData itemData[] ={
                new ItemData("4.0  : JellyBean ",featuresJB,R.drawable.jellybean),
                new ItemData("4.4  : KitKat ",featuresKK,R.drawable.kitkat),
                new ItemData("6.0  : MarshMallow",featuresMM,R.drawable.marshmallow),
                new ItemData("8.0  : Oreo",featuresO,R.drawable.oreo)
        };

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(itemData);
        //recyclerView.setAdapter(myAdapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
