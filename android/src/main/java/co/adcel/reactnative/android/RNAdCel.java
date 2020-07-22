package co.adcel.reactnative.android;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import co.adcel.common.AdProvider;
import co.adcel.init.AdCel;
import co.adcel.interstitialads.InterstitialListener;

/**
 * Created by pavel on 24.01.17.
 */

public class RNAdCel extends ReactContextBaseJavaModule implements LifecycleEventListener, InterstitialListener {
    public static final String IMAGE        = "Image";
    public static final String VIDEO        = "Video";
    public static final String INTERSTITIAL = "Interstitial";
    public static final String REWARDED     = "Rewarded";
    public static final String BANNER       = "Banner";

    public RNAdCel(ReactApplicationContext reactContext) {
        super(reactContext);
        reactContext.addLifecycleEventListener(this);
    }

    @Override
    public String getName() {
        return "RNAdCel";
    }

    @ReactMethod
    public void start(final String appKey, final String type) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run () {
                if (getCurrentActivity() == null) {
                    return;
                }
                int mask = 0;
                if (type.contains(INTERSTITIAL)){
                    mask |= AdCel.MASK_INTERSTITIAL;
                }
                if (type.contains(IMAGE)) {
                    mask |= AdCel.MASK_IMAGE;
                }
                if (type.contains(VIDEO)) {
                    mask |= AdCel.MASK_VIDEO;
                }
                if (type.contains(REWARDED)) {
                    mask |= AdCel.MASK_REWARDED;
                }
                if (type.contains(BANNER)) {
                    mask |= AdCel.MASK_BANNER;
                }
                AdCel.setInterstitialListener(RNAdCel.this);
                AdCel.initializeSDK(getCurrentActivity(), appKey, mask);
            }
        });
    }

    @ReactMethod
    public void setLogs(final boolean logging) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run () {
                AdCel.setLogging(logging);
            }
        });
    }
    
    @ReactMethod
    public void setUserConsent(final boolean consent) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run () {
                AdCel.setUserConsent(consent);
            }
        });
    }

    @ReactMethod
    public void hasInterstitial(final String type, final Callback callback) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run () {
                String type = AdCel.INTERSTITIAL;
                if (type.equals(IMAGE)) {
                    type = AdCel.IMAGE;
                } else if (type.equals(VIDEO)) {
                    type = AdCel.VIDEO;
                } else if (type.equals(REWARDED)) {
                    type = AdCel.REWARDED;
                }
                callback.invoke(AdCel.isAvailableAd(type));
            }
        });
    }

    @ReactMethod
    public void showInterstitial(final String type) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run () {
                if (type == null || type == "null" || type.equals(INTERSTITIAL)) {
                    AdCel.showInterstitialAd();
                } else if (type.equals(IMAGE)) {
                    AdCel.showInterstitialAd(AdCel.IMAGE);
                } else if (type.equals(VIDEO)) {
                    AdCel.showInterstitialAd(AdCel.VIDEO);
                } else if (type.equals(REWARDED)) {
                    AdCel.showInterstitialAd(AdCel.REWARDED);
                }
            }
        });
    }

    @Override
    public void onHostResume() {
        final Activity activity = getCurrentActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AdCel.onResume(activity);
                }
            });
        }
    }

    @Override
    public void onHostPause() {
        final Activity activity = getCurrentActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AdCel.onPause(activity);
                }
            });
        }
    }

    @Override
    public void onHostDestroy() {
        final Activity activity = getCurrentActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AdCel.onDestroy(activity);
                }
            });
        }
    }

    @Override
    public void onFirstInterstitialLoad(String s, String s1) {
        WritableMap params = Arguments.createMap();
        params.putString("adType", s);
        params.putString("provider", s1);
        getReactApplicationContext()
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("onInterstitialFirstLoaded", params);
    }

    @Override
    public void onInterstitialStarted(String s, String s1) {
        WritableMap params = Arguments.createMap();
        params.putString("adType", s);
        params.putString("provider", s1);
        getReactApplicationContext()
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("onInterstitialWillAppear", params);
    }

    @Override
    public void onInterstitialClicked(String s, String s1) {
        WritableMap params = Arguments.createMap();
        params.putString("adType", s);
        params.putString("provider", s1);
        getReactApplicationContext()
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("onInterstitialClicked", params);
    }

    @Override
    public void onInterstitialClosed(String s, String s1) {
        WritableMap params = Arguments.createMap();
        params.putString("adType", s);
        params.putString("provider", s1);
        getReactApplicationContext()
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("onInterstitialDidDisappear", params);
    }

    @Override
    public void onInterstitialFailLoad(String s, String s1) {
        WritableMap params = Arguments.createMap();
        params.putString("adType", s);
        params.putString("provider", s1);
        getReactApplicationContext()
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("onInterstitialFailedToAppear", params);
    }

    @Override
    public boolean onInterstitialFailedToShow(String s) {
        WritableMap params = Arguments.createMap();
        params.putString("adType", s);
        getReactApplicationContext()
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("onInterstitialFailedToAppear", params);
        return false;
    }

    @Override
    public void onRewardedCompleted(String s, String s1, String s2) {
        WritableMap params = Arguments.createMap();
        params.putString("adProvider", s);
        params.putString("currencyName", s1);
        params.putString("currencyValue", s2);
        getReactApplicationContext()
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("onRewardedCompleted", params);
    }
}
