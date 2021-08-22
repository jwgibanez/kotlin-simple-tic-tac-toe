fun main() {
    val input = readLine()!!
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    for (i in alphabet.indices) {
        if (input == alphabet[i].toString()) break
        print(alphabet[i])
    }
}
