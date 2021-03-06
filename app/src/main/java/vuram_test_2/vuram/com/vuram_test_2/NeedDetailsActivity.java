package vuram_test_2.vuram.com.vuram_test_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.ArrayList;

public class NeedDetailsActivity extends AppCompatActivity {

    ArrayList<NeedListViewItems> needData,needCardData;
    RecyclerView needrecyclerView,receivalCardView;
    NeedListViewAdapter needListViewAdapter;
    NeedReceivalCard needReceivalCard;
    Button showlistButton;
    LinearLayout needListLayout,headingLayout;
    CircularProgressBar progressBar;
    TextView percentage;
    View divider1;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_details);

        toolbar = (Toolbar) findViewById(R.id.toolbar_need_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        needData = new ArrayList();
        needCardData = new ArrayList();

        needViewData();
        needCardViewData();

        progressBar = (CircularProgressBar)findViewById(R.id.circularProgressBar_ReceivalPage);
        percentage = (TextView)findViewById(R.id.circularProgressPercentageTextVIew_ReceivalPage);

        int animationDuration = 1000; // 2500ms = 2,5s
        progressBar.setProgressWithAnimation(80, animationDuration);
        percentage.setText("80%");

        showlistButton = (Button)findViewById(R.id.showListButton_ReceivalPage);
        needrecyclerView = (RecyclerView)findViewById(R.id.needListRecyclerView_ReceivalPage);
        receivalCardView = (RecyclerView)findViewById(R.id.donorListRecyclerView_ReceivalPage);
        needListLayout = (LinearLayout)findViewById(R.id.needListDivider_ReceivalPage);
        headingLayout = (LinearLayout)findViewById(R.id.listHeadingLinearLayout_ReceivalPage);


        needListViewAdapter = new NeedListViewAdapter(this,needData);
        needrecyclerView.setAdapter(needListViewAdapter);
        needrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        needListLayout.setVisibility(View.GONE);
        headingLayout.setVisibility(View.GONE);

       // Toast.makeText(this,"after list adapter",Toast.LENGTH_LONG).show();
        needReceivalCard = new NeedReceivalCard(this,needCardData);
        receivalCardView.setAdapter(needReceivalCard);
        receivalCardView.setLayoutManager(new LinearLayoutManager(this));

        divider1 = findViewById(R.id.divider1);

        showlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(needListLayout.getVisibility() == View.GONE) {
                    needListLayout.setVisibility(View.VISIBLE);
                    headingLayout.setVisibility(View.VISIBLE);
                    divider1.setVisibility(View.VISIBLE);
                    showlistButton.setText("Hide Need List");
                }
                else {
                    needListLayout.setVisibility(View.GONE);
                    headingLayout.setVisibility(View.GONE);
                    divider1.setVisibility(View.GONE);
                    showlistButton.setText("Show Need List");
                }

            }
        });
       // Toast.makeText(this,"after caardd adapter",Toast.LENGTH_LONG).show();
  }

    public void needViewData()
    {
        for(int i = 0;i<10;i++) {
            NeedListViewItems needListViewItems = new NeedListViewItems("Clothes", "Male", "20");
            needData.add(needListViewItems);
        }

    }

    public void needCardViewData(){
        for (int j=0;j<6;j++){
            NeedListViewItems items = new NeedListViewItems("Clothes", "Male","20","Akshaya");
            needCardData.add(items);

        }

    }
}
