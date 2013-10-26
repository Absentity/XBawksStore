XBawks 720 Store Library
========================

((This project was intended as an educational project and has no use))


Thank you for choosing the XBawks 720 Store system! We provide a clean
and easy to use interface for setting up and configuring a store
front-end that will provide top 3 games in a variety of categories. We
built the software from the ground up to be flexible.
   

## Running the Sample Program (JAR File)

The provided JAR file (*XBawksGameStoreSample.jar*) is executable. If
the JAR file and the input.txt file are in the same directory,
double-clicking it will execute the project. It will generate an output
file (*output.txt*) containing all results. Results are broken down
into the top three of each of the following categories, first as
exclusively multiplayer and then from all games. The categories the
output lists include:

1. Newest Releases
2. Newest Releases broken down by each genre
3. Top Rated Games   
   

## Compiling

The source provided is an Eclipse project, created on OS X. You can
import this project into the Eclipse IDE or compile it manually with the
Java Compiler.


### Compiling with the Eclipse IDE

The source provided can be imported into Eclipse and compiled. In
Eclipse, go to **File > Import > General > Existing Projects into
Workspace...**, navigate to the extracted project directory
**"XBawksStore"** and press Finish.  

Then, select *XBawksGameStoreMain.java* and press the Run button at the
top.


### Compiling Manually

Change directory into the extracted src directory and run the java
compiler.

    cd ./src
    javac ./*


## Running the Program

To run the compiled output, call java on the main class. The sample
program's main class is *XBawksGameStoreMain*.


## Program Operation Details
### Providing the Input

The input file contains two sections: the count header and the list of
games. The count header tells the program how many games will need to
be read in. Then each game is broken down into several lines.

1. Name of the game
2. Date (in short American English format, mm/dd/yy)
3. Slash '/' delimited list of genres
4. Real number rating [0.0, 10.0]
5. Integer number of player

The program will scan this into an ArrayList database.


### Client-Server API

#### searchTopThree

Take in a set of search criteria to search for games. Returns the top
three from the list.

    searchTopThree(Genre[] genres,
                   Comparator<XBawksGame> sorter,
                   boolean forMultiplayer)

##### genres
> List of Genres to filter output.

##### sorter
> Comparator for filtering. Returned lists contain results in
  ascending order.

##### forMultiplayer
> Filter output by selecting multiplayer games exclusively if set to
  true, all games if set to false.


### Sorting, Filtering, and Extending

The system, using the searchTopThree method, returns the top three games
using a list of criteria. Genres strictly follow the provided genres in
*Genre.java*. This can be expanded. Users can write sorters to operate
on XBawksGame objects. These objects contain read-only data read in from
the section _Providing the Input_ above. Add whole Comparators to their
own classes and expand filters in *ListFilters.java*. Adding methods in
*StoreFront.java* can easily expand functionality using these and
similar criteria.
