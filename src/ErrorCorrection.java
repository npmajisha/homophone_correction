/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.trees.Tree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author Majisha
 */
public class ErrorCorrection{

    /**
     * @param args the command line arguments
     */
    
    private final static String PCG_MODEL = "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";        

    private static final TokenizerFactory<CoreLabel> tokenizerFactory = PTBTokenizer.factory(new CoreLabelTokenFactory(), "invertible=true");

    private static final LexicalizedParser parser = LexicalizedParser.loadModel(PCG_MODEL);

    private static Tree parse(String str) {                
        List<CoreLabel> tokens = tokenize(str);
        Tree tree = parser.apply(tokens);
        return tree;
    }

    private static List<CoreLabel> tokenize(String str) {
        Tokenizer<CoreLabel> tokenizer =
            tokenizerFactory.getTokenizer(
                new StringReader(str));    
        return tokenizer.tokenize();
    }
    
    

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        
        File inputFile = new File(args[0]);
	FileWriter outFile = new FileWriter(args[1],true);
        
        Pattern p_to = Pattern.compile("\\bto\\b", Pattern.CASE_INSENSITIVE);
        Pattern p_too = Pattern.compile("\\btoo\\b", Pattern.CASE_INSENSITIVE);
        Pattern p_its = Pattern.compile("\\bits\\b", Pattern.CASE_INSENSITIVE);
        Pattern p_it_s = Pattern.compile("\\bit\\s*'s\\b", Pattern.CASE_INSENSITIVE);
        Pattern p_lose = Pattern.compile("\\blose\\b", Pattern.CASE_INSENSITIVE);
        Pattern p_loose = Pattern.compile("\\bloose\\b", Pattern.CASE_INSENSITIVE);
        Pattern p_their = Pattern.compile("\\btheir\\b", Pattern.CASE_INSENSITIVE);
        Pattern p_theyre = Pattern.compile("\\bthey\\s*'re\\b", Pattern.CASE_INSENSITIVE);
        Pattern p_your = Pattern.compile("\\byour\\b", Pattern.CASE_INSENSITIVE);
        Pattern p_youre = Pattern.compile("\\byou\\s*'re\\b", Pattern.CASE_INSENSITIVE);

        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        PrintWriter out = new PrintWriter(outFile);
        
        String str;
        HashSet<String> generatedStrings = new HashSet();
        List<String> list = new ArrayList<String>();
        while((str = in.readLine()) != null){
            list.add(str);
        }
        
        for(String l : list){
            if (l.length() != 0){
            
            generatedStrings = new HashSet();
            
            generatedStrings.add(l);
            List<String> new_strings = new ArrayList();
            for(String gl : generatedStrings){
                
                Matcher m = p_to.matcher(l);
                int begin = 0;
                int end = 0;
                
                String word ="";
                while(m.find()){
                    end = m.start();
                    char fc = m.group().charAt(0);
                    if (Character.isUpperCase(fc)){
                        word = "Too";
                    }
                    else{
                        word = "too";
                    }
                    String new_string = gl.substring(begin, end)+word+gl.substring(m.end(),gl.length());
                    new_strings.add(new_string);
                
                }
            }
            
            generatedStrings.addAll(new_strings);
            new_strings = new ArrayList();
            for(String gl : generatedStrings){
                
                Matcher m = p_too.matcher(gl);
                int begin = 0;
                int end = 0;
                String word = "";
                while(m.find()){
                    end = m.start();
                    char fc = m.group().charAt(0);
                    if (Character.isUpperCase(fc)){
                        word = "To";
                    }
                    else{
                        word = "to";
                    }
                    String new_string = gl.substring(begin, end)+word+gl.substring(m.end(),gl.length());
                    new_strings.add(new_string);
                
                }
            }
            
            generatedStrings.addAll(new_strings);
            new_strings = new ArrayList();
            for(String gl : generatedStrings){
                
                Matcher m = p_its.matcher(gl);
                int begin = 0;
                int end = 0;
                
                String word = "";
                while(m.find()){
                    end = m.start();
                    char fc = m.group().charAt(0);
                    if (Character.isUpperCase(fc)){
                        word = "It's";
                    }
                    else{
                        word = "it's";
                    }
                    String new_string = gl.substring(begin, end)+word+gl.substring(m.end(),gl.length());
                    new_strings.add(new_string);
                
                }
            }
            
            generatedStrings.addAll(new_strings);
            new_strings = new ArrayList();
            for(String gl : generatedStrings){
                
                Matcher m = p_it_s.matcher(gl);
                int begin = 0;
                int end = 0;
                
                String word = "";
                while(m.find()){
                    end = m.start();
                    char fc = m.group().charAt(0);
                    if (Character.isUpperCase(fc)){
                        word = "Its";
                    }
                    else{
                        word = "its";
                    }
                    String new_string = gl.substring(begin, end)+word+gl.substring(m.end(),gl.length());
                    new_strings.add(new_string);
                
                }
            }
            
            generatedStrings.addAll(new_strings);
            new_strings = new ArrayList();
            for(String gl : generatedStrings){
                
                Matcher m = p_lose.matcher(gl);
                int begin = 0;
                int end = 0;
                
                String word = "";
                while(m.find()){
                    end = m.start();
                    char fc = m.group().charAt(0);
                    if (Character.isUpperCase(fc)){
                        word = "Loose";
                    }
                    else{
                        word = "loose";
                    }
                    String new_string = gl.substring(begin, end)+word+gl.substring(m.end(),gl.length());
                    new_strings.add(new_string);
                
                }
            }
            
            generatedStrings.addAll(new_strings);
            new_strings = new ArrayList();
            for(String gl : generatedStrings){
                
                Matcher m = p_loose.matcher(gl);
                int begin = 0;
                int end = 0;
                
                String word = "";
                while(m.find()){
                    end = m.start();
                    char fc = m.group().charAt(0);
                    if (Character.isUpperCase(fc)){
                        word = "Lose";
                    }
                    else{
                        word = "lose";
                    }
                    String new_string = gl.substring(begin, end)+word+gl.substring(m.end(),gl.length());
                    new_strings.add(new_string);
                
                }
            }
            
            generatedStrings.addAll(new_strings);
            new_strings = new ArrayList();            
            for(String gl : generatedStrings){
                
                Matcher m = p_their.matcher(gl);
                int begin = 0;
                int end = 0;
                
                String word = "";
                while(m.find()){
                    end = m.start();
                    char fc = m.group().charAt(0);
                    if (Character.isUpperCase(fc)){
                        word = "They're";
                    }
                    else{
                        word = "they're";
                    }
                    String new_string = gl.substring(begin, end)+word+gl.substring(m.end(),gl.length());
                    new_strings.add(new_string);
                
                }
            }
            
            generatedStrings.addAll(new_strings);
            
            generatedStrings.addAll(new_strings);
            new_strings = new ArrayList();            
            for(String gl : generatedStrings){
                
                Matcher m = p_theyre.matcher(gl);
                int begin = 0;
                int end = 0;
                
                String word = "";
                while(m.find()){
                    end = m.start();
                    char fc = m.group().charAt(0);
                    if (Character.isUpperCase(fc)){
                        word = "Their";
                    }
                    else{
                        word = "their";
                    }
                    String new_string = gl.substring(begin, end)+word+gl.substring(m.end(),gl.length());
                    new_strings.add(new_string);
                
                }
            }
            
            generatedStrings.addAll(new_strings);
            
            generatedStrings.addAll(new_strings);
            new_strings = new ArrayList();            
            for(String gl : generatedStrings){
                
                Matcher m = p_your.matcher(gl);
                int begin = 0;
                int end = 0;
                
                String word = "";
                while(m.find()){
                    end = m.start();
                    char fc = m.group().charAt(0);
                    if (Character.isUpperCase(fc)){
                        word = "You're";
                    }
                    else{
                        word = "you're";
                    }
                    String new_string = gl.substring(begin, end)+word+gl.substring(m.end(),gl.length());
                    new_strings.add(new_string);
                
                }
            }
            
            generatedStrings.addAll(new_strings);
            new_strings = new ArrayList();            
            for(String gl : generatedStrings){
                
                Matcher m = p_youre.matcher(gl);
                int begin = 0;
                int end = 0;
                
                String word = "";
                while(m.find()){
                    end = m.start();
                    char fc = m.group().charAt(0);
                    if (Character.isUpperCase(fc)){
                        word = "Your";
                    }
                    else{
                        word = "your";
                    }
                    String new_string = gl.substring(begin, end)+word+gl.substring(m.end(),gl.length());
                    new_strings.add(new_string);
                
                }
            }
            
            generatedStrings.addAll(new_strings);
            
            double score=0.0;double best=0.0;String best_line = "";
            int i = 0;
            for(String gl : generatedStrings){
            
                Tree tr = parse(gl);
                score = tr.score();
                if (i==0){
                    best = score;
                    best_line = gl;
                }
                else{
                    if (best < score){
                        best = score;
                        best_line = gl;
                    }
                }
                
                i++;
            
            }
        
            out.println(best_line);
            }
            else{

            out.println(l);
            }
        
        }
        
        
        out.close();
        
    
    }

    
}
