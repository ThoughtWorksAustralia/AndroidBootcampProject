AndroidBootcampProject
======================

## Objectives
To teach Java programmers the basics of Android development using Agile best practices, by incrementally developing a small game over a period of six weeks.

## The App: Treasure Hunt
A single player game. The app supplies a list of photos of 'treasures' in your local area, with hints on how to find them. Your job is to run (or stroll) around the area to find each treasure and take a photo of it. Points are awarded according to how many treasures you can locate, how long you take, and how close you were to the original photo location.

## Pre-Bootcamp Preparation

Follow these setup steps before your first session:

1. Install [Java SE SDK 7](http://www.oracle.com/technetwork/java/javase/downloads/index.html) if you don't have it
1. Install [Git](http://git-scm.com/book/en/Getting-Started-Installing-Git) if you don't have it 
1. Download and install [Android Studio](http://tools.android.com/download/studio/canary)
1. Create a directory called AndroidStudioProjects. Change to that directory. At the command line, type
```git clone https://github.com/ThoughtWorksAustralia/AndroidBootcampProject.git```
1. If you previously had a version of Android installed on your machine, you may need to use Android's [SDK manager](http://developer.android.com/tools/help/sdk-manager.html) to install Build Tools v19.
1. (Optional) Download and install [Genymotion](https://cloud.genymotion.com/page/launchpad/download/)
  1. Create an account on the [Genymotion cloud](https://cloud.genymotion.com/page/customer/login/)
  1. (Mac only) Download and install [VirtualBox](https://www.virtualbox.org/wiki/Downloads)
  1. Download and install Genymotion and Genymotion Shell
  1. Install the Genymotion plugin for Android Studio:
    1. Android Studio > Preferences > Plugins
    1. Browse Repositories
    1. Search for Genymotion
    1. Choose Download and Install from the context menu
  1. Open the Genymotion app and create a new virtual device



## Week 1: Hello Android
###Prerequisites:
In the Android Bootcamp directory you set up earlier, do:   
```
git stash
git checkout start-week-1
```

  
###Goals: 
 * Develop a working "hello world" app and explore its anatomy.
 * Allow the user to enter their name.
 
###Material:  
[View the Presentation](http://prezi.com/jibn_vzm9rml/?utm_campaign=share&utm_medium=copy)  
[Exercise 1: Explore the Lifecycle](https://github.com/macosgrove/AndroidBootcampProject/commit/bd381649f0981bc9d74b90af2389acc364f16914)  
[Exercise 2: Create a Second Activity Part 1](https://github.com/macosgrove/AndroidBootcampProject/commit/f794de4638037308e2100b5bf73043df89540231),
[Part 2](https://github.com/macosgrove/AndroidBootcampProject/commit/173f178c6a933500e047120ce2f94b8046d927a7)  
[Exercise 3: Capture the Player's Name](https://github.com/macosgrove/AndroidBootcampProject/commit/1716a164608a5710869d36562379d0203dfc2b64)  
[Exercise 4: Keep the game state safe](https://github.com/macosgrove/AndroidBootcampProject/commit/50e7ab9107659897a733298e2504c14578ba85c9),
[Optional extra](https://github.com/macosgrove/AndroidBootcampProject/commit/2059476941cedb19db271ee68140b844a7404998)  

### Resources
[Android Developers site](http://developer.android.com/develop/index.html)  
[The Busy Coder's Guide to Android Development](http://commonsware.com/Android/)  
[Saving and retrieving instance state](http://www.intertech.com/Blog/saving-and-retrieving-android-instance-state-part-1/)  
[Parcelable vs Serializable](http://www.developerphil.com/parcelable-vs-serializable/)  
[Genymotion Users Guide](https://cloud.genymotion.com/page/doc/)  
[Better performance with the Android emulator](http://stackoverflow.com/questions/2662650/making-the-android-emulator-run-faster)  
[Gradle](http://www.gradle.org/)  

## Week 2: BDD with Android
###Prerequisites:
In the Android Bootcamp directory you set up earlier, do:    
```
git stash
git checkout start-week-2
```

###Goals: 
 * Add a framework for behaviour driven development including a unit test and a functional test
 * Allow the user to view treasures, high scores, and a map page.  

###Material:  
[View the Presentation](http://prezi.com/78y82u9ld2yy/?utm_campaign=share&utm_medium=copy)  
[Exercise 1: Create a failing instrument test](https://github.com/macosgrove/AndroidBootcampProject/commit/9f5d25952ac48d4e6c9ea5a0345c1ece2c43ddae)  
[Exercise 2: Add Espresso to the test Part 1](https://github.com/macosgrove/AndroidBootcampProject/commit/5d137c44445bdcc97bb02a53246a3fe6f44a1915),
[Part 2](https://github.com/macosgrove/AndroidBootcampProject/commit/6a10373f167e709c907797aa00953ee899bd8ed2)  
[Exercise 3: Some new behaviour](https://github.com/macosgrove/AndroidBootcampProject/commit/ff41e46f18da9ab904607f62a766368459b78db2)  
[Exercise 4: Add Unit Tests Part 1,](https://github.com/macosgrove/AndroidBootcampProject/commit/816cc9f7dc56a3d3d09b040891992d336f6bc277)
[Part 2,](https://github.com/macosgrove/AndroidBootcampProject/commit/527d923d5f9d0fe8072422b72c56ba01ee9e5d1c) 
[Part 3](https://github.com/macosgrove/AndroidBootcampProject/commit/0549ce579badab5c61b150f71b7bfd0faaf36243)  
[Step by step instructions](https://github.com/macosgrove/AndroidBootcampProject/blob/master/BDDinAS.md)  
[Exercise 5: Make the tests pass](https://github.com/macosgrove/AndroidBootcampProject/commit/9ef2627ff2e6e40b4d526ba604aadba9bbf128e9)  

### Resources
[Behaviour Driven Development](http://dannorth.net/introducing-bdd/)  
[Testing the Android Way](http://blog.bignerdranch.com/2583-testing-the-android-way/) 
[Serious Unit Testing on Android](http://eclipsesource.com/blogs/2012/06/15/serious-unit-testing-on-android/)  
[Espresso](https://code.google.com/p/android-test-kit/wiki/Espresso)  
[Robolectric](http://robolectric.org/)  
[FEST](http://square.github.io/fest-android/)    
[Mockito](https://code.google.com/p/mockito/) 
[JUnit](https://github.com/junit-team/junit/wiki)  
   
## Week 3: Layout and Design
###Prerequisites:
In the Android Bootcamp directory you set up earlier, do:   
```
git stash
git checkout start-week-3
```

###Goals: 
 * Layout the welcome screen
 * Display a list of treasures  

###Material:  
[View the Presentation](http://prezi.com/v9yrnlv2yerk/?utm_campaign=share&utm_medium=copy&rc=ex0share)  
[Exercise 1 Part 1,2,3: Prettify the welcome screen](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/ff34f3207670a7713621aad9814eb367c72cb9e5)  
[Exercise 1 Part 4,5,6: Further enhancement](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/db5dbfcbf49251a0b4b8debc622b91c9e18bbb99)  
[Exercise 2 Part 1: Write a test for the Treasure List](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/4fa78d569cda9687481846eea6d5662de50d440c)  
[Exercise 2 Part 2,3: Create the gridview and adapter](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/4fa78d569cda9687481846eea6d5662de50d440c)  

### Resources
[Designing for Multiple Screens](http://developer.android.com/training/multiscreen/index.html)  
[Styles and Themes](http://developer.android.com/guide/topics/ui/themes.html)  
[Layouts](http://developer.android.com/guide/topics/ui/declaring-layout.html)  
[Grid View](http://developer.android.com/guide/topics/ui/layout/gridview.html)  

## Week 4: Using the Camera
###Prerequisites:  
In the Android Bootcamp directory you set up earlier, do:     
```
git stash
git checkout start-week-4
```

The default camera app in Genymotion doesn't capture the GPS details for taken photos so we need to install a different camera (otherwise you can use a real device)

1. Install google play services, Download the appropriate Google Apps for Android zip file for your device from here: http://stackoverflow.com/a/20013322. Make sure the version of Google Apps you use matches the Android version on your emulated device. For example [gapps-kk-20140105-signed.zip](http://www.androidfilehost.com/?fid=23311191640114013) works with the Google Nexus 5 4.4.2 Genymotion device.
2. Drag the downloaded zip onto your running Genymotion emulator
3. Ignore any errors and restart the emulator
4. Now using the playstore in your emulator find the App called Camera MX and install it
5. If you cant find it here is the link https://play.google.com/store/apps/details?id=com.magix.camera_mx
 
###Goals: 
 * Find out how to access the Camera app 
 * Take a photo of a found Treasure using the phones built in camera app  
 * Evaluate its proximity to the listed Treasure  

###Material:  
[View the Presentation](http://prezi.com/cvbktfttlnj4/?utm_campaign=share&utm_medium=copy&rc=ex0share)  
[Exercise 1: Register a on item click listener for the treasure list](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/2499eac0bdb27ae576bbec69a480ac5080e99e65)  
[Exercise 2: Use an Intent to create a photo](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/205897d08c958d37e42f908bc1634dcc319a0c08)  
[Exercise 3: Get the captured photo](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/d53461cd1d33c4b87c634ffdb36e1abcb589d2f4)  
[Exercise 4: Calculate the distance between the two photos location and show in Toast message](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/8f12a82aa5541fdf568b5f64127b5ccd558a6e62)  

### Resources  
[EXIF](http://en.wikipedia.org/wiki/Exchangeable_image_file_format)  
[Intents](http://developer.android.com/guide/components/intents-filters.html)  
[Using the Camera in Android](http://developer.android.com/guide/topics/media/camera.html)    
[Android Location API (can use to calc distances between two points)](http://developer.android.com/reference/android/location/Location.html)  
[Toasts in Android](http://developer.android.com/guide/topics/ui/notifiers/toasts.html)  

## Week 5: Data and Communication
###Prerequisites:  
In the Android Bootcamp directory you set up earlier, do:     
```
git stash
git checkout start-week-5
```

###Goals: 
 * Learn about handling data and communicating with a server
 * Retrieve a real list of Treasures from a server

 ###Material:   
 [View the Presentation](http://prezi.com/-svdzfuq7wbi/?utm_campaign=share&utm_medium=copy)  
 [Exercise 1, Exercise 2 pt1: Write a model for the treasures](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/71612668c44226bdff331438274fd99c7041a442)  
 [Exercise 2 pt2: Writing the client pt 1](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/1f7d13322bd41c009e79f6351875d7bd0b4ddb34)  
 [Exercise 2 pt3: Writing the client pt 2](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/e095dfbbe51cbd8eb353099b650f28559825c394)  
 [Exercise 3 pt1: Using the client](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/1f7d13322bd41c009e79f6351875d7bd0b4ddb34)  
 [Exercise 3 pt2: Fixing the client](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/992ec60bb00ed3469300cb3b295af7df3405e243)  

### Resources
[Processes and Threads](http://developer.android.com/guide/components/processes-and-threads.html)  
[Retrofit](http://square.github.io/retrofit/)  
[JSON](http://www.json.org/)  
[http://www.jsonschema2pojo.org](http://www.jsonschema2pojo.org)
[Source code for the Android Bootcamp server](https://github.com/ThoughtWorksAustralia/android-bootcamp-rest-server)  

## Week 6: Playing with Maps
###Prerequisites:  
In the Android Bootcamp directory you set up earlier, do:     
```
git stash
git checkout start-week-6
```
Ensure you've installed Google Apps on your emulated device as per the instructions for [week 4](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject#week-4-using-the-camera).

Open the Android SDK manager (Tools > Android > SDK Manager from Android Studio).
Check Android Support Repository, Google Play Services and Google Repository from the Extras section at the bottom of the window, and click Install Packages.

###Goals: 
 * Explore the Google Maps API
 * Complete the game with a map of actual and found Treasure locations. Generate a score.

###Material: 
[View the Presentation]()  
[Excercise 1: Set up for using Play Services](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/ac292303cecba45fd3cb45317abd1a73e68fe48f)  
NOTE: This exercise causes all Robolectric tests to fail when run on the command line, due to [Robolectric issue 1025!](https://github.com/robolectric/robolectric/issues/1025)  
[Exercise 2a: Display the map](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/d5976f1ade07ad7afd34c6fd6bd91828667eb46a)  
[Exercise 2b: Nested fragments must be added programmatically!](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/597f5f74e9f5f289faf74fa5cecbc91e9aaac6a4)  
[Exercise 2c: Connect to Google Play Services and zoom to our current location](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/ccb596ecf39c0c415007b856a3436e78a558d0e0)  
[Exercise 3: Map attempts](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/ac292303cecba45fd3cb45317abd1a73e68fe48f)  
[Exercise 4a: Add Finish Game button to High Scores fragment, and improve styling.](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/50bcb05014be2f4cbf9688796d1c5a2f373d95a8)  
[Exercise 4b: Finish the game, and show Treasures on the map once it has ended.](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/a9cffdbe57fd4740be6db7e82a520be90f3dc21d)  
[Exercise 4c: Send player's score to the server, and refresh the high scores](https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/commit/56714ec52b4f7d6e2f91a86e7940aea281f8721b)  

### Resources
[Google Play Services](http://developer.android.com/google/index.html)  
[Installing and Configuring the Google Maps V2 API](https://developers.google.com/maps/documentation/android/start#installing_the_google_maps_android_v2_api)    
[Google Maps API](http://developer.android.com/google/play-services/maps.html)
[Nested fragments must be added programmatically](http://developer.android.com/about/versions/android-4.2.html#NestedFragments)  
[Maps in the Genymotion emulator](http://www.webupd8.org/2013/11/android-x86-emulator-genymotion-20.html)  

