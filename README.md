# MVVM, Room and Dagger Hilt

## Hi! This project is the sample for the beginner who wanna try `MVVM` pattern. Which is popular ones for Android Development.

### 1. MVVM stands for `Model`, `View`, `ViewModel`.

`Model:` ***This holds the data of the application. It cannot directly talk to the View. Generally, 
it’s recommended to expose the data to the ViewModel through Observables.***

`View:` ***It represents the UI of the application devoid of any Application Logic. It observes the ViewModel.***

`ViewModel:` ***It acts as a link between the Model and the View. It’s responsible for transforming the data from the Model. 
It provides data streams to the View. It also uses hooks or callbacks to update the View. It’ll ask for the data from the Model.***


### 2. Room
***Room is now considered as a better approach for data persistence than SQLiteDatabase. 
It makes it easier to work with SQLiteDatabase objects in your app, decreasing the amount of boilerplate code and verifying SQL queries at compile time.***

### 3. Dagger Hilt
***Hilt is built on top of the popular DI ([Dependency injection](https://developer.android.com/training/dependency-injection)) library Dagger so benefits from the compile time correctness, runtime performance, scalability, 
and Android Studio support that Dagger provides. Due to this, Dagger’s seen great adoption on 30% of top 10k apps of the Google Play Store. 
However, because of the compile time code generation, expect a build time increase.***


