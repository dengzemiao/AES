# AES

项目内含:  iOS_AES_128,  Android_AES_128 两平台加密文件, 基于 AES 的ECB模式,选用了 zeropadding 填充,数据位为 128位

***

#### iOS

```
NSString *key = @"DZM";

NSString *string = @"DZM_TEST";

NSString *encrypt_128_base64String = [AESCrypt encrypt_128:string key:key];

NSLog(@"AES128加密之后: %@", encrypt_128_base64String);

NSString *decrypt_128_string = [AESCrypt decrypt_128:encrypt_128_base64String key:key];

NSLog(@"AES128解密之后: %@", decrypt_128_string);

```
