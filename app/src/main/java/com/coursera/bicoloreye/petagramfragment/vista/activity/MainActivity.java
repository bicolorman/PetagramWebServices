package com.coursera.bicoloreye.petagramfragment.vista.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.coursera.bicoloreye.petagramfragment.R;
import com.coursera.bicoloreye.petagramfragment.adapter.MascotaAdaptador;
import com.coursera.bicoloreye.petagramfragment.adapter.PageAdapter;
import com.coursera.bicoloreye.petagramfragment.adapter.PostInstagramAdapter;
import com.coursera.bicoloreye.petagramfragment.vista.fragment.PerfilFragment;
import com.coursera.bicoloreye.petagramfragment.vista.fragment.RecyclerViewFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar= (Toolbar) findViewById(R.id.miactionBar);
        if(miActionBar !=null){
            setSupportActionBar(miActionBar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }



        /*ImageButton imgBtnFavoritos =(ImageButton) findViewById(R.id.imgBtnFavoritos);
        imgBtnFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Diste Favoritos",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,FavoritosActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });*/



        tabLayout= (TabLayout) findViewById(R.id.tablayout);

        viewPager= (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();




        TextView tvNombrePetagram = (TextView)findViewById(R.id.tvNombrePetagram);
        registerForContextMenu(tvNombrePetagram);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Toast.makeText(this,R.string.menu_about,Toast.LENGTH_SHORT).show();
                Intent iAbout= new Intent(MainActivity.this,AboutActivity.class);
                startActivity(iAbout);
                break;
            case R.id.mContacto:
                Toast.makeText(this,R.string.menu_contacto,Toast.LENGTH_SHORT).show();
                Intent iContacto = new Intent(MainActivity.this,ContactoActivity.class);
                startActivity(iContacto);
                break;
            case R.id.mFavoritos:
                Toast.makeText(this,R.string.menu_action_favoritos,Toast.LENGTH_SHORT).show();
                Intent iFavoritos = new Intent(MainActivity.this,FavoritosActivity.class);
                startActivity(iFavoritos);
                break;
            case R.id.mCuenta:
                Toast.makeText(this,R.string.menu_action_Cuenta,Toast.LENGTH_SHORT).show();
                Intent iCuenta = new Intent(MainActivity.this,AccountSettingsActivity.class);
                startActivity(iCuenta);
                break;
         }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

       getMenuInflater().inflate(R.menu.menu_contexto, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mEdit:
                Toast.makeText(this,"Editar",Toast.LENGTH_SHORT).show();
                break;

            case R.id.mDelete:
                Toast.makeText(this,"Delete",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void levantarMenuPopup(View view){
        ImageView imageView=(ImageView) findViewById(R.id.ivIconPetagram);
        PopupMenu popupMenu = new PopupMenu(this, imageView);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return  fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dog_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);
    }




}