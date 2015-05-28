-keepattributes *Annotation*

-keep class com.parse.simple.** { *; }
-keep class * extends com.parse.simple.SimpleParseObject { *; }
-keepclasseswithmembers class * { @com.parse.simple.ParseColumn <fields>; }
