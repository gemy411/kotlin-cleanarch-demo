package pokemoncreator.domain.gateway

import pokemoncreator.domain.model.CreatePokemonRequestModel
import pokemoncreator.domain.model.PokemonDomainModel

interface PokemonCreationGateway {
    suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonDomainModel
}