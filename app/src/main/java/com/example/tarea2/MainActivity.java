package com.example.tarea2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    double X1, Y1, X2, Y2;
    Point point1 = new Point();
    Point point2 = new Point();

    EditText input_x1, input_y1, input_x2, input_y2;
    Button middle_point_button, slope_button, quadrant_button;

    TextView result, result2;

    public static final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        input_x1 = (EditText) findViewById(R.id.input_x1);
        input_y1 = (EditText) findViewById(R.id.input_y1);
        input_x2 = (EditText) findViewById(R.id.input_x2);
        input_y2 = (EditText) findViewById(R.id.input_y2);

        result = (TextView) findViewById(R.id.result_text);
        result2 = (TextView) findViewById(R.id.result2_text);

        middle_point_button = (Button) findViewById(R.id.middle_point_button);
        slope_button = (Button) findViewById(R.id.slope_button);
        quadrant_button = (Button) findViewById(R.id.quadrant_button);


        middle_point_button.setOnClickListener(this);
        slope_button.setOnClickListener(this);
        quadrant_button.setOnClickListener(this);
    }

    @SuppressLint("DefaultLocale")
    public static String formatDouble(double number)
    {
        return (String) String.format("%.2f", number);
    }


    public String getRandomNumber(double min, double max)
    {
        return formatDouble(min + (max - min) * random.nextDouble() );
    }

    public void genRandomPoints()
    {
        input_x1.setText(getRandomNumber(-50,50));
        input_y1.setText(getRandomNumber(-50,50));

        input_x2.setText(getRandomNumber(-50,50));
        input_y2.setText(getRandomNumber(-50,50));
    }

    public boolean setPointsValues()
    {
        String i_x1 = input_x1.getText().toString();
        String i_y1 = input_y1.getText().toString();
        String i_x2 = input_x2.getText().toString();
        String i_y2 = input_y2.getText().toString();
        if( !i_x1.isEmpty() && !i_y1.isEmpty() && !i_x2.isEmpty() && !i_y2.isEmpty() ) {
            point1.setX(Double.parseDouble(i_x1));
            point1.setY(Double.parseDouble(i_y1));

            point2.setX(Double.parseDouble(i_x2));
            point2.setY(Double.parseDouble(i_y2));
            return true;
        }else {
            Toast.makeText(this, "Faltan Campos por llenar", Toast.LENGTH_LONG).show();
            return false;
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

        result.setText("");

        if(id == R.id.action_random)
        {
            this.genRandomPoints();
            return true;
        }else if(id == R.id.action_distance)
        {
            setPointsValues();
            result.setText(new String("Respuesta: La pendiente es "+formatDouble(AppMath.distance(point1, point2))));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(!setPointsValues())
            return;

        result2.setText("");

        switch (view.getId())
        {
            case R.id.middle_point_button:
                Point point = AppMath.middlePoint(point1, point2);
                result.setText(new String("El punto medio es "+point.toString()));
                break;
            case R.id.slope_button:
                try {
                    double resultNumber = AppMath.slope(point1, point2);
                    System.out.println(resultNumber);
                    result.setText(new String("Respuesta: La pendiente es "+formatDouble(resultNumber)));
                }catch (Exception e)
                {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.quadrant_button:
                String quadrant1 = AppMath.getQuadrant(point1);
                String quadrant2 = AppMath.getQuadrant(point2);

                result.setText(quadrant1);
                result2.setText(quadrant2);
                break;
        }
    }
}