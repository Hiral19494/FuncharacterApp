package ca.hiral.viewpagerexample.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import ca.hiral.viewpagerexample.Adapter.ColorAdapter;
import ca.hiral.viewpagerexample.Adapter.ImageAdapter;
import ca.hiral.viewpagerexample.LayoutActivity;
import ca.hiral.viewpagerexample.R;

/**
 * Created by Admin on 06-06-2017.
 */
public class ColorFragment extends Fragment {
    int black = Color.parseColor("#000000");
    int black1 = Color.parseColor("#0F0309");

    int n0 = Color.parseColor("#FFFFFF");
    int n1 = Color.parseColor("#BFBFBF");
    int n2 = Color.parseColor("#6699FF");
    int n3 = Color.parseColor("#99CC33");
    int n4 = Color.parseColor("#FFCC00");
    int n5 = Color.parseColor("#808080");
    int n6 = Color.parseColor("#3366CC");
    int n7 = Color.parseColor("#00CC00");
    int n8 = Color.parseColor("#FF9900");
    int n9 = Color.parseColor("#000000");
    int n10 = Color.parseColor("#404040");
    int n11 = Color.parseColor("#003399");
    int n12 = Color.parseColor("#FF6600");
    int n13 = Color.parseColor("#e55820");
    int n14 = Color.parseColor("#CC0000");
    ColorAdapter colorAdapter;
    Bitmap bitmap, newImage;
    int position;
    Intent intent;
    GridView gridView;
    ImageAdapter imageAdapter;
    ImageView imageView;

    public ColorFragment() {
        // Required empty public constructor
    }

    public Integer[] mThumbIds = {
            R.drawable.pic_s9_white,
            R.drawable.pic_s9_2, R.drawable.pic_s9_3,
            R.drawable.pic_s9_4, R.drawable.pic_s9_5,
            R.drawable.pic_s9_6, R.drawable.pic_s9_7,
            R.drawable.pic_s9_8, R.drawable.pic_s9_9,
            R.drawable.pic_s9_10, R.drawable.pic_s9_11,
            R.drawable.pic_s9_13, R.drawable.pic_s9_14,
            R.drawable.pic_s9_15

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character, container, false);
        gridView = (GridView) view.findViewById(R.id.grv_character_images);

        colorAdapter = new ColorAdapter(getActivity());
        imageAdapter = new ImageAdapter(getActivity(), mThumbIds);
        imageView = (ImageView) getActivity().findViewById(R.id.imv_face);


        //  imvCharacterPart.setImageResource(imageAdapter.imageArray[position]);
        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache();
        bitmap = Bitmap.createBitmap(imageView.getDrawingCache());

        gridView.setAdapter(colorAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                position = (int) adapterView.getItemAtPosition(i);
                intent = new Intent(getActivity(), LayoutActivity.class);

                // passing array index
                intent.putExtra("id", i);
                Log.d("hiral", String.valueOf(position));
//onResume();
                updateUI(intent);

            }
        });  // Inflate the layout for this fragment

        return view;


    }

    private void updateUI(Intent intent) {


        int position = intent.getExtras().getInt("id");
        int[] allpixels = new int[bitmap.getHeight() * bitmap.getWidth()];
        bitmap.getPixels(allpixels, 0, bitmap.getHeight(), 0, 0, bitmap.getWidth(), bitmap.getHeight());


        for (int i = 4; i < allpixels.length / 1.8; i++) {

            if (allpixels[i] >= black && allpixels[i] <= black1) {
                if (position == 0) {
                    allpixels[i] = n0;
                } else if (position == 1) {
                    allpixels[i] = n1;
                } else if (position == 2) {
                    allpixels[i] = n2;
                } else if (position == 3) {
                    allpixels[i] = n3;
                } else if (position == 4) {
                    allpixels[i] = n4;
                } else if (position == 5) {
                    allpixels[i] = n5;
                } else if (position == 6) {
                    allpixels[i] = n6;
                } else if (position == 7) {
                    allpixels[i] = n7;
                } else if (position == 8) {
                    allpixels[i] = n8;
                } else if (position == 9) {
                    allpixels[i] = n9;
                } else if (position == 10) {
                    allpixels[i] = n10;
                } else if (position == 11) {
                    allpixels[i] = n11;
                } else if (position == 12) {
                    allpixels[i] = n12;
                } else if (position == 13) {
                    allpixels[i] = n13;
                } else if (position == 14) {
                    allpixels[i] = n14;
                }


            }
        }
        newImage = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        newImage.setPixels(allpixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        imageView.setImageBitmap(newImage);
    }
}
