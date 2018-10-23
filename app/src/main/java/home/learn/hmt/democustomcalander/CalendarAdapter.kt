package home.learn.hmt.democustomcalander

import android.content.Context
import android.graphics.Typeface
import android.icu.util.ChineseCalendar
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.calendar_item.view.*
import java.util.*

class CalendarAdapter : BaseAdapter {
    var context: Context? = null
    var list = ArrayList<Date>()

    constructor(context: Context, list: ArrayList<Date>) : super() {
        this.context = context
        this.list = list
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val today = Date()
        val date = getItem(position)
        val dateLuna = ChineseCalendar(date)
        val day = date.date
        val month = date.month
        val year = date.year
        var inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var calendarLayout = inflator.inflate(R.layout.calendar_item, parent, false)

        calendarLayout.txtCell.setTypeface(null, Typeface.NORMAL)
        calendarLayout.txtCell.setTextColor(context!!.resources.getColor(R.color.black))

        if (month != today.month || year != today.year) {
            calendarLayout.txtCell.setTextColor(context!!.resources.getColor(R.color.greyed_out))
        } else if (day == today.date) {
            calendarLayout.txtCell.setTypeface(null, Typeface.BOLD)
            calendarLayout.txtCell.setTextColor(context!!.resources.getColor(R.color.today))
        }

        calendarLayout.txtCell.text = dateLuna.time.date.toString()

        return calendarLayout
    }

    override fun getItem(position: Int): Date = list[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = list.size
}