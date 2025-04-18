package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Game {
    val cars = mutableListOf<Car>()
    var rounds: Int = 0

    fun addCar(car: Car) {
        cars.add(car)
    }
}

fun Game.inputCarNames(){
    println("Enter the names of the cars (comma-separated):")
    val names = Console.readLine().split(",")
    for (player in names)
        if (player.isEmpty() || player.length > 5)
            throw IllegalArgumentException("Car name must be 1–5 characters.")
        else
            addCar(Car(player.trim()))
}

fun Game.inputRoundCount(){
    println("How many rounds will be played?")
    val input = Console.readLine().toIntOrNull()
    if (input == null)
        throw IllegalArgumentException("Input must be a number.")
    else if (input < 1)
        throw IllegalArgumentException("Number of rounds must be at least 1.")
    rounds = input
}

fun Game.playTurn(){
    for (car in cars)
        if (4 <= Randoms.pickNumberInRange(0, 9))
            car.position++
    for (car in cars)
        car.printStatus()
    println()
}

fun Game.race(){
    println("\nRace Results")
    repeat(rounds) {
        playTurn()
    }
}