# CatLike

The main view of the application is a list view of cat images. If the user touches an image, it shows a detail. In the detail of each image, the user can indicate if the image is liked. In the Likes menu, a list of favorite images is displayed.

# Strategy
If there is an internet connection, the data sorted by date is captured from the API using Flows, OkHttp3, Retrofit, and Gson. They are then saved to a local database using Room. 
The view is only loaded with data from the local database. If there is no internet connection, the local database data is displayed directly, without attempting to fetch the data from the API.

For navigation between fragments, graphic navigation is used. More info at: https://developer.android.com/guide/navigation/navigation-design-graph?hl=es

To pass information between the fragments a sharedViewModel is used. More info at: https://developer.android.com/topic/libraries/architecture/viewmodel#sharing

For simplicity, Dagger Hilt has been used for dependency injection. More info at: https://developer.android.com/training/dependency-injection/hilt-android?hl=es-419

# Requirements
kotlin version = "1.4.10"

In your gradle:
  - minSdkVersion 23
  - targetSdkVersion 30

# Features
  - Clean Architecture 
  - MVVM
  - Flows
  - Dagger Hilt
  - Room 
  - Retrofit
  - OkHttp3
  - Coroutines
