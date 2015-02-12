package com.example.xj.myfragment;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.Optional;


public class MainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        @InjectView(R.id.button)
        Button button;
        @InjectView(R.id.button2)
        Button button01;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ButterKnife.inject(this, rootView);
            sayHi(button);

            return rootView;
        }
        //可选的注入 @Optional
        @Optional @OnClick(R.id.button)
        void onMaybeMissingClicked(){
            button01.setText("222");
        }

        @OnItemSelected(value=R.id.button,callback=NOTHING_SELECTED)
        void onNothingSelected(){
            Toast.makeText(this, "Nothing selected!", LENGTH_SHORT).show();
        }


        public void sayHi(Button button){
            button.setText("1111");

            // Toast.makeText(this,"Clicked1",Toast.LENGTH_SHORT).show();

        }
        //Fragment中，我们需要在onDestroyView中设置这些View为null，但是只要调用reset方法，Butter Knife会自动执行这个步骤
        @Override
        public void onDestroyView(){
            super.onDestroyView();
            ButterKnife.reset(this);
        }
    }
}
