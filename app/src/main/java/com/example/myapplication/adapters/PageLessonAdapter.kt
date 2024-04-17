import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.fragment.Intro_lesson_Fragment
import com.example.myapplication.fragment.Test_lesson_Fragment
import com.example.myapplication.fragment.discuss_lesson_fragment


class PageLessonAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return  3
    }

    override fun createFragment(position: Int): Fragment {
        if(position == 0)
            return Intro_lesson_Fragment()
        else if (position ==1)
            return Test_lesson_Fragment()
        else
            return discuss_lesson_fragment()

    }

}