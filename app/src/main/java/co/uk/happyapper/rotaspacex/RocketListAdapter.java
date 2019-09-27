package co.uk.happyapper.rotaspacex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import co.uk.happyapper.rotaspacex.Models.Rocket;

public class RocketListAdapter extends RecyclerView.Adapter<RocketListAdapter.ViewHolder> {
    private ArrayList<Rocket> mDataset;
    private Context mContext;
    private LayoutInflater mInflater;
    private boolean metric;
    private int max;

    public RocketListAdapter(Context context, boolean metric, ArrayList<Rocket> data) {
        mDataset = data;
        this.mContext = context;
        this.metric = metric;
        this.mInflater = LayoutInflater.from(context);
        this.max = data.get(0).getHeight();
    }

    @NonNull
    @Override
    public RocketListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.rocket_list_item, parent, false);
        return new RocketListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RocketListAdapter.ViewHolder holder, int position) {
        holder.name.setText(mDataset.get(position).getRocketName());
        holder.height.setText(mDataset.get(position).getFormattedHeight(metric));
        holder.bar.setMax(max);
        holder.bar.setProgress(mDataset.get(position).getHeight());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView height;
        public ProgressBar bar;


        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            height = itemView.findViewById(R.id.height);
            bar = itemView.findViewById(R.id.indicator);
        }

    }


}
