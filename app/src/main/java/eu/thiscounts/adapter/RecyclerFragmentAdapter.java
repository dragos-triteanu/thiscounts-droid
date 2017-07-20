package eu.thiscounts.adapter;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import eu.thiscounts.R;
import eu.thiscounts.model.Discount;
import eu.thiscounts.views.ResizableImageView;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class RecyclerFragmentAdapter extends RecyclerView.Adapter<RecyclerFragmentAdapter.ViewHolder> {
    private static final String TAG = "RecyclerFragmentAdapter";

    private List<Discount> mData;


    public RecyclerFragmentAdapter(List<Discount> data) {
        mData = data;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_card_item, viewGroup, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getImageView().setImageResource(mData.get(position).getImageId());
        viewHolder.getProductName().setText(mData.get(position).getProductName());
        viewHolder.getBusinessName().setText(mData.get(position).getBusinessName());
        viewHolder.getProductCurrentPrice().setText(mData.get(position).getCurrentPrice());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mData.size();
    }


    /**
     * Custom holder class required for using the {@link RecyclerView}.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView productName;
        private final TextView businessName;
        private final ResizableImageView imageView;
        private final TextView productCurrentPrice;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });

            productName = (TextView) v.findViewById(R.id.productName);
            businessName = (TextView) v.findViewById(R.id.businessName);
            imageView = (ResizableImageView) v.findViewById(R.id.cardImage);
            productCurrentPrice = (TextView) v.findViewById(R.id.productCurrentPrice);
        }


        public TextView getProductName() {
            return productName;
        }

        public TextView getBusinessName() {
            return businessName;
        }

        public ResizableImageView getImageView() {
            return imageView;
        }

        public TextView getProductCurrentPrice() {
            return productCurrentPrice;
        }
    }

}