package com.example.smartmart.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartmart.R;
import com.example.smartmart.adapters.MarketsAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recMarkets;
    private MarketsAdapter marketsAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recMarkets = root.findViewById(R.id.recMarkets);
        recMarkets.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.pandalogo);
        imageList.add(R.drawable.altaimim);
        imageList.add(R.drawable.lululogo);

        List<String> nameList = new ArrayList<>();
        nameList.add("Panda");
        nameList.add("Altamimi");
        nameList.add("Lulu Market");

        marketsAdapter = new MarketsAdapter(getActivity(), imageList, nameList);
        recMarkets.setAdapter(marketsAdapter);

        return root;
    }
}
