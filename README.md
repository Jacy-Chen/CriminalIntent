# CriminalIntent
The Implementation of practice project from turial "Android Programming: The Big Nerd Ranch Guide". 

## Brief Intro
Criminal Intent record the details of "office crimes" - things like leavind dirty dises in the breakroom sink or walking away from an empty shared printer after documents have printed.

## Key Features
* UI Fragment and Fragment Manager with fragmentActivity
* User Interface with Layouts and Widgets
* Display Lists with RecyclerView --> Just like the iOS UITableView
* Pass Values via Fragment Arguments
* Show multi Page via ViewPager
* Show Dialogs holding DatePicker
* Custumise the Tool bar
* Save data with SQLite in Android device

## Comments
* Fragments 
  * Always use fragment if possible
  * Number of fragments shuold not over 3 in one activity
  * Custume View --> sub level plan
  * Fragment Arguments Best, not use public instance variable to pass value.
* Fragments Manager
  * State chasing 
  * Fragment ID and Location Spot in the Activity
  * Singleton viriable for a Activity? 
* Intents
  * StartActivityWithResult() -- HasResult() 
  * Handle the Extra code within the class by using static method. 
* Bundle
  * Save State of Activity and Fragment    
* Support Library
  * Add Dependency 
  * Gradle sync
  * Support Library is the King (Always use latest function and size is small)
