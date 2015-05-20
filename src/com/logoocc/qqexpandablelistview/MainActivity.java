package com.logoocc.qqexpandablelistview;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;

import android.widget.ExpandableListView;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ExpandableListView expandableListView;
	private ExpandableListAdapters adapter ;
	private String[] groups = { "我的好友", "我的家人", "妹子", "神马" };
	private String[][] children = { { "Google glass", "Cortana", "iPhone" },
			{ "facebook", "snachat", "twitter" },
			{ "Oracle", "Mysql", "Redis" },
			{"Android","iOS","COCOS"}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		super.registerForContextMenu(expandableListView);
		expandableListView.setAdapter(adapter);
	}

	private void initView() {
		expandableListView = (ExpandableListView) findViewById(R.id.expList);
		adapter = new ExpandableListAdapters(this,groups,children);
		expandableListView
				.setOnChildClickListener(new OnChildClickListenerImpl());
		expandableListView
				.setOnGroupClickListener(new OnGroupClickListenerImpl());
		expandableListView
				.setOnGroupExpandListener(new OnGroupExpandListenerImpl());
		expandableListView
				.setOnGroupCollapseListener(new OnGroupCollapseListenerImpl());
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {

		super.onCreateContextMenu(menu, v, menuInfo);
		ExpandableListView.ExpandableListContextMenuInfo info = (ExpandableListContextMenuInfo) menuInfo;
		// 取得菜单项
		int type = ExpandableListView
				.getPackedPositionType(info.packedPosition);
		// 取得所在组的索引
		int groups = ExpandableListView
				.getPackedPositionGroup(info.packedPosition);
		// 取得子菜单项的索引
		int child = expandableListView
				.getPackedPositionChild(info.packedPosition);

		Toast.makeText(getApplicationContext(),
				"type " + type + "groups" + groups + "child" + child,
				Toast.LENGTH_SHORT).show();
	}

	private class OnGroupCollapseListenerImpl implements
			OnGroupCollapseListener {

		@Override
		public void onGroupCollapse(int groupPosition) {// TODO Auto-generated
														// method stub
			Toast.makeText(getApplicationContext(), "关闭分组 " + groupPosition,
					Toast.LENGTH_SHORT).show();
		}

	}

	private class OnGroupExpandListenerImpl implements OnGroupExpandListener {

		@Override
		public void onGroupExpand(int groupPosition) {
			Toast.makeText(getApplicationContext(), "打开分组" + groupPosition,
					Toast.LENGTH_SHORT).show();

		}

	}

	private class OnChildClickListenerImpl implements OnChildClickListener {

		@Override
		public boolean onChildClick(ExpandableListView parent, View v,
				int groupPosition, int childPosition, long id) {
			Toast.makeText(getApplicationContext(),
					"分组" + groupPosition + "子选项" + childPosition + "被选中",
					Toast.LENGTH_SHORT).show();
			return false;
		}

	}

	private class OnGroupClickListenerImpl implements OnGroupClickListener {

		@Override
		public boolean onGroupClick(ExpandableListView parent, View v,
				int groupPosition, long id) {
			Toast.makeText(getApplicationContext(),
					"分组 "+groupPosition+" 被选中" , Toast.LENGTH_SHORT)
					.show();

			return false;
		}

	}

}
