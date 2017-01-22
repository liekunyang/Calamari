/*
 * Copyright 2006-2017 CIRDLES.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cirdles.calamari.tasks.expressions.parsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.cirdles.calamari.ExpressionsForSquidBaseListener;
import org.cirdles.calamari.ExpressionsForSquidLexer;
import org.cirdles.calamari.ExpressionsForSquidListener;
import org.cirdles.calamari.ExpressionsForSquidParser;
import org.cirdles.calamari.ExpressionsForSquidParser.ExprContext;
import org.cirdles.calamari.tasks.expressions.ConstantNode;
import org.cirdles.calamari.tasks.expressions.ExpressionTree;
import org.cirdles.calamari.tasks.expressions.ExpressionTreeBuilderInterface;
import org.cirdles.calamari.tasks.expressions.ExpressionTreeInterface;
import org.cirdles.calamari.tasks.expressions.ShrimpSpeciesNode;
import org.cirdles.calamari.tasks.expressions.operations.Operation;
import org.cirdles.calamari.tasks.expressions.parsing.ShuntingYard.TokenTypes;

/**
 *
 * @author James F. Bowring
 */
public class AntlrDriver {

    private void parseExpression(String expression) {
        // Get our lexer
        ExpressionsForSquidLexer lexer = new ExpressionsForSquidLexer(new ANTLRInputStream(expression));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        List<Token> tk = tokens.getTokens();

        // Pass the tokens to the parser
        ExpressionsForSquidParser parser = new ExpressionsForSquidParser(tokens);

        // Specify our entry point
        ExprContext expSentenceContext = parser.expr();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        ExpressionsForSquidListener listener = new AntlrExpListener();
        walker.walk(listener, expSentenceContext);

        parser.setBuildParseTree(true);
        List<ParseTree> children = expSentenceContext.children;

        List<String> parsed = new ArrayList<>();
        System.out.println();
        for (int i = 0; i < children.size(); i++) {
            printTree(parser, children.get(i), parsed);
        }

        System.out.println("Infix  " + parsed);
        List<String> parsedRPN = ShuntingYard.infixToPostfix(parsed);
        System.out.println("PostFix  " + parsedRPN);

        Collections.reverse(parsedRPN);

        buildTree(parsedRPN);

    }

    public final static Map<String, String> operationsMap = new HashMap<>();

    static {
        operationsMap.put("+", "add");
        operationsMap.put("-", "subtract");
        operationsMap.put("/", "divide");
        operationsMap.put("*", "multiply");
        operationsMap.put("^", "pow");
    }

    private void buildTree(List<String> parsedRPNreversed) {
        Iterator<String> parsedRPNreversedIterator = parsedRPNreversed.iterator();

        ExpressionTreeInterface exp = null;
        ExpressionTreeInterface savedExp = null;

        boolean firstPass = true;
        while (parsedRPNreversedIterator.hasNext()) {
            String token = parsedRPNreversedIterator.next();

            if (exp != null) {
                // find next available empty left
                exp = walkUpTreeToEmptyLeftChild(exp);
            }

            exp = walkTree(token, exp);
            if (firstPass) {
                savedExp = exp;
                firstPass = false;
            }
        }

        System.out.println(savedExp.toStringMathML());
    }

    private ExpressionTreeInterface walkUpTreeToEmptyLeftChild(ExpressionTreeInterface exp) {
        ExpressionTreeInterface savedExp = exp;
        ExpressionTreeInterface expParent = exp;

        boolean didAscend = true;
        while (didAscend) {
            if (savedExp instanceof ExpressionTreeBuilderInterface) {
                if (((ExpressionTreeBuilderInterface) savedExp).getLeftET() != null) {
                    expParent = savedExp.getParentET();
                    savedExp = expParent;
                } else {
                    didAscend = false;
                }
            } else if (savedExp instanceof ConstantNode) {
                expParent = savedExp.getParentET();
                savedExp = expParent;
            } else if (savedExp instanceof ShrimpSpeciesNode) {
                expParent = savedExp.getParentET();
                savedExp = expParent;
            } else {
                didAscend = false;
            }
        }

        return expParent;
    }

    private ExpressionTreeInterface walkTree(String token, ExpressionTreeInterface exp) {
        TokenTypes tokenType = TokenTypes.getType(token);
        ExpressionTreeInterface retExpTree = null;

        switch (tokenType) {
            case OPERATOR_A:
            case OPERATOR_M:
            case OPERATOR_E:
                Operation operation = Operation.operationFactory(operationsMap.get(token));
                retExpTree = new ExpressionTree(operation);

                if (exp == null) {
                    // do nothing
                } else if (((ExpressionTreeBuilderInterface) exp).getRightET() == null) {
                    ((ExpressionTreeBuilderInterface) exp).setRightET(retExpTree);
                } else if (((ExpressionTreeBuilderInterface) exp).getLeftET() == null) {
                    ((ExpressionTreeBuilderInterface) exp).setLeftET(retExpTree);
                }

                break;

            case CONSTANT:
                retExpTree = new ConstantNode(token, Double.parseDouble(token));

                if (((ExpressionTreeBuilderInterface) exp).getRightET() == null) {
                    ((ExpressionTreeBuilderInterface) exp).setRightET(retExpTree);
                } else if (((ExpressionTreeBuilderInterface) exp).getLeftET() == null) {
                    ((ExpressionTreeBuilderInterface) exp).setLeftET(retExpTree);
                }

                break;

            case VARIABLE:
                retExpTree = new ConstantNode(token, 0.0);

                if (((ExpressionTreeBuilderInterface) exp).getRightET() == null) {
                    ((ExpressionTreeBuilderInterface) exp).setRightET(retExpTree);
                } else if (((ExpressionTreeBuilderInterface) exp).getLeftET() == null) {
                    ((ExpressionTreeBuilderInterface) exp).setLeftET(retExpTree);
                }

                break;

        }

        return retExpTree;
    }

    private void printTree(ExpressionsForSquidParser parser, ParseTree tree, List<String> parsed) {
        if (tree.getChildCount() < 1) {
            parsed.add(tree.toStringTree(parser));
        } else {
            for (int i = 0; i < tree.getChildCount(); i++) {
                printTree(parser, tree.getChild(i), parsed);
            }
        }
    }

    /**
     *
     */
    public class AntlrExpListener extends ExpressionsForSquidBaseListener {

        @Override
        public void enterExpr(ExprContext ctx) {
//            System.out.println(ctx.getText());
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AntlrDriver dr = new AntlrDriver();
//        dr.parseExpression("(aaa+bbb)*ccc");
//        dr.parseExpression("a +b+c+d+e");
        dr.parseExpression("AA+4*2/(1-5)^2^AA");
    }

}
