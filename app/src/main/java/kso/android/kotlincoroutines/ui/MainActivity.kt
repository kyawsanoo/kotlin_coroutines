package kso.android.kotlincoroutines.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kso.android.kotlincoroutines.databinding.ActivityMainBinding
import kso.android.kotlincoroutines.ui.basic.BasicActivity
import kso.android.kotlincoroutines.ui.errorhandling.exceptionhandler.ExceptionHandlerActivity
import kso.android.kotlincoroutines.ui.errorhandling.supervisor.IgnoreErrorAndContinueActivity
import kso.android.kotlincoroutines.ui.errorhandling.trycatch.TryCatchActivity
import kso.android.kotlincoroutines.ui.retrofit.parallel.ParallelNetworkCallsActivity
import kso.android.kotlincoroutines.ui.retrofit.series.SeriesNetworkCallsActivity
import kso.android.kotlincoroutines.ui.retrofit.single.SingleNetworkCallActivity
import kso.android.kotlincoroutines.ui.room.RoomDBActivity
import kso.android.kotlincoroutines.ui.task.onetask.LongRunningTaskActivity
import kso.android.kotlincoroutines.ui.task.twotasks.TwoLongRunningTasksActivity
import kso.android.kotlincoroutines.ui.timeout.TimeoutActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun startSingleNetworkCallActivity(view: View) {
        startActivity(Intent(this@MainActivity, SingleNetworkCallActivity::class.java))
    }

    fun startSeriesNetworkCallsActivity(view: View) {
        startActivity(Intent(this@MainActivity, SeriesNetworkCallsActivity::class.java))
    }

    fun startParallelNetworkCallsActivity(view: View) {
        startActivity(Intent(this@MainActivity, ParallelNetworkCallsActivity::class.java))
    }

    fun startRoomDatabaseActivity(view: View) {
        startActivity(Intent(this@MainActivity, RoomDBActivity::class.java))
    }

    fun startTimeoutActivity(view: View) {
        startActivity(Intent(this@MainActivity, TimeoutActivity::class.java))
    }

    fun startTryCatchActivity(view: View) {
        startActivity(Intent(this@MainActivity, TryCatchActivity::class.java))
    }

    fun startExceptionHandlerActivity(view: View) {
        startActivity(Intent(this@MainActivity, ExceptionHandlerActivity::class.java))
    }

    fun startIgnoreErrorAndContinueActivity(view: View) {
        startActivity(Intent(this@MainActivity, IgnoreErrorAndContinueActivity::class.java))
    }

    fun startLongRunningTaskActivity(view: View) {
        startActivity(Intent(this@MainActivity, LongRunningTaskActivity::class.java))
    }

    fun startTwoLongRunningTasksActivity(view: View) {
        startActivity(Intent(this@MainActivity, TwoLongRunningTasksActivity::class.java))
    }

    fun startBasicActivity(view: View) {
        startActivity(Intent(this@MainActivity, BasicActivity::class.java))
    }

}
