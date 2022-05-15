@echo off
javac Main.java -encoding UTF-8

:loop

echo 1 : Add Virologist
echo 2 : Place agent in laboratory
echo 3 : Place agent in shelter
echo 4 : Neighbour
echo 5 : Move to field
echo 6 : Move to laboratory
echo 7 : Move to warehouse
echo 8 : Move to shelter
echo 9 : Dance move
echo 10 : Bear move
echo 11 : Bear move to warehouse
echo 12 : Bear move next to axe user
echo 13 : Attack with stun
echo 14 : Attack with dance
echo 15 : Attack self with immunity
echo 16 : Attack with amnesia
echo 17 : Attack cloak user (protected)
echo 18 : Attack cloak user (not protected)
echo 19 : Attack glove user
echo 20 : Attack glove user as glove user
echo 21 : Attack immune virologist
echo 22 : Craft agent
echo 23 : Steal material
echo 24 : Steal bag
echo 25 : Crafted agent use time runs out
echo 26 : VAttribute duration time runs out
echo 27 : Virologist wins
echo 28 : Add laboratory (not infected)
echo 29 : Add laboratory (infected)
echo m : Manual testing

set /p choice= "Please select one of the options above:" 

java Main %choice%

pause
cls
goto loop