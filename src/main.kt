import java.util.*
import java.util.concurrent.ThreadLocalRandom
import java.util.regex.Pattern

fun randomNumber(min: Int, max: Int) = ThreadLocalRandom.current().nextInt(min, max)

const val separator = "---------------------"

data class Player(var name: String, var wins: Int = 0, val isComputer: Boolean = false)

fun String.withIncrementedPostfix(): String {
    val pattern = Pattern.compile("(.*?)(\\d+)$")
    val matcher = pattern.matcher(this)
    return if (matcher.find()) {
        val nameWithoutPostfix = matcher.group(1)
        val currentPostfix = matcher.group(2).toInt()
        nameWithoutPostfix + (currentPostfix + 1)
    } else {
        this + "1"
    }
}

val scanner = Scanner(System.`in`)

val players = listOf(
    Player("Paweł", isComputer = true),
    Player("Paweł", isComputer = true),
    Player("Paweł", isComputer = true),
)

fun main() {

    // ensure all names are unique
    var someoneHasRepeatedName = true
    while (someoneHasRepeatedName) {
        val playerToRename = players.find { player ->
            val otherPlayers = (players - player)
            player.name in otherPlayers.map { it.name }
        }

        if (playerToRename == null) {
            someoneHasRepeatedName = false
        } else {
            playerToRename.name = playerToRename.name.withIncrementedPostfix()
        }
    }


    // play 100 games
    for (i in 1..100) {
        var someoneWon = false
        // play until someone wins
        while (!someoneWon) {
            // game starts
            val guesses = players.associateWith {
                if (it.isComputer) randomNumber(1, 6) else run {
                    // read input until int
                    while (true) {
                        return@run try {
                            scanner.nextInt()
                        } catch (exception: InputMismatchException) {
                            scanner.next()
                        }
                    }
                }
            }

            println(separator)
            val diceThrow = randomNumber(1, 6)
            println("Kostka: $diceThrow")


            players.forEach { player ->
                val guess = guesses[player]
                println("Gracz ${player.name}: $guess")
            }

            val winners = guesses.filterValues { it == diceThrow }.keys

            if (winners.isNotEmpty()) {
                // end game
                val winnerNames = winners.joinToString { it.name }
                println()
                println("Zwycięzcy: $winnerNames")

                winners.forEach { it.wins++ }
                someoneWon = true
            }
        }
    }

    // print stats
    println(separator)
    players.sortedByDescending { it.wins }.forEach {
        println("${it.name}: ${it.wins}")
    }
}
