package animal.forest.chat.fragments;

import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.SubscribeCallback;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.pubsub.PNMessageResult;
import com.pubnub.api.models.consumer.pubsub.PNPresenceEventResult;

import animal.forest.chat.util.PNFragmentImpl;

public class SampleFragment extends ParentFragment implements PNFragmentImpl {

    // tag::FRG-4.1[]
    private SubscribeCallback mPubNubListener; // field of Fragment

    // end::FRG-4.1[]

    @Override
    public int provideLayoutResourceId() {
        return 0;
    }

    @Override
    public void setViewBehaviour(boolean viewFromCache) {

    }

    @Override
    public String setScreenTitle() {
        return null;
    }

    // tag::FRG-4.2[]
    @Override
    public void onReady() {
        initListener();
    }

    private void initListener() {
        mPubNubListener = new SubscribeCallback() {
            @Override
            public void status(PubNub pubnub, PNStatus status) {

            }

            @Override
            public void message(PubNub pubnub, PNMessageResult message) {

            }

            @Override
            public void presence(PubNub pubnub, PNPresenceEventResult presence) {

            }
        };
    }

    @Override
    public SubscribeCallback provideListener() {
        return mPubNubListener;
    }
    // end::FRG-4.2[]
}
