package animal.forest.chat;

import android.app.Application;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import java.util.Arrays;
import java.util.List;

public class ChatReactNativeHost extends ReactNativeHost {
    public ChatReactNativeHost(Application application){
        super(application);
    }
    
    @Override
    protected List<ReactPackage> getPackages()
    {
        return Arrays.asList(
            new MainReactPackage()
        );
    }

    @Override public boolean getUseDeveloperSupport()  {
        return BuildConfig.DEBUG;
    }

    @Override
    public String getJSMainModuleName() {
        return "index";
    }
}