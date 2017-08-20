package com.eljholiveira.builtitbiggerudacity;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.eltonjhony.myapplication.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by eltonjhony on 19/08/17.
 */

public class JokesAsyncTask extends AsyncTask<String, Void, JokeResponse> {

    private static JokeApi jokeApi = null;
    private OnLoadJokesListener listener;

    public JokesAsyncTask(@NonNull OnLoadJokesListener listener) {
        buildApi();
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listener.onStartRequest();
    }

    @Override
    protected JokeResponse doInBackground(String... param) {
        try {
            return new JokeResponse(jokeApi.getJoke().execute().getJoke(), false);
        } catch (Exception e) {
            return new JokeResponse(e.getMessage(), true);
        }
    }

    @Override
    protected void onPostExecute(JokeResponse jokeResponse) {
        if (jokeResponse.isError()) {
            listener.onError(jokeResponse.getData());
        } else {
            listener.onSuccess(jokeResponse.getData());
        }
    }

    private void buildApi() {
        if (jokeApi == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(BuildConfig.BASE_URL)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            jokeApi = builder.build();
        }
    }

    interface OnLoadJokesListener {
        void onStartRequest();
        void onSuccess(String joke);
        void onError(String message);
    }
}
