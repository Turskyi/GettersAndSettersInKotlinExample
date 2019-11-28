/**
 * @Description
 * Example of using  getters and setters objects in kotlin.
 *
 * When we run the code, the following text gets printed in the IDE’s output window:

Dog Fido has been created. The breed is MIXED.

Woof!

Weight in Kgs is 34.090909090909086

Weight is 75

My dog enjoys Walks

My dog enjoys Fetching balls

My dog enjoys Frisbee

Dog Kelpie has been created. The breed is WESTIE.

Dog Ripper has been created. The breed is POODLE.

Yip!
 */
class Dog(
    val name: String,
    weight_param: Int,
    breed_param: String
) {
    init {
        print("Dog $name has been created. ")
    }

    var activities = arrayOf("Walks")
    private val breed = breed_param.toUpperCase()

    init {
        println("The breed is $breed.")
    }

    var weight = weight_param
        set(value) {
            if (value > 0) field = value
        }
    val weightInKgs: Double
        get() = weight / 2.2

    fun bark() {
        println(if (weight < 20) "Yip!" else "Woof!")
    }
}

fun main() {
    val myDog = Dog("Fido", 70, "Mixed")
    myDog.bark()
    myDog.weight = 75
    println("Weight in Kgs is ${myDog.weightInKgs}")
    myDog.weight = -2
    println("Weight is ${myDog.weight}")
    myDog.activities = arrayOf("Walks", "Fetching balls", "Frisbee")
    for (item in myDog.activities) {
        println("My dog enjoys $item")
    }
    val dogs = arrayOf(
        Dog("Kelpie", 20, "Westie"),
        Dog(
            "Ripper",
            10, "Poodle"
        )
    )
    dogs[1].bark()
    dogs[1].weight = 15
    println("Weight for ${dogs[1].name} is ${dogs[1].weight}")
}