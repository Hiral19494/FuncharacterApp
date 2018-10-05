package ca.hiral.viewpagerexample.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import ca.hiral.viewpagerexample.Adapter.ImageAdapter;
import ca.hiral.viewpagerexample.ArrayClass;
import ca.hiral.viewpagerexample.R;

/**
 * Created by Admin on 23-05-2017.
 */

public class CharacterFragment extends Fragment {
    public Integer[] imageArray;

    GridView grvCharacterimg;
    ImageAdapter imageAdapter;
    int position;
    Intent intent;
    ArrayClass arrayClass;
    ImageView imvCharacterPart;

    public CharacterFragment(Integer[] arrayClass) {
        this.imageArray = arrayClass;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character, container, false);
        grvCharacterimg = (GridView) view.findViewById(R.id.grv_character_images);
        arrayClass = new ArrayClass();
        imageAdapter = new ImageAdapter(getActivity(), imageArray);
        grvCharacterimg.setAdapter(imageAdapter);


        grvCharacterimg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                position = (int) adapterView.getItemAtPosition(i);
                intent = new Intent();
                Drawable myDrawable = getResources().getDrawable(imageAdapter.characterArray[i]);
                Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();
                // passing array index

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                myLogo.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] bytes = stream.toByteArray();

                intent.putExtra("id", bytes);
                updateUI(intent);

            }
        });  // Inflate the layout for this fragment

        return view;


    }

    private void updateUI(Intent intent) {

        byte[] bytes = intent.getByteArrayExtra("id");
        Log.d("valueimage", String.valueOf(intent.getByteArrayExtra("id")));
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        if (Arrays.equals(imageArray, arrayClass.facearray)) {

            imvCharacterPart = (ImageView) getActivity().findViewById(R.id.imv_face);

        } else if (Arrays.equals(imageArray, arrayClass.eyebrowarray)) {
            imvCharacterPart = (ImageView) getActivity().findViewById(R.id.imv_eyebrow);

        } else if (Arrays.equals(imageArray, arrayClass.eyearray)) {
            imvCharacterPart = (ImageView) getActivity().findViewById(R.id.imv_eyes);

        } else if (Arrays.equals(imageArray, arrayClass.Liparray)) {
            imvCharacterPart = (ImageView) getActivity().findViewById(R.id.imv_lip);

        } else if (Arrays.equals(imageArray, arrayClass.nosearray)) {
            imvCharacterPart = (ImageView) getActivity().findViewById(R.id.imv_nose);
        } else if (Arrays.equals(imageArray, arrayClass.glassarray)) {

            imvCharacterPart = (ImageView) getActivity().findViewById(R.id.imv_glasses);
        } else if (Arrays.equals(imageArray, arrayClass.toparray)) {

            imvCharacterPart = (ImageView) getActivity().findViewById(R.id.imv_top);
        }
        imvCharacterPart.setImageBitmap(bmp);
    }

}
