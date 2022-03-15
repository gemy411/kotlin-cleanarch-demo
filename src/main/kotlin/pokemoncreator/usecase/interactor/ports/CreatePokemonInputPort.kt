package pokemoncreator.usecase.interactor.ports

import pokemoncreator.usecase.interactor.model.CreatePokemonRequestModel

interface CreatePokemonInputPort {
    suspend fun execute(createPokemonRequestModel: CreatePokemonRequestModel)
}