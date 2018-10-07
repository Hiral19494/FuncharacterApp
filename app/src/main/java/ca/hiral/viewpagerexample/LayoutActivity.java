package ca.hiral.viewpagerexample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import ca.hiral.viewpagerexample.Fragment.CharacterFragment;

/**
 * Created by Admin on 24-05-2017.
 */

public class LayoutActivity extends AppCompatActivity {
    /* @BindView(R.id.toolbar)
     Toolbar toolbar;*/
    @BindView(R.id.tabs)
    public TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    ArrayClass arrayClass;
    private int[] tabIcons = {
            R.drawable.pic_s1_1,
            R.drawable.eyebrow,
            R.drawable.pic_s4_1,
            R.drawable.pic_s5_7,
            R.drawable.nose,
            R.drawable.glass,
            R.drawable.pic_s8_1,
            R.drawable.hair
    };
    private ImageView imvFace;
    private ImageView imvEyebrow;
    private ImageView imvEyes;
    private ImageView imvLip;
    public ImageView imvNose;
    private ImageView imvGlasses;
    private ImageView imvTop;
    FrameLayout flCharacter;
    ScrollView scroll;
    @BindView(R.id.fl_full_image)
    FrameLayout flFullImage;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutactivity);
        ButterKnife.bind(this);

        //    setSupportActionBar(toolbar);
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        scroll = new ScrollView(this);
        FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(new AbsListView.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT
                , FrameLayout.LayoutParams.MATCH_PARENT));
        scroll.setLayoutParams(layoutParams1);


        flCharacter = new FrameLayout(this);
        //    flCharacter.setBackgroundResource(R.drawable.layout_border);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new AbsListView.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT
                , FrameLayout.LayoutParams.MATCH_PARENT));
        layoutParams.setMargins(0, 0, 0, 2);
        layoutParams.gravity= Gravity.CENTER_HORIZONTAL;
        flCharacter.setLayoutParams(layoutParams);
        //flCharacter.setGravity(Gravity.CENTER);


        imvFace = new ImageView(this);
        imvFace.setId(R.id.imv_face);
        imvFace.setImageResource(R.drawable.pic_s1_0);
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(680, 680);
        layoutparams.setMargins(0, 0, 0, 450);
        imvFace.setLayoutParams(layoutparams);


        imvTop = new ImageView(this);
        imvTop.setId(R.id.imv_top);

        imvTop.setImageResource(R.drawable.pic_s8_1);
        FrameLayout.LayoutParams to = new FrameLayout.LayoutParams(500, 500);
        to.setMargins(80, 210, 0, 0);
        imvTop.setLayoutParams(to);


        imvEyebrow = new ImageView(this);
        imvEyebrow.setId(R.id.imv_eyebrow);
        imvEyebrow.setImageResource(R.drawable.pic_s3_1);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(300, 300);
        lp.setMargins(190, 145, 0, 0);
        imvEyebrow.setLayoutParams(lp);


        imvGlasses = new ImageView(this);
        imvGlasses.setId(R.id.imv_glasses);
        imvGlasses.setImageResource(0);
        FrameLayout.LayoutParams glass = new FrameLayout.LayoutParams(390, 390);
        glass.setMargins(150, 130, 20, 0);
        imvGlasses.setLayoutParams(glass);


        imvEyes = new ImageView(this);
        imvEyes.setId(R.id.imv_eyes);
        imvEyes.setImageResource(R.drawable.pic_s4_34);
        FrameLayout.LayoutParams lp2 = new FrameLayout.LayoutParams(300, 300);
        lp2.setMargins(190, 172, 0, 0);
        imvEyes.setLayoutParams(lp2);


        imvNose = new ImageView(this);
        imvNose.setId(R.id.imv_nose);
        imvNose.setImageResource(R.drawable.pic_s14_20024);
        FrameLayout.LayoutParams lp3 = new FrameLayout.LayoutParams(180, 180);
        lp3.setMargins(255, 310, 0, 0);
        imvNose.setLayoutParams(lp3);

        imvLip = new ImageView(this);
        imvLip.setId(R.id.imv_lip);
        imvLip.setImageResource(R.drawable.pic_s5_20001);
        FrameLayout.LayoutParams lp4 = new FrameLayout.LayoutParams(310, 310);
        lp4.setMargins(190, 330, 0, 0);
        imvLip.setLayoutParams(lp4);


        flCharacter.addView(imvFace);
        flCharacter.addView(imvTop);
        flCharacter.addView(imvEyebrow);
        flCharacter.addView(imvGlasses);
        flCharacter.addView(imvEyes);
        flCharacter.addView(imvNose);
        flCharacter.addView(imvLip);

        scroll.addView(flCharacter);


        flFullImage.addView(scroll);


        setupTabIcons();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //   client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void saveImageToGallery() {
        flCharacter.setDrawingCacheEnabled(true);
        flCharacter.buildDrawingCache();
        Bitmap bm = flCharacter.getDrawingCache();

        String root = String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));

        File myDir = new File(root + "/FunFaces");
        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".png";
        File file = new File(myDir, fname);

        Log.d("joo", "" + file);
        Log.d("fname",fname);

        if (file.exists())
            file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            //
            bm.compress(Bitmap.CompressFormat.PNG, 70, out);
            //Toast.makeText(getBaseContext(), "Image save", Toast.LENGTH_LONG).show();
             out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("error",e.getMessage());
        }
        Toast.makeText(getBaseContext(), "Image save in Gallery", Toast.LENGTH_LONG).show();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
        tabLayout.getTabAt(5).setIcon(tabIcons[5]);
        tabLayout.getTabAt(6).setIcon(tabIcons[6]);
        //tabLayout.getTabAt(7).setIcon(tabIcons[7]);


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        arrayClass = new ArrayClass();
        adapter.addFragment(new CharacterFragment(arrayClass.facearray), "one");
        adapter.addFragment(new CharacterFragment(arrayClass.eyebrowarray), "two");
        adapter.addFragment(new CharacterFragment(arrayClass.eyearray), "three");
        adapter.addFragment(new CharacterFragment(arrayClass.Liparray), "Four");
        adapter.addFragment(new CharacterFragment(arrayClass.nosearray), "Five");
        adapter.addFragment(new CharacterFragment(arrayClass.glassarray), "Six");
        adapter.addFragment(new CharacterFragment(arrayClass.toparray), "seven");
        //adapter.addFragment(new ColorFragment(), "Eight");
        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;

            //  return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.imagesave, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:

                saveImageToGallery();
              //  addImageToGallery(String.valueOf(file),getBaseContext() );
                /*Log.d("pass image", String.valueOf(flFullImage));
                Intent a = new Intent(LayoutActivity.this, AnimationActivity.class);
                startActivity(a);*/


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}