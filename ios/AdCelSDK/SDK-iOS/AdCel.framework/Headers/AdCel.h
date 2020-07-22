//
//  AdCel.h
//  AdCel
//
//  Created by Vasiliy Matsnev on 03/05/2018.
//  Copyright © 2018 AdCel. All rights reserved.
//

#import <UIKit/UIKit.h>

//! Project version number for AdCel.
FOUNDATION_EXPORT double AdCelVersionNumber;

//! Project version string for AdCel.
FOUNDATION_EXPORT const unsigned char AdCelVersionString[];

#import <AdCel/AdCelSDK.h>
#import <AdCel/AdCelTargeting.h>
#import <AdCel/AdCelBaseView.h>
#import <AdCel/AdCelView.h>
#ifdef ADCEL_RTB_ONLY
#import <AdCel/AdCelInHouse.h>
#endif
