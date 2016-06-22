# Android Cursors Lab
Use Cursors in Android to display the planets!


## Instructions

1. Fork this repository
2. Clone this repository
3. Open the project inside of the `starter_code` folder in this directory.
4. Verify that the project (Planets SQL) runs.

## Part One

1. Add a `Planets` class. Each property of the class should correspond the columns that are created inside of the `DatabaseHelper`.
2. Uncomment the `getPlanetById` method in `DatabaseHelper`. 
3. Use Cursor(s) to implement this method to return an individual `Planet` class.

## Part Two

1. Open the `Books` project in this repository. Run the application (update Gradle if required). You may be given a warning to upgrade specific libraries.
2. Inspect the `MainActivity` and identify:
3. How items are inserted into the database
4. How items are added to an ArrayList
5. How items are rendered using an ArrayAdapter
6. Add three of your favourite books to the `MainActivity` and run the app. See your additions?

## Part Three

1. Return to your Planets SQL project.
2. Inside of your `MainActivity`, add a new method, use _any_ technique of your chocie to display _all_ of your planets on screen. You may query individual items using `getPlanetById` or loop through all items with a `Cursor` - _the choice is yours!_

# Submit by midnight
