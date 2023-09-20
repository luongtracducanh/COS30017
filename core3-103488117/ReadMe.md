Software Development for Mobile devices
Jan 2022
Kotlin version: 1.5
============================

A sample project (named `ProjTemp1dot5`) which is used as starter template for your assignment projects.

## Configuration
- Android Studio 2020.3.1 (patch 3): Artic Fox 
- API 30
- Kotline version 1.5

## Usage
- Git clone this repository
- In Android Studio (version as described above), open the project `ProjTemp1dot5` i
- Ensure the configuration is correct by executing `Main.kt` file. It should prints: `Hello, my friend Kotlin`
- Customise the project to suite your assignment project (see below)

## How to change the project name?
- In file `settings.gradle`, change the project directory name to your project name
  - Locate the entry `rootProject.name = "ProjTemp1dot5"` and change `ProjTemp1dot5` to your project assignment name 
- On File Explorer, rename the project directory to the same name
- Close the project and open it again to see the change

## How to change the default package name to your assignment?
Do the followings in Android Studio:
- In `app/java/`, right-click on the package and choose "Refactor/Rename"
  - Choose "Rename package" and enter a new package name
  - Tick the two check boxes: "Search in comments and strings" and "Search for text occurrences"
  - Click "Refactor" and then "Do Refactor" on the Refactoring Preview panel (bottom left)
  - Click "Sync now" link on the Gradle notification message (top of the editor panel)
## How to create a new Activity?
- In the Project view on Android Studio
- Right click on `app` node
- On the context menu, choose "New -> Empty Activity"
- Tick the check box "Launcher activity" check box on the dialog. Leave all other options and values as their defaults.
- Click Finish to create
