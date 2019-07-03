//
//  NSData+Base64.h
//  AES
//
//  Created by dengzemiao on 2019/7/3.
//  Copyright © 2019 DZM. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface NSData (Base64)

+ (NSData *)base64DataFromString:(NSString *)string;

@end

NS_ASSUME_NONNULL_END
