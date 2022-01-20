# Gilded Rose Refactoring Kata
Welcome to the dojo! This is a kata (exercise) about working with legacy code.
In this kata we have been given a piece of code that is hard to test since it
was not written with testing in mind. The code is risky to refactor because it
does not have any tests so we might introduce bugs if we try to refactor. It is
also risky to add new functionality for the same reason. How should we approach
this problem? The goal is to transfer the crappy piece of code that we have been
given to code that is well tested, easy to read and understand.

We will study the [Testing and Refactoring Legacy
Code](https://www.youtube.com/watch?v=_NnElPO5BU0) approach presented by Sandro
Mancuso and apply it to a modified Java version of the [Gilded Rose Refactoring
Kata](https://github.com/emilybache/GildedRose-Refactoring-Kata) originally
created by [Terry Hughes](https://twitter.com/TerryHughes). And we will work in
pairs to solve the kata.

## Preparation
Watch [Testing and Refactoring Legacy
Code](https://www.youtube.com/watch?v=_NnElPO5BU0) before the kata coding
session.

## Getting started
### Suggested Tools
Feel free to use any IDE that you want for the kata. For Eclipse, here are the
tools that we will use, you probably already have many of them:
* [Buildship: Eclipse Plug-ins for Gradle](https://github.com/eclipse/buildship/blob/master/docs/user/Installation.md)
* [TestNG Eclipse plug-in](https://testng.org/doc/download.html)
* [EclEmma: Java code coverage for Eclipse](https://www.eclemma.org/)

I could not get
[Infinitest](https://infinitest.github.io/doc/eclipse#get-started) to work which
is what Sandro Mancuso used in the video. I suggest using
[MoreUnit](https://moreunit.github.io/MoreUnit-Eclipse/) instead. Instead of
running tests on save as Infinitest does, MoreUnit provides shortcuts for
running the corresponding test file, jumping between the test file and class
under test, and creating a test if it does not exist. For this exercise,
MoreUnit 3.3.1 works fine, but in our Ufo projects the jumping does not work. I
suggest installing MoreUnit 3.3.0 instead. It works for both this exercise and
the Ufo projects. To install MoreUnit 3.3.0, do the following:
1. Download [org.moreunit.updatesite-3.3.0.zip from their releases on
   github](https://github.com/MoreUnit/MoreUnit-Eclipse/releases/download/v3.3.0/org.moreunit.updatesite-3.3.0.zip).
2. In eclipse, go to Help > Install New Software.
3. Click Add...
4. Click Archive... and open org.moreunit.updatesite-3.3.0.zip
5. name it MoreUnit
6. Click Add
7. Select *MoreUnit for Java* and *MoreUnit Light*
8. Click Finish and follow the installation procedure until installed

### Git branch and Eclipse import
Create a branch of this repository called firstname1-firstname2 where firstname1
is your first name and firstname2 is your coding partner's first name. Import
the project as a Gradle project in Eclipse or your preferred IDE. In Eclipse,
you can import the project via:
1. File > Import...
2. Select Existing Gradle Project
3. Select the directory in which this README exists
4. Press Finish

## Gilded Rose requirements
Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime
location in a prominent city ran by a friendly innkeeper named Allison. We also
buy and sell only the finest goods. Unfortunately, our goods are constantly
degrading in quality as they approach their sell by date. We have a system in
place that updates our inventory for us. It was developed by a no-nonsense type
named Leeroy, who has moved on to new adventures. Your task is to add the new
feature to our system so that we can begin selling a new category of items.
First an introduction to our system:

* All items have a SellIn value which denotes the number of days we have to sell
  the item
* All items have a Quality value which denotes how valuable the item is
* At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:

* Once the sell by date has passed, Quality degrades twice as fast
* The Quality of an item is never negative
* "Aged Brie" actually increases in Quality the older it gets
* The Quality of an item is never more than 50 except for "Sulfuras" which
  always has quality 80 since it is a ledgendary item.
* "Sulfuras", being a legendary item, never has to be sold or decreases in
  Quality
* "Backstage passes", like aged brie, increases in Quality as its SellIn value
  approaches; Quality increases by 2 when there are 10 days or less and by 3
  when there are 5 days or less but Quality drops to 0 after the concert

We have recently signed a supplier of conjured items. This requires an update to
our system:

* "Conjured" items degrade in Quality twice as fast as normal items. Conjured
  items are identified by having a name that starts with "Conjured".

**You are not allowed to change the signatures of any of the methods or
constructors that already exist.** We imagine that there is a lot of other code
that is using this piece of code, and by changing the signatures we would affect
other untested code which is too risky. **You are also not allowed to change the
implementation of getTemperature in the Freezer or the Fridge classes.**

You are allowed to change everything else like adding additional methods,
constructors and classes. You can modify the code within the existing methods or
add new third party libraries. But everything has to still work as before with
the exception of conjured items. Also, feel free to remove the foo test method
in GildedRoseTest.

## Strategy
The basic strategy we will use is:
1. Cover legacy code with tests
2. Refactor
3. Implement new feature

The main idea is:
> You cannot change production code if it is not covered by tests. However there
> is one exception, automated refactorings (via IDEs) are allowed, if needed to
> write the test.

Switch the person driving in your pair often.

Guidelines when writing tests for legacy code:
1. When adding tests to legacy code, start by adding tests to the shortest
   branch before moving on the to deeper branches.
2. Use code coverage tools to answer the following question: is my test covering
   the branch that I thought it would cover?

Guidelines when refactoring legacy code:
1. Start refactoring from deepest to shortest branch.
2. Small steps when refactoring, stay in the green as much as possible.
3. Getting rid of variables is a good way to make it easier to rejuggle the
   code.

Suggested way to add a new features is to use TDD:
1. Add a failing test.
2. Make it pass.
3. Refactor.
4. Repeat until the feature has been added.

Sandro Mancuso had a final slide with general advice:

Craftsmen at work
* Write readable and maintainable code
    * Code must express business rules
* Strive for simplicity
* Know your tools well (i.e. framworks, shortcuts)
* Work in small and safe increments
    * Commit often
* Embrace changes, be brave
* Boy scout rule / No broken windows