package pokemoncreator.frameworksNdrivers.network.remote

import kotlinx.coroutines.delay
import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.frameworksNdrivers.network.model.PokemonNetworkModel
import pokemoncreator.frameworksNdrivers.network.model.toEntity
import pokemoncreator.interfaceadapters.ports.PokemonRemoteCreator
import pokemoncreator.usecase.usecase.model.CreatePokemonRequestModel

class PokemonRemoteCreatorImpl(
   // can depend on a third party handling HTTP requests
): PokemonRemoteCreator {
    override suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonDataEntity {
        // simulate calling an API
        delay(3000L)
        // dummy object creation just to fulfill the contract
        val (name, description, type, power, color) = requestData
        val apiResponse = PokemonNetworkModel(name, description, type, power, color)
        return apiResponse.toEntity()
    }
}