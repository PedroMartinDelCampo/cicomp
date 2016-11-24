package pmg.cicomp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 20/10/16.
 */

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    private List<Section> sections;

    public SectionsPagerAdapter(FragmentManager fm, List<Section> sections) {
        super(fm);
        this.sections = sections;
    }

    @Override
    public Fragment getItem(int position) {
        return sections.get(position);
    }

    @Override
    public int getCount() {
        return sections.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return sections.get(position).getTitle();
    }

}
