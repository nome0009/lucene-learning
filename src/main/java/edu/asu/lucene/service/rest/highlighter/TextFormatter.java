package edu.asu.lucene.service.rest.highlighter;

import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.TokenGroup;

public class TextFormatter implements Formatter {
    private static final String DEFAULT_PRE_TAG = "<B>";
    private static final String DEFAULT_POST_TAG = "</B>";
    private String preTag;
    private String postTag;

    public TextFormatter(String preTag, String postTag) {
        this.preTag = preTag;
        this.postTag = postTag;
    }

    public TextFormatter() {
        this("<mark>", "</mark>");
    }

    public String highlightTerm(String originalText, TokenGroup tokenGroup) {
        if (tokenGroup.getTotalScore() <= 0.0F) {
            return originalText;
        } else {
            StringBuilder returnBuffer = new StringBuilder(this.preTag.length() + originalText.length() + this.postTag.length());
            returnBuffer.append(this.preTag);
            returnBuffer.append(originalText);
            returnBuffer.append(this.postTag);
            return returnBuffer.toString();
        }
    }
}
