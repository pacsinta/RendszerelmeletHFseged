import kotlin.math.sqrt

fun main(){
    val A = arrayOf(-5.6725, -0.4183, 0.0413, -6.3275)
    val B = arrayOf(0.9, -1.9)
    val CT = arrayOf(-1.3, 0.6)
    val d = 1.5

    for(ertek in sajatertek(A)){
        println(ertek)
    }

    println("Asz: ${ASZStabilFI(A)}")
}

fun ASZStabilFI(
    A: Array<Double>
): Boolean {
    if(-A[0] + -A[3] > 0 && -A[1]*A[2] + A[0]*A[3] > 0){  //a1 > 0 és a2 > 0
        return true
    }
    return false
}

fun sajatertek(
    A: Array<Double>
): Array<Double> {
    return masodfokuMegoldo(
        b = -A[0] + -A[3],
        c = -A[1]*A[2] + A[0]*A[3]
    )
}

fun L(
    A: Array<Double>,
    lambda1: Double,
    lambda2: Double
){

}

//https://www.programiz.com/kotlin-programming/examples/quadratic-roots-equation
fun masodfokuMegoldo(
    a: Double = 1.0,
    b: Double,
    c: Double
):Array<Double> {
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