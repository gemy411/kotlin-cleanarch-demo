package pokemoncreator.interfaceadapters.ports

import pokemoncreator.interfaceadapters.models.PokemonNetworkResponseModel
import pokemoncreator.usecase.interactor.model.CreatePokemonRequestModel

interface PokemonRemoteCreator {
    suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonNetworkResponseModel
}