//g[k] = a + b * c^k * E[k]

fun main(){
    val a = 11
    val b = 10
    val c = -0.5

    val b2 = b
    val a2 = (1-c)*b/(-c)
    val c2 = (a2/(1-c)-a)*-1


    println("a: $a2")
    println("b: $b2")
    println("c: $c2")
}