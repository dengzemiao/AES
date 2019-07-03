//
//  NSData+AES128.h
//  AES
//
//  Created by dengzemiao on 2019/7/3.
//  Copyright © 2019 DZM. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface NSData (AES128)

- (NSData *)AES128EncryptedDataWithKey:(NSString *)key;

- (NSData *)AES128DecryptedDataWithKey:(NSString *)key;

- (NSData *)AES128EncryptedDataWithKey:(NSString *)key iv:(NSString *)iv;

- (NSData *)AES128DecryptedDataWithKey:(NSString *)key iv:(NSString *)iv;

@end

NS_ASSUME_NONNULL_END
