package me.dt2dev.pm25.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.dt2dev.pm25.ui.MainActivity;
import retrofit.RestAdapter;

/**
 * Created by darktiny on 14-1-29.
 */
@Module(
        injects = {MainActivity.class}
)
public class DataModule {

    @Provides @Singleton public PM25Service getPM25Service(RestAdapter restAdapter) {
        return restAdapter.create(PM25Service.class);
    }

    @Provides @Singleton public RestAdapter provideRestAdapter() {
        return new RestAdapter.Builder().setServer(PM25Contact.BASE_URL).build();
    }
}