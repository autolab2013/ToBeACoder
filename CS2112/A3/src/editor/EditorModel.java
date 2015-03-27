package editor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import modules.AutoCompleteModule;
import modules.ModuleFactory;
import modules.SearchModule;
import modules.SpellCheckModule;

public class EditorModel {

    private final AutoCompleteModule autoComplete;
    private final SpellCheckModule spellCheck;
    private final SearchModule search;
    private long spellCheckTime;

    public EditorModel() {
        autoComplete = ModuleFactory.getAutoComplete();
        spellCheck = ModuleFactory.getSpellCheck();
        search = ModuleFactory.getSearchModule();
    }

    public void loadDictionary(File dict) {
        if (dict != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(dict))) {
                for (String line; (line = br.readLine()) != null;) {
                    autoComplete.addWord(line);
                    spellCheck.addWord(line);
                }
            }
            catch (IOException ioe) {
                System.err.println("Error reading provided dictionary file.");
            }
        }
    }

    public String spellCheck(String markupText) {
        String plainText = toPlainText(markupText);
        String preamble = markupText.substring(0, firstIndexOfBody(markupText));
        String conclusion =
                markupText.substring(lastIndexOfBody(markupText) + 1);
        StringBuilder sb = new StringBuilder();
        sb.append(preamble);
        long start = System.nanoTime();
        for (String word : plainText.split("\\s+")) {
            if (!spellCheck.isValidWord(word.toLowerCase().replaceAll("[^\\w]",
                                                                      ""))) {
                sb.append("<u><font color=\"red\">");
                sb.append(word);
                sb.append("</font></u> ");
            }
            else {
                sb.append(word);
                sb.append(" ");
            }
        }
        spellCheckTime = (System.nanoTime() - start) / 1000;
        sb.append(conclusion);
        return sb.toString();
    }

    public long getSpellCheckTime() {
        return spellCheckTime;
    }

    public String autocomplete(String markupText) {
        int startIndex =
                Math.max(Math.max(markupText.lastIndexOf(' ') + 1,
                                  firstIndexOfBody(markupText)),
                         markupText.lastIndexOf("&nbsp;") + 6);
        String pref =
                toPlainText(markupText.substring(startIndex,
                                                 lastIndexOfBody(markupText) + 1));
        return autoComplete.getWordForPrefix(pref);
    }

    public String search(String query, String markupText) {
        int index = search.find(query, markupText);
        if (index != -1) {
            String pretext = markupText.substring(0, index);
            String posttext = markupText.substring(index + query.length());
            return pretext + "<u><font color=\"blue\">" + query + "</font></u>"
                    + posttext;
        }
        else {
            return markupText;
        }
    }

    public String clearFormatting(String markupText) {
        return markupText.replaceAll("<u><font color=\"(red|blue)\">", "")
                         .replaceAll("</font></u>", "");
    }

    private String toPlainText(String markupText) {
        return markupText.replaceAll("<[^>]+>", "").replace("&nbsp;", "");
    }

    private int firstIndexOfBody(String markupText) {
        int index = 0;
        int max = lastIndexOfBody(markupText);
        while (index < max - 1 && markupText.charAt(index) == '<') {
            index++;
            while (markupText.charAt(index) != '>')
                index++;
            index++;
        }
        return index;
    }

    private int lastIndexOfBody(String markupText) {
        return markupText.lastIndexOf("</body>") - 1;
    }
}
