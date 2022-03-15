package pokemoncreator.interfaceadapters.gateway

import kotlinx.coroutines.delay
import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.usecase.usecase.model.CreatePokemonRequestModel
import pokemoncreator.usecase.usecase.ports.PokemonCreator

class PokemonCreatorImpl: PokemonCreator {
    override suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonDataEntity {
        delay(3000L)
        val (name, description, type, power, color) = requestData
        if (name.isBlank()) throw IllegalArgumentException("Name can't be empty!")
        return PokemonDataEntity(
            name, description, type, power, color
        )
    }
}