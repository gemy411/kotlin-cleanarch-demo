package pokemoncreator.data.repo

import pokemoncreator.domain.model.CreatePokemonRequestModel
import pokemoncreator.domain.repo.PokemonRepo
import kotlinx.coroutines.delay
import pokemoncreator.domain.model.PokemonDomainModel

class PokemonRepoImpl: PokemonRepo {
    override suspend fun createPokemon(requestData: CreatePokemonRequestModel): PokemonDomainModel {
        delay(3000L)
        val (name, description, type, power, color) = requestData
        return PokemonDomainModel(
            name, description, type, power, color
        )
    }
}