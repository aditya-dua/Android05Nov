package com.adityadua.googlecpnldemo5n;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.services.language.v1.CloudNaturalLanguage;
import com.google.api.services.language.v1.CloudNaturalLanguageRequestInitializer;
import com.google.api.services.language.v1.model.AnnotateTextRequest;
import com.google.api.services.language.v1.model.AnnotateTextResponse;
import com.google.api.services.language.v1.model.Document;
import com.google.api.services.language.v1.model.Entity;
import com.google.api.services.language.v1.model.Features;
import com.google.api.services.language.v1.model.Sentiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public static final String API_KEY="";


    @BindView(R.id.analyze)
    Button analyze;

    @BindView(R.id.docText)
    EditText docText;

   /* @BindView(R.id.entitySentiment)
    TextView sentiment;
*/
    @BindView(R.id.entity)
    RecyclerView entities;

    EntityListAdapter entityListAdapter;
    private List<Entity> entityList;

    private CloudNaturalLanguage naturalLanguageService;
    private Document document;
    private Features features;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        naturalLanguageService = new CloudNaturalLanguage.Builder(
                AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(),
                null
        ).setCloudNaturalLanguageRequestInitializer(
                new CloudNaturalLanguageRequestInitializer(API_KEY)
        ).build();

        document = new Document();

        document.setType("PLAIN_TEXT");
        document.setLanguage("en-US");

        features = new Features();
        features.setExtractEntities(true);
        features.setExtractSyntax(true);
        features.setExtractDocumentSentiment(true);


        final AnnotateTextRequest request = new AnnotateTextRequest();
        request.setDocument(document);
        request.setFeatures(features);

        entityList = new ArrayList<>();
        entityListAdapter = new EntityListAdapter(entityList);
        entities.setAdapter(entityListAdapter);
        entities.setLayoutManager(new LinearLayoutManager(this));

        analyze.setOnClickListener(this);








    }

    @Override
    public void onClick(View view) {

        String text = docText.getText().toString().trim();

        if(!TextUtils.isEmpty(text)){
            document.setContent(text);

            final AnnotateTextRequest request = new AnnotateTextRequest();
            request.setDocument(document);
            request.setFeatures(features);

            new AsyncTask<Object, Object, AnnotateTextResponse>(){


                @Override
                protected AnnotateTextResponse doInBackground(Object... objects) {
                    AnnotateTextResponse resposne = null;
                    try{
                        resposne = naturalLanguageService.documents().annotateText(request).execute();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return resposne;
                }

                @Override
                protected void onPostExecute(AnnotateTextResponse annotateTextResponse) {
                    super.onPostExecute(annotateTextResponse);

                    if(annotateTextResponse !=null){

                        Sentiment sent = annotateTextResponse.getDocumentSentiment();
                        entityList.addAll(annotateTextResponse.getEntities());
                        entityListAdapter.notifyDataSetChanged();
                        //sentiment.setText("Score :"+sent.getScore()+"Magnitude :"+sent.getMagnitude());

                    }
                }
            }.execute();


        }

    }
}
