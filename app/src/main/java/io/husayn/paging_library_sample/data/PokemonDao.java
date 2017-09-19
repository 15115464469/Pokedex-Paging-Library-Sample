package io.husayn.paging_library_sample.data;

import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface PokemonDao {

    @Query("SELECT * FROM pokemon ORDER BY id ASC")
    public LivePagedListProvider<Integer, Pokemon> pokemons();


    @Insert
    void insert(Pokemon... pokemons);
}
