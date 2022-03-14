package pokemoncreator.interfaceadapters.controller

import pokemoncreator.domain.model.CreatePokemonRequestModel
import pokemoncreator.domain.usecase.ports.CreatePokemonInputPort
import kotlinx.coroutines.*
import java.util.*

class PokemonCreatorController(private val createPokemonUseCaseInput: CreatePokemonInputPort) {
    private val controllerScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    fun createPokemon(
        name: String,
        description: String,
        type: String,
        power: Int,
        color: String,
    ) {
        val processedName = name.trim()
        val processedDescription = description.trimIndent()
        val request = CreatePokemonRequestModel(
            processedName,
            processedDescription,
            type,
            power,
            color,
        )
        controllerScope.launch {
            createPokemonUseCaseInput.execute(request)
        }
    }
    fun destroyController() {
        controllerScope.cancel()
    }
}