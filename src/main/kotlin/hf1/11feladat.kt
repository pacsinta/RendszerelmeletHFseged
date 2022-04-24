import kotlin.math.abs

fun main() {
    val A = Matrix(2, 2, arrayOf(-0.4591, 0.5727, -0.2386, 0.5591))
    val B = Matrix(2, 1, arrayOf(0.4, 0.6))
    val CT = Matrix(1, 2, arrayOf(-0.9, 0.5))
    val d = -4.3

    val lambda = A.lamda()
    println("lambda1 = ${lambda[0]}, lambda2 = ${lambda[1]}")

    println("Asz: ${ASZStabilDI(A)}")

    val L1 = A.Lagrange(lambda[0], lambda[1])
    val L2 = A.Lagrange(lambda[1], lambda[0])

    println("L1: ")
    L1.print()

    println("L2: ")
    L2.print()


    //a
    println("a: $d")

    //b
    val b = (CT * L1 * B).data[0][0]
    println("b: $b")

    //c
    println("c: ${lambda[0]}")

    //d
    val d2 = (CT * L2 * B).data[0][0]
    println("d: $d2")

    //f
    println("f: ${lambda[1]}")
}


fun ASZStabilDI(
    A: Matrix,
): Boolean {
    val a1 = -A.data[0][0] + -A.data[1][1]
    val a2 = -A.data[0][1] * A.data[1][0] + A.data[0][0] * A.data[1][1]
    if (1 + a1 + a2 > 0 && 1 - a1 - a2 > 0 && abs(a2) < 1) {
        return true
    }

    return false
}