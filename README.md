# Towers
Android app for the towers puzzle game

## The game
Towers resolves around a [Latin Square](https://en.wikipedia.org/wiki/Latin_square). The app gives you a (partially filled) board, with your chosen size, and the game is to fill it in. Every column and every row must contain each value exactly once, as is with a Latin Square. Outside of the game grid, there are some numbers. These numbers represent the amount of towers you can 'see', were you to stand in that position. Higher towers block lower ones behind them from being seen.

An example:
The following puzzle:

|     |  2  |  2  |     |     |
| --- | --- |:---:| --: | --- |
|     |  .  |  .  |  .  |     |
|**2**|  .  |  .  |  .  |     |
|     |  .  |  .  |  .  |**3**|

could be filled in like:

|     |  2  |  2  |     |     |
| --- | --- |:---:| --: | --- |
|     |  2  |  1  |  3  |     |
|**2**|  1  |  3  |  2  |     |
|     |  3  |  2  |  1  |**3**|

In this app, higher numbers are indicated with darker colors.
