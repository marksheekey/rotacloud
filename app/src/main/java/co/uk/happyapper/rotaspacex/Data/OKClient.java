package co.uk.happyapper.rotaspacex.Data;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;

public class OKClient {
    private static OkHttpClient okClient;

    public static OkHttpClient getInstance() {
        if (okClient == null) {
            okClient = new OkHttpClient.Builder()
                    .build();
        }
        return okClient;
    }

}
