package pokemoncreator.interfaceadapters.ports

import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.usecase.interactor.model.CreatePokemonRequestModel

interface PokemonRemoteCreator {
    suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonDataEntity
}