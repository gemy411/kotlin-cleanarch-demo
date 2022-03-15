package pokemoncreator.data.gateway

import kotlinx.coroutines.delay
import pokemoncreator.domain.gateway.PokemonCreationGateway
import pokemoncreator.domain.model.CreatePokemonRequestModel
import pokemoncreator.domain.model.PokemonDomainModel

class PokemonCreationGatewayImpl: PokemonCreationGateway {
    override suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonDomainModel {
        delay(3000L)
        val (name, description, type, power, color) = requestData
        if (name.isBlank()) throw IllegalArgumentException("Name can't be empty!")
        return PokemonDomainModel(
            name, description, type, power, color
        )
    }
}