package br.edu.ifsc.sharedpreferences;

import android.content.SharedPreferences;
import android.content.Context;
import android.widget.Toast;


public class Notes {

    SharedPreferences preferences;
    SharedPreferences.Editor editorPreferences;
    Context context;

    private static final String PREFERENCES_FILE ="Notas";

    public Notes(Context context){
        this.context = context;
        preferences = this.context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);

    }

    public String noteREcouver(){
        if (this.preferences.contains("nota")){
            return this.preferences.getString("nota", "");
        } else {
            return "";
        }
    }

    public void noteSave (String string){
        if ( string.trim().equals("")) {
            Toast.makeText(this.context, context.getResources().getString(R.string.empty_note), Toast.LENGTH_LONG).show();
        } else {
            this.editorPreferences.putString("nota", string);
            this.editorPreferences.commit();
        }
    }
}
