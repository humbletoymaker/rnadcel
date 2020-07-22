import PropTypes from 'prop-types';
import React from 'react';
import {
    requireNativeComponent,
    findNodeHandle,
    UIManager,
} from 'react-native';

const RNAdCelBanner = requireNativeComponent('RNAdCelBanner', AdCelBanner);

export default class AdCelBanner extends React.Component {
    loadNextAd = () => {
        this.banner && UIManager.dispatchViewManagerCommand(
            findNodeHandle(this.banner),
            UIManager.getViewManagerConfig('RNAdCelBanner').Commands.loadNextAd,
            null
        );
    }

    render() {
        return <RNAdCelBanner {...this.props} ref={el => (this.banner = el)} />;
    }
}

AdCelBanner.propTypes = {
    refreshInterval: PropTypes.number,
    adSize: PropTypes.string,
    zone: PropTypes.string,
    onBannerDidDisplayAd: PropTypes.func,
    onBannerFailedToDisplayAd: PropTypes.func,
    onBannerAllProvidersFailedToDisplayAd: PropTypes.func,
    onBannerClicked: PropTypes.func
};
