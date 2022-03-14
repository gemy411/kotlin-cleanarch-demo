package pokemoncreator.domain.repo

import pokemoncreator.domain.model.CreatePokemonRequestModel
import pokemoncreator.domain.model.PokemonDomainModel

interface PokemonRepo {
    suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonDomainModel
}