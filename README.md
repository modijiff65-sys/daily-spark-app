# Daily Spark

A tiny, offline motivational-quote Android app. Tap **New Quote** for a fresh spark.

- Kotlin, plain Android Views (Material 3)
- No permissions, works fully offline
- Debug APK is built automatically by GitHub Actions on every push to `main`

## Get the APK

Open the **Releases** tab and download `app-debug.apk`, or grab it from the latest
Actions run's artifacts. Install it on any Android 7.0+ (API 24) device.

## Build locally

```
./gradlew assembleDebug
```

The APK lands in `app/build/outputs/apk/debug/app-debug.apk`.
