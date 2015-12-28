package com.android.customviewpagerindicator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FeedBackContentFragment extends BaseFragment {

    private ListView listView;
    private String[] contentArray;
    private String title;
    private int typeposition=0;

    public static FeedBackContentFragment newInstance(String title,String[] contentArray,int position) {
        FeedBackContentFragment feedBackContentFragment= new FeedBackContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putStringArray("contentArray", contentArray);
        feedBackContentFragment.setArguments(bundle);
        return feedBackContentFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feedback_content_fragment, null);
        initViews(view);
        return view;
    }
private void initViews(View view) {
    title = getArguments().getString("title");
    contentArray = getArguments().getStringArray("contentArray");
    listView = (ListView) view.findViewById(R.id.listView);
    listView.setAdapter(new FeedBackListViewAdapter(contentArray, getActivity()));

}

    protected void lazyLoad() {

    }
}
