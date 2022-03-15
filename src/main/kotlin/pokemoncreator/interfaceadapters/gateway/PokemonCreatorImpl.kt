package pokemoncreator.interfaceadapters.gateway

import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.interfaceadapters.ports.PokemonRemoteCreator
import pokemoncreator.usecase.usecase.model.CreatePokemonRequestModel
import pokemoncreator.usecase.usecase.ports.PokemonCreator

class PokemonCreatorImpl(private val pokemonRemoteCreator: PokemonRemoteCreator): PokemonCreator {
    override suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonDataEntity {
        if (requestData.name.isBlank()) throw IllegalArgumentException("Name can't be empty!")
        return pokemonRemoteCreator.createPokemon(requestData)
    }
}