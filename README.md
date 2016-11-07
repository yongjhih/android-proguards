# android proguards

[![Android Weekly](https://img.shields.io/badge/Android%20Weekly-%23230-blue.svg)](http://androidweekly.net/issues/issue-230)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-android--proguards-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/4600)
[![JitPack](https://img.shields.io/github/tag/yongjhih/android-proguards.svg?label=JitPack)](https://jitpack.io/#yongjhih/android-proguards)
[![Build Status](https://travis-ci.org/yongjhih/android-proguards.svg)](https://travis-ci.org/yongjhih/android-proguards)

Use one line to apply almost famous libraries of proguard configurations:

`compile 'com.infstory:proguard-snippets:1.0.0'`

[![proguard-snippets.png](art/proguard-snippets.png)](art/proguard-snippets.png)

## Installation

via jcenter

```gradle
repositories {
    jcenter()

}

dependencies {
    compile 'com.infstory:proguard-snippets:1.0.0'
}
```

Or via jitpack.io

```gradle
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    compile 'com.github.yongjhih.android-proguards:android-proguards:-SNAPSHOT'
}
```

Specify RxJava proguard rules:

```gradle
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    compile 'io.reactivex:rxjava:1.2.1'
    compile 'com.github.yongjhih.android-proguards:rxjava-pro:-SNAPSHOT'
}
```

## Details

Pack proguard rules as `proguard.txt` into AAR with `consumeProguardFiles` android-gradle directive.

```sh
wget https://bintray.com/yongjhih/maven/download_file?file_path=com%2Finfstory%2Fproguard-snippets%2F1.0.0%2Fproguard-snippets-1.0.0.aar
mv proguard-snippets-1.0.0.aar a.zip
unzip a.zip
```

You can find out `proguard.txt`.

## See Also

* [krschultz/android-proguard-snippets](https://github.com/krschultz/android-proguard-snippets)

## Libraries

* [ACRA 4.5.0](https://github.com/ACRA/acra)
* [ActionBarSherlock 4.4.0](http://actionbarsherlock.com/)
* [ActiveAndroid](http://www.activeandroid.com/)
* [Adjust](https://github.com/adjust/android_sdk)
* [Amazon Web Services 1.6.x / 1.7.x](https://aws.amazon.com/releasenotes/Android/1855915734308772)
* [Amazon Web Services 2.1.x](https://github.com/aws/aws-sdk-android)
* [AndroidAnnotations](http://androidannotations.org/)
* [android-gif-drawable](https://github.com/koral--/android-gif-drawable)
* [Apache Avro](http://http://avro.apache.org/)
* [Alibaba Fastjson](https://github.com/alibaba/fastjson)
* [Butterknife 5.1.2](http://jakewharton.github.io/butterknife/)
* [Crashlytics 1.+ / 2.+](http://try.crashlytics.com/sdk-android/)
* [Crittercism](http://docs.crittercism.com/android/android.html)
* [EventBus 2.0.2](https://github.com/greenrobot/EventBus)
* [Facebook 3.2.0](https://developers.facebook.com/docs/android/)
* [Facebook Conceal](https://facebook.github.io/conceal/)
* [Facebook Stetho](https://facebook.github.io/stetho/)
* [Facebook Fresco](https://github.com/facebook/fresco)
* [Flurry 3.4.0](http://support.flurry.com/index.php?title=Analytics/Code/ReleaseNotes/Android)
* [Google Analytics 3.0+](https://developers.google.com/analytics/devguides/collection/android/v3/)
* [Google Guava](https://code.google.com/p/guava-libraries/)
* [Google Play Services 4.3.23](http://developer.android.com/google/play-services/setup.html)
* [GreenDao 1.3.x](http://greendao-orm.com/)
* [GSON 2.2.4](https://code.google.com/p/google-gson/)
* [Jackson 2.x](http://wiki.fasterxml.com/JacksonHome)
* [Joda-Convert 1.6](http://www.joda.org/joda-convert/)
* [Joda-Time 2.3](http://www.joda.org/joda-time/)
* [Jsoup](http://jsoup.org/)
* [LoganSquare](https://github.com/bluelinelabs/LoganSquare)
* [New Relic](https://docs.newrelic.com/docs/mobile-monitoring/mobile-sdk-api/new-relic-mobile-sdk-api/working-android-sdk-api)
* [Parse](https://parse.com/products/android)
* [Realm](http://realm.io/news/realm-for-android/)
* [RxJava 0.21](https://github.com/ReactiveX/RxJava/wiki/The-RxJava-Android-Module)
* [RxJava-Promises](https://github.com/darylteo/rxjava-promises)
* [Support Library v7](https://developer.android.com/tools/support-library/features.html#v7-appcompat)
* [Sqlite](http://www.sqlite.org/index.html)
* [Square Dagger](https://github.com/square/dagger)
* [Square OkHttp](http://square.github.io/okhttp/)
* [Square Okio](https://github.com/square/okio)
* [Square Otto](http://square.github.io/otto/)
* [Square Picasso](https://github.com/square/picasso)
* [Square Retrofit](http://square.github.io/retrofit/)
* [Square Wire](https://github.com/square/wire)
* [SVG Android](https://github.com/pents90/svg-android)
* [Icepick](https://github.com/frankiesardo/icepick)
* [Simple-Xml](http://simple.sourceforge.net/)
* [Tencent Bugly](http://bugly.qq.com/)

## Credit

* Krschultz: [krschultz/android-proguard-snippets](https://github.com/krschultz/android-proguard-snippets)

## License

```
Copyright 2015 8tory, Inc.
Copyright 2013 Kevin Schultz

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

