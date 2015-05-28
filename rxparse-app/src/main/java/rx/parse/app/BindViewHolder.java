package rx.parse.app;

import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;

public abstract class BindViewHolder<T> extends RecyclerView.ViewHolder {
    public BindViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position, T item);
}
