//
//  ViewController.m
//  AES
//
//  Created by dengzemiao on 2019/7/3.
//  Copyright © 2019 DZM. All rights reserved.
//

#import "ViewController.h"
#import "AESCrypt.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    
    [super viewDidLoad];
    
    /// 可用网页加密工具对调: http://tool.chacuo.net/cryptaes
    /// 文件夹内含 安卓AES128 加密文件
    /// 安卓AES128加密源文件下载地址(我这里直接帮忙下载好了): https://download.csdn.net/download/qq_30180491/10796331
    
    NSString *key = @"DZM";
    
    NSString *string = @"DZM_TEST";
    
    NSString *encrypt_128_base64String = [AESCrypt encrypt_128:string key:key];

    NSLog(@"AES128加密之后: %@", encrypt_128_base64String);
    
    NSString *decrypt_128_string = [AESCrypt decrypt_128:encrypt_128_base64String key:key];
    
    NSLog(@"AES128解密之后: %@", decrypt_128_string);
}

@end
