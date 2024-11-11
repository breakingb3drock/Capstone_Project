# Team Name: Team Timmy  
## Team Members: Nikhil Anoop & Ido Nir  
## Revision Date: 5/24/2024  
## Program Purpose: Fun game for 2 players
## Target User Profile: Teenage Friends/Groups
### Feature List:
- Graphics: Display game, characters, items
- Keyboard input: Take input used to move characters
- Hitboxes: Keep track of collisions between characters or items
- Borders: Prevents characters from running outside the window.
### Instructions:
- Use arrow keys to move hunters and wasd to move runner. When the hunter and runner
are touching a death screen will appear. To restart the game press the spacebar. To win
as the runner, collect 3 coins. To win as the hunter touch the runner. Power ups like
drinks can speed you up or slow you down like the cobweb. These can be collected by
the hunter or runner.
### Class List:
- Character - To create the mechanics for characters in the game  
○ Runner - Has specific details about runner character in game  
○ Hunter - Specific details about hunter character  
- Item - Creates template for different spawnable items in game  
○ Coin- Reward for runner to gain in order to win game  
○ Drink - Makes character faster when applied  
○ Web - makes opposing character slower  
- Window - Creates a window which can be drawn on.  
- DrawingSurface - draws everything on the window  
### Team Responsibilities:  
- Ido - Items classes  
- Nikhil - Character Classes  
- Shared Tasks - Window, DrawingSurface  
### Known Bugs/Workarounds:  
- NONE  
### Key Learnings:  
- It’s a lot more simpler to call a method than it is to manually code something in a single
class.
- When in doubt refer to the super class.
- Bugs are inevitable, it’s how you debug that matters.
### Credit List:
- GamePhysicsDemo1 - Used as outline for some graphics, characters, and movement.
● FCP BufferedImageCollision - Used as an example idea that adds to our check for
collisions.
