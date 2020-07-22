
## 1.5.6  (July 8, 2020)

UPDATED:
- Pangle to 3.0.0.6;
- Facebook to 5.10.0 (FBSDKCoreKit_Basics to 7.1.1);

## 1.5.5  (June 29, 2020)

UPDATED:
- AdColony provider to 4.1.5;
- UnityAds provider to 3.4.6;
- Supersonic provider to 6.16.3;
- Criteo provider to 3.6.1;
- Applovin provider to 6.12.8;
- MyTarget provider to 5.6.3;
- StartApp provider to 4.5.0;
- Yandex provider to 2.15.4;
- MoPub provider to 5.13.0;

## 1.5.4  (June 3, 2020)

UPDATED:
- Smaato provider;

## 1.5.3  (May 20, 2020)

ADDED:
- Vungle 300x250 banners;

## 1.5.2  (May 19, 2020)

UPDATED:
- Pangle to 2.9.5.6;
- InMobi to 9.0.7;

## 1.5.1  (May 15, 2020)

ADDED:
- Criteo provider

## 1.5.0  (May 11, 2020)

ADDED:
- zones support for banner ads;

UPDATED:
- completely replaced UIAlertView with UIAlertController;

## 1.4.18  (April 13, 2020)

ADDED:
- Support for RTB ads which cannot be loaded when banner is not on screen;

UPDATED:
- Vungle to 6.5.3;
- IronSource(Supersonic) to 6.15.0.1;
- MyTarget to 5.5.0;
- GoogleMobileAds to 7.57.0;
- StartApp to 4.4.3;
- Yandex to 2.15.0;
- Facebook to 5.8.0;
- MoPub to 5.12.0;

## 1.4.17  (March 20, 2020)

FIXED:
- AdCelView crashed because of internal observers;

## 1.4.16  (March 17, 2020)

UPDATED:
- improved loading ad for small banners while not on screen;

## 1.4.15  (March 10, 2020)

UPDATED:
- improved server logs for AdCelView;

## 1.4.14  (March 5, 2020)

UPDATED:
- AdColony to 4.1.4;
- Unity to 3.4.2;
- Vungle to 6.5.2;
- IronSource(Supersonic) to 6.14.0;
- Tapjoy to 12.4.2;
- MyTarget to 5.4.8;
- Smaato to 10.2.6;
- Yandex to 2.14.0;
- Facebook to 5.7.1;
- MoPub to 5.11.0;
- InMobi to 9.0.6;

## 1.4.13  (February 27, 2020)

UPDATED:
- StartApp to 4.4.2;

- improved stability of AdCelView;

## 1.4.12  (February 25, 2020)

UPDATED:
- Added Zone Key for Applovin Banner ads;

## 1.4.11  (January 28, 2020)

ADDED:
- Pangle provider to AdCel.framework;

## 1.4.10  (January 22, 2020)

ADDED:
- Pangle provider (Chunks and Cocoapods only);

## 1.4.9  (January 13, 2020)

UPDATED:
- GoogleMobileAds to 7.53.1;

## 1.4.8  (December 23, 2019)

UPDATED:
- Unity to 3.4.0;
- Vungle to 6.4.6;
- IronSource(Supersonic) to 6.11.0;
- Applovin to 6.11.0;
- MyTarget to 5.4.4;
- StartApp to 4.4.0;
- InMobi to 9.0.3;

## 1.4.7  (November 26, 2019)

ADDED:
- StartApp Video ads;
- Yandex Reward ads;

UPDATED:
- Amazon to 3.0.0;
- IronSource(Supersonic) to 6.10.0;
- Applovin to 6.10.1;
- StartApp to 4.3.0;
- Yandex Metrica to 3.8.2;
- Facebook to 5.6.0;
- MoPub to 5.10.0;
- InMobi to 9.0.1;

## 1.4.6  (November 12, 2019)

ADDED:
- InMobi interstitial, reward and banners ads in chunks version of SDK;

UPDATED:
- AdColony to 4.1.2 (will be available only in iOS11 and higher);
- InMobi to 9.0.0;

## 1.4.5  (October 30, 2019)

UPDATED:
- Unity to 3.3.0;
- Vungle to 6.3.2;
- IronSource(Supersonic) to 6.8.7;
- Tapjoy to 12.3.4;
- Applovin to 6.9.5;
- Smaato to 10.2.4;
- StartApp to 4.2.1;
- Yandex to 2.13.3;
- Facebook to 5.5.1;
- MoPub to 5.9.0;

REMOVED:
- removed usage of UIWebView from AdCel source code;

## 1.4.4  (September 5, 2019)

ADDED:
- support for 300x50 MoPab banner;

UPDATED:
- Unity to 3.2.0;
- Supersonic(IronSource) to 6.8.4.2;
- MyTarget to 5.3.5;
- Smaato to 10.2.2;
- Yandex to 2.13.2;
- MoPub to 5.8.0;

## 1.4.3  (August 15, 2019)

ADDED:
- Support for MoPub adapters for RTB-only SDK

## 1.4.2  (July 22, 2019)

UPDATED:
- Supersonic(IronSource) to 6.8.4.1;
- MyTarget to 5.3.3;
- StartApp to 4.1.0;

## 1.4.1  (July 18, 2019)

UPDATED:
- banner impressions logs;

## 1.4.0  (July 15, 2019)

ADDED:
- logs will be compressed before sending to server;

UPDATED:
- Applovin to 6.7.1;

- get KeyWindow logic updated. If keyWindow return nil, we will be trying to find visible window in application windows pool;

REMOVED:
- support for iOS 8. (if you still need iOS8 compatible version, use script "build_AdCelFramework_iOS8_compatible.sh" in chunks version of AdCel SDK);
- Tapjoy disabled for iOS9 because displaying Interstitial may cause keyWindow become nil;

## 1.3.9  (June 5, 2019)

UPDATED:
- AdColony to 3.3.8.1;
- Supersonic(IronSource) to 6.8.4;
- Tapjoy to 12.3.1;
- MyTarget to 5.3.2;
- Yandex to 2.13.0;

## 1.3.8  (June 20, 2019)

FIXED:
- analytics uploader crashes;

## 1.3.7  (June 12, 2019)

UPDATED:
- server logs uploading algorithm;

## 1.3.6  (June 6, 2019)

REMOVED:
- forcing geolocation authorization request from SDK;

## 1.3.5  (June 3, 2019)

ADDED:
- support for StartApp banners with size 300x250;

UPDATED:
- UnityAds to 3.1.0;
- Supersonic(IronSource) to 6.8.3;
- Tapjoy to 12.3.0;
- MyTarget to 5.2.1;
- Smaato to 10.2.0;
- StartApp to 4.0.0;
- Yandex to 2.12.0;

## 1.3.4  (May 16, 2019)

FIXED:
- appearance of Banner with sizes 300x50, 300x250, 728x90 and 768x90 from Smaato provider;

## 1.3.3  (May 14, 2019)

UPDATED:
- improved session time interval tracking;
- improved 'No Fill' tracking for RTB ads;

## 1.3.2  (May 7, 2019)

ADDED:
- Tapjoy provider resources availability check. 

## 1.3.1  (April 22, 2019)

UPDATED:
- improved performance of onFirstAdLoaded: delegate method.

## 1.3.0  (April 17, 2019)

ADDED:
- delegate method -(void)allProvidersFailedToDisplayAdInView:(AdCelView*)adCelView in protocol AdCelViewDelegate. 
  This delegate method will be called if all of the ad providers in the queue have failed to display ad.

## 1.2.27  (April 8, 2019)

FIXED:
- bug where banner from RTB provider may activate click link without user interaction;

## 1.2.26  (April 4, 2019)

UPDATED:
- UnityAds to 3.0.3;

FIXED:
- firing "AdCelViewDelegate - failedToDisplayAdWithError" callback on provider request timeout;

## 1.2.25 (March 19, 2019)

UPDATED:
- Tapjoy to 12.2.1;
- Smaato to 10.1.2;
- Yandex to 2.11.1;
- Facebook to 5.2.0;
- MoPub to 5.6.0;

## 1.2.24 (February 12, 2019)

UPDATED:
- UnityAds to 3.0.1;
- GoogleMobileAds to 7.39.0;
- Facebook to 5.1.1;

FIXED:
- onClick callback from Unity provider;

## 1.2.23 (February 5, 2019)

REMOVED:
- Woobi;
- Avocarrot;
- InMobi;
- Chartboost;
- RevMob;

## 1.2.22 (January 31, 2019)

UPDATED:
- GDPR compatibility improved for Yandex provider;

- AdColony to 3.3.7;
- Vungle to 6.3.2;
- Supersonic(IronSource) to 6.8.1;
- GoogleMobileAds to 7.38.0;
- StartApp to 3.11.0;
- Yandex to 2.11.0 (Metrica to 3.5.0);
- MoPub to 5.5.0;

## 1.2.21 (January 25, 2019)

ADDED:
- minor improvements;

## 1.2.20 (January 22, 2019)

UPDATED:
- GDPR compatibility improved for AdColony provider;
- RTB providers support improved;

## 1.2.19 (January 15, 2019)

UPDATED:
- caching algorithm for Vungle provider;

## 1.2.18 (January 4, 2019)

UPDATED:
- StartApp to 3.10.2;
- MoPub to 5.4.1;

## 1.2.17 (January 3, 2019)

UPDATED:
- Ad caching algorithm
- UIWebView replaced with WKWebView for RTB providers;

- Supersonic(IronSource) to 6.8.0;
- Tapjoy to 12.2.0;
- MyTarget to 4.8.9;
- Smaato to 10.1.1;
- GoogleMobileAds to 7.37.0;

## 1.2.16 (November 20, 2018)

UPDATED:
- InMobi to 7.2.1;
- MyTarget to 4.8.6;
- Smaato to 10.1.0;
- GoogleMobileAds to 7.36.0;
- StartApp to 3.10.1;
- Avocarrot to 4.10.2;
- Facebook to 5.1.0;

## 1.2.15 (November 16, 2018)

UPDATED:
- AdColony to 3.3.6;
- UnityAds to 3.0.0;
- Supersonic(IronSource) to 6.7.12;

FIXED:
- fixed Applovin provider launch problems;

## 1.2.14 (October 12, 2018)

ADDED:
- GDPR support for AmazonAd;

UPDATED:
- Vungle to 6.3.1;
- InMobi to 7.2.0;
- MyTarget to 4.8.4;
- Smaato to 10.0.1;
- GoogleMobileAds to 7.34.0;
- StartApp to 3.9.0;
- Yandex to 2.10.0;
- MoPub to 5.4.0;

## 1.2.13 (October 9, 2018)

UPDATED:
- compatibility with AdCelAudioAdditions.framework version 1.1.0;

## 1.2.12 (September 28, 2018)

FIXED:
- fixed an issue caused by multi-threading violation;

## 1.2.11 (September 27, 2018)

UPDATED:
- delayed initialization for Unity and Supersonic providers replaced with eager one;
- server logs system;

## 1.2.10 (September 21, 2018)

ADDED:
- support for Tapjoy Interstitial format;

## 1.2.9 (September 21, 2018)

ADDED:
- support for Tapjoy Video and Reward formats;

## 1.2.8 (September 17, 2018)

UPDATED:
- banner refresh requests will be stopped if AdCelView or any of it superviews are hidden;

## 1.2.7 (September 11, 2018)

UPDATED:
- Vungle to 6.3.0;
- Supersonic(IronSource) to 6.7.11;
- Applovin to 5.1.2;
- MyTarget to 4.8.1;
- Smaato to 9.1.0;
- Yandex to 2.9.1 (Metrica to 3.1.2);
- Facebook to 4.99.3;
- MoPub to 5.3.0;

## 1.2.6 (August 23, 2018)

REMOVED:
- Personagraph;

## 1.2.5 (August 16, 2018)

UPDATED:
- Applovin to 5.1.1;
- InMobi to 7.1.2;
- MyTarget to 4.8.0;
- GoogleMobileAds to 7.32.0;
- Facebook to 4.99.2;

## 1.2.4 (July 31, 2018)

UPDATED:
- AmazonAd to 2.2.17;
- AdColony to 3.3.5;
- UnityAds to 2.3.0;
- Supersonic(IronSource) to 6.7.10;
- Applovin to 5.1.0;
- MyTarget to 4.7.11;
- Smaato to 9.0.2;
- StartApp to 3.8.1;
- MoPub to 5.2.0;

## 1.2.3 (June 27, 2018)

UPDATED:
- Supersonic(IronSource) to 6.7.9.3;
- Applovin to 5.0.2;
- GoogleMobileAds to 7.31.0;
- Avocarrot to 4.10.1;
- Yandex to 2.9.0;
- Facebook to 4.99.0;
- MoPub to 5.0.1;

## 1.2.2 (June 11, 2018)

REMOVED:
- TapSense;

## 1.2.1 (June 6, 2018)

FIXED:
- minor fixes to GDPR logging;

UPDATED:
- Avocarrot to 4.10.0;

## 1.2.0 (May 25, 2018)

ADDED:
- GDPR support;

UPDATED:
- AdColony to 3.3.4;
- MyTarget to 4.7.9;
- StartApp to 3.7.1;
- MoPub to 5.0.0;

## 1.1.31 (May 17, 2018)

FIXED:
- minor fixes;

UPDATED:
- Vungle to 6.2.0;
- Supersonic(IronSource) to 6.7.9;
- Chartboost to 7.2.0;

## 1.1.30 (May 2, 2018)

ADDED:
- added support for InMobi 300x250 banner;
- added support for Applovin banners - 320x50, 300x250, 728x90, 768x90;

FIXED:
- availability of MoPub Reward ads;
- Image and Video interstitials determination of Chartboost ads provider;

UPDATED:
- UnityAds to 2.2.1;
- Applovin to 5.0.1;
- InMobi to 7.1.1;
- MyTarget to 4.7.8;
- GoogleMobileAds to 7.30.0;
- StartApp to 3.7.0;
- Yandex to 2.8.3;

REMOVED:
- NativeX;

## 1.1.29 (April 9, 2018)

ADDED:
- added support for MoPub Banner (300x250, 728x90) and Reward;

UPDATED:
- Supersonic(IronSource) to 6.7.8;
- Applovin to 4.8.4;
- MyTarget to 4.7.7;

## 1.1.28 (March 23, 2018)

FIXED:
- fixed crash on iOS 7;

## 1.1.27 (March 21, 2018)

UPDATED:
- UnityAds to 2.2.0;
- Supersonic(IronSource) to 6.7.7;
- Chartboost to 7.1.2;
- Applovin to 4.8.3;
- MyTarget to 4.7.6;
- Smaato to 8.2.3;
- GoogleMobileAds to 7.29.0;
- StartApp to 3.6.0;
- Yandex to 2.8.2 (Metrica to 2.9.6);
- MoPub to 4.20.1;

## 1.1.26 (February 28, 2018)

UPDATED:
- minor optimizations;

## 1.1.25 (February 13, 2018)

UPDATED:
- AdColony to 3.3.0;
- Chartboost to 7.1.0;
- Applovin to 4.8.2;
- MyTarget to 4.7.3;
- GoogleMobileAds to 7.28.0;
- StartApp to 3.5.3;

## 1.1.24 (February 6, 2018)

UPDATED:
- Supersonic(IronSource) to 6.7.5;

## 1.1.23 (February 5, 2018)

UPDATED:
- optimizations added to the previous fix for Unity provider

## 1.1.22 (January 31, 2018)

FIXED:
- Interstitial, Image, Video or Reward ads will not be shown if application alert is on screen;

## 1.1.21 (January 25, 2018)

FIXED:
- UnityAds crash in some rare cases

## 1.1.20 (January 16, 2018)

UPDATED:
- Supersonic(IronSource) to 6.7.4;
- Applovin to 4.7.0;
- MyTarget to 4.7.2;
- GoogleMobileAds to 7.27.0;
- Yandex to 2.8.0 (Metrica to 2.9.4);
- Facebook to 4.27.2;
- MoPub to 4.19.0;

## 1.1.19 (December 12, 2017)

FIXED:
- crash when trying to show second interstitial from Yandex provider;

## 1.1.18 (December 11, 2017)

UPDATED:
- UnityAds to 2.1.2;
- Supersonic(IronSource) to 6.7.3.1;
- Chartboost to 7.0.4;
- Applovin to 4.6.0;
- InMobi to 7.0.4;
- Facebook to 4.27.0;
- MoPub to 4.18.0;

## 1.1.17 (November 21, 2017)

UPDATED:
- Supersonic(IronSource) to 6.7.2;
- Chartboost to 7.0.3;
- Applovin to 4.5.1;
- InMobi to 7.0.1;
- MyTarget to 4.6.24;
- GoogleMobileAds to 7.26.0;
- StartApp to 3.5.2;
- Facebook to 4.26.1;

## 1.1.16 (November 16, 2017)

FIXED:
- crash when ads loaded from InMobi provider if |AppDelegate| doesn't contain |window| property;

DEPRECATED:
- AdCelSDK_setTargetingParam in AdCelTargeting.h. Please use [AdCelSDK setTargetingParam: value:] instead.

## 1.1.15 (November 7, 2017)

UPDATED:
- unnecessary runtime warnings removed.

## 1.1.14 (November 7, 2017)

UPDATED:
- unnecessary runtime warnings removed.

## 1.1.13 (October 31, 2017)

ADDED:
- 60 min keepalive interval for Facebook Interstitial and Reward ads.

## 1.1.12 (October 24, 2017)

UPDATED:
- Supersonic(IronSource) to 6.7.0;
- Applovin to 4.4.1;
- GoogleMobileAds to 7.24.1;
- StartApp to 3.5.1;

## 1.1.11 (September 27, 2017)

UPDATED:
- AmazonAd to 2.2.15.1;
- AdColony to 3.2.1;
- UnityAds to 2.1.1;
- Vungle downgraded to 4.1.0 (for iOS 7 devices compatibility);
- Supersonic(IronSource) to 6.6.7.1;
- Chartboost to 7.0.1;
- Applovin to 4.3.1;
- InMobi to 7.0.0;
- MyTarget to 4.6.21;
- Smaato to 8.1.5;
- GoogleMobileAds to 7.24.0;
- Yandex to 2.7.2 (Metrica to 2.9.1);
- Facebook to 4.26.0;

FIXED:
- restored compatibility with iOS7;

REMOVED:
- GoogleMobileAds and Facebook removed from main library and now available only in chunks version of SDK; 

## 1.1.10 (August 29, 2017)

UPDATED:
- AdColony to 3.2.0;
- Supersonic(IronSource) to 6.6.5;
- Applovin to 4.3.0;
- MyTarget to 4.6.20;
- GoogleMobileAds to 7.22.0;
- MoPub to 4.16.0;

FIXED:
- delegate callbacks for AdMob Reward ads;

## 1.1.9 (August 02, 2017)

UPDATED:
- MyTarget to 4.6.19;
- StartApp to 3.4.3;
- Facebook to 4.25.0;

REMOVED:
- Instreamatic provider;

## 1.1.8 (July 17, 2017)

UPDATED:
- Vungle to 5.1.0;
- Supersonic(IronSource) to 6.6.2;
- MyTarget to 4.6.17;
- MoPub to 4.15.0;

## 1.1.7 (July 5, 2017)

ADDED:
- added support for Facebook Reward ads;

## 1.1.6 (June 27, 2017)

ADDED:
- added support for Google Reward ads;
- added support for MyTarget banners of size 728x90;

UPDATED:
- Supersonic(IronSource) to 6.6.1.1;
- Applovin to 4.2.1;
- MyTarget to 4.6.16;
- Smaato to 8.1.4;
- GoogleMobileAds to 7.21.0;
- Facebook to 4.24.0;

## 1.1.5 (June 21, 2017)

UPDATED:
- algorithm of showing banners

ADDED:
- added OpenIDFA for devices with "Limit Ad Tracking" enabled

FIXED:
- User Agent in the internal RTB provider

## 1.1.4 (June 6, 2017)

UPDATED:
- Vungle to 4.1.0;
- Applovin to 4.2.0;
- InMobi to 6.2.1;
- MyTarget to 4.6.14;
- Yandex to 2.7.0 (Metrica to 2.8.0);
- Facebook to 4.23.0;
- MoPub to 4.14.0;

FIXED:
- caching for Applovin rewarded ads; 

## 1.1.3 (May 29, 2017)

UPDATED:
- Supersonic(IronSource) to 6.6.1

## 1.1.2 (May 23, 2017)

UPDATED:
- logging system

## 1.1.1 (May 18, 2017)

UPDATED:
- improved RTB media playback;
- improved stability of VAST parser and player;
- added additional check on View Controller in showInterstitial methods;

FIXED:
- miscellaneous bugs fixed in InHouse SDK and VAST player;

## 1.1.0 (May 5, 2017)

UPDATED:
- improved AdColony caching logic;

- Chartboost to 6.6.3;
- InMobi to 6.2.0;
- MyTarget to 4.6.13;
- Smaato to 8.1.3;
- GoogleMobileAds to 7.20.0;
- Yandex to 2.6.0 (Metrica to 2.7.0);
- Facebook to 4.22.0;

FIXED:
- RTB mediation always failed for the AdCel Interstitial format;
- if RTB mediation for any Interstitial format fails it stops requesting ads;

## 1.0.17 (May 2, 2017)

ADDED:
- RTB mediation logic for all Interstitial formats and for Banners;
- support for Supersonic Interstitial format;

UPDATED:
- AdColony to 3.1.1;

## 1.0.16 (March 30, 2017)

UPDATED:
- improved Interstitial formats caching logic;

- AdColony to 3.1.0;
- UnityAds to 2.1.0;
- Chartboost to 6.6.2;
- InMobi to 6.1.2;
- MyTarget to 4.6.9;
- GoogleMobileAds to 7.19.0;
- Facebook to 4.20.2;
- MoPub to 4.13.0;

## 1.0.15 (March 27, 2017)

ADDED:
- sending geo position data;

UPDATED:
- banner work stability improved;
- banner logging improved;
- reward caching improved;

- MyTarget to 4.6.5;

## 1.0.14 (February 27, 2017)

ADDED:
- support for Smaato Reward format;

UPDATED:
- Smaato to 8.1.1;

## 1.0.13 (February 17, 2017)

REMOVED:
- FlurryAds provider;

## 1.0.12 (February 14, 2017)

ADDED:
- support for InMobi Video format;

## 1.0.11 (February 7, 2017)

UPDATED:
- UnityAds to 2.0.8;
- FlurryAds to 7.9.2;
- Applovin to 3.5.2;
- MyTarget to 4.6.4;
- GoogleMobileAds to 7.17.0;
- Facebook to 4.19.0;

## 1.0.10 (January 25, 2017)

UPDATED:
- ads caching algorithm for AppLovin provider

## 1.0.9 (January 18, 2017)

ADDED:
- possibility to change skip button timer behavior in InHouse provider (configured in dashboard)

## 1.0.8 (January 10, 2017)

UPDATED:
- UnityAds to 2.0.7;
- Supersonic to 6.4.21;
- Chartboost to 6.6.1;
- InMobi to 6.0.1;
- MyTarget to 4.6.2;
- Smaato to 8.1.0;

## 1.0.7 (December 29, 2016)

REMOVED:
- Diagnostic messages when the app is in the AppStore;

## 1.0.6 (December 20, 2016)

ADDED:
- support for Chartboost Image and Video formats; 

## 1.0.5 (December 17, 2016)

ADDED:
- minor improvements for InHouse provider

## 1.0.4 (December 14, 2016)

UPDATED:
- Error handling and caching algorithm for InHouse ads;

- AdColony to 2.6.3;
- UnityAds to 2.0.6;
- Vungle to 4.0.9;
- Supersonic to 6.4.20;
- Applovin to 3.5.1;
- MyTarget to 4.6.1;
- AdMob to 7.16.0;
- StartApp to 3.4.2;
- Facebook to 4.18.0;
- MoPub to 4.11.1;

## 1.0.3 (December 5, 2016)

UPDATED:
- Caching algorithm for the AdColony provider
- SDK analytics was updated to new API version;

## 1.0.2 (November 22, 2016)

UPDATED:
- Supersonic to 6.4.19;
- Chartboost to 6.6.0;
- MyTarget to 4.5.15;
- StartApp to 3.4.1;

## 1.0.1 (November 16, 2016)

ADDED:
- Chartboost 6.5.2;
- MoPub 4.11.0;

UPDATED:
- Applovin to 3.4.3;

## 1.0.0 (November 9, 2016)

- Release of AdCel SDK;
