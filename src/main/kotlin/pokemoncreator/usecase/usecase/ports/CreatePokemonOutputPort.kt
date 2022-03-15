package pokemoncreator.usecase.usecase.ports

import pokemoncreator.entity.model.PokemonDataEntity

interface CreatePokemonOutputPort {
    fun onFinishedCreatingPokemon(pokemon: PokemonDataEntity)
    fun onFailed(errorMessage: String)
}
