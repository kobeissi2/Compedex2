package com.kobeissidev.jetpackcomposepokedex.data.local

import androidx.paging.PagingSource
import androidx.room.*
import com.kobeissidev.jetpackcomposepokedex.data.model.entry.PokemonEntry
import com.kobeissidev.jetpackcomposepokedex.data.model.pokemon.Pokemon
import com.kobeissidev.jetpackcomposepokedex.data.model.remotekey.RemoteKey

@Dao
interface PokeDao {

    /**
     * Insert the Pokemon Entry. Results only contain the Pokemon name.
     * @see PokemonEntry
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPokemonEntries(pokemon: PokemonEntry)

    /**
     * Get all of the Pokemon Entries. Only contains the Pokemon name.
     * @see PokemonEntry
     */
    @Query("SELECT * FROM pokemon_entry")
    fun getAllPokemonEntries(): PagingSource<Int, PokemonEntry>

    /**
     * Deletes all of the Pokemon Entries.
     * @see PokemonEntry
     */
    @Query("DELETE FROM pokemon_entry")
    suspend fun deleteAllPokemonEntries()

    /**
     * Insert a specific Pokemon. It should contain the complete Pokemon data.
     * @see Pokemon
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: Pokemon)

    /**
     * Get all of the Pokemon. Only contains the Pokemon name.
     * @see Pokemon
     */
    @Query("SELECT * FROM pokemon")
    fun getAllPokemon(): List<Pokemon>

    /**
     * Deletes all of the Pokemon.
     * @see Pokemon
     */
    @Query("DELETE FROM pokemon")
    suspend fun deleteAllPokemon()

    /**
     * Update a specific Pokemon.
     * @see Pokemon
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updatePokemon(pokemon: Pokemon)

    /**
     * Get a specific Pokemon.
     * @see Pokemon
     */
    @Query("SELECT * FROM pokemon WHERE id = :id")
    suspend fun getPokemon(id: Int): Pokemon?

    /**
     * Insert the remote key for paging.
     * @see RemoteKey
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRemoteKeys(remoteKey: RemoteKey)

    /**
     * Get a specific remote key to check if we should fetch or page.
     * @see RemoteKey
     */
    @Query("SELECT * FROM remote_key WHERE id = :id")
    suspend fun getRemoteKey(id: Int): RemoteKey?

    /**
     * Deletes all of the remote keys.
     * @see RemoteKey
     */
    @Query("DELETE FROM remote_key")
    suspend fun deleteAllRemoteKeys()
}