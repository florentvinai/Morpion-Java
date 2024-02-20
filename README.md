# Morpion-Java
This project involves implementing the classic Tic-Tac-Toe game using Java, with a command-line interface. The game allows two players to take turns placing their symbols on a 3x3 grid, aiming to align three identical symbols horizontally, vertically, or diagonally.

Key Features:

Turn-Based Gameplay: Players alternate to place their symbols on the grid, selecting an empty cell each turn.

Command-Line Interface: The game is entirely played through the command-line interface, providing clear instructions to guide players in their choices.

Win Condition Detection: The program automatically detects win conditions, announcing the winning player when a line of three identical symbols is formed.

Draw Detection: If the grid is filled without a winner, the game correctly identifies a draw and ends the match.

Technologies Used:

Java: The game's logic, user interface, and gameplay mechanisms are all implemented using the Java programming language.
Project Purpose:

This project aims to provide an educational and entertaining implementation of the classic Tic-Tac-Toe game, offering a simple yet engaging gaming experience directly from the command line. It is designed to showcase fundamental Java programming concepts, including object-oriented principles, data structures, and user input management.

Readme - How to Play:

Starting the Game: Compile and execute the Java file TicTacToe.java to begin the game.

Game Grid: The game grid is represented by a 3x3 matrix. Empty cells are denoted by numbers from 1 to 9, corresponding to their positions on the grid.

Player Turns: Players alternate to place their symbol (X or O) on the grid. At the start of each turn, the current player is prompted to enter the number of the cell where they wish to place their symbol.

Placing a Symbol: Enter the number of the desired cell according to the following layout:

markdown
Copy code
1 | 2 | 3
---------
4 | 5 | 6
---------
7 | 8 | 9
Winning the Game: The first player to align three of their symbols horizontally, vertically, or diagonally wins the game.

Draw: If the grid is filled without a winner, the game ends in a draw.

Replay: After the game ends, players have the option to replay by responding to the prompt that appears.