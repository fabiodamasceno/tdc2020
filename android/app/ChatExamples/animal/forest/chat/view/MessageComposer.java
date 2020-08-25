package animal.forest.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import animal.forest.chat.R;

// tag::SEND-1[]
public class MessageComposer extends RelativeLayout {

    private EditText mInput;
    private ImageView mSend;
    private ImageView mAttachment;
    private ImageView mCamera;

    private Listener mListener;
    private Listener mCameraListener;


    public MessageComposer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View root = inflate(getContext(), R.layout.view_message_composer, this);
        mInput = root.findViewById(R.id.composer_edittext);
        mSend = root.findViewById(R.id.composer_send);
        mAttachment = root.findViewById(R.id.composer_attachment);
        mSend.setOnClickListener(v -> {
            mListener.onSentClick(mInput.getText().toString().trim());
            mInput.setText("");
        });
        mCamera = root.findViewById(R.id.camera);
        mCamera.setOnClickListener(v -> {
            mCameraListener.onCameraClick();
        });
    }

    public void setListener(Listener listener) {
        mListener = listener;
    }
    public void setCameraListener(Listener listener) {
        mCameraListener = listener;
    }

    public interface Listener {
        void onCameraClick();
        void onSentClick(String message);
    }

}
// end::SEND-1[]
