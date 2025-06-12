package com.example.hercryptoapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hercryptoapp.data.model.CryptoModel
import com.example.hercryptoapp.data.repository.CryptoRepository
import kotlinx.coroutines.launch

class CryptoViewModel : ViewModel() {
    private val repository = CryptoRepository()
    private val _cryptoList = mutableStateOf<List<CryptoModel>>(emptyList())
    private val _searchQuery = mutableStateOf("")

    val searchQuery: State<String> = _searchQuery
    val cryptoList: State<List<CryptoModel>> = _cryptoList

    private var fullCryptoList = listOf<CryptoModel>()

    init {
        fetchCryptoData()
    }

    private fun fetchCryptoData() {
        viewModelScope.launch {
            fullCryptoList = repository.getCryptoList()
            filterCryptoList()
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        filterCryptoList()
    }

    private fun filterCryptoList() {
        if (_searchQuery.value.isEmpty()) {
            _cryptoList.value = fullCryptoList
        } else {
            _cryptoList.value = fullCryptoList.filter {
                it.name.lowercase().contains(_searchQuery.value.lowercase()) ||
                        it.symbol.lowercase().contains(_searchQuery.value.lowercase())
            }
        }
    }
}