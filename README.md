# Bounce-Floating-Edition

* Introduction
* Manual
* Description
* Example of work

## Introduction
---
Hello, I am glad to see you reading this file.This Game was programmed using java to pass subject at Warsaw University of Technology.
I am aware that code style isn't clean but I did as much as possible to make it understandable for all of you.
Any questions send via mail at : **boocianpawel@gmail.com**

## Manual
---
The game is about finishing levels by entering into portals, avoiding contact with Obstacles (spikes) as fast as possible! 
Using keys UP, DOWN, LEFR, RIGHT or W, A, S, D you can controll bounce ball. Game has 3 levels icluded.

### Using libraries
* [ini4j](http://ini4j.sourceforge.net/)

## Description 
---
All code is endowed with comments, describing classes objects and methods in project. 

### Most important classes:

* `GameObject` - abstract class to create all active Objects like Player, Obstacles, MedKit, Coins and Portal.
* `Game Window` - main window where graphics is rendered
* `Game Values` - special class to contain all game params like player lives, points. Actual window size (width and hight)
* `Game Graphics` - where graphics are loaded using Config.ini file and scaled.
* `Handler` - class handles all GameObjects.

### Game Objects:
* `Player` - no comment needed
* `Obstacles` (8 types, all described in GameGraphics code)
* `Coin` - adds extra 30 points.
* `MedKit` - adds extra one live
* `Portal` - teleports into next level

### Controlling player
Whole controll procedure is based on Keyinput Class which is observing our active keys. While pressed or released horizontal and vertical acceleration of player velocity is changed depends on key type. At every level gravity is different. Player can also pause the game using `SPACE_BAR`. Unfreezing game also at pressing `SPACE_BAR` again.

### Config.ini file
In this project we use Config.ini file and ini4j library. Congif file includes paths to every type GameObject graphics. Value of graviti etc is included in other file called "LevelX.txt" where 'X' is number of level.

### Level loading
Levels are loaded by special Handler method loadLevel().Struct of Level.txt file is : 
* - Name of object (Obstacle0)
* - Amount (fx. 10)
* - Position X and Y of this object.


## Example of work
---
Here you can see how it really looks. 



![](images/Work_screen.png)


Video of all functionality here [BocianooTech](https://www.youtube.com/channel/UClkl_F0n8ZwLmSB5RVzRORw)
