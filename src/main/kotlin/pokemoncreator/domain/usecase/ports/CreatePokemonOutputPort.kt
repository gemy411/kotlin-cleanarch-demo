package pokemoncreator.domain.usecase.ports

interface CreatePokemonOutputPort {
    fun onFinishedCreatingPokemon(success: Boolean)
}
