package co.adcel.reactnative.android;

import android.app.Activity;
import android.view.View;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import co.adcel.adbanner.BannerListener;

/**
 * Created by pavel on 26.01.17.
 */

public class RNAdCelBanner extends SimpleViewManager {
    private static final String COMMAND_LOAD_NEXT_AD_NAME = "loadNextAd";
    private static final int COMMAND_LOAD_NEXT_AD_ID = 0;

    private ReactContext reactContext;

    public RNAdCelBanner(ReactContext context) {
        super();
        this.reactContext = context;
    }

    @Override
    public String getName() {
        return "RNAdCelBanner";
    }

    @Override
    protected AdCelBanner createViewInstance(ThemedReactContext reactContext) {
        return new AdCelBanner(reactContext);
    }

    @ReactProp(name = "adSize")
    public void setSize(final AdCelBanner view, final String size) {
        Activity activity = reactContext.getCurrentActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    view.setSize(size);
                }
            });
        }
    }

    @ReactProp(name = "refreshInterval")
    public void setRefreshInterval(final AdCelBanner view, final int refreshInterval) {
        Activity activity = reactContext.getCurrentActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    view.setRefreshInterval(refreshInterval);
                }
            });
        }
    }

    private void loadNextAd(AdCelBanner banner) {
        banner.loadNextAd();
    }

    @Nullable
    @Override
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(
                "onBannerDidDisplayAd",
                MapBuilder.of("registrationName", "onBannerDidDisplayAd"),
                "onBannerFailedToDisplayAd",
                MapBuilder.of("registrationName", "onBannerFailedToDisplayAd"),
                "onBannerClicked",
                MapBuilder.of("registrationName", "onBannerClicked"),
                "onBannerAllProvidersFailedToDisplayAd",
                MapBuilder.of("registrationName", "onBannerAllProvidersFailedToDisplayAd")
        );
    }

    @Nullable
    @Override
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of(COMMAND_LOAD_NEXT_AD_NAME, COMMAND_LOAD_NEXT_AD_ID);
    }

    @Override
    public void receiveCommand(@Nonnull View root, int commandId, @Nullable ReadableArray args) {
        switch (commandId) {
            case COMMAND_LOAD_NEXT_AD_ID:
                loadNextAd((AdCelBanner)root);
                break;
        }
    }
}
