package ca.hiral.viewpagerexample.Fragment;

import android.app.Activity;
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
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

import ca.hiral.viewpagerexample.Adapter.ImageAdapter;
import ca.hiral.viewpagerexample.ArrayClass;
import ca.hiral.viewpagerexample.LayoutActivity;

import ca.hiral.viewpagerexample.R;
/**
 * Created by Admin on 23-05-2017.
 */

public class FaceFragment extends Fragment {
    public  Integer[] mThumbIds ;

GridView gridView;
    ImageAdapter imageAdapter ;
 int position;
    Intent intent;
    FrameLayout ij;
ArrayClass arrayClass;
    ImageView imageView;
    public FaceFragment(Integer[] arrayClass) {
        this.mThumbIds = arrayClass;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_one, container, false);
        gridView = (GridView)view.findViewById(R.id.grid_view);
        arrayClass = new ArrayClass();
    imageAdapter = new ImageAdapter(getActivity(),mThumbIds);
ij = new FrameLayout(getActivity());
        gridView.setAdapter(imageAdapter);





gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


         position = (int) adapterView.getItemAtPosition(i);
   intent   = new Intent();
        Drawable myDrawable = getResources().getDrawable(imageAdapter.mThumbIds[i]);
        Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        // passing array index

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        myLogo.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bytes = stream.toByteArray();

        intent.putExtra("id", bytes);
        Log.d("hiral", String.valueOf(position));



       updateUI(intent);

    }
});  // Inflate the layout for this fragment

return view;


    }

    private void updateUI(Intent intent) {

        byte[] bytes = intent.getByteArrayExtra("id");
        Log.d("valueimage", String.valueOf(intent.getByteArrayExtra("id")));
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

if(Arrays.equals(mThumbIds,arrayClass.facemThumbIds)) {

    imageView = (ImageView) getActivity().findViewById(R.id.faceimage);

        }
        else if(Arrays.equals(mThumbIds,arrayClass.eyebrowmThumbIds)){
    imageView = (ImageView)getActivity().findViewById(R.id.eyeimage);

        } else if(Arrays.equals(mThumbIds,arrayClass.eyemThumbIds)){
    imageView = (ImageView)getActivity().findViewById(R.id.eyesimage);

        }else if(Arrays.equals(mThumbIds,arrayClass.LipmThumbIds)){
    imageView = (ImageView)getActivity().findViewById(R.id.lipimage);

        }else if(Arrays.equals(mThumbIds,arrayClass.nosemThumbIds)){
        imageView = (ImageView)getActivity().findViewById(R.id.noseimage);
        }
        else if(Arrays.equals(mThumbIds,arrayClass.glassmThumbIds)) {

    imageView = (ImageView) getActivity().findViewById(R.id.glasses);
    }else if(Arrays.equals(mThumbIds,arrayClass.topmThumbIds)) {

    imageView = (ImageView) getActivity().findViewById(R.id.toop);
}
        imageView.setImageBitmap(bmp);
    }

}
