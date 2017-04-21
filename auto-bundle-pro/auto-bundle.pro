# ref. https://github.com/yatatsu/AutoBundle/blob/master/autobundle/autobundle-proguard-rules.pro

-keep class **AutoBundle { *; }
-keep class com.yatatsu.autobundle.** { *; }
-keepclasseswithmembers class * {
    @com.yatatsu.autobundle.* <fields>;
}

-dontwarn com.yatatsu.autobundle.**
