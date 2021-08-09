package com.kobeissidev.jetpackcomposepokedex.data.remote

import com.kobeissidev.jetpackcomposepokedex.data.model.entry.PokemonEntry
import com.kobeissidev.jetpackcomposepokedex.data.model.evolution.Evolution
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.data.model.species.Species
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    /**
     * Get the Pokemon Entry object. This will contain the results of Pokemon which contain the name and url.
     * @param offset is the offset of the page we'll be fetching.
     * @param limit is the number of items per query to fetch.
     */
    @GET("pokemon")
    suspend fun getPokemonEntry(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<PokemonEntry>

    /**
     * Get the Pokemon object. This will contain the Pokemon which contain the data.
     * @param name is the name of the Pokemon to fetch.
     */
    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): Response<Pokemon>

    /**
     * Get the Pokemon species object.
     * @param id is the id of the Pokemon species to fetch.
     */
    @GET("pokemon-species/{id}")
    suspend fun getPokemonSpecies(
        @Path("id") id: String
    ): Response<Species>

    /**
     * Get the Pokemon evolution object.
     * @param id is the id of the Pokemon evolution chain obtained from the species result.
     */
    @GET("evolution-chain/{id}")
    suspend fun getPokemonEvolutionChain(
        @Path("id") id: String
    ): Response<Evolution>
}