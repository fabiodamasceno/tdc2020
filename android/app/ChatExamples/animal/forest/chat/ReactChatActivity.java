package animal.forest.chat;

import android.content.Context;
import android.content.Intent;
import com.facebook.react.ReactActivity;

public class ReactChatActivity extends ReactActivity {

    @Override
    public String getMainComponentName(){
        return "Chat";
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, ReactChatActivity.class);
    }
}
