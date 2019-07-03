//
//  AESCrypt.m
//  AES
//
//  Created by dengzemiao on 2019/7/3.
//  Copyright © 2019 DZM. All rights reserved.
//

#import "AESCrypt.h"
#import "NSData+AES128.h"
#import "NSData+Base64.h"
#import "NSString+Base64.h"

@implementation AESCrypt

+ (NSString *)encrypt_128:(NSString *)string key:(NSString *)key {
    
    NSData *encryptedData = [[string dataUsingEncoding:NSUTF8StringEncoding] AES128EncryptedDataWithKey:key];
    
    NSString *base64EncodedString = [NSString base64StringFromData:encryptedData];
    
    return base64EncodedString;
}

+ (NSString *)decrypt_128:(NSString *)base64EncodedString key:(NSString *)key {
    
    NSData *encryptedData = [NSData base64DataFromString:base64EncodedString];
    
    NSData *decryptedData = [encryptedData AES128DecryptedDataWithKey:key];
    
    return [[NSString alloc] initWithData:decryptedData encoding:NSUTF8StringEncoding];
}

@end
