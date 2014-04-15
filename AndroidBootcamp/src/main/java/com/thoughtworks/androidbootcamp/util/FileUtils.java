package com.thoughtworks.androidbootcamp.util;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alex on 15/04/2014.
 */
public class FileUtils {

    private static final String TAG = "FileUtils";

    public static File getExternalPublicFile(String type, String folder) throws IOException {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                type), folder);

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(TAG, "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        return File.createTempFile(
                "IMG_" + timeStamp, /* prefix */
                ".jpg",             /* suffix */
                mediaStorageDir     /* directory */
        );
    }
}
