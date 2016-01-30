package com.example.alice.calculator;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    boolean decimal= false;
    boolean restaa= false;
    boolean suma= false;
    boolean multi= false;
    boolean division= false;
    boolean poten= false;
    boolean raizz= false;
    Double[] numero= new Double[20];
    Double resultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Button n0=(Button)findViewById(R.id.button0);
        n0.setOnClickListener((View.OnClickListener) this);

        Button n1=(Button)findViewById(R.id.button1);
        n1.setOnClickListener((View.OnClickListener) this);
        Button n2=(Button)findViewById(R.id.button2);
        n2.setOnClickListener((View.OnClickListener) this);
        Button n3=(Button)findViewById(R.id.button3);
        n3.setOnClickListener((View.OnClickListener) this);
        Button n4=(Button)findViewById(R.id.button4);
        n4.setOnClickListener((View.OnClickListener) this);
        Button n5=(Button)findViewById(R.id.button5);
        n5.setOnClickListener((View.OnClickListener) this);
        Button n6=(Button)findViewById(R.id.button6);
        n6.setOnClickListener((View.OnClickListener) this);
        Button n7=(Button)findViewById(R.id.button7);
        n7.setOnClickListener((View.OnClickListener) this);
        Button n8=(Button)findViewById(R.id.button8);
        n8.setOnClickListener((View.OnClickListener) this);
        Button n9=(Button)findViewById(R.id.button9);
        n9.setOnClickListener((View.OnClickListener) this);

        Button punto=(Button)findViewById(R.id.buttonpunto);
        punto.setOnClickListener((View.OnClickListener) this);
        Button igual=(Button)findViewById(R.id.buttonigual);
        igual.setOnClickListener((View.OnClickListener) this);
        Button sum=(Button)findViewById(R.id.buttonsum);
        sum.setOnClickListener((View.OnClickListener) this);
        Button rest=(Button)findViewById(R.id.buttonrest);
        rest.setOnClickListener((View.OnClickListener) this);
        Button div=(Button)findViewById(R.id.buttondiv);
        div.setOnClickListener((View.OnClickListener) this);
        Button mult=(Button)findViewById(R.id.buttonmult);
        mult.setOnClickListener((View.OnClickListener) this);
        Button raiz=(Button)findViewById(R.id.buttonraiz);
        raiz.setOnClickListener((View.OnClickListener) this);
        Button pot=(Button)findViewById(R.id.buttonpot);
        pot.setOnClickListener((View.OnClickListener) this);
        Button sen=(Button)findViewById(R.id.buttonsen);
        sen.setOnClickListener((View.OnClickListener) this);
        Button cos=(Button)findViewById(R.id.buttoncos);
        cos.setOnClickListener((View.OnClickListener) this);
        Button tan=(Button)findViewById(R.id.buttontan);
        tan.setOnClickListener((View.OnClickListener) this);
        Button ac=(Button)findViewById(R.id.buttonac);
        ac.setOnClickListener((View.OnClickListener) this);
        Button del=(Button)findViewById(R.id.buttondel);
        del.setOnClickListener((View.OnClickListener) this);

        Button pi=(Button)findViewById(R.id.buttonpi);
        pi.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View v){

        TextView pantalla=(TextView)findViewById(R.id.Pantalla);
        int select=v.getId();
        String a=pantalla.getText().toString();

        try{
        switch(select){

            case R.id.button0:
                pantalla.setText(a+"0");
                break;
            case R.id.button1:
                pantalla.setText(a+"1");
                break;
            case R.id.button2:
                pantalla.setText(a+"2");
                break;
            case R.id.button3:
                pantalla.setText(a+"3");
                break;
            case R.id.button4:
                pantalla.setText(a+"4");
                break;
            case R.id.button5:
                pantalla.setText(a+"5");
                break;
            case R.id.button6:
                pantalla.setText(a+"6");
                break;
            case R.id.button7:
                pantalla.setText(a+"7");
                break;
            case R.id.button8:
                pantalla.setText(a+"8");
                break;
            case R.id.button9:
                pantalla.setText(a+"9");
                break;

            case R.id.buttonpunto:
                if(decimal== false){
                    pantalla.setText(a+".");
                    decimal=true;
                }
                else {return;}
                break;

            case R.id.buttonmult:
                numero[0]= Double.parseDouble(a);
                //pantalla.setText(a+"x");
                pantalla.setText("");
                multi=true;
                decimal=false;
                break;
            case R.id.buttonsum:
                numero[0]= Double.parseDouble(a);
                //pantalla.setText(a+"+");
                pantalla.setText("");
                suma=true;
                decimal=false;
                break;
            case R.id.buttondiv:
                numero[0]= Double.parseDouble(a);
                //pantalla.setText(a+"/");
                pantalla.setText("");
                division=true;
                decimal=false;
                break;
            case R.id.buttonrest:
                numero[0]= Double.parseDouble(a);
                //pantalla.setText(a+"-");
                pantalla.setText("");
                restaa=true;
                decimal=false;
                break;
            case R.id.buttonpot:
                numero[0]= Double.parseDouble(a);
                //pantalla.setText(a+"-");
                pantalla.setText("");
                poten=true;
                decimal=false;
                break;
            case R.id.buttonraiz:
                numero[0]= Double.parseDouble(a);
                //pantalla.setText(a+"-");
                pantalla.setText("");
                raizz=true;
                decimal=false;
                break;


            case R.id.buttonigual:

                numero[1]= Double.parseDouble(a);
                if(suma==true){
                    resultado=numero[0]+numero[1];
                    pantalla.setText(String.valueOf(resultado));
                }else if(restaa==true){
                    resultado=numero[0]-numero[1];
                    pantalla.setText(String.valueOf(resultado));
                }else if(multi==true){
                    resultado=numero[0]*numero[1];
                    pantalla.setText(resultado.toString());
                }else if(division==true){
                    resultado=numero[0]/numero[1];
                    pantalla.setText(resultado.toString());
                }else if(poten==true){

                    resultado=Math.pow(numero[0],numero[1]);
                    pantalla.setText(resultado.toString());
                }else if(raizz==true) {

                    resultado = Math.pow(numero[0], (1 / numero[1]));
                    pantalla.setText(resultado.toString());
                }
                //pantalla.setText("igual");

                decimal=restaa=suma=division=multi=poten=false;
                break;
            case R.id.buttonpi:
                resultado = Math.PI;
                pantalla.setText(String.valueOf(resultado));
                decimal=true;
                break;

            case R.id.buttonsen:
                numero[0]= Double.parseDouble(a);
                resultado = Math.sin(numero[0]);
                pantalla.setText(String.valueOf(resultado));
                decimal=false;
                break;
            case R.id.buttoncos:
                numero[0]= Double.parseDouble(a);
                resultado = Math.cos(numero[0]);
                pantalla.setText(String.valueOf(resultado));
                decimal=false;
                break;
            case R.id.buttontan:
                numero[0]= Double.parseDouble(a);
                resultado = Math.tan(numero[0]);
                pantalla.setText(String.valueOf(resultado));
                decimal=false;
                break;
            case R.id.buttonac:
                pantalla.setText("");
                decimal=false;
                break;
            case R.id.buttondel:
                if (a != null || a.length() > 0) {
                    a= a.substring(0, a.length()-1);
                }
                pantalla.setText(a);

                break;


        }}
        catch(Exception e){
            pantalla.setText("error");
        }
    }


}
