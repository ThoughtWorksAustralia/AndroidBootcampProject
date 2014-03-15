package com.thoughtworks.androidbootcamp.util;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by trogdor on 4/03/14.
 */
public class TreasureLoader {
    static String TREASURES_ASSETS_SUBDIR = "treasures";
    static String TREASURES_CACHE_SUBDIR = "/treasures/";
    Context context;

    public TreasureLoader(Context context) {
        this.context = context;
    }

    public void copySampleImages() {
        try {
            String treasuresDir = context.getExternalCacheDir() + TREASURES_CACHE_SUBDIR;
            new File(treasuresDir).mkdir();
            String[] assets = context.getAssets().list(TREASURES_ASSETS_SUBDIR);
            for(int i=0; i<assets.length; i++)
                copySampleImage(assets[i]);

        } catch (IOException e) {

        }

    }

    private void copySampleImage(String assetName) {
        try {
            String treasuresDir = context.getExternalCacheDir() + TREASURES_CACHE_SUBDIR;
            InputStream asset = context.getAssets().open(TREASURES_ASSETS_SUBDIR + "/" + assetName);
            File outFile = new File(treasuresDir + assetName);
            OutputStream out = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int len;
            while((len = asset.read(buffer)) > 0)
                out.write(buffer, 0, len);
            out.close();
            asset.close();
        } catch (IOException e) {

        }
    }

    public String[] getSampleImagePaths() {
        String cacheDir = context.getExternalCacheDir() + TREASURES_CACHE_SUBDIR;
        String[] fileNames = new File(cacheDir).list(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.contains(".jpg");
            }
        });

        String[] filesWithPaths = new String[fileNames.length];
        for (int i=0; i < fileNames.length; i++)
            filesWithPaths[i] =  cacheDir + "/" + fileNames[i];

        return filesWithPaths;
    }
}
