import kotlin.math.cos
import kotlin.math.pow

fun main(args: Array<String>) {
    print(konvolucio(2))
}


fun konvolucio(
    maxK: Int
): Double {
    var y = 0.0
    for(i in 0..maxK){
        y += h(i) * u(maxK - i)
    }

    return y
}

fun h(
    k: Int
): Double{
    return 5.0*((0.1*5.0).pow(k))*cos(2*Math.PI/3*k + 0.4)
}

fun u(
    k: Int
): Double{
    var u = -7*((0.1*-3).pow(k+1))
    if(k==0){
        u += 1
    }

    return u
}

