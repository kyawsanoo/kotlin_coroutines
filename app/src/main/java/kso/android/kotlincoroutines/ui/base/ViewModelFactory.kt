package kso.android.kotlincoroutines.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kso.android.kotlincoroutines.data.api.ApiHelper
import kso.android.kotlincoroutines.data.local.DatabaseHelper
import kso.android.kotlincoroutines.ui.errorhandling.exceptionhandler.ExceptionHandlerViewModel
import kso.android.kotlincoroutines.ui.errorhandling.supervisor.IgnoreErrorAndContinueViewModel
import kso.android.kotlincoroutines.ui.errorhandling.trycatch.TryCatchViewModel
import kso.android.kotlincoroutines.ui.retrofit.parallel.ParallelNetworkCallsViewModel
import kso.android.kotlincoroutines.ui.retrofit.series.SeriesNetworkCallsViewModel
import kso.android.kotlincoroutines.ui.retrofit.single.SingleNetworkCallViewModel
import kso.android.kotlincoroutines.ui.room.RoomDBViewModel
import kso.android.kotlincoroutines.ui.task.onetask.LongRunningTaskViewModel
import kso.android.kotlincoroutines.ui.task.twotasks.TwoLongRunningTasksViewModel
import kso.android.kotlincoroutines.ui.timeout.TimeoutViewModel

class ViewModelFactory(private val apiHelper: ApiHelper, private val dbHelper: DatabaseHelper) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SingleNetworkCallViewModel::class.java)) {
            return SingleNetworkCallViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(SeriesNetworkCallsViewModel::class.java)) {
            return SeriesNetworkCallsViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(ParallelNetworkCallsViewModel::class.java)) {
            return ParallelNetworkCallsViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(RoomDBViewModel::class.java)) {
            return RoomDBViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(TimeoutViewModel::class.java)) {
            return TimeoutViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(TryCatchViewModel::class.java)) {
            return TryCatchViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(ExceptionHandlerViewModel::class.java)) {
            return ExceptionHandlerViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(LongRunningTaskViewModel::class.java)) {
            return LongRunningTaskViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(TwoLongRunningTasksViewModel::class.java)) {
            return TwoLongRunningTasksViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(IgnoreErrorAndContinueViewModel::class.java)) {
            return IgnoreErrorAndContinueViewModel(apiHelper, dbHelper) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}