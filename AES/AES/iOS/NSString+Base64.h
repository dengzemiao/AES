//
//  NSString+Base64.h
//  AES
//
//  Created by dengzemiao on 2019/7/3.
//  Copyright © 2019 DZM. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface NSString (Base64)

+ (NSString *)base64StringFromData:(NSData *)data;

+ (NSString *)base64StringFromData:(NSData *)data length:(NSUInteger)length;

@end

NS_ASSUME_NONNULL_END
