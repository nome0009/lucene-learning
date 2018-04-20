package edu.asu.lucene.service.rest.indexer;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class LuceneIndexer {

    public LuceneIndexer(@Value("${lucene.index.location}") String indexLocation) throws IOException {
//        StandardAnalyzer analyzer = new StandardAnalyzer();
//        Directory index = FSDirectory.open(Paths.get(indexLocation));
//
//        IndexWriterConfig config = new IndexWriterConfig(analyzer);
//
//        IndexWriter w = new IndexWriter(index, config);
//
//        File dir = new File("C:\\Users\\Not Joel\\Desktop\\files");
//
//        for (File f : dir.listFiles()) {
//            addDoc(w, f.getAbsolutePath());
//        }
//        w.close();

    }

    private void addDoc(IndexWriter w, String absolutePath) throws IOException {
        Document document = new Document();
        document.add(new TextField("body", new String(Files.readAllBytes(Paths.get(absolutePath))), Field.Store.YES));
        document.add(new StringField("file-name", Paths.get(absolutePath).getFileName().toString(), Field.Store.YES));
        w.addDocument(document);
    }

}
