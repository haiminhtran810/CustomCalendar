package home.learn.hmt.democustomcalander

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import java.lang.Exception

const val SWIPE_THRESHOLD = 100
const val SWIPE_VELOCITY_THRESHOLD = 100

open class OnSwipeTouchListener(context: Context) : View.OnTouchListener {
    private var gestureDetector: GestureDetector

    init {
        gestureDetector = GestureDetector(context, GestureListener())
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return try {
            gestureDetector.onTouchEvent(p1)
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }


    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent?): Boolean {
            return true
        }

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            return super.onSingleTapUp(e)
        }

        override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
            var result = false
            try {
                val diffY = e2!!.y - e1!!.y
                val diffX = e2.x - e1.x
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight()
                        } else {
                            onSwipeLeft()
                        }
                    }
                    result = true
                }
            } catch (e: Exception) {

            }
            return super.onFling(e1, e2, velocityX, velocityY)
        }
    }

    open fun onSwipeRight() {}
    open fun onSwipeLeft() {}
}