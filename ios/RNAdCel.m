#import "RNAdCel.h"
#import "AdCelSDKPlugin.h"
#import <React/RCTEventDispatcher.h>

extern BOOL adCel_ignore_onscreen_banner_status;

@implementation RNAdCel

static RNAdCel* adCelInstance = nil;

@synthesize bridge = _bridge;

- (dispatch_queue_t)methodQueue
{
  return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE();

#pragma mark exported methods

RCT_EXPORT_METHOD(start:(NSString *)app_id adContentType:(NSString*)adContentType)
{
  adCelInstance = self;
  
  adCel_ignore_onscreen_banner_status=YES;

  AdCel_start_platform(app_id.UTF8String, adContentType.UTF8String);
}

RCT_EXPORT_METHOD(setLogs:(BOOL)logs)
{
  AdCel_setLogLevel_platform(1);
}

RCT_EXPORT_METHOD(hasInterstitial:(NSString*)adContentType callback:(RCTResponseSenderBlock)callback)
{
  if ([NSThread isMainThread])
  {
    callback(@[@(AdCel_hasInterstitial_platform(adContentType.UTF8String))]);
  }
  else
  {
    dispatch_async(dispatch_get_main_queue(), ^{
      
      callback(@[@(AdCel_hasInterstitial_platform(adContentType.UTF8String))]);
    });
  }
}

RCT_EXPORT_METHOD(showInterstitial:(NSString*)adContentType)
{
  AdCel_showInterstitial_platform(adContentType.UTF8String);
}

RCT_EXPORT_METHOD(setTargetingParam:(NSString*)param value:(NSString*)value)
{
  AdCel_setTargetingParam_platform(param.UTF8String, value.UTF8String);
}

RCT_EXPORT_METHOD(setUserConsent:(BOOL)consent)
{
  AdCel_setUserConsent_platform(consent);
}

+(void)deliverEventWithName:(NSString*)eventName data:(id)data
{
  [adCelInstance.bridge.eventDispatcher sendDeviceEventWithName:eventName body:data];
}

@end
