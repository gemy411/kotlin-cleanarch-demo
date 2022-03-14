package pokemoncreator.ui

import pokemoncreator.data.repo.PokemonRepoImpl
import pokemoncreator.domain.usecase.CreatePokemonUseCase
import pokemoncreator.interfaceadapters.controller.PokemonColors
import pokemoncreator.interfaceadapters.controller.PokemonType
import pokemoncreator.interfaceadapters.controller.PokemonCreatorController
import pokemoncreator.interfaceadapters.presenter.PokemonPresenter
import pokemoncreator.interfaceadapters.view.PokemonView
import pokemoncreator.ui.model.PokemonUIModel

// DI section
// data
private val pokemonRepo = PokemonRepoImpl()

class UIComponent: PokemonView {

    //adapter
    private val presenter by lazy {
        PokemonPresenter(this)
    }

    // User case inter-actor
    private val createPokemonUseCase  = CreatePokemonUseCase(pokemonRepo, presenter)

    // adapter
    private val controller = PokemonCreatorController(createPokemonUseCase)

    init {
        println("Welcome to Pokemon creator!")

        println("Please start by entering the Pokemon's name..")
        val name = readlnOrNull()

        println("Now it's time for a poetic descriptive and non-self-destructive description..")
        val desc = readlnOrNull() ?: ""

        println("""
            Enter a Pokemon type from ${PokemonType.values().joinToString()}....
        """.trimIndent())
        val type = readlnOrNull() ?: ""

        println("How much power does it have??")
        val power = readlnOrNull()?.toIntOrNull() ?: 0

        println("""
            Enter a Pokemon color from ${PokemonColors.values().joinToString()}....
        """.trimIndent())
        val color = readlnOrNull() ?: ""

        println("LOADING.....")

        controller.createPokemon(
            name ?: "No name",
            desc,
            type,
            44,
            color,
        )
    }


    override fun onPokemonCreated(pokemonUIModel: PokemonUIModel) {
        println("Pokemon created as $pokemonUIModel")
    }

    override fun onPokemonCreationFailed(errorMessage: String) {
        println("Pokemon creation failed :( :( with message $errorMessage")
    }
}