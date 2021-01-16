package com.coursera.bicoloreye.petagramfragment.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.coursera.bicoloreye.petagramfragment.R;
import com.coursera.bicoloreye.petagramfragment.db.ConstructorMascotas;
import com.coursera.bicoloreye.petagramfragment.pojo.InstagramPost;
import com.coursera.bicoloreye.petagramfragment.pojo.InstagramProfile;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostInstagramAdapter extends RecyclerView.Adapter<PostInstagramAdapter.InstagramPostViewHolder> {

    private ArrayList<InstagramPost> posts;
    private Activity activity;
    private boolean enabledLikes;
    private boolean enabledNames;
    private boolean single;

    public PostInstagramAdapter(ArrayList<InstagramPost> posts, Activity activity){
        this.posts=posts;
        this.activity=activity;
        this.enabledNames=false;
        this.enabledLikes=false;


    }



    @NonNull
    @Override
    public PostInstagramAdapter.InstagramPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate( R.layout.cardview_post,parent,false);
        return new PostInstagramAdapter.InstagramPostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostInstagramAdapter.InstagramPostViewHolder instagramPostViewHolder, int position) {
        final InstagramPost post=posts.get(position);

        Log.i("Post->"+position,post.toString());

        Log.i("instagramPostView->",instagramPostViewHolder.toString());
        Picasso.get().load(post.getMedia_url()).placeholder(R.drawable.instagrampost).into(instagramPostViewHolder.imgFotoPost);

        //instagramPostViewHolder.imgFotoPost.setImageResource(post.get);
        //if(enabledNames)
         //   instagramPostViewHolder.tvCaptionPost.setText(post.getCaption());
        instagramPostViewHolder.tvlikesPost.setText(""+post.getLike_count());

        //if(enabledLikes)
          //  instagramPostViewHolder.btnLikePost.setOnClickListener(new View.OnClickListener() {
                //@Override
            /*    public void onClick(View view) {
                    Toast.makeText(activity,"Diste Like a "+post.getCaption(),Toast.LENGTH_SHORT).show();
                    //mascotaViewHolder.tvlikes.setText(mascota.setLike()+"");
                    //ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                    //constructorMascotas.darLikeMascota(mascota);
                    instagramPostViewHolder.tvlikesPost.setText(post.getLike_count()+"");
                }
            });*/
    }



    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public void setEnableName(boolean name){ this.enabledNames=name; }

    public boolean isEnabledName() {
        return enabledNames;
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public boolean isEnabledLikes() {
        return enabledLikes;
    }

    public void setEnabledLikes(boolean enabledLikes) {
        this.enabledLikes = enabledLikes;
    }

    @NonNull

    public Fragment getItem(int position) {
        return null;
    }

    public int getCount() {
        return 0;
    }

    public static class InstagramPostViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgFotoPost, imgLikePost;
        private ImageButton btnLikePost;
        private TextView tvCaptionPost, tvlikesPost;


        public InstagramPostViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoPost =(ImageView)itemView.findViewById(R.id.imgFotoPost);
            imgLikePost =(ImageView)itemView.findViewById(R.id.imgLikePost);
            //tvCaptionPost =(TextView) itemView.findViewById(R.id.tv);
            tvlikesPost =(TextView) itemView.findViewById(R.id.tvlikesPost);
            //btnLikePost = (ImageButton)itemView.findViewById(R.id.bt);
        }
    }
}
