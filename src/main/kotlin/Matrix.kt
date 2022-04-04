import kotlin.math.sqrt

data class Matrix(
    val data: ArrayList<ArrayList<Double>>,
    val row: Int,
    val column: Int
) {
    constructor(
        row: Int,
        column: Int,
        array: Array<Double> = Array(row * column) { 0.0 }
    ): this(
        data = arrayListOf(),
        row = row,
        column = column
    ){
        var n = 0

        for (i in 0 until row) {
            data.add(arrayListOf())
            for (j in 0 until column) {
                data[i].add(array[n])
                n++
            }
        }
    }

    constructor(
        row: Int,
        column: Int,
    ):this(
        row = row,
        column = column,
        array = Array(row * column) { 0.0 }
    ){
        for (i in 0 until row) {
            data.add(arrayListOf())
            for (j in 0 until column) {
                if(i == j) {
                    data[i][j] = 1.0
                } else {
                    data[i][j] = 0.0
                }
            }
        }
    }

    operator fun Matrix.times(B: Matrix): Matrix {
        val C = Matrix(
            row = this.row,
            column = B.column
        )
        for (i in 0 until this.row) {
            for (j in 0 until B.column) {
                var sum = 0.0
                for (k in 0 until B.row) {
                    sum += this.data[i][k] * B.data[k][j]
                }
                C.data[i][j] = sum
            }
        }
        return C
    }

    operator fun Matrix.times(b: Double): Matrix {
        val C = Matrix(
            row = this.row,
            column = this.column
        )

        for (i in 0 until this.row) {
            for (j in 0 until this.column) {
                C.data[i][j] = this.data[i][j] * b
            }
        }
        return C
    }

    operator fun Matrix.div(b: Double): Matrix {
        return this * (1 / b)
    }

    fun print(){
        for (i in 0 until this.row) {
            for (j in 0 until this.column) {
                print("${this.data[i][j]} ")
            }
            println()
        }
    }

    fun Lagrange(lamda1: Double, lamda2: Double): Matrix{
        val E = Matrix(2, 2)

        return (this - (E * lamda2))/(lamda1 - lamda2)
    }

    operator fun Matrix.minus(B: Matrix): Matrix {
        val C = Matrix(
            row = this.row,
            column = this.column
        )
        for (i in 0 until this.row) {
            for (j in 0 until this.column) {
                C.data[i][j] = this.data[i][j] - B.data[i][j]
            }
        }
        return C
    }

    fun lamda(): Array<Double> {
        return masodfokuMegoldo(
            b = -(data[0][0] + data[1][1]),
            c = -data[0][1]*data[1][0] + data[0][0]*data[1][1]
        )
    }

    //https://www.programiz.com/kotlin-programming/examples/quadratic-roots-equation
    private fun masodfokuMegoldo(
        a: Double = 1.0,
        b: Double,
        c: Double
    ):Array<Double> {

        println("b: $b")
        println("c: $c")
        var root1 = 0.0
        var root2 = 0.0

        val determinant = b * b - 4.0 * a * c

        // condition for real and different roots
        if (determinant > 0) {
            root1 = (-b + sqrt(determinant)) / (2 * a)
            root2 = (-b - sqrt(determinant)) / (2 * a)
        }
        // Condition for real and equal roots
        else if (determinant == 0.0) {
            root2 = -b / (2 * a)
            root1 = root2
        }
        // If roots are not real
        else {
            val realPart = -b / (2 * a)
            val imaginaryPart = sqrt(-determinant) / (2 * a)
        }

        return arrayOf(root1, root2)
    }
}