package until;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by Administrator on 2015/10/14.
 */
public class LoginUtil {
    public static  boolean putString(Context context,String key,String value){
          SharedPreferences settings=
                  context.getSharedPreferences("login_info",Context.MODE_PRIVATE);
          SharedPreferences.Editor editor=settings.edit();
          editor.putString(key,value);
          return  editor.commit();
    }
    public static String getString(Context context,String key){
        SharedPreferences settings=
                context.getSharedPreferences("login_info", Context.MODE_PRIVATE);
        return  settings.getString(key,"");

    }
}
