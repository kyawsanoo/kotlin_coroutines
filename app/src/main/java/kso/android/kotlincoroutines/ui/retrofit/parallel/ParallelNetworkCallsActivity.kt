package kso.android.kotlincoroutines.ui.retrofit.parallel

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kso.android.kotlincoroutines.databinding.ActivityRecyclerViewBinding
import kso.android.kotlincoroutines.data.api.ApiHelperImpl
import kso.android.kotlincoroutines.data.api.RetrofitBuilder
import kso.android.kotlincoroutines.data.local.DatabaseBuilder
import kso.android.kotlincoroutines.data.local.DatabaseHelperImpl
import kso.android.kotlincoroutines.data.model.ApiUser
import kso.android.kotlincoroutines.ui.base.ApiUserAdapter
import kso.android.kotlincoroutines.ui.base.UiState
import kso.android.kotlincoroutines.ui.base.ViewModelFactory

class ParallelNetworkCallsActivity : AppCompatActivity() {

    private lateinit var viewModel: ParallelNetworkCallsViewModel
    private lateinit var adapter: ApiUserAdapter
    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter =
            ApiUserAdapter(
                arrayListOf()
            )
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.getUiState().observe(this) {
            when (it) {
                is UiState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    renderList(it.data)
                    binding.recyclerView.visibility = View.VISIBLE
                }
                is UiState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
                is UiState.Error -> {
                    //Handle Error
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun renderList(users: List<ApiUser>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
            )
        )[ParallelNetworkCallsViewModel::class.java]
    }
}
