## Note-App

🗒️ Simple Note App helps to to create your notes. You can 📝 edit and ❌ delete notes too. App respects its Mvvm architecture. Android Architecture Components Part of Android Jetpack. Android architecture components are a collection of libraries that help you design robust, testable, and maintainable apps.

 Made in Kotlin

Features

- Add Notes
- Delete Notes
- Update Notes

## Architecture
MVVM is one of the architectural patterns which enhances separation of concerns, it allows separating the user interface logic from the business (or the back-end) logic. Its target (with other MVC patterns goal) is to achieve the following principle “Keeping UI code simple and free of app logic in order to make it easier to manage”.

Lifecycles: It manages activity and fragment lifecycles of our app, survives configuration changes, avoids memory leaks and easily loads data into our UI.
LiveData: It notifies views of any database changes. Use LiveData to build data objects that notify views when the underlying database changes.
Room: It is a SQLite object mapping library. Use it to Avoid boilerplate code and easily convert SQLite table data to Java objects. Room provides compile time checks of SQLite statements and can return RxJava, Flowable and LiveData observables.
ViewModel: It manages UI-related data in a lifecycle-conscious way. It stores UI-related data that isn't destroyed on app rotations.
Repository: The repository depends on a persistent data model and a remote backend data source.

<img src="https://developer.android.com/topic/libraries/architecture/images/final-architecture.png"/>

## Library use

- JetPack Navigation
- Roomdatabase
- Coroutines
- Safe Args
- Live Model
- ViewModel
