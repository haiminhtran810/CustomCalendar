package home.learn.hmt.democustomcalander

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calendar_demo.updateCalendar()
        calendar_demo.setEventHandler(object : CalendarView.EventHandler {
            override fun onDayPress(date: Date) {

            }
        })
    }
}
