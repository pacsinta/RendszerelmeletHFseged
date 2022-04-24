fun main() {
    val A = Matrix(2, 2, arrayOf(-13.3286, -0.8343, 0.3571, -14.0714))
    val B = Matrix(2, 1, arrayOf(1.7, 14.2))
    val CT = Matrix(1, 2, arrayOf(-12.7, -4.3))
    val d = 14.0


    val a1 = 1.0
    val a2 = -A.data[0][0] + -A.data[1][1]
    val a3 = -A.data[0][0] * -A.data[1][1] - A.data[0][1] * A.data[1][0]

    val b1 = d
    val b2 = CT.data[0][0] * B.data[0][0] + CT.data[0][1] * B.data[1][0] + d * a2
    val b3 = (CT.data[0][0] * -A.data[1][1] + CT.data[0][1] * A.data[1][0]) * B.data[0][0] +
            (CT.data[0][0] * A.data[0][1] + CT.data[0][1] * -A.data[0][0]) * B.data[1][0] +
            d * a3

    print("b1 = $b1 b2 = $b2 b3 = $b3\n")
    print("a1 = $a1 a2 = $a2 a3 = $a3\n")
}