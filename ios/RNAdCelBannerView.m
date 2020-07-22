#import "RNAdCelBannerView.h"
#import <React/RCTBridgeModule.h>
#import <React/RCTEventDispatcher.h>
#import <React/RCTLog.h>
#import "AdCelView.h"

@interface RNAdCelBannerView()<AdCelViewDelegate>
@end

@implementation RNAdCelBannerView
{
    AdCelView* _bannerView;
    NSString* _adSize;
    int _refreshInterval;
    NSString* _zone;
    
    RCTEventDispatcher* __weak _eventDispatcher;
}

- (instancetype)initWithEventDispatcher:(RCTEventDispatcher *)eventDispatcher
{
    if ((self = [super initWithFrame:CGRectZero]))
    {
        _eventDispatcher = eventDispatcher;
    }

    return self;
}

RCT_NOT_IMPLEMENTED(- (instancetype)initWithFrame:(CGRect)frame)
RCT_NOT_IMPLEMENTED(- (instancetype)initWithCoder:coder)

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wobjc-missing-super-calls"
- (void)insertReactSubview:(UIView *)view atIndex:(NSInteger)atIndex
{
    RCTLogError(@"AdMob Banner cannot have any subviews");
    return;
}
- (void)removeReactSubview:(UIView *)subview
{
    RCTLogError(@"AdMob Banner cannot have any subviews");
    return;
}
#pragma clang diagnostic pop

- (void)recreateBannerView
{
    if (![NSThread isMainThread])
    {
        __weak typeof(self)weakSelf = self;
        dispatch_async(dispatch_get_main_queue(), ^(void) {
        
            [weakSelf recreateBannerView];
        });

        return;
    }
    
    [_bannerView removeFromSuperview];

    _bannerView = [[AdCelView alloc]initWithBannerSize:_adSize delegate:NSClassFromString(@"AdCelSDKPluginName")];
    _bannerView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    
    _bannerView.frame = self.bounds;
    _bannerView.refreshInterval = _refreshInterval;
    //_bannerView.backgroundColor = [UIColor yellowColor];
    _bannerView.zone = _zone;
    
    [self addSubview:_bannerView];
}

- (BOOL)shouldCreateBanner
{
    if (![NSThread isMainThread])
    {
        return NO;
    }
    
    return 0 != _adSize.length &&
        !CGSizeEqualToSize(self.bounds.size, CGSizeZero);
}

- (void)setAdSize:(NSString *)adSize
{
    if (![NSThread isMainThread])
    {
        __weak typeof(self)weakSelf = self;
        dispatch_async(dispatch_get_main_queue(), ^(void) {
        
            [weakSelf setAdSize:adSize];
        });

        return;
    }
    
    if (0 == adSize.length)
    {
        return;
    }
    
    if(![_adSize isEqual:adSize])
    {
        _adSize = adSize;
        
        if ([self shouldCreateBanner])
        {
            [self recreateBannerView];
        }
    }
}

- (void)setZone:(NSString *)zone
{
    if (![NSThread isMainThread])
    {
        __weak typeof(self)weakSelf = self;
        dispatch_async(dispatch_get_main_queue(), ^(void) {
        
            [weakSelf setZone:zone];
        });

        return;
    }
    
    if(![_zone isEqual:zone])
    {
        _zone = zone;
        
        if ([self shouldCreateBanner])
        {
            [self recreateBannerView];
        }
    }
}

-(void)setRefreshInterval:(int)refreshInterval
{
    if (![NSThread isMainThread])
    {
        __weak typeof(self)weakSelf = self;
        dispatch_async(dispatch_get_main_queue(), ^(void) {
        
            [weakSelf setRefreshInterval:refreshInterval];
        });

        return;
    }
    
    if(_refreshInterval != refreshInterval)
    {
        _refreshInterval = refreshInterval;
        
        _bannerView.refreshInterval = _refreshInterval;
    }
}

-(void)layoutSubviews
{
    if (![NSThread isMainThread])
    {
        __weak typeof(self)weakSelf = self;
        dispatch_async(dispatch_get_main_queue(), ^(void) {
        
            [weakSelf layoutSubviews];
        });

        return;
    }
    
    [super layoutSubviews];
    
    _bannerView.frame = self.bounds;
    
    if (nil == _bannerView &&
        [self shouldCreateBanner])
    {
        [self recreateBannerView];
    }
}

- (void)loadNextAd
{
    [_bannerView loadNextAd];
}

@end
