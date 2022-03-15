package pokemoncreator.usecase.usecase

import pokemoncreator.usecase.usecase.model.CreatePokemonRequestModel
import pokemoncreator.usecase.usecase.ports.CreatePokemonInputPort
import pokemoncreator.usecase.usecase.ports.CreatePokemonOutputPort
import pokemoncreator.usecase.usecase.ports.PokemonCreator

class CreatePokemonUseCaseInteractor(
    private val pokemonCreator: PokemonCreator,
    private val outputPort: CreatePokemonOutputPort
): CreatePokemonInputPort {

    override suspend fun execute(createPokemonRequestModel: CreatePokemonRequestModel) {
        try {
            val pokemon = pokemonCreator.createPokemon(createPokemonRequestModel)
            outputPort.onFinishedCreatingPokemon(pokemon)
        } catch (e: Exception) {
            outputPort.onFailed(e.message ?: "Domain error!")
        }
    }
}