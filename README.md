# 最低jdk版本

* JDK 11

# springboot基础工具包

```

├── LICENSE                                                 #    版权协议
├── README.md                                               #    项目描述文件
├── CHANGELOG.md                                            #    版本发布日志
│
│
├── core-dependencies                                       #├── 基础核心模块
│   ├── core-common                                          │   ├── 基础实体、接口定义
│   └── core-exception                                       └───└── 通用异常、异常接口定义
│
│
├── project-dependencies                                    #    业务项目父pom文件模块
│
│
├── utils-dependencies                                      #├── 工具类模块
│   ├── util-compression                                     │   ├── 解压缩
│   ├── util-constant                                        │   ├── 常量池                      
│   ├── util-cryto                                           │   ├── 加解密
│   ├── util-event                                           │   ├── 进程内事件模型
│   ├── util-executor                                        │   ├── 线程池
│   ├── util-extra                                           │   ├── Emoji、FTP、二维码、邮件、图片验证码
│   ├── util-http                                            │   ├── http客户端：JDKHTTPClient、OKHttpClient
│   ├── util-media                                           │   ├── 视频处理、图片处理、文件识别
│   ├── util-serialization                                   │   ├── 序列化：json、gson、protostuff
│   ├── util-setting                                         │   ├── 属性文件处理
│   ├── util-stress                                          │   ├── 本地压力测试包
│   ├── util-system                                          │   ├── IP检测、端口检测、系统参数获取、脚本运行
│   └── util-value                                           └───└── 值处理：bean、string、array、collection、number、date、object、lambda、reflect、stream、assert
│
│
│
├── starters-dependencies                                   #├── starter自动配置模块
│   ├── starter-annotation                                   │   ├── 通用自定义注解
│   ├── starter-feign-protostuff                             │   ├── feign的http2和protobuf支持
│   ├── starter-ftp                                          │   ├── ftp服务自动配置
│   ├── starter-id                                           │   ├── id服务自动配置
│   ├── starter-port-shift                                   │   ├── 端口自动偏移
│   ├── starter-redis                                        │   ├── redis封装方法服务自动配置
│   ├── starter-spring-support                               │   ├── spring通用支持方法
│   └── starter-web                                          └───└── 统一返回值、异常处理
│
│
│
│
└── pom.xml                                                 #    依赖包、协议、署名等管理

```

# 常用可用类库版本

* springBoot 2.6.6
* springCloud 2021.0.1
* springCloudAlibaba 2021.0.1.0
* log4j 2.17.2
* lombok 1.8.22
* mybatis 3.5.9
* mybatis-plus 3.5.1
* mybatis-fluent 1.9.5
* druid 1.2.9
* hutool 5.8.0.M2
* fastjson 1.2.80
* dubbo 3.0.7
* protostuff 1.8.0
* lettuce 6.1.8.RELEASE
* jedis 4.2.2
* morphia 2.2.6
* javacv 1.5.7
* ...