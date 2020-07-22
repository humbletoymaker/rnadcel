package co.adcel.reactnative.android;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import co.adcel.adbanner.AdSize;
import co.adcel.adbanner.BannerAdContainer;
import co.adcel.adbanner.BannerListener;

/**
 * Created by pavel on 25.01.17.
 */

public class AdCelBanner extends FrameLayout implements BannerListener, LifecycleEventListener {

    private ReactContext mContext;
    private BannerAdContainer myAdView;
    private String mSize;
    private int mRefreshInterval;
    private DeviceEventManagerModule.RCTDeviceEventEmitter mEventEmitter;
    boolean isAttached = false;

    public AdCelBanner(ThemedReactContext context) {
        super(context);
        mContext = context;
        mContext.addLifecycleEventListener(this);
        mEventEmitter = mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    public void setSize(String size) {
        mSize = size;
        createAdViewIfCan();
    }

    public void setRefreshInterval(int refreshInterval) {
        mRefreshInterval = refreshInterval;
        if (myAdView != null) {
            myAdView.setRefreshInterval(refreshInterval);
        }
    }

    public void loadNextAd() {
        if (myAdView != null) {
            myAdView.loadNextAd();
        }
    }

    private AdSize getBannerSize(String size) {
        switch (size) {
            case "300x50":
                return AdSize.BANNER_300x50;
            case "728x90":
            case "768x90":
                return AdSize.BANNER_728x90;
            case "300x250":
                return AdSize.BANNER_300x250;
            case "320x50":
            default:
                return AdSize.BANNER_320x50;
        }
    }

    private void createAdViewIfCan() {
        if (mSize != null && mContext.getCurrentActivity() != null) {
            int width = 0;
            int height = 0;
            String[] sizeComp = mSize.split("x");
            if (sizeComp.length == 2) {
                try {
                    width = Integer.parseInt(sizeComp[0]);
                    height = Integer.parseInt(sizeComp[1]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            Resources r = mContext.getResources();
            DisplayMetrics dm = r.getDisplayMetrics();
            int pxW = width > 0 ?
                    dp2px(width, dm)
                    : r.getDisplayMetrics().widthPixels;
            int pxH = dp2px(height, dm);

            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(pxW, pxH, Gravity.CENTER);

            if (myAdView == null) {
                this.removeAllViews();
                myAdView = new BannerAdContainer(mContext.getCurrentActivity());
                myAdView.setBannerListener(this);
                addView(myAdView, lp);
            }

            myAdView.setSize(getBannerSize(mSize));
            myAdView.setRefreshInterval(mRefreshInterval);
            myAdView.setLayoutParams(lp);
            myAdView.setGravity(Gravity.BOTTOM);
            myAdView.setOrientation(LinearLayout.VERTICAL);

            myAdView.measure(pxW, pxH);
            myAdView.layout(0, 0, pxW, pxH);
        }
    }

    private int dp2px(int dp, DisplayMetrics dm) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, dm));
    }

    @Override
    public void requestLayout() {
        super.requestLayout();
        post(measureAndLayout);
    }

    private final Runnable measureAndLayout = new Runnable() {
        @Override
        public void run() {
            measure(
                    MeasureSpec.makeMeasureSpec(getWidth(), MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(getHeight(), MeasureSpec.EXACTLY));
            layout(getLeft(), getTop(), getRight(), getBottom());
        }
    };

    @Override
    public void onBannerLoad() {
        mContext.getJSModule(RCTEventEmitter.class).receiveEvent(getId(), "onBannerDidDisplayAd", null);
        Activity activity = mContext.getCurrentActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    createAdViewIfCan();
                }
            });
        }
    }

    @Override
    public void onBannerFailedToLoadProvider(String provider) {
        WritableMap event = Arguments.createMap();

        event.putString("error", "No fill");
        event.putString("provider", provider);
        mContext.getJSModule(RCTEventEmitter.class).receiveEvent(getId(), "onBannerFailedToDisplayAd", event);
    }

    @Override
    public void onBannerFailedToLoad() {
        WritableMap event = Arguments.createMap();
        mContext.getJSModule(RCTEventEmitter.class).receiveEvent(getId(), "onBannerAllProvidersFailedToDisplayAd", event);
    }

    @Override
    public void onBannerClicked() {
        mContext.getJSModule(RCTEventEmitter.class).receiveEvent(getId(), "onBannerClicked", null);
    }

    @Override
    public void onHostResume() {
        if (myAdView != null) {
            myAdView.post(new Runnable() {
                @Override
                public void run() {
                    myAdView.resume();
                }
            });
        }
    }

    @Override
    public void onHostPause() {
        if (myAdView != null) {
            myAdView.post(new Runnable() {
                @Override
                public void run() {
                    myAdView.pause();
                }
            });
        }
    }

    @Override
    public void onHostDestroy() {
        if (myAdView != null) {
            myAdView.post(new Runnable() {
                @Override
                public void run() {
                    myAdView.destroy();
                }
            });
        }
    }
}
