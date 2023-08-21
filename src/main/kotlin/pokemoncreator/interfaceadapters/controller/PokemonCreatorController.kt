package pokemoncreator.interfaceadapters.controller

import kotlinx.coroutines.*
import pokemoncreator.frameworksNdrivers.ui.model.PokemonUIModel
import pokemoncreator.frameworksNdrivers.ui.model.toEntity
import pokemoncreator.usecase.checkwinner.ports.CheckWinnerInputPort
import pokemoncreator.usecase.createpokemon.model.CreatePokemonRequestModel
import pokemoncreator.usecase.createpokemon.ports.CreatePokemonInputPort

class PokemonCreatorController(
    private val createPokemonUseCaseInput: CreatePokemonInputPort,
    private val checkWinnerPokemonUseCaseInput: CheckWinnerInputPort,
) {
    private val controllerScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    fun checkWinner(pokemonOne: PokemonUIModel, pokemonTwo: PokemonUIModel) {
        controllerScope.launch {
            checkWinnerPokemonUseCaseInput.execute(pokemonOne.toEntity(), pokemonTwo.toEntity())
        }
    }
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