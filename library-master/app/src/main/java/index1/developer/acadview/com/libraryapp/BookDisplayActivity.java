package index1.developer.acadview.com.libraryapp;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class BookDisplayActivity extends AppCompatActivity {
    PDFView pd;
    TextView tx;
    Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_display);

        pd = (PDFView) findViewById(R.id.pdfView);
        tx = (TextView) findViewById(R.id.textView3);
        Intent intent= getIntent();
        String name = (String) intent.getStringExtra("name") + ".pdf";
        try {
            if(Arrays.asList(getResources().getAssets().list("")).contains(name)){
                tx.setVisibility(View.INVISIBLE);
                pd.setVisibility(View.VISIBLE);
                pd.fromAsset(name).load();
            }
            else {
                pd.setVisibility(View.INVISIBLE);
                tx.setVisibility(View.VISIBLE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
