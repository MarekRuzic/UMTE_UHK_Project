package cz.uhk.fim.cryptoapp

import cz.uhk.fim.cryptoapp.repository.FavouriteRepository
import cz.uhk.fim.cryptoapp.viewmodels.FavouriteCryptoViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { FavouriteRepository() }
}

val viewModelModule = module {
    viewModel { FavouriteCryptoViewModel(get()) }
}