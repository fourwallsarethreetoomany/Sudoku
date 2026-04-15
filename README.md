Sudoku project - Yuzhang Chen
Generates a 9x9 solved Sudoku board using backtracking. Each run produces an unique solved Sudoku board.
To run the program you should have Java installed, save the SudokuGenerator.java in a file, compile the program and run it.
The program uses backtracking to scan the board for the next empty entry (0), shuffles the numbers 1-9 in a random order and tries them all on the entry. If it returns true the program recursively fills all the other entries. If a dead end is reached it backtracks by setting one or more entries back to zero. When no entry is zero the board is filled. The board will be valid, random, and have no empty spaces. 
There is the SudokuGenerator.java and an explanatory pdf.
