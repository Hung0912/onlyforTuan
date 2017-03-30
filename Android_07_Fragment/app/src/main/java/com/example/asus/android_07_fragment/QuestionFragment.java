package com.example.asus.android_07_fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment implements View.OnClickListener{
    private static final String Bundle_Count = "BUNDLE_COUNT";
    private int mCount;
    private TextView mTextCount;
    private OnSendResult mListenner;
    public static QuestionFragment newInstance(int mCount){
        QuestionFragment fragment = new QuestionFragment();
        //truyền dữ liện từ activity xuống fragment
        Bundle bundle = new Bundle();
        bundle.putInt(Bundle_Count, mCount);
        fragment.setArguments(bundle);
        return fragment;
    }

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListenner = (OnSendResult) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question, container, false);
        mTextCount = (TextView) v.findViewById(R.id.text_count);
        v.findViewById(R.id.button_send_result).setOnClickListener(this);
        mTextCount.setText(String.valueOf(mCount));
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() == null) return;
        mCount = getArguments().getInt(Bundle_Count);
    }

    @Override
    public void onClick(View view) {
        mListenner.sendResult(mCount);
    }


    public interface OnSendResult{
        void sendResult(int Result);
    }
    /*
    Truyền data từ fragment đến activity
    1.Tạo interface trong fragment
     */
}
