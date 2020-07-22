#import "RNAdCel.h"

#define ADCEL_PLUGIN_CALLBACK(method) [RNAdCel deliverEventWithName:ToNSString(ADCEL_##method) data:nil]
#define ADCEL_PLUGIN_CALLBACK_ARG(method, arg) [RNAdCel deliverEventWithName:ToNSString(ADCEL_##method) data:ToNSString(arg)]
#define ADCEL_PLUGIN_CALLBACK_ERROR_ARG(method, arg) [RNAdCel deliverEventWithName:ToNSString(ADCEL_##method) data:ToNSString(arg)]

#define ADCEL_USE_C_EXTERN

#define ADCELSDK_PLUGIN_NAME (@"reactnative")
