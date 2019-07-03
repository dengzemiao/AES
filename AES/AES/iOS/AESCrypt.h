//
//  AESCrypt.h
//  AES
//
//  Created by dengzemiao on 2019/7/3.
//  Copyright © 2019 DZM. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface AESCrypt : NSObject

+ (NSString *)encrypt_128:(NSString *)string key:(NSString *)key;

+ (NSString *)decrypt_128:(NSString *)base64EncodedString key:(NSString *)key;

@end

NS_ASSUME_NONNULL_END
