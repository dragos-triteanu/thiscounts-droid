package eu.thiscounts.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import eu.thiscounts.tutorial.CustomPresentationPagerFragment;


public class TutorialActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(eu.thiscounts.R.layout.activity_tutorial);

		findViewById(eu.thiscounts.R.id.bRetry).setOnClickListener(this);

		if (savedInstanceState == null) {
			replaceTutorialFragment();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case eu.thiscounts.R.id.bRetry:
				replaceTutorialFragment();
				break;
		}
	}

	public void replaceTutorialFragment() {
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(eu.thiscounts.R.id.container, new CustomPresentationPagerFragment());
		fragmentTransaction.commit();
	}
}
