package com.pixelhang.pirat.hangman;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View.OnKeyListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


import java.util.Arrays;
import java.util.Random;

import static com.pixelhang.pirat.hangman.R.id.image;

public class MainActivity extends AppCompatActivity {


    Button BtnPlay;
    Button BtnGeography;
    Button BtnFantasy;
    Button BtnSciFi;
    Button BtnFood;
    Button BtnReplay;
    Button BtnAnimals;
    TextView txtHangman;
    EditText txtEnterLetter;
    TextView txtLettersUsed;
    TextView txtGame;
    TextView txtWinLose;
    TextView txtCategory;
    ImageView imghangman;
    ImageView imghangman1;
    ImageView imghangman2;
    ImageView imghangman3;
    ImageView imghangman4;
    ImageView imghangman5;
    ImageView imghangman6;
    private AdView mAdView;


    private static String[]  WordListFant={"d r a g o n ","k n i g h t ","c a s t l e ","s w o r d ","l a n c e ","q u e s t ","a d v e n t u r e ","c a t a p u l t ","m a g i c ","w i z a r d ","p o t i o n ","d u n g e o n ", "w a n d ","c l o a k ","v a m p i r e ","w e r e w o l f ","m i n o t a u r ","u n i c o r n ","a l c h e m y ","a m u l e t ","c o n j u r e r ","d w a r f ","e l f ","g h o s t ","g o b l i n ","o r c ","g n o m e ","h e r o ","k i n g d o m ","l e g e n d ","n e c r o m a n c e r ","o g r e ","o r a c l e ","s h a m a n ","s c r o l l ","s o r c e r y ","s o r c e r e r ","m e d i e v a l ","s e r p e n t "};
    private static String[] WordListSciFi={"s p a c e s h i p ","l a s e r ","a l i e n ","p l a n e t ","g a l a x y ","r o b o t ","a n d r o i d ","c y b o r g ","s p a c e ","b l a s t e r ","t e l e p o r t e r ","s t a r s h i p ","a t o m i c ","r o b o t ","a u t o m a t o n ","c l o n e ","f u t u r e ","h o l o g r a p h ","m e t e o r ","d r o n e ","a s t r o n a u t ","n a n o b o t ","t e c h n o l o g y ","t e r r a f o r m ","h o v e r c r a f t ","b e a m ","c y b e r ","d y s t o p i a ","g a d g e t ","h y p e r s p a c e ","h y p e r s p e e d ","h y p e r d r i v e ","s c i e n t i s t","m a r t i a n ","m u t a n t ","n e b u l a ","t e l e p a t h y ","w a r p "};
    private static String[] WordListGeo={"a m e r i c a ","a l p s ","e n g l a n d ","c u b a ","e v e r e s t ","a n t a r c t i c a ","g e r m a n y ","c a n a d a ","r u s s i a ","m e x i c o ","s w e d e n ","t r i n i d a d ","s t o n e h e n g e ","n i l e ", "a u s t r a l i a ","c h i n a","j a p a n ","i n d i a ","a t l a n t i c ","p a c i f i c ","a l a s k a ","f i n l a n d ","b e l g i u m ","f r a n c e ","l o n d o n ","p a r i s ","i r a n ","i r a q ","m o s c o w ","n e w y o r k ","b e r l i n ","a f r i c a ","a s i a ","a m a z o n","i t a l y ","b r a z i l ","a r g e n t i n a ","s p a i n ","d e n m a r k ","n o r w a y "};
    private static String[] WordListFood={"p i z z a ","h a m b u r g e r ","h o t d o g ","c a k e ","c h i c k e n ","b a c o n ", "d o n u t ","s a l a d ","c h e e s e ", "t a c o ","s o u p ","s a u s a g e ","p a s t a ","n o o d l e s ","p a n c a k e ","a p p l e ","b a n a n a","s t r a w b e r r y ","k i w i ","c o c o n u t ","s h r i m p ","s a l m o n ","e n c h i l a d a ","d u m p l i n g ","t o m a t o ","o n i o n ","b r e a d ","b i s c u i t ", "c r o i s s a n t ","w a f f l e ","e g g ","b u t t e r ","p o r k ","c e r e a l ","r i c e ","c a l a m a r i ","c o r n ","c h o c o l a t e ","s a n d w i c h "};
    private static String[] WordListAnimals={"d o g ","c a t ","m o u s e ","a l l i g a t o r ","c r o c o d i l e ","l i z a r d ","f a l c o n ","l i o n ","t u r t l e ","t o r t o i s e ","b a d g e r ","o t t e r ","p o r c u p i n e ","s n a k e ","b i s o n","b u f f a l o ","a n a c o n d a ","s q u i r r e l ","f o x ","e l e p h a n t ","a n t e a t e r ","b a b o o n ","m o n k e y ","m o n g o o s e ","e a g l e ","v u l t u r e ","s p i d e r ","k a n g a r o o ","c a r d i n a l ","c a t f i s h ","w i l d e b e e s t ","d o l p h i n ","p e l i c a n ","s t a r f i s h ","b u t t e r f l y ","p y t h o n ","f l a m i n g o ","r a c o o n ","t u r k e y ","r a t t l e s n a k e "};
    private static String[] CurWordList=new String[40];
    private static String[] LettersUsed=new String[26];
    private static String Word="";
    private static String Letter="";
    StringBuilder template = new StringBuilder("");
    private static int WordNum=0;
    private static int Health=6;
    private static int score=0;
    private static int NumLettersUsed=0;
    private static boolean x=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-4472977458998508/3305934875");

        mAdView=(AdView) findViewById(R.id.mAdView);
        AdRequest adRequest=new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);








        BtnPlay= (Button) findViewById(R.id.BtnPlay);
        BtnGeography = (Button) findViewById(R.id.BtnGeography);
        BtnFantasy = (Button) findViewById(R.id.BtnFantasy);
        BtnFood= (Button) findViewById(R.id.BtnFood);
        BtnSciFi = (Button) findViewById(R.id.BtnSciFi);
        BtnAnimals = (Button) findViewById(R.id.BtnAnimals);
        BtnReplay = (Button) findViewById(R.id.BtnReplay);
        txtHangman = (TextView) findViewById(R.id.txtHangman);
        txtGame = (TextView) findViewById(R.id.txtGame);
        txtLettersUsed = (TextView) findViewById(R.id.txtLettersUsed);
        txtEnterLetter = (EditText) findViewById(R.id.txtEnterLetter);
        txtWinLose = (TextView) findViewById(R.id.txtWinLose);
        txtCategory = (TextView) findViewById(R.id.txtCategory);
        imghangman=(ImageView) findViewById(R.id.imghangman);
        imghangman1=(ImageView) findViewById(R.id.imghangman1);
        imghangman2=(ImageView) findViewById(R.id.imghangman2);
        imghangman3=(ImageView) findViewById(R.id.imghangman3);
        imghangman4=(ImageView) findViewById(R.id.imghangman4);
        imghangman5=(ImageView) findViewById(R.id.imghangman5);
        imghangman6=(ImageView) findViewById(R.id.imghangman6);





        BtnGeography.setVisibility(View.GONE);
        BtnFantasy.setVisibility(View.GONE);
        BtnSciFi.setVisibility(View.GONE);
        BtnFood.setVisibility(View.GONE);
        BtnAnimals.setVisibility(View.GONE);
        txtGame.setVisibility(View.GONE);
        txtLettersUsed.setVisibility(View.GONE);
        txtEnterLetter.setVisibility(View.GONE);
        BtnReplay.setVisibility(View.GONE);
        txtWinLose.setVisibility(View.GONE);
        txtCategory.setVisibility(View.GONE);
        imghangman.setVisibility(View.GONE);
        imghangman1.setVisibility(View.GONE);
        imghangman2.setVisibility(View.GONE);
        imghangman3.setVisibility(View.GONE);
        imghangman4.setVisibility(View.GONE);
        imghangman5.setVisibility(View.GONE);









        BtnPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                txtHangman.setVisibility(View.GONE);
                BtnPlay.setVisibility(View.GONE);
                BtnGeography.setVisibility(View.VISIBLE);
                BtnFantasy.setVisibility(View.VISIBLE);
                BtnSciFi.setVisibility(View.VISIBLE);
                BtnFood.setVisibility(View.VISIBLE);
                BtnAnimals.setVisibility(View.VISIBLE);
                imghangman6.setVisibility(View.GONE);

                Word="";
                Letter="";
                template = new StringBuilder("");
                WordNum=0;
                Health=6;
                score=0;
                NumLettersUsed=0;


            }

        });

        BtnReplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){


                BtnGeography.setVisibility(View.VISIBLE);
                BtnFantasy.setVisibility(View.VISIBLE);
                BtnSciFi.setVisibility(View.VISIBLE);
                BtnFood.setVisibility(View.VISIBLE);
                BtnAnimals.setVisibility(View.VISIBLE);

               txtLettersUsed.setVisibility(View.GONE);
                txtEnterLetter.setVisibility(View.GONE);
                txtGame.setVisibility(View.GONE);
                txtWinLose.setVisibility(View.GONE);

                template.setLength(0);
                txtGame.setText("");
                LettersUsed=new String[LettersUsed.length];
                txtLettersUsed.setText("");
                Health=6;
                score=0;
                BtnReplay.setVisibility(View.GONE);
                txtCategory.setVisibility(View.GONE);


                imghangman.setVisibility(View.GONE);
                imghangman1.setVisibility(View.GONE);
                imghangman2.setVisibility(View.GONE);
                imghangman3.setVisibility(View.GONE);
                imghangman4.setVisibility(View.GONE);
                imghangman5.setVisibility(View.GONE);
                imghangman6.setVisibility(View.GONE);


            }

        });






        BtnGeography.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                BtnGeography.setVisibility(View.GONE);
                BtnFantasy.setVisibility(View.GONE);
                BtnSciFi.setVisibility(View.GONE);
                BtnFood.setVisibility(View.GONE);
                BtnAnimals.setVisibility(View.GONE);
                txtGame.setVisibility(View.VISIBLE);
                txtLettersUsed.setVisibility(View.VISIBLE);
                txtEnterLetter.setVisibility(View.VISIBLE);


                CurWordList=WordListGeo;
                txtCategory.setVisibility(View.VISIBLE);
                txtCategory.setText("Geography");
                Method();



            }

        });

        BtnFantasy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                BtnGeography.setVisibility(View.GONE);
                BtnFantasy.setVisibility(View.GONE);
                BtnSciFi.setVisibility(View.GONE);
                BtnFood.setVisibility(View.GONE);
                BtnAnimals.setVisibility(View.GONE);
                txtGame.setVisibility(View.VISIBLE);
                txtLettersUsed.setVisibility(View.VISIBLE);
                txtEnterLetter.setVisibility(View.VISIBLE);


                CurWordList=WordListFant;
                txtCategory.setVisibility(View.VISIBLE);
                txtCategory.setText("Fantasy");
                Method();



            }

        });

        BtnSciFi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                BtnGeography.setVisibility(View.GONE);
                BtnFantasy.setVisibility(View.GONE);
                BtnSciFi.setVisibility(View.GONE);
                BtnFood.setVisibility(View.GONE);
                BtnAnimals.setVisibility(View.GONE);
                txtGame.setVisibility(View.VISIBLE);
                txtLettersUsed.setVisibility(View.VISIBLE);
                txtEnterLetter.setVisibility(View.VISIBLE);


                CurWordList=WordListSciFi;
                txtCategory.setVisibility(View.VISIBLE);
                txtCategory.setText("Sci-Fi");
                Method();



            }

        });

        BtnFood.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                BtnGeography.setVisibility(View.GONE);
                BtnFantasy.setVisibility(View.GONE);
                BtnSciFi.setVisibility(View.GONE);
                BtnFood.setVisibility(View.GONE);
                BtnAnimals.setVisibility(View.GONE);
                txtGame.setVisibility(View.VISIBLE);
                txtLettersUsed.setVisibility(View.VISIBLE);
                txtEnterLetter.setVisibility(View.VISIBLE);


                CurWordList=WordListFood;
                txtCategory.setVisibility(View.VISIBLE);
                txtCategory.setText("Food");
                Method();



            }

        });

        BtnAnimals.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                BtnGeography.setVisibility(View.GONE);
                BtnFantasy.setVisibility(View.GONE);
                BtnSciFi.setVisibility(View.GONE);
                BtnFood.setVisibility(View.GONE);
                BtnAnimals.setVisibility(View.GONE);
                txtGame.setVisibility(View.VISIBLE);
                txtLettersUsed.setVisibility(View.VISIBLE);
                txtEnterLetter.setVisibility(View.VISIBLE);


                CurWordList=WordListAnimals;
                txtCategory.setVisibility(View.VISIBLE);
                txtCategory.setText("Animals");
                Method();



            }

        });



    }

    private void Method() {

        template.setLength(0);
        txtGame.setText("");
        LettersUsed=new String[LettersUsed.length];
        txtLettersUsed.setText("");
        Health=6;
        score=0;
        Word="";
        Letter="";
        template = new StringBuilder("");


        Random rndm = new Random() ;
        WordNum=rndm.nextInt(CurWordList.length);
        Word=CurWordList[WordNum];

        for(int i=0;i<Word.length()/2;i++)
        {
            template.append("_ ");
        }
        txtGame.setText(""+template.toString());


        NumLettersUsed=0;


        imghangman.setVisibility(View.VISIBLE);


        txtEnterLetter.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override


            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {



                    Letter= String.valueOf(txtEnterLetter.getText());
                    Letter=Letter.toLowerCase();

                    if(Word.contains(Letter) & !Arrays.asList(LettersUsed).contains(Letter) & Letter.length()==1)
                    {
                        txtEnterLetter.setText("");
                        for(int i=0;i<Word.length();i++){
                            if (Letter.equals(Word.substring(i,i+1)))
                            {

                                score++;
                                template.setCharAt(i,Word.charAt(i));
                                txtGame.setText(template.toString());

                            }


                        }
                        if(score==Word.length()/2)
                        {
                            txtWinLose.setVisibility(View.VISIBLE);
                            txtWinLose.setText("You Win");
                            BtnReplay.setVisibility(View.VISIBLE);
                            txtEnterLetter.setVisibility(View.GONE);


                        }
                        txtLettersUsed.setText(txtLettersUsed.getText()+Letter+", ");
                        LettersUsed[NumLettersUsed]=Letter;
                        NumLettersUsed++;
                    }

                    else if (!Word.contains(Letter) & !Arrays.asList(LettersUsed).contains(Letter) & Letter.length()==1)
                    {
                        txtEnterLetter.setText("");
                        Health--;


                        if (Health==5)
                        {
                            imghangman.setVisibility(View.GONE);
                            imghangman1.setVisibility(View.VISIBLE);
                        }

                        if (Health==4)
                        {
                            imghangman1.setVisibility(View.GONE);
                            imghangman2.setVisibility(View.VISIBLE);
                        }

                        if (Health==3)
                        {
                            imghangman2.setVisibility(View.GONE);
                            imghangman3.setVisibility(View.VISIBLE);
                        }

                        if (Health==2)
                        {
                            imghangman3.setVisibility(View.GONE);
                            imghangman4.setVisibility(View.VISIBLE);
                        }

                        if (Health==1)
                        {
                            imghangman4.setVisibility(View.GONE);
                            imghangman5.setVisibility(View.VISIBLE);
                        }


                        if(Health==0)
                        {
                            imghangman5.setVisibility(View.GONE);
                            imghangman6.setVisibility(View.VISIBLE);
                            txtWinLose.setVisibility(View.VISIBLE);
                            txtWinLose.setText("You Lose");
                            BtnReplay.setVisibility(View.VISIBLE);
                            txtEnterLetter.setVisibility(View.GONE);


                        }
                        txtLettersUsed.setText(txtLettersUsed.getText()+Letter+", ");
                        LettersUsed[NumLettersUsed]=Letter;
                        NumLettersUsed++;
                    }



                    return true;
                }
                return false;
            }
        });




    }
}
