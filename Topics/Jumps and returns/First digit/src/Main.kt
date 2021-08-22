fun main() {
    val input = readLine()!!
    for (i in input.indices) {
        if (input[i].isDigit()) {
            print(input[i])
            break
        }
    }
}
