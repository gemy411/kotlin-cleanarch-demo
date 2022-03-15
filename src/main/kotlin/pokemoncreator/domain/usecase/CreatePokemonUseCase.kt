package pokemoncreator.domain.usecase

import pokemoncreator.domain.gateway.PokemonCreationGateway
import pokemoncreator.domain.model.CreatePokemonRequestModel
import pokemoncreator.domain.usecase.ports.CreatePokemonInputPort
import pokemoncreator.domain.usecase.ports.CreatePokemonOutputPort

class CreatePokemonUseCase(
    private val pokemonCreationGateway: PokemonCreationGateway,
    private val outputPort: CreatePokemonOutputPort
): CreatePokemonInputPort {

    override suspend fun execute(createPokemonRequestModel: CreatePokemonRequestModel) {
        try {
            val pokemon = pokemonCreationGateway.createPokemon(createPokemonRequestModel)
            outputPort.onFinishedCreatingPokemon(pokemon)
        } catch (e: Exception) {
            outputPort.onFailed(e.message ?: "Domain error!")
        }
    }
}