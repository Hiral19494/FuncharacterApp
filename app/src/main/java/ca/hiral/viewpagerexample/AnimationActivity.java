package ca.hiral.viewpagerexample;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

import ca.hiral.viewpagerexample.Adapter.AniamtionAdapter;

/**
 * Created by Admin on 21-06-2017.
 */

public class AnimationActivity extends Activity {

    ListView grid;
    AniamtionAdapter adapter;
    File file;
    String hello;
    AnimationDrawable Anim;
    ImageView animationimage;
    // Declare variables
    private String[] FilePathStrings;
    private String[] FileNameStrings;
    private File[] listFile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animationactivity);
        animationimage = (ImageView) findViewById(R.id.animationimage);
        // Check for SD Card
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                    .show();
        } else {
            // Locate the image folder in your SD Card
            String root = (String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)));
            //	file = new File(Environment.getExternalStorageDirectory()
            //		+ File.separator + "SDImageTutorial");
            // Create a new folder if no folder named SDImageTutorial exist
            file = new File(root + "/Funcharacter1");
            file.mkdirs();
        }

        if (file.isDirectory()) {
            listFile = file.listFiles();
            // Create a String array for FilePathStrings
            FilePathStrings = new String[listFile.length];
            // Create a String array for FileNameStrings
            FileNameStrings = new String[listFile.length];

            for (int i = 0; i < listFile.length; i++) {
                // Get the path of the image file
                FilePathStrings[i] = listFile[i].getAbsolutePath();
                // Get the name image file
                FileNameStrings[i] = listFile[i].getName();
            }
        }

        // Locate the GridView in gridview_main.xml
        grid = (ListView) findViewById(R.id.list_item);
        // Pass String arrays to LazyAdapter Class
        adapter = new AniamtionAdapter(this, FilePathStrings, FileNameStrings);
        // Set the LazyAdapter to the GridView
        grid.setAdapter(adapter);


        Anim = new AnimationDrawable();
        for (int i = 0; i < grid.getAdapter().getCount(); i++) {

            Anim.addFrame(Drawable.createFromPath(listFile[i].getAbsolutePath()), 200);
        }
        Anim.setOneShot(false);
        animationimage.setBackgroundDrawable(Anim);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            public void run() {

                Anim.start();

            }
        }, 5000);


    }

}
