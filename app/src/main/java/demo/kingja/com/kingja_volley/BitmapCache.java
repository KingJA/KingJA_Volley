package demo.kingja.com.kingja_volley;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Description:TODO
 * Create Time:2017/5/13 10:53
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class BitmapCache implements ImageLoader.ImageCache {
    private LruCache<String,Bitmap>mCache;
    public BitmapCache() {
        int maxSize = 10 * 1024 * 1024;
        mCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }
    @Override
    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mCache.put(url, bitmap);
    }
}
