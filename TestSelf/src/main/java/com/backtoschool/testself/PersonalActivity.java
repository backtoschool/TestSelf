package com.backtoschool.testself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;

/**
 * Created by MiracleLife on 6/9/2556.
 */
public class PersonalActivity extends Activity {
    private GraphUser user;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_layout);
        // start Facebook Login
        Session.openActiveSession(this, true, new Session.StatusCallback() {

            // callback when session changes state
            @Override
            public void call(Session session, SessionState state, Exception exception) {
               if(state == SessionState.OPENED){
                   Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {
                       @Override
                       public void onCompleted(GraphUser user, Response response) {
                           processUserInfo(user);

                       }
                   });

               }
            }
        });



    }

    private void processUserInfo(GraphUser user) {
        if(user != null){
            this.user = user;
            TextView tv = (TextView) findViewById(R.id.user_name);
            tv.setText(user.getName());

        }



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
    }

}