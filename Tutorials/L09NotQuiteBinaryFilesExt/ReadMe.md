# Reading and writing data

This is a small app that:

* reads an HTML file from /res/raw and shows the text on the screen;
* contains a converter that stores numbers entered and their conversions to file;
* stores the last number converted to SharedPreferences;
* shows the contents of that file in a list. 

***Two versions*** of the app:
1. `MainActivityBasic`: Classic app that uses different activities
2. `MainActivity`: App that uses the Bottom Navigation template
  - use fragments

Choose which version to use by setting the LAUNCHER activity 
in the file `AndroidManifest.xml`