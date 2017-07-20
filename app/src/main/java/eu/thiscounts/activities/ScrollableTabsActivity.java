package eu.thiscounts.activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.thiscounts.R;
import eu.thiscounts.adapter.FragmentPagerAdapter;
import eu.thiscounts.fragments.NearMeFragment;
import eu.thiscounts.fragments.PurchasesFragment;
import eu.thiscounts.fragments.RecyclerViewFragment;


/**
 * Example http://www.androidhive.info/2015/09/android-material-design-working-with-tabs/
 */
public class ScrollableTabsActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);
        ButterKnife.bind(this);

        setupToolbar();
        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupToolbar() {
        toolbar.setLogo(R.drawable.ic_logo);
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setTitle(R.string.app_name);
        //Toolbar is used here as an action bar to navigate between activities.
        setSupportActionBar(toolbar);
    }

    private void setupViewPager() {
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager());

        adapter.addFragmentWithTitle(getString(R.string.discountsTabTxt), new RecyclerViewFragment());
        adapter.addFragmentWithTitle(getString(R.string.nearMeTabTxt), new NearMeFragment());
        adapter.addFragmentWithTitle(getString(R.string.purchasesTabTxt), new PurchasesFragment());

        viewPager.setAdapter(adapter);

    }
}
