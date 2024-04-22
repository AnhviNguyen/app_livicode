

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.newsprojectpractice.R

class CourseApdater(
    private val context: Context,
    private val expandableListTitle: List<String?>,
    private val expandableListDetail: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        val count = expandableListTitle.size
       return count
    }

    override fun getChildrenCount(groupPosition: Int): Int {
     return expandableListDetail[expandableListTitle[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): Any? {
       return  expandableListTitle[groupPosition]

    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return expandableListDetail[expandableListTitle[groupPosition]]!!.get(childPosition)

    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
       return  childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val convertView = LayoutInflater.from(context).inflate(R.layout.list_group_expandable_lesson, null)
        val listTitle = getGroup(groupPosition) as String
        val listTitleTextView = convertView.findViewById(R.id.lesson_name) as TextView
        listTitleTextView.setTypeface(null, Typeface.BOLD)
        listTitleTextView.text = listTitle
        return  convertView
    }

    @SuppressLint("MissingInflatedId")
    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val convertView = LayoutInflater.from(context).inflate(R.layout.list_item_expandable_lesson, null)
        val expandListText = getChild(groupPosition, childPosition) as String
        val expandedListTextView = convertView.findViewById<TextView>(R.id.video_name) as TextView
        expandedListTextView.text = expandListText
        return  convertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
       return  true
    }


}