package pokemoncreator.usecase.checkwinner.ports

import pokemoncreator.entity.model.PokemonDataEntity

interface CheckWinnerOutPutPort {
    fun onWinnerDecided(pokemon: PokemonDataEntity)
}