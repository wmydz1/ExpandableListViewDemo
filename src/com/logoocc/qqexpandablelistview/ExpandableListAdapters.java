package com.logoocc.qqexpandablelistview;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListAdapters extends BaseExpandableListAdapter {
	private Context context;
	private String[] groups;
	private String[][] children;
	


//	private String[] groups = { "我的好友", "我的家人", "妹子", "神马" };
//	private String[][] children = { { "Google glass", "Cortana", "iPhone" },
//			{ "facebook", "snachat", "twitter" },
//			{ "Oracle", "Mysql", "Redis" },
//			{"Android","iOS","COCOS"}
//	};

	public ExpandableListAdapters(Context context, String[] groups,
			String[][] children) {
	
		this.context = context;
		this.groups = groups;
		this.children = children;
	}


	private TextView buidTextView() {
		AbsListView.LayoutParams params = new AbsListView.LayoutParams(
				ViewGroup.LayoutParams.FILL_PARENT, 35);
		TextView textView = new TextView(context);
		textView.setLayoutParams(params);
		textView.setTextSize(15.0f);
		textView.setGravity(Gravity.LEFT);
		textView.setPadding(40, 8, 3, 3);
		return textView;
	}

	
	//groups
	@Override
	public int getGroupCount() {

		return groups.length;
	}
	@Override
	public Object getGroup(int groupPosition) {

		return groups[groupPosition];
	}
	@Override
	public long getGroupId(int groupPosition) {

		return groupPosition;
	}

	
	//child
	@Override
	public Object getChild(int groupPosition, int childPosition) {

		return children[groupPosition][childPosition];
	}
	
	@Override
	public long getChildId(int groupPosition, int childPosition) {

		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		TextView textView = buidTextView();
		textView.setText(getChild(groupPosition, childPosition).toString());

		return textView;

	}
	@Override
	public int getChildrenCount(int groupPosition) {

		return children[groupPosition].length;
	}

//-----
	
	
	
	
	

	
	
	@Override
	public boolean hasStableIds() {

		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {

		TextView textView = buidTextView();
		textView.setText(getGroup(groupPosition).toString());

		return textView;
	}

	
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {

		return true;
	}

}
