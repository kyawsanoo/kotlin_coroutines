package kso.android.kotlincoroutines.ui.timeout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import kso.android.kotlincoroutines.data.api.ApiHelper
import kso.android.kotlincoroutines.data.local.DatabaseHelper
import kso.android.kotlincoroutines.data.model.ApiUser
import kso.android.kotlincoroutines.ui.base.UiState

class TimeoutViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
) : ViewModel() {

    private val uiState = MutableLiveData<UiState<List<ApiUser>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            uiState.postValue(UiState.Loading)
            try {
                withTimeout(100) {
                    val usersFromApi = apiHelper.getUsers()
                    uiState.postValue(UiState.Success(usersFromApi))
                }
            } catch (e: TimeoutCancellationException) {
                uiState.postValue(UiState.Error("TimeoutCancellationException"))
            } catch (e: Exception) {
                uiState.postValue(UiState.Error("Something Went Wrong"))
            }
        }
    }

    fun getUiState(): LiveData<UiState<List<ApiUser>>> {
        return uiState
    }

}