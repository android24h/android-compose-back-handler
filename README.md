# Android Double Back Press to Exit (Jetpack Compose)

A clean, reusable, and lifecycle-aware **Double Back Press to Exit** implementation using **Jetpack Compose**.

This snippet demonstrates how to properly handle the system back button in a Compose-based Android app without relying on deprecated APIs.

---

## ✨ Features

- Built with **Jetpack Compose**
- Uses `BackHandler` (non-deprecated)
- Lifecycle-aware
- Configurable exit delay
- Simple and reusable composable
- Prevents accidental app exit

---

## 📌 Use Case

This pattern is commonly used when you want the user to:
- Press back once → see a hint (Toast)
- Press back again within a short time → exit the app

Typical scenarios:
- Home screen of an app
- Root destination in navigation

---

## 🧩 Implementation

```kotlin
@Composable
fun DoubleBackToExitHandler(
    exitDelay: Long = 2000L
) {
    val context = LocalContext.current
    var lastBackPressTime by remember { mutableStateOf(0L) }

    BackHandler {
        val currentTime = SystemClock.elapsedRealtime()

        if (currentTime - lastBackPressTime < exitDelay) {
            (context as? Activity)?.finish()
        } else {
            lastBackPressTime = currentTime
            Toast.makeText(
                context,
                "Press back again to exit",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
```

---

## 🚀 Usage

Call this composable inside any screen where you want to enable double back press behavior:

```kotlin
@Composable
fun HomeScreen() {
    DoubleBackToExitHandler()

    // Screen UI
}
```

To customize the delay:

```kotlin
DoubleBackToExitHandler(exitDelay = 3000L)
```

---

## ⚙️ Why This Approach?

- Avoids deprecated `onBackPressed()`
- Works seamlessly with Compose navigation
- Easy to configure and reuse across screens
- Aligns with modern Android development best practices

---

## 🛠 Tech Stack

- Kotlin
- Jetpack Compose
- Android BackHandler API

---

## 📄 License

MIT License
