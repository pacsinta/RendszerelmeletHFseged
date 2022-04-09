fun main(){
    val a = -0.7
    val b = -0.1
    val c = 0.7
    val d = 0.3
    val e = -0.6
    val f = -0.8
    val g = 0.9


    val A = Matrix(2, 2, arrayOf(b*c + d*f, e*f, b, 0.0))
    val B = Matrix(2, 1, arrayOf(1.0, 0.0))
    val CT = Matrix(1, 2, arrayOf(b*c*a+b*d*g+b*d*f*a, e*g + e*f*a))
    val d2 = a

    println("A:")
    A.print()

    println("B:")
    B.print()

    println("CT:")
    CT.print()

    println("d2: $d2")


    println("0, 1, ${-(A.data[0][0] + A.data[1][1])}, ${-A.data[0][1]*A.data[1][0] + A.data[0][0]*A.data[1][1]}")
    println()

    val lambda = A.lamda()
    for (l in lambda) {
        println("lamda: $l")
    }

    println("Asz: ${ASZStabilDI(A)}")
}