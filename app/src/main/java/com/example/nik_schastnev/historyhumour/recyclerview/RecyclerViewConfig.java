package com.example.nik_schastnev.historyhumour.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nik_schastnev.historyhumour.R;

import java.util.List;

public class RecyclerViewConfig {
    private Context mContext;
    private PostsAdapter mPostsAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Post> posts,
                          List<String> keys) {
        mContext = context;
        mPostsAdapter = new PostsAdapter(posts, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mPostsAdapter);
    }

    class PostItemView extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mAuthor;
        private TextView mDescription;
        private TextView mSource;
        private ImageView mImageUrl;

        private String key;

        public PostItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.post_list_item, parent,
                    false));

            mTitle = (TextView) itemView.findViewById(R.id.title_txtView);
            mAuthor = (TextView) itemView.findViewById(R.id.author_txtView);
            mDescription = (TextView) itemView.findViewById(R.id.description_txtView);
            mSource = (TextView) itemView.findViewById(R.id.source_txtView);
            mImageUrl = (ImageView) itemView.findViewById(R.id.image_imgView);
        }

        public void bind(Post post, String key) {
            mTitle.setText(post.getTitle());
            mAuthor.setText(post.getAuthor());
            mDescription.setText(post.getDescription());
            mSource.setText(post.getSource());
            this.key = key;
        }
    }

    class PostsAdapter extends RecyclerView.Adapter<PostItemView> {
        private List<Post> mPostList;
        private List<String> mKeys;

        public PostsAdapter(List<Post> mPostList, List<String> mKeys) {
            this.mPostList = mPostList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public PostItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PostItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull PostItemView holder, int position) {
            holder.bind(mPostList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mPostList.size();
        }
    }
}
