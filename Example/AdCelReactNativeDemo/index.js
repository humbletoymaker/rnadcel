/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View,
    Platform,
    TouchableHighlight,
} from 'react-native';

import { AdCel, AdCelBanner } from 'react-native-adcel';

const ADCEL_IMAGE_INTERSTITIAL = 'Image'
const ADCEL_INTERSTITIAL = 'Interstitial'
const ADCEL_VIDEO_INTERSTITIAL = 'Video'
const ADCEL_REWARDED_INTERSTITIAL = 'Rewarded'
const ADCEL_BANNER = 'Banner'

//Supported banner sizes
const ADCEL_BANNER_SIZE_300x50 = '300x50'
const ADCEL_BANNER_SIZE_320x50 = '320x50'
const ADCEL_BANNER_SIZE_728x90 = '728x90'
const ADCEL_BANNER_SIZE_768x90 = '768x90'
const ADCEL_BANNER_SIZE_300x250 = '300x250'

export default class AdCelReactNativeDemo extends Component {
    
    constructor() {
        super();
        this.state = {
        adSize: ADCEL_BANNER_SIZE_320x50,
        };
        this.setAdSize = this.setAdSize.bind(this);
    }
    
    componentDidMount() {
        //If you need console logs from the AdCel SDK
        AdCel.setLogs(true);
        
        AdCel.setUserConsent(true);
        
        //Event handlers from the AdCel SDK
        AdCel.addEventListener('onInterstitialFirstLoaded',
                               (adContentType) => console.log('onInterstitialFirstLoaded event: '+adContentType));
        AdCel.addEventListener('onInterstitialDidDisappear',
                               (adContentType) => console.log('onInterstitialDidDisappear event: '+adContentType));
        AdCel.addEventListener('onInterstitialFailedToAppear',
                               (adContentType) => console.log('onInterstitialFailedToAppear event:'+adContentType));
        AdCel.addEventListener('onInterstitialWillAppear',
                               (adContentType) => console.log('onInterstitialWillAppear event:'+adContentType));
        AdCel.addEventListener('onInterstitialClicked',
                               (adContentType) => console.log('onInterstitialClicked event'+adContentType));
        AdCel.addEventListener('onRewardedCompleted',
                               (reward) => console.log('onRewardedCompleted event: '+reward));
        
        //Constants that are not used to show ads in this application are commented out:
        adContentType = /*ADCEL_IMAGE_INTERSTITIAL +*/ /*ADCEL_INTERSTITIAL + */ /*ADCEL_VIDEO_INTERSTITIAL +*/ ADCEL_BANNER + ADCEL_REWARDED_INTERSTITIAL;
        
        //The app_id of your app should be taken directly from your personal user account in the adcel.co website
        //The app_id below is from a test app with bundle_id = co.adcel.demo
        if (Platform.OS === 'ios')
        {
            app_id = 'ab3d155f-7703-4289-8372-848737c2b879:d949782d-cb74-4501-8f38-613f89a579b9';
        }
        else if (Platform.OS === 'android')
        {
            app_id = '89fdf849-b5bc-49d0-ad51-0b790e777ae4:fc7094bb-3ca7-4450-9a7e-320b6b4f4e42';
        }
        
        //Start(initialize) the SDK
        AdCel.start(app_id, adContentType);
        
        AdCel.hasInterstitial(ADCEL_REWARDED_INTERSTITIAL, (hasInterstitial) => hasInterstitial && console.log('*** Has Interstitial'));
    }
    
    componentWillUnmount() {
        AdCel.removeAllListeners();
    }
    
    showInterstital() {
        //Show ads
        
        //AdCel.showInterstitial(ADCEL_IMAGE_INTERSTITIAL);
        AdCel.showInterstitial(ADCEL_REWARDED_INTERSTITIAL);
        //AdCel.showInterstitial(ADCEL_VIDEO_INTERSTITIAL);
        //AdCel.showInterstitial(ADCEL_INTERSTITIAL);
    }
    
    setAdSize() {
        const { adSize } = this.state;
        this.setState({
                      adSize: adSize === ADCEL_BANNER_SIZE_320x50 ?
                      ADCEL_BANNER_SIZE_768x90 : ADCEL_BANNER_SIZE_320x50,
                      });
    }
    
    loadNextAd = () => {
        this.banner && this.banner.loadNextAd()
    }
    
    render() {
        const { adSize } = this.state;
        console.log(adSize);
        
        return (
                <View style={styles.container}>
                <View style={{ flex: 1 }}>
                <Text onPress={this.showInterstital} style={styles.button}>
                Show interstital
                </Text>
                <Text onPress={this.setAdSize} style={styles.button}>
                Change banner size {adSize === ADCEL_BANNER_SIZE_320x50 ?
                ADCEL_BANNER_SIZE_768x90 : ADCEL_BANNER_SIZE_320x50}
                </Text>
                <Text onPress={this.loadNextAd} style={styles.button}>Load Next Ad</Text>
                </View>
                <AdCelBanner style={{width: 320, height: 50, backgroundColor: 'powderblue'}}
                refreshInterval={30}
                adSize={this.state.adSize}
                zone={"MenuZone"}
                onBannerDidDisplayAd={() => console.log('onBannerDidDisplayAd event')}
                onBannerFailedToDisplayAd={({ nativeEvent: {error}}) => console.log('onBannerFailedToDisplayAd event. Error: ' + error)}
                onBannerAllProvidersFailedToDisplayAd={() => console.log('onBannerAllProvidersFailedToDisplayAd event')}
                onBannerClicked={() => console.log('onBannerClicked event')}
                ref={el => (this.banner = el)}
                />
                </View>
                );
    }
}

const styles = StyleSheet.create({
                                 container: {
                                 marginTop:  30,
                                 flex: 1,
                                 alignItems: 'center',
                                 },
                                 button: {
                                 color: '#333333',
                                 marginBottom: 15,
                                 },
                                 });

AppRegistry.registerComponent('AdCelReactNativeDemo', () => AdCelReactNativeDemo);
