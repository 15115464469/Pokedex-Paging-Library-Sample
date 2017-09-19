package io.husayn.paging_library_sample;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;

public class MainViewModel extends ViewModel {

    public static final int INITIAL_LOAD_KEY = 0;
    public static final int PAGE_SIZE = 20;
    public static final int PREFETCH_DISTANCE = 5;

    public PokemonDao pokemonDao = PokemonDataBase.getInstance(PokemonApplication.getContext()).pokemonDao();
    public final LiveData<PagedList<Pokemon>> pokemonList;

    public MainViewModel() {
        pokemonList = pokemonDao.pokemons().create(INITIAL_LOAD_KEY, new PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .setPrefetchDistance(PREFETCH_DISTANCE)
                .setEnablePlaceholders(true)
                .build()
        );
    }
}
