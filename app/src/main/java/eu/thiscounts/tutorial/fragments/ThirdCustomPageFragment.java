package eu.thiscounts.tutorial.fragments;


import com.cleveroad.slidingtutorial.PageFragment;
import com.cleveroad.slidingtutorial.TransformItem;

public class ThirdCustomPageFragment extends PageFragment {

	@Override
	protected int getLayoutResId() {
		return eu.thiscounts.R.layout.fragment_tutorial_third_page;
	}

	@Override
	protected TransformItem[] provideTransformItems() {
		return new TransformItem[]{
				new TransformItem(eu.thiscounts.R.id.ivFirstImage, true, 20),
				new TransformItem(eu.thiscounts.R.id.ivSecondImage, false, 6),
				new TransformItem(eu.thiscounts.R.id.ivThirdImage, true, 8),
				new TransformItem(eu.thiscounts.R.id.ivFourthImage, false, 10),
				new TransformItem(eu.thiscounts.R.id.ivFifthImage, false, 3),
				new TransformItem(eu.thiscounts.R.id.ivSixthImage, false, 9),
				new TransformItem(eu.thiscounts.R.id.ivSeventhImage, false, 14),
		};
	}
}
