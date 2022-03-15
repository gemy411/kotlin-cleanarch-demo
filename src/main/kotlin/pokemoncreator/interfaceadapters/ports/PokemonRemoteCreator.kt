package pokemoncreator.interfaceadapters.ports

import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.usecase.usecase.model.CreatePokemonRequestModel

interface PokemonRemoteCreator {
    suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonDataEntity
}