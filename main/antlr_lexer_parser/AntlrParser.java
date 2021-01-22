package com.dpath.language_based_document_parser.antlr_lexer_parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.dpath_grammar.DpathGrammarLexer;
import org.dpath_grammar.DpathGrammarParser;

import com.dpath.language_based_document_parser.bo.DpathDecoder;
import com.dpath.language_based_document_parser.error_handler.VerboseListener;
import com.dpath.language_based_document_parser.parse_tree_visiter.ParseTreeVisiter;

public class AntlrParser implements IParser {

	@Override
	public DpathDecoder getDpathInfo(String dpath) {
		ParseTree tree = getParseTree(dpath);
		ParseTreeVisiter parseTreeVisiter = new ParseTreeVisiter();

		/**
		 * pathTreeVisiter object will visit the parse tree formed
		 */
		DpathDecoder dpathDecoder = parseTreeVisiter.visit(tree);
		return dpathDecoder;

	}

	@Override
	public ParseTree getParseTree(String dpath) {
		ParseTree tree;
		DpathGrammarParser parser = getParser(dpath);
		parser.removeErrorListeners();
		parser.addErrorListener(new VerboseListener());
		tree = parser.dpath();/**
								 * dpath is the start rule in DpathGrammar.g4......tree contains the root node
								 * of parse tree formed.
								 */

		return tree;
	}

	@Override
	public DpathGrammarParser getParser(String dpath) {
		CommonTokenStream tokens = getTokens(dpath);
		DpathGrammarParser parser = new DpathGrammarParser(tokens);

		return parser;

	}

	@Override
	public CommonTokenStream getTokens(String dpath) {
		DpathGrammarLexer lexer = getLexer(dpath);
		CommonTokenStream tokens = new CommonTokenStream(lexer);/**
																 * object tokens contain tokenstream which will be given
																 * to parser to parse the dpath
																 */
		return tokens;
	}

	@Override
	public DpathGrammarLexer getLexer(String dpath) {
		CharStream input = CharStreams.fromString(dpath);
		DpathGrammarLexer lexer = new DpathGrammarLexer(input);
		lexer.removeErrorListeners();
		lexer.addErrorListener(new VerboseListener());
		return lexer;
	}
}

/*
 * Complete the 'distinctMoves' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. INTEGER n
 *  3. INTEGER x
 *  4. INTEGER y
 */
   /*vector<map<int,int> > dp(10004);
int distinctMoves(string s, int n, int x, int y) {
    int dif=abs(x-y),i,j,v,ans=0,mod=1e9+7;
    if(x>y)swap(x,y);
    int minneg=x,maxpos=n-y;
    n=s.size();
    for(i=0;i<n;i++){
        int val;
        if(s[i]=='l')val=-1;
        else val=1;
            int pos=0;
            if(pos+val<minneg || pos+val>maxpos){}
            else dp[i][pos+val]++;
            if(pos+val==dif){ans=(ans+dp[i][dif])%mod;}
        if(i==0)continue;
        for(j=0;j<i;j++){
            for(auto x: dp[j]){
                int pos=x.first;
                if(pos+val<minneg || pos+val>maxpos)continue;
                else dp[i][pos+val]=(dp[i][pos+val]+x.second)%mod;
                if(pos+val==dif){ans=(ans+dp[i][dif])%mod;}
            }
        }
    }

    return ans;
}

int main()
*/
