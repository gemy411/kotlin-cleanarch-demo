package pokemoncreator.domain.usecase.ports

import pokemoncreator.domain.model.CreatePokemonRequestModel

interface CreatePokemonInputPort {
    suspend fun execute(createPokemonRequestModel: CreatePokemonRequestModel)
}