package hu.netlab.orsi.newslistapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

public class NewsLoader extends AsyncTaskLoader{
    private String mUrl;
    private int page = 0;

    public NewsLoader(Context context) {
        super(context);

        mUrl = context.getString(R.string.apiUrl);
        mUrl = mUrl.concat("&page=");
        mUrl = mUrl.concat(Integer.toString(page));
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public Object loadInBackground() {
        return QueryUtils.fetchData(mUrl);
    }
}
