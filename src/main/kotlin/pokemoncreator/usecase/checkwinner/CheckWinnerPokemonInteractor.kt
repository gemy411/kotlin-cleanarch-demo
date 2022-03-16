package pokemoncreator.usecase.checkwinner

import kotlinx.coroutines.delay
import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.entity.rules.canBeat
import pokemoncreator.usecase.checkwinner.ports.CheckWinnerInputPort
import pokemoncreator.usecase.checkwinner.ports.CheckWinnerOutPutPort

class CheckWinnerPokemonInteractor(
    private val outPutPort: CheckWinnerOutPutPort
): CheckWinnerInputPort {
    override suspend fun execute(pokemonOne: PokemonDataEntity, pokemonTwo: PokemonDataEntity) {
        delay(2000L)
        outPutPort.onWinnerDecided(if (pokemonOne.canBeat(pokemonTwo)) pokemonOne else pokemonTwo)
    }
}