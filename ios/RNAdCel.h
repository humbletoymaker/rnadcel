#import <UIKit/UIKit.h>
#import <React/RCTBridgeModule.h>

@interface RNAdCel : NSObject <RCTBridgeModule>

+(void)deliverEventWithName:(NSString*)eventName data:(id)data;

@end



