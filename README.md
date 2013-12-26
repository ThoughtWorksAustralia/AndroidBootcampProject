AndroidBootcampProject
======================

## Objectives
To teach Java programmers the basics of Android development using Agile best practices, by incrementally developing a small game over a period of six weeks.

## The App: Treasure Hunt
A single player game. The app supplies a list of photos of 'treasures' in your local area, with hints on how to find them. Your job is to run (or stroll) around the area to find each treasure and take a photo of it. Points are awarded according to how many treasures you can locate, how long you take, and how close you were to the original photo location.

## Pre-Bootcamp Preparation

Follow these setup steps before the first session:

1. Install [Java SE SDK 7](http://www.oracle.com/technetwork/java/javase/downloads/index.html) if you don't have it
1. Download and install Android Studio
1. Studio will prompt you to create a new project. Use the default settings, except:
  1. Enter any project name you like
  1. Enter "HelloAndroid" as the Activity Name
  1. Enter activity_hello as the layout name
  1. Change the Package Name to com.thoughtworks.androidbootcamp or something that's relevant to you. Note that a device can carry only one application from any given package, and the Google Play store will only list one application per package.
  1. Select Navigation Type: Action Bar Spinner
1. Download and install [Genymotion]()
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
Goal: Develop a working "hello world" app and explore its anatomy.
[View the Presentation](http://prezi.com/jibn_vzm9rml/?utm_campaign=share&utm_medium=copy)

## Week 2: TDD with Android
Goal: Add a framework for test driven development including a unit test and a functional test

## Week 3: Layout and Design
Goal: Display a list of Treasures (from a provided file)

## Week 4: Using the Hardware
Goal: Take a photo of a found Treasure. Evaluate its proximity to the listed Treasure

## Week 5: Data & Communication
Goal: Retrieve a real list of Treasures from a server

## Week 6: Google APIs
Goal: Complete the game with a map of actual vs found Treasure locations. Generate a score.

## Resources
### Android in General
[Android Developers site](http://developer.android.com/develop/index.html)  
[The Busy Coder's Guide to Android Development](http://commonsware.com/Android/)

###Genymotion
[Genymotion Users Guide](https://cloud.genymotion.com/page/doc/)
