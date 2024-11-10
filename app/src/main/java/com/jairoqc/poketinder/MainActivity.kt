package com.jairoqc.poketinder
import PokemonAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.jairoqc.poketinder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var listPokemon: List<PokemonResponse> = emptyList()
    private val adapter by lazy { PokemonAdapter(listPokemon) }
    private lateinit var binding : ActivityMainBinding
    private val viewModel by lazy { MainViewModel() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvTinderPokemon.adapter = adapter
        observeValues()
    }
    private fun observeValues() {
        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.isVisible = isLoading
        }
        viewModel.pokemonList.observe(this) { pokemonList ->
            adapter.list = pokemonList
            adapter.notifyDataSetChanged()
        }
        viewModel.errorApi.observe(this) { errorMessage ->
            showMessage(errorMessage)
        }
    }
    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
