package machine

var money = 550
var water = 400
var milk = 540
var coffeeBeans = 120
var disposableCups = 9
var exitCondition = true

fun main() {
    while (exitCondition) {
        coffeeMachine()
    }
}

fun coffeeMachine() {

    println("Write action (buy, fill, take, remaining, exit):")

    when (readln()) {
        "buy" -> {
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
            sellCoffee(readln())
        }
        "fill" -> {
            replenished()
        }
        "take" -> {
            takeMoney()
        }
        "remaining" -> {
            totalSupplies(water, milk, coffeeBeans, disposableCups, money)
        }
        "exit" -> {
            exitCondition = false
        }
        else -> {
            println("Enter a valid action please!")
        }
    }
}

fun sellCoffee(coffeeType: String) {//espresso, latte, and cappuccino
    when (coffeeType) {
        "1" -> {
            if (water >= 250) {
                if (coffeeBeans >= 16) {
                    money += 4
                    disposableCups--
                    water -= 250
                    coffeeBeans -= 16
                    println("I have enough resources, making you a coffee!")
                } else {
                    println("Sorry, not enough coffee beans!")
                }
            } else {
                println("Sorry, not enough water!")
            }
        }
        "2" -> {
            if (water >= 350) {
                if (milk >= 75) {
                    if (coffeeBeans >= 20) {
                        money += 7
                        disposableCups--
                        water -= 350
                        milk -= 75
                        coffeeBeans -= 20
                        println("I have enough resources, making you a coffee!")
                    } else {
                        println("Sorry, not enough coffee beans!")
                    }
                } else {
                    println("Sorry, not enough milk!")
                }
            } else {
                println("Sorry, not enough water!")
            }
        }
        "3" -> {
            if (water >= 200) {
                if (milk >= 100) {
                    if (coffeeBeans >= 12) {
                        money += 6
                        disposableCups--
                        water -= 200
                        milk -= 100
                        coffeeBeans -= 12
                        println("I have enough resources, making you a coffee!")
                    } else {
                        println("Sorry, not enough coffee beans!")
                    }
                } else {
                    println("Sorry, not enough milk!")
                }
            } else {
                println("Sorry, not enough water!")
            }
        }
        "back" -> {

        }
    }
}

fun replenished() {
    println("Write how many ml of water do you want to add:")
    water += readln().toInt()
    println("Write how many ml of milk do you want to add:")
    milk += readln().toInt()
    println("Write how many grams of coffee beans do you want to add:")
    coffeeBeans += readln().toInt()
    println("Write how many disposable cups of coffee do you want to add:")
    disposableCups += readln().toInt()
}

fun takeMoney() {
    println("I gave you $money\n")
    money = 0
}

fun totalSupplies(water: Int, milk: Int, coffeeBeans: Int, disposableCups: Int, money: Int) {
    println("The coffee machine has:")
    println("$water ml of water")
    println("$milk ml of milk")
    println("$coffeeBeans g of coffee beans")
    println("$disposableCups disposable cups")
    println("$$money of money\n")
}