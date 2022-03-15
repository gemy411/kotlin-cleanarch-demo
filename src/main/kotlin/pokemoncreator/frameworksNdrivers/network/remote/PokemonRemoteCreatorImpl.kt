package pokemoncreator.frameworksNdrivers.network.remote

import kotlinx.coroutines.delay
import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.frameworksNdrivers.network.model.PokemonNetworkModel
import pokemoncreator.frameworksNdrivers.network.model.toEntity
import pokemoncreator.interfaceadapters.ports.PokemonRemoteCreator
import pokemoncreator.usecase.interactor.model.CreatePokemonRequestModel

/**
 * This is where the actual http request is being made. But, if you are using an ORM wrapping the http requests into a
 * set of functions, then the ORM itself would be in the interface adapters layer
 */
class PokemonRemoteCreatorImpl(): PokemonRemoteCreator {
    override suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonDataEntity {
        // simulate calling an API
        delay(3000L)
        // dummy object creation just to fulfill the contract
        val (name, description, type, power, color) = requestData
        val apiResponse = PokemonNetworkModel(name, description, type, power, color)
        return apiResponse.toEntity()
    }
}