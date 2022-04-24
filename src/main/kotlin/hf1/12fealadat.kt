import kotlin.math.sqrt

fun main(){
    val A = Matrix(2, 2, arrayOf(-5.6725, -0.4183, 0.0413, -6.3275))
    val B = Matrix(2, 1, arrayOf(0.9, -1.9))
    val CT = Matrix(1, 2, arrayOf(-1.3, 0.6))
    val d = 1.5

    /*val A = Matrix(2, 2, arrayOf(-6.2415, 3.0277, 0.2348, -1.8585))
    val B = Matrix(2, 1, arrayOf(-0.1, -2.0))
    val CT = Matrix(1, 2, arrayOf(0.8, -1.3))
    val d = -0.6*/

    val lambda = A.lamda()
    println("lambda1 = ${lambda[0]}, lambda2 = ${lambda[1]}")

    println("Asz: ${ASZStabilFI(A)}")



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

fun ASZStabilFI(
    A: Matrix
): Boolean {
    if(-A.data[0][0] + -A.data[1][1] > 0 && -A.data[0][1]*A.data[1][0] + A.data[0][0]*A.data[1][1] > 0){  //a1 > 0 és a2 > 0
        return true
    }
    return false
}

