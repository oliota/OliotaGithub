package rubem.oliota.github.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import rubem.oliota.github.model.Repository;
import rubem.oliota.github.R;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.SimpleViewHolder> {

    private Context context;
    private ArrayList<Repository> list;

     RepositoryAdapter(Context context, ArrayList<Repository> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {
        final Repository repository = list.get(position);
        holder.tv_name.setText(repository.getName());
        holder.tv_owner.setText(repository.getOwner());
        holder.ll_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent=new Intent(context,RepositoryActivity.class);
                intent.putExtra("repository",repository);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SimpleViewHolder extends RecyclerView.ViewHolder {
        final LinearLayout ll_item;
        final TextView tv_name;
        final TextView tv_owner;

        SimpleViewHolder(View view) {
            super(view);
            ll_item = view.findViewById(R.id.ll_item);
            tv_name = view.findViewById(R.id.tv_name);
            tv_owner = view.findViewById(R.id.tv_owner);
        }
    }
}