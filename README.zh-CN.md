# hitool

[English](./README.md) | [简体中文](./README.zh-CN.md)

[![Java](https://img.shields.io/badge/Java-8-orange)](https://github.com/easy-4-java/hitool) [![License](https://img.shields.io/badge/license-Apache%202.0-green)](./LICENSE)

通用工具组件（An Common Tools Component）— 多模块 Java 工具集，涵盖核心工具、加密、Web、邮件、FreeMarker 辅助与 LRC 歌词解析。

## 目录

- [1. 项目概览](#1-项目概览)
- [2. 功能与状态](#2-features--status)
- [3. 环境要求与兼容性](#3-requirements--compatibility)
- [4. 架构与模块](#4-architecture--modules)
- [5. 安装](#5-installation)
- [6. 快速开始](#6-quick-start)
- [7. 配置](#7-configuration)
- [8. 核心用法 / API](#8-core-usage--api)
- [9. 测试与构建](#9-testing--build)
- [10. 版本线与分支](#10-versioning--branches)
- [11. 参与贡献与许可协议](#11-contributing--license)

## 1. 项目概览

`hitool`（项目描述：*An Common Tools Component*）是一个多模块 Java 工具集，各模块可独立使用：

| 模块 | 提供内容 |
|:---|:---|
| `hitool-core` | 核心工具：lang3（字符串、数字、金额、UID、时间、网络、bundle、异常）、beanutils（Bean/属性/ResultSet 工具与转换器）、collections、compress（zip/rar）、net（+SSL）、regexp、io、format（日期/数字） |
| `hitool-crypto` | 加密：摘要工具、对称/非对称/散列算法实现（MD5、SHA、DES、DESede、AES、Hmac、IDEA、PBE、RSA、SM3、SMS4）、加解密/验签接口 |
| `hitool-web` | Web 工具：Cookie、URI 组件、multipart、远程地址、Servlet 过滤器/监听器 |
| `hitool-mail` | 邮件：`JavaMailClient` 抽象，提供 JavaMail、Apache Commons Email 与 Spring 实现 |
| `hitool-freemarker` | FreeMarker 辅助：配置、模型包装、加载器、格式化 |
| `hitool-lrc4j` | LRC 歌词解析（LRC / Lyrics 模型、时间与 ID 处理） |

| 是什么 | 不是什么 |
|:---|:---|
| 通用 Java 工具集 | Spring Boot Starter（自动配置由使用方应用负责） |
| 独立、可复用的模块 | Web 框架 |
| Apache 2.0 许可 | 商业产品 |

典型使用场景：

| 场景 | 模块 |
|:---|:---|
| 字符串 / 数字 / 金额 / UID 工具 | `hitool-core`（`hitool.core.lang3`） |
| Bean 复制、转换与属性访问 | `hitool-core`（`hitool.core.beanutils`） |
| Java 中的摘要 / 对称 / 非对称加密 | `hitool-crypto` |
| Servlet 应用中的 Cookie、multipart、URI 处理 | `hitool-web` |
| 发送文本 / MIME 邮件 | `hitool-mail` |
| 使用共享模型渲染 FreeMarker 模板 | `hitool-freemarker` |
| 解析 LRC 歌词文件 | `hitool-lrc4j` |

**项目状态：** 稳定。

<a id="2-features--status"></a>
## 2. 功能与状态

| 能力 | 状态 | 说明 |
|:---|:---|:---|
| `hitool-core` lang3 工具 | 可用 | `RandomStringUtils`、`NumberUtils`、`MoneyUtils`、`RmbString`、`SerializationUtils`、`StringEscapeUtils`、UID/时间/网络/bundle 辅助 |
| `hitool-core` beanutils | 可用 | `BeanConvertUtils`、`BeanPropertyCopyUtils`、`BeanPropertyUtils`、`BeanUtils`、`OgnlPropertyUtils`、`ResultSetUtils`、转换器族（bean/map/collection/date/number/properties/request） |
| `hitool-core` collections/compress/net/regexp/io/format | 可用 | 基于 Commons 的工具、zip/rar 支持、SSL 辅助、日期/数字格式化 |
| `hitool-crypto` | 可用 | `DigestUtils`、算法类（`MD5Crypto`、`SHAHexCrypto`、`DESBase64Crypto`、`AESBase64Crypto`、`Hmac*`、`RSAPublicPrivateKeyAnalysis`、`SM3`、`SMS4` 等）、`StringEncryptor` / `BinaryEncryptor` / `Certificate*` / `File*` / `SecretKey*` 接口 |
| `hitool-web` | 可用 | `CookieUtils`、`URIComponents` / `URIUtils`、`MultipartContentUtils`、`RemoteAddrUtils`、Servlet 过滤器与监听器 |
| `hitool-mail` | 可用 | `JavaMailClient`（sendText / sendMime / receive）、`JavaMailClientImpl`、`CommonsMailClientImpl`、`SpringMailClientImpl`、`JavaMailKey` 常量 |
| `hitool-freemarker` | 可用 | `Configuration`、`ModelWrapper`、`ScopesHashModel`、加载器/缓存/上下文 |
| `hitool-lrc4j` | 可用 | `LRC`、`Lyrics`、`tar.time` / `tar.id` 处理 |
| 单元测试 | 可用 | 加密测试（MD5/DES/RSA/DigestUtils）、邮件测试、lrc4j `LRCPlayTest` |
| CI 流水线 | 未配置 | 仓库中无 CI 工作流文件 |

<a id="3-requirements--compatibility"></a>
## 3. 环境要求与兼容性

| 依赖项 | 版本 |
|:---|:---|
| JDK | 8 |
| Maven | 3.0+ |
| Commons 库 | commons-lang3 / beanutils / io / compress / codec（按模块） |
| 第三方 | Bouncy Castle（`bcprov`）、OGNL、junrar、jakarta-regexp、ORO（core）；javax.mail / commons-email / spring-context-support（mail）；freemarker / spring-core（freemarker）；commons-fileupload2 / jakarta.servlet-api（web） |

### 版本线矩阵

| 分支 | JDK | 版本号模式 |
|:---|:---|:---|
| `feature/1.0.x` | JDK 8 | `1.0.x.*` |
| `feature/2.0.x` | JDK 17 | `2.0.x.*` |
| `feature/3.0.x` | JDK 21 | `3.0.x.*` |

<a id="4-architecture--modules"></a>
## 4. 架构与模块

```text
                 hitool（多模块工具集）
   ---------------------------------------------------------------
   hitool-core        hitool-crypto        hitool-web
   （lang3、beanutils、（摘要、算法、         （cookie、URI、multipart、
    collections、      加解密/验签接口、      servlet 过滤器、
    compress、net、     keypair）             监听器）
    regexp、io、
    format）
   ---------------------------------------------------------------
   hitool-mail        hitool-freemarker    hitool-lrc4j
   （JavaMailClient、  （Configuration、     （LRC / Lyrics、
    Commons/Spring     ModelWrapper、        tar 时间与 ID）
    实现）             加载器、缓存）
   ---------------------------------------------------------------
              由应用按需独立引用
```

| 模块 | 职责 |
|:---|:---|
| `hitool-core` | 通用工具（包 `hitool.core.*`） |
| `hitool-crypto` | 加密算法与加解密/验签 API（包 `hitool.crypto.*`） |
| `hitool-web` | Servlet Web 工具（包 `hitool.web.*`） |
| `hitool-mail` | 邮件客户端抽象与实现（包 `hitool.mail.*`） |
| `hitool-freemarker` | FreeMarker 集成辅助（包 `hitool.freemarker.*`） |
| `hitool-lrc4j` | LRC 歌词解析（包 `hitool.lrc4j.*`） |

<a id="5-installation"></a>
## 5. 安装

### Maven

按需引入模块，例如：

```xml
<dependency>
    <groupId>io.github.easy4j</groupId>
    <artifactId>hitool-core</artifactId>
    <version>1.0.x.20260630-SNAPSHOT</version>
</dependency>
<dependency>
    <groupId>io.github.easy4j</groupId>
    <artifactId>hitool-crypto</artifactId>
    <version>1.0.x.20260630-SNAPSHOT</version>
</dependency>
```

### Gradle

```groovy
implementation 'io.github.easy4j:hitool-core:1.0.x.20260630-SNAPSHOT'
implementation 'io.github.easy4j:hitool-crypto:1.0.x.20260630-SNAPSHOT'
```

**可用性：** 构件发布至阿里云私有 Maven 仓库，并通过 GitHub Releases 分发；尚未发布到 Maven Central。

<a id="6-quick-start"></a>
## 6. 快速开始

```java
import hitool.core.lang3.RandomStringUtils;
import hitool.crypto.algorithm.MD5HexCrypto;

// 核心：随机字符串工具
String token = RandomStringUtils.randomMix(16);   // 混合大小写字母数字

// 加密：十六进制 MD5 与校验
MD5HexCrypto md5 = MD5HexCrypto.getInstance();
String digest = md5.encode("hello");
boolean ok = md5.verify("hello", digest);          // true
```

预期结果：`token` 为 16 位混合大小写随机字符串；`digest` 为 `"hello"` 的 32 位十六进制 MD5，`ok` 为 `true`。

<a id="7-configuration"></a>
## 7. 配置

`hitool` 为纯工具库：各模块以编程方式配置，不读取任何配置文件。常见运行时参数：

- `hitool-mail`：通过 `JavaMailKey` 常量（`mail.host`、`mail.port`、`mail.user` 等）与 `conf` 包（`EmailBody`、`provider` / `provider.def`）传入邮件服务器参数
- `hitool-freemarker`：通过 `context` / `cache` 包传入 `Configuration` 与引擎设置
- `hitool-crypto`：算法与密钥对作为构造/方法参数传入

<a id="8-core-usage--api"></a>
## 8. 核心用法 / API

### 8.1 Bean 转换（hitool-core）

```java
import hitool.core.beanutils.BeanConvertUtils;

// 通过注册的转换器将源 Bean 转换为目标类型
Target target = BeanConvertUtils.convert(SomeConverter.class, sourceBean, Target.class);
```

**假设：** 转换器类遵循 `hitool.core.beanutils.converters` 包约定；具体实现请参见该包内的转换器。

### 8.2 摘要工具（hitool-crypto）

```java
import hitool.crypto.digest.DigestUtils;

byte[] md4 = DigestUtils.md4("source");      // 原始 MD4 摘要
```

### 8.3 邮件客户端（hitool-mail）

`JavaMailClient` 是邮件抽象：

| 方法 | 说明 |
|:---|:---|
| `sendText(EmailBody email)` | 发送纯文本邮件 |
| `sendMime(EmailBody email)` / `sendMime(InputStream email)` | 发送 MIME 邮件 |
| `receive(String subject, String content, String sendTo)` | 接收操作 |

实现类：`JavaMailClientImpl`（JavaMail）、`CommonsMailClientImpl`（Apache Commons Email）、`SpringMailClientImpl`（Spring `org.springframework.mail`）。

### 8.4 关键包

| 包 | 内容 |
|:---|:---|
| `hitool.core.lang3` | `RandomStringUtils`、`NumberUtils`、`MoneyUtils`、`RmbString`、`SerializationUtils`、UID/网络/时间/bundle 辅助 |
| `hitool.core.beanutils` | `BeanConvertUtils`、`BeanPropertyCopyUtils`、`BeanUtils`、`OgnlPropertyUtils`、转换器 |
| `hitool.crypto.algorithm` | `MD5Crypto` / `MD5HexCrypto` / `MD5Base64Crypto`、`SHAHexCrypto`、`DESBase64Crypto`、`DESedeCrypto`、`AESBase64Crypto`、`HmacHexCrypto`、`IDEACrypto`、`PBECrypto`、`RIPEMDCrypto`、`SM3Digest`、`SMS4` 等 |
| `hitool.web` | `CookieUtils`、`URIComponents` / `URIComponentsBuilder`、`MultipartContentUtils`、`RemoteAddrUtils` |

<a id="9-testing--build"></a>
## 9. 测试与构建

```bash
./mvnw clean verify        # 构建全部模块、运行测试、生成覆盖率报告
./mvnw clean install       # 安装全部模块到本地仓库
```

- 测试源码位于 `hitool-crypto`（如 `MD5Base64CryptoTest`、`RSAHexCrypto_Test`、`DigestUtils_Test`）、`hitool-mail`（如 `JavaMailClientTest`、`SendMailTest`、`CommonsMailClientTest`）与 `hitool-lrc4j`（`LRCPlayTest`）。
- 覆盖率由 JaCoCo Maven 插件度量（目标：90% 行覆盖率，`haltOnFailure=false`）。
- `release` profile 组装 GPG 签名 + 源码 + Javadoc + 部署（`./mvnw -Prelease clean deploy`）。

<a id="10-versioning--branches"></a>
## 10. 版本线与分支

仓库维护三条并行版本线：

| 分支 | JDK | 版本号模式 |
|:---|:---|:---|
| `feature/1.0.x` | JDK 8 | `1.0.x.*` |
| `feature/2.0.x` | JDK 17 | `2.0.x.*` |
| `feature/3.0.x` | JDK 21 | `3.0.x.*` |

维护策略：在 JDK 8 作为基线的同时，1.0.x 版本线接收缺陷修复；新功能开发主要面向 2.0.x / 3.0.x 版本线。

<a id="11-contributing--license"></a>
## 11. 参与贡献与许可协议

欢迎参与贡献——请通过 Issue 反馈问题，或向对应版本线分支提交 Pull Request（JDK 8 相关改动提交到 `feature/1.0.x`）。

本项目基于 [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0) 许可发布。详见仓库根目录的 `LICENSE` 文件。
