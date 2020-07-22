'use strict';

import {
  NativeModules,
  DeviceEventEmitter,
} from 'react-native';

const RNAdCel = NativeModules.RNAdCel;

const eventHandlers = {
  onInterstitialFirstLoaded: new Map(),
  onInterstitialFailedToAppear: new Map(),
  onInterstitialWillAppear: new Map(),
  onInterstitialDidDisappear: new Map(),
  onInterstitialClicked: new Map(),
  onRewardedCompleted: new Map(),
    
  onBannerDidDisplayAd: new Map(),
  onBannerFailedToDisplayAd: new Map(),
  onBannerAllProvidersFailedToDisplayAd: new Map(),
  onBannerClicked: new Map(),
};

const addEventListener = (type, handler) => {
  switch (type) {
    case 'onInterstitialFirstLoaded':
    case 'onInterstitialFailedToAppear':
    case 'onInterstitialWillAppear':
    case 'onInterstitialDidDisappear':
    case 'onInterstitialClicked':
    case 'onRewardedCompleted':
          
    case 'onBannerDidDisplayAd':
    case 'onBannerFailedToDisplayAd':
    case 'onBannerAllProvidersFailedToDisplayAd':
    case 'onBannerClicked':
      eventHandlers[type].set(handler, DeviceEventEmitter.addListener(type, handler));
      break;
          
    default:
      console.log(`Event with type ${type} does not exist.`);
  }
}

const removeEventListener = (type, handler) => {
  if (!eventHandlers[type].has(handler)) {
    return;
  }
  eventHandlers[type].get(handler).remove();
  eventHandlers[type].delete(handler);
}

const removeAllListeners = () => {
  DeviceEventEmitter.removeAllListeners('onInterstitialFirstLoaded');
  DeviceEventEmitter.removeAllListeners('onInterstitialFailedToAppear');
  DeviceEventEmitter.removeAllListeners('onInterstitialWillAppear');
  DeviceEventEmitter.removeAllListeners('onInterstitialDidDisappear');
  DeviceEventEmitter.removeAllListeners('onInterstitialClicked');
  DeviceEventEmitter.removeAllListeners('onRewardedCompleted');
    
  DeviceEventEmitter.removeAllListeners('onBannerDidDisplayAd');
  DeviceEventEmitter.removeAllListeners('onBannerFailedToDisplayAd');
  DeviceEventEmitter.removeAllListeners('onBannerAllProvidersFailedToDisplayAd');
  DeviceEventEmitter.removeAllListeners('onBannerClicked');
};

module.exports = {
  ...RNAdCel,
  setLogs: (logs) => RNAdCel.setLogs(logs),
  setUserConsent: (consent) => RNAdCel.setUserConsent(consent),
  start: (id,adContentType) => RNAdCel.start(id,adContentType),
  showInterstitial: (adContentType) => RNAdCel.showInterstitial(adContentType),
  hasInterstitial: (adContentType, cb) => RNAdCel.hasInterstitial(adContentType, cb),
  setTargetingParam: (param, value) => RNAdCel.setTargetingParam(param, value),
  addEventListener,
  removeEventListener,
  removeAllListeners,
};
