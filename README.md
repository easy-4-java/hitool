# hitool

[English](./README.md) | [简体中文](./README.zh-CN.md)

![Java](https://img.shields.io/badge/Java-17-orange) ![License](https://img.shields.io/badge/License-Apache%202.0-blue)

A common tools component (通用工具组件) — a multi-module Java utility toolkit covering core utilities, crypto, web, mail, FreeMarker helpers and LRC lyrics parsing.

## Table of Contents

- [1. Project Overview](#1-project-overview)
- [2. Features & Status](#2-features--status)
- [3. Requirements & Compatibility](#3-requirements--compatibility)
- [4. Architecture & Modules](#4-architecture--modules)
- [5. Installation](#5-installation)
- [6. Quick Start](#6-quick-start)
- [7. Configuration](#7-configuration)
- [8. Core Usage / API](#8-core-usage--api)
- [9. Testing & Build](#9-testing--build)
- [10. Versioning & Branches](#10-versioning--branches)
- [11. Contributing & License](#11-contributing--license)

## 1. Project Overview

`hitool` (project description: *An Common Tools Component*) is a multi-module Java utility toolkit. Each module is independently usable:

| Module | What it provides |
|:---|:---|
| `hitool-core` | Core utilities: lang3 (strings, numbers, money, UID, time, network, bundle, exceptions), beanutils (bean/property/result-set utilities and converters), collections, compress (zip/rar), net (+SSL), regexp, io, format (date/number) |
| `hitool-crypto` | Cryptography: digest utilities, symmetric/asymmetric/hash algorithm implementations (MD5, SHA, DES, DESede, AES, Hmac, IDEA, PBE, RSA, SM3, SMS4), encryptor/decryptor/verifier interfaces |
| `hitool-web` | Web utilities: cookies, URI components, multipart, remote address, servlet filters/listeners |
| `hitool-mail` | Mail: `JavaMailClient` abstraction with JavaMail, Apache Commons Email and Spring implementations |
| `hitool-freemarker` | FreeMarker helpers: configuration, model wrappers, loaders, formatting |
| `hitool-lrc4j` | LRC lyrics parsing (LRC / Lyrics models, time and ID handling) |

| What it is | What it is not |
|:---|:---|
| A general-purpose Java toolkit | A Spring Boot starter (auto-configuration lives in consuming projects) |
| Independent, reusable modules | A web framework |
| Apache 2.0 licensed | A commercial product |

Typical use cases:

| Use case | Module |
|:---|:---|
| String / number / money / UID utilities | `hitool-core` (`hitool.core.lang3`) |
| Bean copying, conversion and property access | `hitool-core` (`hitool.core.beanutils`) |
| Digest / symmetric / asymmetric crypto in Java | `hitool-crypto` |
| Cookie, multipart and URI handling in servlet apps | `hitool-web` |
| Sending text/MIME email | `hitool-mail` |
| Rendering FreeMarker templates with shared models | `hitool-freemarker` |
| Parsing LRC lyric files | `hitool-lrc4j` |

**Project status:** stable.

## 2. Features & Status

| Feature | Status | Notes |
|:---|:---|:---|
| `hitool-core` lang3 utilities | Available | `RandomStringUtils`, `NumberUtils`, `MoneyUtils`, `RmbString`, `SerializationUtils`, `StringEscapeUtils`, UID/time/network/bundle helpers |
| `hitool-core` beanutils | Available | `BeanConvertUtils`, `BeanPropertyCopyUtils`, `BeanPropertyUtils`, `BeanUtils`, `OgnlPropertyUtils`, `ResultSetUtils`, converter families (bean/map/collection/date/number/properties/request) |
| `hitool-core` collections/compress/net/regexp/io/format | Available | Commons-based utilities, zip/rar support, SSL helpers, date/number formatting |
| `hitool-crypto` | Available | `DigestUtils`, algorithm classes (`MD5Crypto`, `SHAHexCrypto`, `DESBase64Crypto`, `AESBase64Crypto`, `Hmac*`, `RSAPublicPrivateKeyAnalysis`, `SM3`, `SMS4`, ...), `StringEncryptor` / `BinaryEncryptor` / `Certificate*` / `File*` / `SecretKey*` interfaces |
| `hitool-web` | Available | `CookieUtils`, `URIComponents` / `URIUtils`, `MultipartContentUtils`, `RemoteAddrUtils`, servlet filters & listeners |
| `hitool-mail` | Available | `JavaMailClient` (sendText / sendMime / receive), `JavaMailClientImpl`, `CommonsMailClientImpl`, `SpringMailClientImpl`, `JavaMailKey` constants |
| `hitool-freemarker` | Available | `Configuration`, `ModelWrapper`, `ScopesHashModel`, loaders/cache/context |
| `hitool-lrc4j` | Available | `LRC`, `Lyrics`, `tar.time` / `tar.id` handling |
| Unit tests | Available | crypto tests (MD5/DES/RSA/DigestUtils), mail tests, lrc4j `LRCPlayTest` |
| CI pipeline | Not configured | No CI workflow files in the repository |

## 3. Requirements & Compatibility

| Requirement | Version |
|:---|:---|
| JDK | 8 |
| Maven | 3.0+ |
| Commons libraries | commons-lang3 / beanutils / io / compress / codec (per module) |
| Third-party | Bouncy Castle (`bcprov`), OGNL, junrar, jakarta-regexp, ORO (core); javax.mail / commons-email / spring-context-support (mail); freemarker / spring-core (freemarker); commons-fileupload2 / jakarta.servlet-api (web) |

### Version lines

| Branch | JDK | Version pattern |
|:---|:---|:---|
| `feature/1.0.x` | JDK 8 | `1.0.x.*` |
| `feature/2.0.x` | JDK 17 | `2.0.x.*` |
| `feature/3.0.x` | JDK 21 | `3.0.x.*` |

## 4. Architecture & Modules

```text
                 hitool (multi-module toolkit)
   ---------------------------------------------------------------
   hitool-core        hitool-crypto        hitool-web
   (lang3, beanutils, (digest, algorithm,  (cookie, URI, multipart,
    collections,       encryptor/decryptor  servlet filters,
    compress, net,     interfaces,          listeners)
    regexp, io,        keypair)
    format)
   ---------------------------------------------------------------
   hitool-mail        hitool-freemarker    hitool-lrc4j
   (JavaMailClient,   (Configuration,      (LRC / Lyrics,
    Commons/Spring     ModelWrapper,         tar time & id)
    implementations)   loaders, cache)
   ---------------------------------------------------------------
              consumed independently by applications
```

| Module | Responsibility |
|:---|:---|
| `hitool-core` | Common utilities (package `hitool.core.*`) |
| `hitool-crypto` | Crypto algorithms and encryptor/decryptor/verifier APIs (package `hitool.crypto.*`) |
| `hitool-web` | Servlet web utilities (package `hitool.web.*`) |
| `hitool-mail` | Mail client abstraction and implementations (package `hitool.mail.*`) |
| `hitool-freemarker` | FreeMarker integration helpers (package `hitool.freemarker.*`) |
| `hitool-lrc4j` | LRC lyrics parsing (package `hitool.lrc4j.*`) |

## 5. Installation

### Maven

Add the modules you need, e.g.:

```xml
<dependency>
    <groupId>io.github.easy4j</groupId>
    <artifactId>hitool-core</artifactId>
    <version>2.0.x.x.20260630-SNAPSHOT</version>
</dependency>
<dependency>
    <groupId>io.github.easy4j</groupId>
    <artifactId>hitool-crypto</artifactId>
    <version>2.0.x.x.20260630-SNAPSHOT</version>
</dependency>
```

### Gradle

```groovy
implementation 'io.github.easy4j:hitool-core:2.0.x.x.20260630-SNAPSHOT'
implementation 'io.github.easy4j:hitool-crypto:2.0.x.x.20260630-SNAPSHOT'
```

**Availability:** the artifacts are published to the Aliyun private Maven repository and distributed through GitHub Releases; they have not yet been published to Maven Central.

## 6. Quick Start

```java
import hitool.core.lang3.RandomStringUtils;
import hitool.crypto.algorithm.MD5HexCrypto;

// Core: random string helpers
String token = RandomStringUtils.randomMix(16);   // mixed-case alphanumeric

// Crypto: hex MD5 with verification
MD5HexCrypto md5 = MD5HexCrypto.getInstance();
String digest = md5.encode("hello");
boolean ok = md5.verify("hello", digest);          // true
```

Expected result: `token` is a 16-char mixed-case random string; `digest` is the 32-char hex MD5 of `"hello"` and `ok` is `true`.

## 7. Configuration

`hitool` is a plain library toolkit: modules are configured programmatically, no configuration files are read. Notable settings passed at runtime:

- `hitool-mail`: mail server parameters via `JavaMailKey` constants (`mail.host`, `mail.port`, `mail.user`, ...) and the `conf` package (`EmailBody`, `provider` / `provider.def`)
- `hitool-freemarker`: `Configuration` and engine settings via the `context` / `cache` packages
- `hitool-crypto`: algorithms and key pairs passed as constructor/argument parameters

## 8. Core Usage / API

### 8.1 Bean conversion (hitool-core)

```java
import hitool.core.beanutils.BeanConvertUtils;

// Convert a source bean to the target type via a registered converter
Target target = BeanConvertUtils.convert(SomeConverter.class, sourceBean, Target.class);
```

**Assumption:** converter classes follow the `hitool.core.beanutils.converters` package conventions; see the converters in that package for concrete implementations.

### 8.2 Digest utilities (hitool-crypto)

```java
import hitool.crypto.digest.DigestUtils;

byte[] md4 = DigestUtils.md4("source");      // raw MD4 digest
```

### 8.3 Mail client (hitool-mail)

`JavaMailClient` is the mail abstraction:

| Method | Description |
|:---|:---|
| `sendText(EmailBody email)` | Send a plain-text email |
| `sendMime(EmailBody email)` / `sendMime(InputStream email)` | Send a MIME email |
| `receive(String subject, String content, String sendTo)` | Receive operation |

Implementations: `JavaMailClientImpl` (JavaMail), `CommonsMailClientImpl` (Apache Commons Email), `SpringMailClientImpl` (Spring `org.springframework.mail`).

### 8.4 Key packages

| Package | Contents |
|:---|:---|
| `hitool.core.lang3` | `RandomStringUtils`, `NumberUtils`, `MoneyUtils`, `RmbString`, `SerializationUtils`, UID/network/time/bundle helpers |
| `hitool.core.beanutils` | `BeanConvertUtils`, `BeanPropertyCopyUtils`, `BeanUtils`, `OgnlPropertyUtils`, converters |
| `hitool.crypto.algorithm` | `MD5Crypto` / `MD5HexCrypto` / `MD5Base64Crypto`, `SHAHexCrypto`, `DESBase64Crypto`, `DESedeCrypto`, `AESBase64Crypto`, `HmacHexCrypto`, `IDEACrypto`, `PBECrypto`, `RIPEMDCrypto`, `SM3Digest`, `SMS4` and more |
| `hitool.web` | `CookieUtils`, `URIComponents` / `URIComponentsBuilder`, `MultipartContentUtils`, `RemoteAddrUtils` |

## 9. Testing & Build

```bash
./mvnw clean verify        # build all modules, run tests, generate coverage report
./mvnw clean install       # install all modules into the local repository
```

- Test sources exist for `hitool-crypto` (e.g. `MD5Base64CryptoTest`, `RSAHexCrypto_Test`, `DigestUtils_Test`), `hitool-mail` (e.g. `JavaMailClientTest`, `SendMailTest`, `CommonsMailClientTest`) and `hitool-lrc4j` (`LRCPlayTest`).
- Coverage is measured with the JaCoCo Maven plugin (target: 90% line coverage, `haltOnFailure=false`).
- The `release` profile assembles GPG signing + sources + Javadoc + deployment (`./mvnw -Prelease clean deploy`).

## 10. Versioning & Branches

Three parallel version lines are maintained:

| Branch | JDK | Version pattern |
|:---|:---|:---|
| `feature/1.0.x` | JDK 8 | `1.0.x.*` |
| `feature/2.0.x` | JDK 17 | `2.0.x.*` |
| `feature/3.0.x` | JDK 21 | `3.0.x.*` |

Maintenance strategy: the 1.0.x line receives bug fixes while JDK 8 remains the baseline; feature development primarily targets the 2.0.x / 3.0.x lines.

## 11. Contributing & License

Contributions are welcome — open an issue or submit a pull request against the matching version-line branch (`feature/2.0.x` for JDK 17 changes).

This project is licensed under the [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0). See the `LICENSE` file in the repository root for details.
