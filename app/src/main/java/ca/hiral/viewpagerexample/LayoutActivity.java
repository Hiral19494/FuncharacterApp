package ca.hiral.viewpagerexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ca.hiral.viewpagerexample.Adapter.ImageAdapter;
import ca.hiral.viewpagerexample.Fragment.ColorFragment;
import ca.hiral.viewpagerexample.Fragment.FaceFragment;

/**
 * Created by Admin on 24-05-2017.
 */

public class LayoutActivity extends AppCompatActivity {
public static ImageAdapter imageAdapter;
    private Toolbar toolbar;
    public TabLayout tabLayout;
    private ViewPager viewPager;
   ArrayClass arrayClass;
    private int[] tabIcons = {
            R.drawable.face,
            R.drawable.eyebrow,
            R.drawable.i,
            R.drawable.lip,
            R.drawable.nose,
            R.drawable.glass,
            R.drawable.pic_s8_1,
            R.drawable.hair
    };
  private    ImageView face;
    private ImageView eyebrow;
    private ImageView eyes;
    private ImageView lip;
    public ImageView nose;
    private ImageView glasses;
    private ImageView top;
    private ImageView imageview;
    FrameLayout framelayout;
 public    Bitmap bmp;
    ScrollView scroll;

    FrameLayout characterimage;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutactivity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        characterimage = (FrameLayout) findViewById(R.id.full_image_view);


       scroll = new ScrollView(this);
        FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(new AbsListView.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT
                , FrameLayout.LayoutParams.MATCH_PARENT));
        scroll.setLayoutParams(layoutParams1);


        framelayout = new FrameLayout(this);
        //    framelayout.setBackgroundResource(R.drawable.layout_border);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(new AbsListView.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT
                , FrameLayout.LayoutParams.MATCH_PARENT));
        layoutParams.setMargins(0, 0, 0, 2);

        framelayout.setLayoutParams(layoutParams);


        face = new ImageView(this);
        face.setId(R.id.faceimage);
        face.setImageResource(R.drawable.pic_s1_0);
        FrameLayout.LayoutParams layoutparams = new FrameLayout.LayoutParams(680, 680);
        layoutparams.setMargins(0, 0, 0, 450);
        face.setLayoutParams(layoutparams);

        top = new ImageView(this);
        top.setId(R.id.toop);

        top.setImageResource(R.drawable.pic_s8_1);
        FrameLayout.LayoutParams to = new FrameLayout.LayoutParams(500, 500);
        to.setMargins(80, 220, 0, 0);
        top.setLayoutParams(to);


        eyebrow = new ImageView(this);
        eyebrow.setId(R.id.eyeimage);
        eyebrow.setImageResource(R.drawable.pic_s3_1);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(300, 300);
        lp.setMargins(190, 145, 0, 0);
        eyebrow.setLayoutParams(lp);


        glasses = new ImageView(this);
        glasses.setId(R.id.glasses);
        glasses.setImageResource(0);
        FrameLayout.LayoutParams glass = new FrameLayout.LayoutParams(390, 390);
        glass.setMargins(150, 130, 20, 0);
        glasses.setLayoutParams(glass);


        eyes = new ImageView(this);
        eyes.setId(R.id.eyesimage);
        eyes.setImageResource(R.drawable.pic_s4_34);
        FrameLayout.LayoutParams lp2 = new FrameLayout.LayoutParams(300, 300);
        lp2.setMargins(190, 172, 0, 0);
        eyes.setLayoutParams(lp2);


        nose = new ImageView(this);
        nose.setId(R.id.noseimage);
        nose.setImageResource(R.drawable.pic_s14_20024);
        FrameLayout.LayoutParams lp3 = new FrameLayout.LayoutParams(180, 180);
        lp3.setMargins(255, 310, 0, 0);
        nose.setLayoutParams(lp3);

        lip = new ImageView(this);
        lip.setId(R.id.lipimage);
        lip.setImageResource(R.drawable.pic_s5_20001);
        FrameLayout.LayoutParams lp4 = new FrameLayout.LayoutParams(310, 310);
        lp4.setMargins(190, 330, 0, 0);
        lip.setLayoutParams(lp4);


        framelayout.addView(face);
        framelayout.addView(top);
        framelayout.addView(eyebrow);
        framelayout.addView(glasses);
        framelayout.addView(eyes);
        framelayout.addView(nose);
        framelayout.addView(lip);

        scroll.addView(framelayout);


        characterimage.addView(scroll);





        setupTabIcons();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
     //   client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }




    public void saveImageToGallery() {
      characterimage.setDrawingCacheEnabled(true);
      characterimage.buildDrawingCache();
       Bitmap      bm = characterimage.getDrawingCache();

        String root = String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));

        File myDir = new File(root + "/Funcharacter1");
        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".png";
        File   file = new File(myDir, fname);

        Log.d("joo", "" + file);

        if (file.exists())
            file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
          //
             bm.compress(Bitmap.CompressFormat.PNG, 70, out);
           // out.flush();
             out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
        tabLayout.getTabAt(5).setIcon(tabIcons[5]);
        tabLayout.getTabAt(6).setIcon(tabIcons[6]);
        tabLayout.getTabAt(7).setIcon(tabIcons[7]);


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        arrayClass = new ArrayClass();
        adapter.addFragment(new FaceFragment(arrayClass.facemThumbIds), "one");
        adapter.addFragment(new FaceFragment(arrayClass.eyebrowmThumbIds), "two");
        adapter.addFragment(new FaceFragment(arrayClass.eyemThumbIds), "three");
        adapter.addFragment(new FaceFragment(arrayClass.LipmThumbIds), "Four");
        adapter.addFragment(new FaceFragment(arrayClass.nosemThumbIds), "Five");
        adapter.addFragment(new FaceFragment(arrayClass.glassmThumbIds), "Six");
        adapter.addFragment(new FaceFragment(arrayClass.topmThumbIds), "seven");
        adapter.addFragment(new ColorFragment(), "Eight");
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
            case R.id.eye:



                   saveImageToGallery();
                Log.d("pass image", String.valueOf(characterimage));
                Intent a = new Intent(LayoutActivity.this,AnimationActivity.class);
                startActivity(a);



                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}