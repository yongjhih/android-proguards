## Google Play Services specific rules ##
## https://developer.android.com/google/play-services/setup.html#Proguard ##

-keep class com.google.android.gms.internal.** { *; }
-dontwarn com.google.android.gms.internal.**
