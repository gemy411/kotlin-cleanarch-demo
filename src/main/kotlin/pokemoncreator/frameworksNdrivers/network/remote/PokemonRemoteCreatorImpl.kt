package pokemoncreator.frameworksNdrivers.network.remote

import kotlinx.coroutines.delay
import pokemoncreator.interfaceadapters.models.PokemonNetworkResponseModel
import pokemoncreator.interfaceadapters.ports.PokemonRemoteCreator
import pokemoncreator.usecase.createpokemon.model.CreatePokemonRequestModel

/**
 * This is where the actual http request is being made. But, if you are using an ORM wrapping the http requests into a
 * set of functions, then the ORM itself would be in the interface adapters layer
 */
class PokemonRemoteCreatorImpl(): PokemonRemoteCreator {
    override suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonNetworkResponseModel {
        // simulate calling an API
        delay(3000L)
        // dummy object creation just to fulfill the contract
        val (name, description, type, power, color) = requestData
        return PokemonNetworkResponseModel(name, description, type, power, color)
    }
}