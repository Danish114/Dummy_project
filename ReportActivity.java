
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;

public class ReportActivity extends AppCompatActivity {
   private WebView reportWebView;
   private Button btnPrintRep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        reportWebView = findViewById(R.id.webviwpage);
        reportWebView.loadUrl("file:///android_asset/reprtfile/Retail_Outlet_Quality_Report.html");
        btnPrintRep= (Button) findViewById(R.id.btnPrintRep);
        btnPrintRep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

                    PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);

                    PrintDocumentAdapter printAdapter =
                            reportWebView.createPrintDocumentAdapter();

                    String jobName = getString(R.string.app_name) + " Print Test";
                    PrintAttributes.Builder builder = new PrintAttributes.Builder();
                    builder.setMediaSize( PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE); // Change Paper Size
                    printManager.print(jobName, printAdapter, builder.build());
                }
            }
        });


        reportWebView.addJavascriptInterface(this,"android");
        //reportWebView.getSettings().setBuiltInZoomControls(true);
        reportWebView.getSettings().setBuiltInZoomControls(true);
    }
    @JavascriptInterface
    public void getData() {

        return;
    }
    }
