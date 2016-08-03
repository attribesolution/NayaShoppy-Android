package com.attribe.nayashoppy.app.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.attribe.nayashoppy.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Sabih Ahmed on 03-Aug-16.
 */
public class LeftDrawerHolder extends RecyclerView.ViewHolder{

    public TextView optionName;
    public TextView userName;
    public CircleImageView optionIcon;
    public CircleImageView userImage;
    public LeftDrawerHolder(View itemView, int itemType) {
        super(itemView);

        if(itemType==0){

            userName = (TextView) itemView.findViewById(R.id.user_name);
            userImage = (CircleImageView)itemView.findViewById(R.id.profile_image);
        }
        if(itemType == 1){
            optionName = (TextView) itemView.findViewById(R.id.optionName);
            optionIcon = (CircleImageView)itemView.findViewById(R.id.optionIcon);
        }

    }
}
