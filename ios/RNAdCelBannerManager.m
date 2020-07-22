#import "RNAdCelBannerManager.h"
#import "RNAdCelBannerView.h"

#import <React/RCTBridge.h>
#import <React/RCTUIManager.h>

@implementation RNAdCelBannerManager

RCT_EXPORT_MODULE();

@synthesize bridge = _bridge;

- (UIView *)view
{
    return [[RNAdCelBannerView alloc] initWithEventDispatcher:self.bridge.eventDispatcher];
}

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_VIEW_PROPERTY(adSize, NSString);
RCT_EXPORT_VIEW_PROPERTY(zone, NSString);
RCT_EXPORT_VIEW_PROPERTY(refreshInterval, int);

RCT_EXPORT_VIEW_PROPERTY(onBannerDidDisplayAd, RCTBubblingEventBlock);
RCT_EXPORT_VIEW_PROPERTY(onBannerFailedToDisplayAd, RCTBubblingEventBlock);
RCT_EXPORT_VIEW_PROPERTY(onBannerAllProvidersFailedToDisplayAd, RCTBubblingEventBlock);
RCT_EXPORT_VIEW_PROPERTY(onBannerClicked, RCTBubblingEventBlock);

RCT_EXPORT_METHOD(loadNextAd:(nonnull NSNumber *)reactTag)
{
    [self.bridge.uiManager addUIBlock:^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, RNAdCelBannerView *> *viewRegistry) {
        RNAdCelBannerView *view = viewRegistry[reactTag];
        if (![view isKindOfClass:[RNAdCelBannerView class]]) {
            RCTLogError(@"Invalid view returned from registry, expecting RNGADBannerView, got: %@", view);
        } else {
            [view loadNextAd];
        }
    }];
}

@end

