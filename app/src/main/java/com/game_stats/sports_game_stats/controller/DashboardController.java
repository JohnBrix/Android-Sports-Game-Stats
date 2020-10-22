package com.game_stats.sports_game_stats.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.game_stats.sports_game_stats.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import com.wajahatkarim3.easyflipview.EasyFlipView;

public class DashboardController extends AppCompatActivity {
    LinearLayout openTeam, openGameStats,openGameToday,openVenues;
    EasyFlipView easyFlipView;
    ImageView back, front, hideAndAdd,left,right, menu;
//    TextView setMyText;
    CountDownTimer countTimer;
//    RelativeLayout swipe;
    ExpandableTextView expandableTextView;
    int i = 1;
    ResideMenu resideMenu;
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.carousel1, R.drawable.carousel2, R.drawable.carousel3, R.drawable.carousel4, R.drawable.carousel5};
    public void javaToXml(){
        back = findViewById(R.id.back_swipe);
        front = findViewById(R.id.front_swipe);
        easyFlipView = findViewById(R.id.easyFlipView);
//        setMyText = findViewById(R.id.set_as_text); COMMENT BECAUSE OF REDUNDANCY
        expandableTextView = findViewById(R.id.expand_text_view);
        hideAndAdd = findViewById(R.id.hide_and_back);
//        swipe = findViewById(R.id.swipe); COMMENT BECAUSE OF REDUNDANCY
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        menu = findViewById(R.id.menues);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        javaToXml();
        resideMenues();
        resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);

        expandableTextView.setText("Click the Image for information!");

//        front.setImageResource(R.drawable.game_stats); // 1
////        setMyText.setText("Games Stats");
//        front.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(DashboardController.this, TeamGameStatsController.class); //Open new Activity
//                startActivity(myIntent);
//                finish();
//            }
//        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
//        swipeOnTouch();
//        leftAndRight(); //changing intent



//        pitureChange();
//        right.setOnTouchListener(new OnSwipeTouchListener(DashboardController.this) {
//            @Override
//            public void onSwipeRight() {
//                super.onSwipeRight();
//
//            }
//        });
        carouselClicked();


        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
    }


//    public void hideAndBack(){
//        hideAndAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (quote.getVisibility() == View.VISIBLE)
//                    quote.setVisibility(View.INVISIBLE);
//                else
//                    quote.setVisibility(View.VISIBLE);
//            }
//        });
//
//    }
//    public void swipeOnTouch(){
//        swipe.setOnTouchListener(new OnSwipeTouchListener(DashboardController.this) {
//            @Override
//            public void onSwipeLeft() {
//                super.onSwipeLeft();
//
//                if (i == 4) {
//                    i = 1;
//                } else {
//                    i++;
//                }
//                pitureChange();
//            }
//
//            @Override
//            public void onSwipeRight() {
//                super.onSwipeRight();
//                if (i == 1) {
//                    i = 4;
//                } else {
//                    i--;
//                }
//                pitureChange();
//            }
//        });
//    }
public void resideMenues(){
    // attach to current activity;
    resideMenu = new ResideMenu(this);
    resideMenu.setBackground(R.drawable.dashboard_blur);
    resideMenu.attachToActivity(this);
    resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
    resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_LEFT);
    // create menu items;
    resideMenu.setScaleValue(0.5f);
    //INITIALIZATION
    String titles[] = { "Game Stats" };
    String titles2[] = {  "Team"};
    String titles3[] = { "Games Today"};
    String titles4[] = { "Venues" };
    int icon[] = { R.drawable.game_stats };
    int icon2[] = {  R.drawable.team };
    int icon3[] = { R.drawable.games_today };
    int icon4[] = { R.drawable.venues };


    resideMenu.openMenu(ResideMenu.DIRECTION_LEFT); // or ResideMenu.DIRECTION_RIGHT
    resideMenu.closeMenu();

    resideMenu.setMenuListener(menuListener);
    //ADDING
    for (int i = 0; i < titles.length; i++){
        ResideMenuItem gameStats = new ResideMenuItem(this, icon[i], titles[i] );
        ResideMenuItem team = new ResideMenuItem(this,  icon2[i],titles2[i] );
        ResideMenuItem gamesToday = new ResideMenuItem(this,  icon3[i],titles3[i] );
        ResideMenuItem venues = new ResideMenuItem(this,  icon4[i],titles4[i] );
        //WHEN CLICKING
        gameStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardController.this, TeamGameStatsController.class); //Open new Activity
                startActivity(myIntent);
                finish();
            }
        });
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardController.this, TeamController.class); //Open new Activity
                startActivity(myIntent);
                finish();
            }
        });
        gamesToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardController.this, GamesTodayController.class); //Open new Activity
                startActivity(myIntent);
                finish();
            }
        });
        venues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DashboardController.this, VenuesController.class); //Open new Activity
                startActivity(myIntent);
                finish();
            }
        });
        resideMenu.addMenuItem(gameStats,  ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(team,  ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(gamesToday,  ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(venues,  ResideMenu.DIRECTION_LEFT);


    }
}
@Override
public boolean dispatchTouchEvent(MotionEvent ev) {
    return resideMenu.dispatchTouchEvent(ev);
}

    ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {

        }

        @Override
        public void closeMenu() {

        }
    };


    public void carouselClicked(){
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {

                if (position == 0){
                    expandableTextView.setText("Even better, based on all of the interviews and reports, we can even get into the mind of these extraordinary athletes.\n" +
                            "\n" +
                            "All of the players have clearly demonstrated a major commitment to excellence, and that alone is super inspiring.\n" +
                            "\n" +
                            "The 2018 World cup, which was held in Russia, was the 21st edition of the international football tournament. France once again showed its footballing prowess when it fought Croatia off in the final. This was France’s second world cup title and the first since it won on home soil in 1998."+"\n \n"+"Credits to: \n"+
                            "Website: everydaypower.com");
                }
                else if(position == 1){
                    expandableTextView.setText("This readiness to assume the guilt for the threats to our environment is deceptively reassuring: We like to be guilty since, if we are guilty, it all depends on us. We pull the strings of the catastrophe, so we can also save ourselves simply by changing our lives. What is really hard for us (at least in the West) to accept is that we are reduced to the role of a passive observer who sits and watches what our fate will be."+"\n"+
                            "To avoid this impotence, we engage in frantic, obsessive activities. We recycle old paper, we buy organic food, we install long-lasting light bulbs—whatever—just so we can be sure that we are doing something."+"\n"
                            +"\n"+"Credits to:"+"" +
                            "\n"+"Website: goodreads.com");
                }
                else if (position == 2){
                    expandableTextView.setText("The one constant through all the years, Ray, has been baseball. America has rolled by like an army of steamrollers. It has been erased like a blackboard, rebuilt and erased again. But baseball has marked the time."+"\n\n"+" This field, this game: it’s a part of our past, Ray. It reminds us of all that once was good and that could be again."+"\n \n"
                            +"- James Earl Jones"+"\n \n"+"Credits to:"+"\n"+"planetofsuccess.com");
                }
                else if (position == 3){
                    expandableTextView.setText("I was just a big guy running down with a big, deep pocket and little short stick putting it against my chest.\n" +
                            "\n" +
                            "I could fully express myself in lacrosse.\n" +
                            "\n" +
                            "…you could be the best team or the best player in different generations and people respect each other. Nobody cares about who was the best.\n" +
                            "\n" +
                            "Lacrosse is probably the best sport I ever played."+"\n \n"+"-Jim Brown Lacrosse"+"\n \n"+"Credits to:"+"\n"+"Website: sportsfeelgoodstories.com");
                }
                else if(position == 4){
                    expandableTextView.setText("German football teams traumatised their neighbours. The worst memory in French football history is the defeat to Germany in the semi-final of the World Cup of 1982. The worst Dutch football memory is the lost World Cup final of 1974, recently mourned in a bestselling book. The worst English memories are probably the defeats to Germany in 1970, 1990 and 1996, summed up by the phrase \"Thirty years of hurt\" in the English football hymn \"Football’s Coming Home\"... they entered the last World Cup as perhaps the first team in history built around a goalkeeper — Oliver Kahn.\n" +
                            " \n       - Simon Kuper, on the decline of Germany, \"The Financial Times\"" +
                            "\n \n"+"Credits to:"+"\n"+"eircom.net");

                }
                }

        });
    }
//    public void leftAndRight(){
//        left.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (i == 1) {
//                    i = 4;
//                } else {
//                    i--;
//                }
//                pitureChange();
//            }
//
//        });
//        right.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (i == 4) {
//                    i = 1;
//                } else {
//                    i++;
//                }
//                pitureChange();
//            }
//        });
//    }



    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


//    public boolean pitureChange() {
//
//        if (i == 1) {
//            easyFlipView.flipTheView();
//            front.setImageResource(R.drawable.game_stats);
//            Toast.makeText(DashboardController.this, "1", Toast.LENGTH_SHORT).show();
//            setMyText.setText("Game Stats");
//
//            front.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent myIntent = new Intent(DashboardController.this, TeamGameStatsController.class); //Open new Activity
//                    startActivity(myIntent);
//                    finish();
//                }
//            });
//
//
//        } else if (i == 2) {
//            easyFlipView.flipTheView();
//            back.setImageResource(R.drawable.team);
//            setMyText.setText("Team");
//
//            Toast.makeText(DashboardController.this, "2", Toast.LENGTH_SHORT).show();
//            back.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent myIntent = new Intent(DashboardController.this, TeamController.class); //Open new Activity
//                    startActivity(myIntent);
//                    finish();
//                }
//            });
//
//
//        } else if (i == 3) {
//            easyFlipView.flipTheView();
//            front.setImageResource(R.drawable.games_today);
//            setMyText.setText("Games Today");
//
//            Toast.makeText(DashboardController.this, "3", Toast.LENGTH_SHORT).show();
//            front.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent myIntent = new Intent(DashboardController.this, GamesTodayController.class); //Open new Activity
//                    startActivity(myIntent);
//                    finish();
//                }
//            });
////            openGamesToday(front);
//
//        } else if (i == 4) {
//            easyFlipView.flipTheView();
//            back.setImageResource(R.drawable.venues);
//            setMyText.setText("Venues");
//            Toast.makeText(DashboardController.this, "4", Toast.LENGTH_SHORT).show();
//
//            back.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent myIntent = new Intent(DashboardController.this, VenuesController.class); //Open new Activity
//                    startActivity(myIntent);
//                    finish();
//                }
//            });
//        }
//        System.out.println(i + " swipes");
//        return true;
//    }
//
//    public void openIntent(){
//        openTeam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(DashboardController.this, TeamController.class); //Open new Activity
//                startActivity(myIntent);
//            }
//        });
////        openGameStats.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent myIntent = new Intent(DashboardController.this, TeamGameStatsController.class); //Open new Activity
////                startActivity(myIntent);
////            }
////        });
////        openGameToday.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent myIntent = new Intent(DashboardController.this, GamesTodayController.class); //Open new Activity
////                startActivity(myIntent);
////            }
////        });
////        openVenues.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent myIntent = new Intent(DashboardController.this, VenuesController.class); //Open new Activity
////                startActivity(myIntent);
////            }
////        });
//
//    }
}