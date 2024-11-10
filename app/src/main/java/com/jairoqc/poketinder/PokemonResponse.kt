package com.jairoqc.poketinder

data class PokemonResponse(
    val name: String,
    val url: String
) {
    fun getPokemonId() = getIdPokemonFromUrl(url)
    fun getIdPokemonFromUrl(url: String): String =
        url.split("/").toTypedArray()[6]
    fun getPokemonImage(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getPokemonId()}.png"
}
