import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textViewTipAmount, textViewTotalAmount, textViewTotalPerPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewTipAmount = findViewById(R.id.textViewTipAmount);
        textViewTotalAmount = findViewById(R.id.textViewTotalAmount);
        textViewTotalPerPerson = findViewById(R.id.textViewTotalPerPerson);

        // Get values passed from MainActivity
        double tipAmount = getIntent().getDoubleExtra("TipAmount", 0.0);
        double totalAmount = getIntent().getDoubleExtra("TotalAmount", 0.0);
        double totalPerPerson = getIntent().getDoubleExtra("TotalPerPerson", 0.0);

        // Display the results
        textViewTipAmount.setText("Tip Amount: " + tipAmount);
        textViewTotalAmount.setText("Total Amount: " + totalAmount);
        textViewTotalPerPerson.setText("Total Per Person: " + totalPerPerson);
    }
}
