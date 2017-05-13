package demo.kingja.com.kingja_volley;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue;
    private ImageView iv;
    private TextView tv;
    private NetworkImageView networkImageView;
    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv);
        networkImageView = (NetworkImageView) findViewById(R.id.networkImageView);
        mQueue = Volley.newRequestQueue(this);
        getStringByGet();
//        getJsonByPost();
//        loadImage();
//        imageLoader();
//        loadImageByXml();
    }


    private void getStringByGet() {
        StringRequest stringRequest = new StringRequest("http://www.baidu.com",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        mQueue.add(stringRequest);
    }

    private void getJsonByPost() {
        GsonRequest<Result> stringRequest = new GsonRequest<Result>("http://10.1.6.186:8070/mobile/account/login",
                Result.class,
                new Response.Listener<Result>() {
                    @Override
                    public void onResponse(Result response) {
                        Log.d("TAG", response.toString());
                        tv.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("userName", "aaa");
                map.put("password", "bbb");
                return map;
            }
        };

        mQueue.add(stringRequest);
    }

    public void loadImage() {
        ImageRequest imageRequest = new ImageRequest("https://ss0.bdstatic" +
                ".com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2075750630,4216747848&fm=23&gp=0.jpg", new Response
                .Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                Log.e("TAG", "onResponse");
                iv.setImageBitmap(response);
            }
        }, iv.getWidth(), iv.getHeight(), ImageView.ScaleType.CENTER_CROP, Bitmap.Config.ARGB_8888, new Response
                .ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        mQueue.add(imageRequest);

    }

    public void imageLoader() {
        imageLoader = new ImageLoader(mQueue, new BitmapCache());
        imageLoader.get("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1494654416436&di=9ac8f7f521ba6068d229678e1b1e915c" +
                "&imgtype=0&src=http%3A%2F%2Fwww.qqxoo.com%2Fuploads%2Fallimg%2F170504%2F135QaS5-3.jpg", new
                ImageLoader.ImageListener() {


                    @Override
                    public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                        Log.e("TAG", "onResponse");
                        iv.setImageBitmap(response.getBitmap());
                    }

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                    }
                });
    }

    public void loadImageByXml() {
        networkImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        networkImageView.setErrorImageResId(R.mipmap.ic_launcher);
        networkImageView.setImageUrl("https://timgsa.baidu" +
                        ".com/timg?image&quality=80&size=b9999_10000&sec=1494654517052&di" +
                        "=e2a0ab37a913172efc128b32489e1f52&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu" +
                        ".com%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3De2548861d12a60595245e91e1d0418ad%2Fa8773912b31bb0514b42d780307adab44aede030.jpg",
                imageLoader);
    }
}
