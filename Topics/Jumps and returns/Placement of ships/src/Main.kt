fun main() {
    val occupiedRows = arrayListOf<Int>()
    val occupiedCols = arrayListOf<Int>()
    repeat(3) {
        val (x, y) = readLine()!!.split(" ")
        if (!occupiedRows.contains(x.toInt())) occupiedRows.add(x.toInt())
        if (!occupiedCols.contains(y.toInt())) occupiedCols.add(y.toInt())
    }
    var output = ""
    for (i in 1..5) {
        if (occupiedRows.contains(i)) continue
        output += "$i "
    }
    println(output.trim())
    output = ""
    for (i in 1..5) {
        if (occupiedCols.contains(i)) continue
        output += "$i "
    }
    println(output.trim())
}
