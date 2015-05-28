package rx.parse.app;

import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.functions.*;

public class ListRecyclerAdapter<T, VH extends BindViewHolder<T>> extends RecyclerView.Adapter<VH> {
    private List<T> mList = Collections.emptyList();
    protected Action3<VH, Integer, T> mOnBindViewHolder;
    protected Func2<ViewGroup, Integer, VH> mOnCreateViewHolder;

    public ListRecyclerAdapter(List<T> list) {
        mList = list;
    }

    public static <R, VHH extends BindViewHolder<R>> ListRecyclerAdapter<R, VHH> create() {
        return create(new ArrayList<R>());
    }

    public static <R, VHH extends BindViewHolder<R>> ListRecyclerAdapter<R, VHH> create(List<R> list) {
        return new ListRecyclerAdapter<>(list);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mOnCreateViewHolder != null) return mOnCreateViewHolder.call(parent, viewType);
        return null;
    }

    public ListRecyclerAdapter<T, VH> createViewHolder(Func2<ViewGroup, Integer, VH> onCreateViewHolder) {
        mOnCreateViewHolder = onCreateViewHolder;
        return this;
    }

    private boolean onBindViewHolderSupered;

    @Override
    public void onBindViewHolder(VH viewHolder, int position) { // final, DO NOT Override until certainly
        onBindViewHolderSupered = false;
        onBindViewHolder(viewHolder, position, mList.get(position));
        if (!onBindViewHolderSupered) throw new IllegalArgumentException("super.onBindViewHolder() not be called");
    }

    // super me
    public void onBindViewHolder(VH viewHolder, int position, T item) { // final, DO NOT Override until certainly
        onBindViewHolderSupered = true;
        if (mOnBindViewHolder == null) {
            mOnBindViewHolder = new Action3<VH, Integer, T>() {
                @Override
                public void call(VH vh, Integer i, T t) {
                    vh.onBind(i, t);
                }
            };
        }
        mOnBindViewHolder.call(viewHolder, position, item);
    }

    public ListRecyclerAdapter<T, VH> bindViewHolder(Action3<VH, Integer, T> onBindViewHolder) {
        mOnBindViewHolder = onBindViewHolder;
        return this;
    }

    @Override
    public int getItemCount() {
        int i = mList.size();
        return i;
    }

    public List<T> getList() {
        return mList;
    }
}
