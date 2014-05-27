Software-Design-and-Development---cs-246
========================================

I have been trying for hours to get this to work correctly … the line that I’m having problems with is “BustedShip.java” line 102


main is in “ConfigObjLoad.java” so you don’t have to find if (you need to comment out all of the “package”s in all of the java files in order for it to compile … 

the line I’m having trouble with is thus:

stemNode.setCapability(Node.ALLOW_PARENT_READ);   

setCapability() expects an int bit
(see http://www.cs.stir.ac.uk/courses/CSC9N6/Java3D/html/javax/media/j3d/SceneGraphObject.html)
so I tried manually putting one it (i.e. 1000001 in place of Node.ALLOW_PARENT_READ),
it sort of works when I do that but causes a runtime error and displays a blank screen; it creates a child/parent exception.


if I comment it out, then only a blank screen shows up

This guy named Edward Eberly made this, I’ve been trying to explore the concepts he uses in 3d graphics:

It seems like a great program … I just can’t get it to work.

post a comment if you get it to work! Or talk to me in class

download zip file here:
http://www.eberdeed.net/programs/POVSpaceInvaders.zip