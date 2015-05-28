package rx.parse.app;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v4.app.NavUtils;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.StaggeredGridLayoutManager;
//import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Handler;

import butterknife.ButterKnife;
import butterknife.InjectView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.parse.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.app.*;
import rx.functions.*;

import rx.parse.*;

import android.support.v4.widget.SwipeRefreshLayout;

public class MainFragment extends Fragment {

    @InjectView(R.id.list)
    RecyclerView listView;
    @InjectView(R.id.loading)
    SwipeRefreshLayout loading;

    private Handler handler;
    private ListRecyclerAdapter<ParseUser, ParseUserViewHolder> listAdapter;
    private SwipeRefreshLayout.OnRefreshListener refresher;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static MainFragment newInstance(int sectionNumber) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
        handler = new Handler();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, view);

        listAdapter = ListRecyclerAdapter.create();

        listAdapter.createViewHolder(new Func2<ViewGroup, Integer, ParseUserViewHolder>() {
            @Override
            public ParseUserViewHolder call(@Nullable ViewGroup viewGroup, Integer position) {
                android.util.Log.d("RxParse", "ParseUserViewHolder");
                return new ParseUserViewHolder(inflater.inflate(R.layout.item_parse_user, viewGroup, false));
            }
        });

        listView.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(getActivity()));
        listView.setAdapter(listAdapter);

        refresher = new SwipeRefreshLayout.OnRefreshListener() {
            @Override public void onRefresh() {
                loading.setRefreshing(true);
                AppObservable.bindFragment(MainFragment.this, ParseObservable.find(ParseUser.getQuery()))
                        .doOnNext(new Action1<ParseUser>() {
                            @Override
                            public void call(final ParseUser user) {
                                android.util.Log.d("RxParse", "onNext: " + user.getObjectId());
                            }
                        })
                        .toList()
                        .subscribe(new Action1<List<ParseUser>>() {
                            @Override
                            public void call(final List<ParseUser> users) {
                                loading.setRefreshing(false);
                                android.util.Log.d("RxParse", "subscribe: " + users);
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        listAdapter.getList().clear();
                                        listAdapter.getList().addAll(users);
                                        listAdapter.notifyDataSetChanged();
                                    }
                                });
                            }
                        });
            }
        };

        loading.setOnRefreshListener(refresher);

        handler.post(new Runnable() {
            @Override
            public void run() {
                refresher.onRefresh();
            }
        });
        return view;
    }

    public static class ParseUserViewHolder extends BindViewHolder<ParseUser> {
        @InjectView(R.id.icon)
        SimpleDraweeView icon;
        @InjectView(R.id.text1)
        TextView text1;

        public ParseUserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        };

        @Override
        public void onBind(int position, ParseUser item) {
            android.util.Log.d("RxParse", "onBind");
            String email = item.getEmail() != null ? item.getEmail() : "";
            if (!android.text.TextUtils.isEmpty(email)) {
                icon.setImageURI(Uri.parse("http://gravatar.com/avatar/" + MD5Util.md5Hex(email)));
            }
            text1.setText(email + ", " + item.getObjectId());
        }
    }

    // ref. https://en.gravatar.com/site/implement/images/java/
    public static class MD5Util {

        public static String hex(byte[] array) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i]
                        & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        }

        public static String md5Hex(String message) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                return hex(md.digest(message.getBytes("CP1252")));
            } catch (NoSuchAlgorithmException e) {
            } catch (UnsupportedEncodingException e) {
            }
            return null;
        }
    }
}
