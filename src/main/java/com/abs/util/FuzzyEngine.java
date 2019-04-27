/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.util;

import com.fuzzylite.Engine;
import com.fuzzylite.activation.General;
import com.fuzzylite.defuzzifier.Centroid;
import com.fuzzylite.norm.s.Maximum;
import com.fuzzylite.norm.t.AlgebraicProduct;
import com.fuzzylite.norm.t.Minimum;
import com.fuzzylite.rule.Rule;
import com.fuzzylite.rule.RuleBlock;
import com.fuzzylite.term.Ramp;
import com.fuzzylite.term.Triangle;
import com.fuzzylite.variable.InputVariable;
import com.fuzzylite.variable.OutputVariable;
import java.util.Map;

/**
 *
 * @author ghani
 */
public class FuzzyEngine {

    private Engine engine;

    public FuzzyEngine(Map<String, Object> factors) {
        engine = new Engine("DiscountGenerator");
        createInputVariables(engine, factors);
        createOutputVariable(engine);
        createRuleBlock(engine);
    }

    public Engine getEngine() {
        return engine;
    }

    private void createInputVariables(Engine engine, Map<String, Object> factors) {
        // create input variables for each factor
        for (Map.Entry<String, Object> entry : factors.entrySet()) {
            InputVariable inputVariable = new InputVariable(entry.getKey());
            inputVariable.setEnabled(true);
            inputVariable.setRange(0.000, 1.000);

            // set terms for each variable
            switch (entry.getKey()) {
                case "member":
                    inputVariable.addTerm(new Ramp("no", 1.000, 0.000));
                    inputVariable.addTerm(new Ramp("yes", 0.000, 1.000));
                    break;
                case "stickiness":
                    inputVariable.addTerm(new Triangle("low", 0.000, 0.250, 0.500));
                    inputVariable.addTerm(new Triangle("medium", 0.250, 0.500, 0.750));
                    inputVariable.addTerm(new Triangle("high", 0.500, 0.750, 1.000));
                    break;
            }

            engine.addInputVariable(inputVariable);
        }
    }

    private void createOutputVariable(Engine engine) {
        // configure output variable
        OutputVariable discountVariable = new OutputVariable("discount");
        discountVariable.setEnabled(true);
        discountVariable.setRange(0.000, 1.000);
        discountVariable.setAggregation(new Maximum());
        discountVariable.setDefuzzifier(new Centroid(100));
        discountVariable.setDefaultValue(Double.NaN);
        discountVariable.setLockPreviousValue(false);
        discountVariable.addTerm(new Triangle("low", 0.000, 0.250, 0.500));
        discountVariable.addTerm(new Triangle("medium", 0.250, 0.500, 0.750));
        discountVariable.addTerm(new Triangle("high", 0.500, 0.750, 1.000));
        engine.addOutputVariable(discountVariable);
    }

    private void createRuleBlock(Engine engine) {
        // configure rule block
        RuleBlock mamdani = new RuleBlock("mamdani");
        mamdani.setEnabled(true);
        mamdani.setConjunction(new Minimum());
        mamdani.setDisjunction(new Maximum());
        mamdani.setImplication(new AlgebraicProduct());
        mamdani.setActivation(new General());
        mamdani.addRule(Rule.parse("if stickiness is low or member is no then discount is low", engine));
        mamdani.addRule(Rule.parse("if stickiness is medium then discount is medium", engine));
        mamdani.addRule(Rule.parse("if stickiness is high and member is yes then discount is high", engine));
        engine.addRuleBlock(mamdani);
    }
}
