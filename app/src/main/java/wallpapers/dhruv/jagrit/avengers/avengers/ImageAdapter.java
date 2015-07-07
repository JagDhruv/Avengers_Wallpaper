package wallpapers.dhruv.jagrit.avengers.avengers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by JAGRIT on 21-04-2015.
 */
public class ImageAdapter  extends BaseAdapter {

    private static final int PADDING=8;
    private static final int WIDTH=250;
    private static final int HEIGHT=250;

    private Context mContext;
    static List<Integer> mThumbIds;


    ImageAdapter(Context context, List<Integer> ids){
        mContext = context;
        this.mThumbIds = ids;
    }

    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither=false;
        options.inJustDecodeBounds=false;
        options.inPreferredConfig= Bitmap.Config.ARGB_8888;
        options.inSampleSize=3;
        options.inPurgeable=true;
        Bitmap icon= BitmapFactory.decodeResource(mContext.getResources(),mThumbIds.get(position),options);
        imageView.setImageBitmap(icon);
       // imageView.setImageResource(mThumbIds.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(WIDTH,HEIGHT));
        return imageView;




    }
}

