fun main() {
    val input = readLine()!!
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    loop@ for (i in alphabet.indices) {
        for (j in input.indices) {
            if (alphabet[i] == input[j]) continue@loop
        }
        print(alphabet[i])
    }
}
