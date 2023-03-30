# DnDCharacterCreator
A text-based DnD character creation project in Java. 
This was the first "big" (I thought so at the time) project I worked on as a Freshman Computer Science student. It was the final project of my
CPSC 1110: Data Structures and Program Design class. <strong>I have not gone back to refactor this code since Freshman year</strong> as of yet in order to use better programming practices, make it more efficient, etc., so bear with me. I've also uploaded the class UML with this. Probably not the best design but once again, that was my Freshman year. 

The assignment was to create a character creation program. This includes allowing the user to create an account(s), create as many characters as they wanted, then the system would save the account and the the accounts characters, and the user could log back into the account even when the program was completely closed out. At this point in time, I didn't know anything about databases, so I stored accounts and characters to files. Obviously, the accounts and characters were stored directly onto the user's computer, so accounts and characters created were unique to that specific computer/instance of the program. 

A couple other requirements are as follows:
 - Race
 - Gender
 - Ability Scores
 - Height 
 - Weight
 - Age
 
Different races, male and female option for each race, range of possible heights and weights were dependent on the race and gender of that character. Range of possible ages were dependent on the race. Weight, height, and age are randomly generated by the system upon finishing the character. 

Every character has a few ability scores: strength, dexterity, intelligence, wisdom, constitution, and charisma. The user was able to choose between three different options on how to fill out these ability scores. 
1) Roll a 6-sided die, 3 times. 
2) Roll a 6-sided die, 5 times. 
3) Roll a 6-sided die 5 times, then a 3-sided die once. 
The race of the character chosen gives an advantage in two ability scores and a disadvantage in another. Exs: If elf was chosen, +2 dexterity, +2 intelligence, -2 constituion. If gnome was chosen, +2 dexterity, +2 constitution, -2 strength. 
