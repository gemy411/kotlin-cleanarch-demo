package pokemoncreator.domain.usecase

import pokemoncreator.domain.model.CreatePokemonRequestModel
import pokemoncreator.domain.model.PokemonDomainModel
import pokemoncreator.domain.repo.PokemonRepo
import pokemoncreator.domain.usecase.ports.CreatePokemonInputPort
import pokemoncreator.domain.usecase.ports.CreatePokemonOutputPort

class CreatePokemonUseCase(
    private val pokemonRepo: PokemonRepo,
    private val outputPort: CreatePokemonOutputPort
): CreatePokemonInputPort {

    override suspend fun execute(createPokemonRequestModel: CreatePokemonRequestModel) {
        try {
            val pokemon = pokemonRepo.createPokemon(createPokemonRequestModel)
            outputPort.onFinishedCreatingPokemon(pokemon)
        } catch (e: Exception) {
            outputPort.onFailed(e.message ?: "Domain error!")
        }
    }
}