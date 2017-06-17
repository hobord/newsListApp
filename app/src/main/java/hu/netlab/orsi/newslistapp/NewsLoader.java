package hu.netlab.orsi.newslistapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

public class NewsLoader extends AsyncTaskLoader{
    private String mUrl;
    private int page = 1;

    public NewsLoader(Context context) {
        super(context);
        mUrl = getContext().getString(R.string.apiUrl);
        Log.v("url", mUrl);
    }

    private String makePagedUrl(String url)
    {
        return url.concat("&page=").concat(Integer.toString(page));
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public Object loadInBackground() {
        return QueryUtils.fetchData(makePagedUrl(mUrl));
    }

    public void nextPage() {
        page++;
        forceLoad();
    }

    public void prevPage() {
        page = (page>1)?page-1:1;
        forceLoad();
    }
}
