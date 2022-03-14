package pokemoncreator.domain.repo

import pokemoncreator.domain.model.CreatePokemonRequestModel

interface PokemonRepo {
    suspend fun createPokemon(requestData: CreatePokemonRequestModel): Boolean
}