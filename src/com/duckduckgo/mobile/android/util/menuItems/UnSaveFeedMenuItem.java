package com.duckduckgo.mobile.android.util.menuItems;

import com.duckduckgo.mobile.android.DDGApplication;
import com.duckduckgo.mobile.android.R;
import com.duckduckgo.mobile.android.activity.DuckDuckGo;
import com.duckduckgo.mobile.android.util.Action;
import com.duckduckgo.mobile.android.util.Item;

public class UnSaveFeedMenuItem extends Item {
	private DuckDuckGo context;
	private String feedObjectId;

	public UnSaveFeedMenuItem(DuckDuckGo context, String feedObjectId){
		super(context.getResources().getString(R.string.Unsave), android.R.drawable.ic_menu_delete, ItemType.UNSAVE);
		this.context = context;
		this.feedObjectId = feedObjectId;
		
		ActionToExecute = getActionToExecute();
	}
	
	public Action getActionToExecute() {
		return new Action() {
			@Override
			public void Execute() {
				final long delResult = DDGApplication.getDB().makeItemHidden(feedObjectId);
				if(delResult != 0) {							
					context.syncAdapters();
				}
			};
		};
	}
}
