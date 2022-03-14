package pokemoncreator.domain.usecase.ports

import pokemoncreator.domain.model.PokemonDomainModel

interface CreatePokemonOutputPort {
    fun onFinishedCreatingPokemon(pokemon: PokemonDomainModel)
    fun onFailed(errorMessage: String)
}
