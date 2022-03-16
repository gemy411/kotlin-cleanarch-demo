package pokemoncreator.usecase.checkwinner.ports

import pokemoncreator.entity.model.PokemonDataEntity

interface CheckWinnerInputPort {
    suspend fun execute(pokemonOne: PokemonDataEntity, pokemonTwo: PokemonDataEntity)
}