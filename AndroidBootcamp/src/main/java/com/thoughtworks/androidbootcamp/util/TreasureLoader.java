package com.thoughtworks.androidbootcamp.util;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by trogdor on 4/03/14.
 */
public class TreasureLoader {
    Context context;

    public TreasureLoader(Context context) {
        this.context = context;
    }

    public void CopySampleImages() {
        try {
            String[] assets = context.getAssets().list("treasures");
            for(int i=0; i<assets.length; i++)
                CopySampleImage(assets[i]);

        } catch (IOException e) {

        }

    }

    private void CopySampleImage(String assetName) {
        try {
            InputStream asset = context.getAssets().open("treasures/"+assetName);
            File outFile = new File(context.getExternalCacheDir()+"/"+assetName);
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
}
