package pokemoncreator.ui

import pokemoncreator.data.repo.PokemonRepoImpl
import pokemoncreator.domain.usecase.CreatePokemonUseCase
import pokemoncreator.interfaceadapters.controller.PokemonColors
import pokemoncreator.interfaceadapters.controller.PokemonType
import pokemoncreator.interfaceadapters.controller.PokemonCreatorController
import pokemoncreator.interfaceadapters.presenter.PokemonPresenter
import pokemoncreator.interfaceadapters.view.PokemonView

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
        controller.createPokemon(
            "   Charmendar ",
            """
               This pokemon is a fire pokemon and is truly very powerful!  
            """,
            PokemonType.FIRE,
            44,
            PokemonColors.ORANGE,
        )

    }

    override fun showError() {
        // update UI
    }

    override fun hideError() {
        // update UI
    }
}