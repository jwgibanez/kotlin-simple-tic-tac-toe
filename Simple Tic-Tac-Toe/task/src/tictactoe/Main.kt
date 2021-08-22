package tictactoe

import java.util.Scanner
import kotlin.math.abs

var turn = 'X'

fun main() {
    val scanner = Scanner(System.`in`)

    var value = "         "

    printCells(value)

    while (getState(value) == "Game not finished") {
        value = play(value, scanner)
    }

    println(getState(value))
}

fun printCells(value: String) {
    println("---------")
    println("| ${value[0]} ${value[1]} ${value[2]} |")
    println("| ${value[3]} ${value[4]} ${value[5]} |")
    println("| ${value[6]} ${value[7]} ${value[8]} |")
    println("---------")
}

fun play(value: String, scanner: Scanner): String {
    print("Enter the coordinates: ")
    val input = scanner.nextLine().toCharArray()
    if (input.size != 3) {
        println("You should enter numbers!")
        return value
    }
    for (ch in input) {
        if (!(ch.isDigit() || ch == ' ')) {
            println("You should enter numbers!")
            return value
        }
    }
    val x = input[0].toString().toInt()
    val y = input[2].toString().toInt()
    if (!(x in 1..3 && y in 1..3)) {
        println("Coordinates should be from 1 to 3!")
        return value
    }
    val idx = ((x-1)*3)+(y-1)
    if (value[idx] != ' ') {
        println("This cell is occupied! Choose another one!")
        return value
    }
    val charArray = value.toCharArray()
    charArray[idx] = turn
    turn = if (turn == 'X') 'O' else 'X'
    val new = String(charArray)
    printCells(new)
    return new
}

fun getState(value: String): String {
    val xWin = hasWin(value, 'X')
    val oWin = hasWin(value, 'O')
    val countX = count(value, 'X')
    val countO = count(value, 'O')
    val countUnderscore = count(value, ' ')
    return if (countUnderscore == 0 && !xWin && !oWin) {
        "Draw"
    } else if ((xWin && oWin) || abs(countX - countO) > 1) {
        "Impossible"
    } else if (xWin) {
        "X wins"
    } else if (oWin) {
        "O wins"
    } else {
        "Game not finished"
    }
}

fun hasWin(value: String, symbol: Char): Boolean {
    val combination = arrayOf(symbol, symbol, symbol)
    when {
        // horizontals
        arrayOf(value[0], value[1], value[2]).contentDeepEquals(combination) ||
        arrayOf(value[3], value[4], value[5]).contentDeepEquals(combination) ||
        arrayOf(value[6], value[7], value[8]).contentDeepEquals(combination) ||
        // verticals
        arrayOf(value[0], value[3], value[6]).contentDeepEquals(combination) ||
        arrayOf(value[1], value[4], value[7]).contentDeepEquals(combination) ||
        arrayOf(value[2], value[5], value[8]).contentDeepEquals(combination) ||
        // diagonals
        arrayOf(value[0], value[4], value[8]).contentDeepEquals(combination) ||
        arrayOf(value[2], value[4], value[6]).contentDeepEquals(combination)
        -> return true
    }
    return false
}

fun count(value: String, symbol: Char): Int {
    var ctr = 0
    for (c in value) {
        if (c == symbol) ctr++
    }
    return ctr
}