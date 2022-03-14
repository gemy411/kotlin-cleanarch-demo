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
        type: PokemonType,
        power: Int,
        color: PokemonColors,
    ) {
        val processedName = name.trim()
        val processedDescription = description.trimIndent()
        val processedType = type.name.lowercase(Locale.ENGLISH)
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ENGLISH) else it.toString() }
        val processedColor = color.name.lowercase(Locale.ENGLISH)
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ENGLISH) else it.toString() }
        val request = CreatePokemonRequestModel(
            processedName,
            processedDescription,
            processedType,
            power,
            processedColor
        )
        controllerScope.launch {
            createPokemonUseCaseInput.execute(request)
        }
    }
    fun destroyController() {
        controllerScope.cancel()
    }
}