package pokemoncreator.usecase.interactor.ports

import pokemoncreator.entity.model.PokemonDataEntity
import pokemoncreator.usecase.interactor.model.CreatePokemonRequestModel

interface PokemonCreator {
    suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonDataEntity
}