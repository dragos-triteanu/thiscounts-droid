/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package eu.thiscounts.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import eu.thiscounts.R;
import eu.thiscounts.adapter.RecyclerFragmentAdapter;
import eu.thiscounts.model.Discount;

import static java.util.Arrays.asList;

/**
 * Demonstrates the use of {@link RecyclerView} with a {@link LinearLayoutManager} and a
 * {@link GridLayoutManager}.
 */
public class RecyclerViewFragment extends Fragment {
    private static final String TAG = "RecyclerViewFragment";

    protected RecyclerView mRecyclerView;
    protected RecyclerFragmentAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discounts_recycler_list, container, false);
        rootView.setTag(TAG);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());


        setRecyclerViewLayoutManager();

        mAdapter = new RecyclerFragmentAdapter(buildDataset());
        // Set RecyclerFragmentAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }


    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     */
    public void setRecyclerViewLayoutManager() {
        int scrollPosition = 0;

        mLayoutManager = new LinearLayoutManager(getActivity());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }



    private List<Discount> buildDataset() {
        List<Discount> discounts = asList(new Discount(R.drawable.foodpic1,"Some Biz","Some prod","6 Ron","12 Ron"),
                new Discount(R.drawable.foodpic2,"Some Bizt","Some prod2","7 Ron","15 Ron"),
                new Discount(R.drawable.foodpic3,"Other","Some prod","9 Ron","12 Ron"),
                new Discount(R.drawable.foodpic1,"Xaxa","Some prod","8 Ron","12 Ron"));
        return discounts;
    }

}