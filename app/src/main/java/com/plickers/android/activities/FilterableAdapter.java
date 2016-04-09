package com.plickers.android.activities;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import com.plickers.android.data.Poll;

import java.util.ArrayList;
import java.util.List;

/**
 * General adapter with filterable capabilities for reusability
 */
public abstract class FilterableAdapter<T> extends ArrayAdapter<T> {
    private List<T> originalData, filteredData;
    private FilterableFilter mFilter = new FilterableFilter();

    public FilterableAdapter(Context context, int layout, List<T> resource) {
        super(context, layout, resource);
        this.originalData=this.filteredData=resource;
    }

    @Override
    public int getCount() {
        return filteredData.size();
    }

    @Override
    public T getItem(int position) {
        return filteredData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    /**
     * Returns true if the item should pass the filter and false if not.
     * @param current
     * @param query
     * @return
     */
    public abstract boolean performFilter(T current, String query);

    private class FilterableFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();

            final List<T> list = originalData;

            int count = list.size();
            final ArrayList<T> nlist = new ArrayList<T>(count);

            for(T item : list){
                boolean add = performFilter(item, constraint.toString());
                if (add) {
                    nlist.add(item);
                }
            }

            results.values = nlist;
            results.count = nlist.size();

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredData = (ArrayList<T>) results.values;
            notifyDataSetChanged();
        }

    }
}
