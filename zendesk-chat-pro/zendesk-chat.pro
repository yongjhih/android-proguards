# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in ${sdk.dir}/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# We only want obfuscation
-keepattributes InnerClasses,Signature,Annotation,EnclosingMethod

# Chat sdk
-keep public interface com.zopim.android.** { *; }
-keep public class com.zopim.android.** { *; }

# OKHttp
-dontwarn com.squareup.okhttp.**

# Belvedere image picker
-keep public interface com.zendesk.belvedere.** { *; }
-keep public class com.zendesk.belvedere.** { *; }

# Jackson
-keep public interface com.fasterxml.jackson.** { *; }
-keep public class com.fasterxml.jackson.** { *; }
-dontwarn org.w3c.dom.bootstrap.DOMImplementationRegistry

# Appcompat and support
-keep interface android.support.v7.** { *; }
-keep class android.support.v7.** { *; }

-dontwarn android.app.Notification
