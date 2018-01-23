package com.privalia.albert.challange.presentation.di.module;

import com.privalia.albert.challange.data.net.Api;
import com.privalia.albert.challange.data.store.imageConfiguration.ImageConfigurationDataStore;
import com.privalia.albert.challange.data.store.imageConfiguration.impl.ImageConfigurationDataStoreImpl;
import com.privalia.albert.challange.data.store.movie.MovieDataStore;
import com.privalia.albert.challange.data.store.movie.impl.MovieDataStoreImpl;
import com.privalia.albert.challange.presentation.di.scope.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albert on 7/1/18.
 */

@Module
public class DataStoreModule {

    @Provides
    @AppScope
    MovieDataStore provideMovieDataStore(Api api){
        return new MovieDataStoreImpl(api);
    }

    @Provides
    @AppScope
    ImageConfigurationDataStore provideImageConfigurationDataStore(Api api){
        return new ImageConfigurationDataStoreImpl(api);
    }
}
