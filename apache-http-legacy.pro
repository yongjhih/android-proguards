# ref. http://stackoverflow.com/a/32303296

#-keep class org.apache.http.** { *; }
-keep class org.apache.http.** { *; }
-keep class org.apache.commons.codec.** { *; }
-keep class org.apache.commons.logging.** { *; }

-dontwarn org.apache.http.**

#-keep class android.net.compatibility.** { *; }
#-keep class android.net.http.** { *; }
