1. Create a new directory and change to it
2. ```git clone https://github.com/ThoughtWorksAustralia/AndroidBootcampProject.git```
3. Open Android Studio and select File > Import Project...
4. Choose build.gradle from your new directory structure
The project will open and complain that it needs build tools 19.0.3
5. Open Android SDK Manager and install build tools 19.0.3
6. Build > Make Project. This will download dependencies the first time.
7. Find the hash tag of the release you want at https://github.com/ThoughtWorksAustralia/AndroidBootcampProject/releases
8. Back at the command line, change to the AndroidBootcampProject subdirectory
9. do ```git checkout <hash>``` eg ```git checkout 9ea56d5``` for start of week 2.  
If you get a message saying 'The project is using an unsupported version of the Android Gradle plug-in (0.6.3), do
10. VCS > Apply Patch... and choose AndroidBootcampProjecct/Upgrade_to_Android_Studio_0_5_1.patch
11. Try the build again. It should work from Android Studio this time.  
It may fail when you run gradle check at the command line, saying ```Could not create plugin of type 'AppPlugin'.```.
12. To fix this, upgrade gradle to v1.11 (on Mac with Homebrew, ```brew upgrade gradle``` , or ```brew switch gradle 1.11``` if you had previously installed it.)

