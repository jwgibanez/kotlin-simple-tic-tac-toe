fun main() {
    val input = readLine()!!
    var ctr = 0
    loop@ for (i in input.indices) {
        for (j in input.indices) {
            if (i != j && input[i] == input[j]) continue@loop
        }
        ctr++
    }
    println(ctr)
}
