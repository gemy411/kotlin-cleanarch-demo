package pokemoncreator.data.repo

import pokemoncreator.domain.model.CreatePokemonRequestModel
import pokemoncreator.domain.repo.PokemonRepo
import kotlinx.coroutines.delay

class PokemonRepoImpl: PokemonRepo {
    override suspend fun createPokemon(requestData: CreatePokemonRequestModel): Boolean {
        delay(1000L)
        return true
    }
}