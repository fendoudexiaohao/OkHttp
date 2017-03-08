package songzhihao.bwei.com.okhttp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;




public class MainActivity extends AppCompatActivity {
    private String htmlStr;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("zzz","name=="+htmlStr);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url("http://mock.eoapi.cn/success/4q69ckcRaBdxhdHySqp2Mnxdju5Z8Yr4")
                .build();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback()
        {
            @Override
            public void onFailure(Request request, IOException e)
            {
            }

            @Override
            public void onResponse(final Response response) throws IOException
            {
                htmlStr = response.body().string();
                handler.sendEmptyMessage(0);
            }
        });
    }
}
