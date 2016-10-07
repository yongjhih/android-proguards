-dontwarn javax.annotation.**
-dontwarn javax.lang.model.**
-dontwarn javax.tools.**
-dontwarn sun.misc.**
-dontwarn com.google.auto.**
#-dontwarn dagger.internal.**
-dontwarn com.google.common.**
#-dontwarn com.google.common.cache.**
#-dontwarn com.google.common.primitives.**

#-keep class dagger.internal.** { *; }
-keep class com.google.common.** { *; }
-keepclassmembers class * implements javax.annotation.processing.ProcessingEnvironment { *; }
-keepclassmembers interface javax.annotation.processing.ProcessingEnvironment { *; }
