#import <UIKit/UIKit.h>
#import <React/UIView+React.h>

@class RCTEventDispatcher;

@interface RNAdCelBannerView : UIView

@property (nonatomic,readwrite) int refreshInterval;
@property (nonatomic,copy) NSString *adSize;
@property (nonatomic,copy) NSString *zone;

@property (nonatomic,copy) RCTBubblingEventBlock onBannerDidDisplayAd;
@property (nonatomic,copy) RCTBubblingEventBlock onBannerFailedToDisplayAd;
@property (nonatomic,copy) RCTBubblingEventBlock onBannerAllProvidersFailedToDisplayAd;
@property (nonatomic,copy) RCTBubblingEventBlock onBannerClicked;

- (instancetype)initWithEventDispatcher:(RCTEventDispatcher *)eventDispatcher NS_DESIGNATED_INITIALIZER;

- (void)loadNextAd;

@end


