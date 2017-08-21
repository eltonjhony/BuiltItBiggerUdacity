package com.eljholiveira.builtitbiggerudacity;

import android.test.AndroidTestCase;

import com.eljholiveira.builtitbiggerudacity.tasks.JokesAsyncTask;
import com.eljholiveira.builtitbiggerudacity.tasks.model.JokeResponse;

import java.util.concurrent.ExecutionException;

/**
 * Created by eltonjhony on 20/08/17.
 */

public class JokesAsyncTaskTest extends AndroidTestCase implements JokesAsyncTask.OnLoadJokesListener {

    public void test() {

        JokesAsyncTask task = new JokesAsyncTask(this);
        task.execute();

        JokeResponse result = null;
        try {
            result = task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Override
    public void onStartRequest() {
    }

    @Override
    public void onSuccess(String joke) {
        assertNotNull(joke);
    }

    @Override
    public void onError(String message) {
        assertNull(message);
    }
}
