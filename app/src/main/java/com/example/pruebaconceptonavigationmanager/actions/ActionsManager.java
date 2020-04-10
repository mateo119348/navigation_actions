package com.example.pruebaconceptonavigationmanager.actions;

import android.content.Context;
import android.util.ArrayMap;

import com.example.navigation.stepsEngine.flow.Flow;
import com.example.navigation.stepsEngine.flow.Step;
import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.navigation.stepsEngine.flow.rules.comparable.ComparableRule;
import com.example.navigation.stepsEngine.flow.rules.logic.AndRule;
import com.example.navigation.stepsEngine.flow.rules.logic.LogicRule;
import com.example.navigation.stepsEngine.flow.rules.logic.NotRule;
import com.example.navigation.stepsEngine.flow.rules.logic.OrRule;
import com.example.navigation.stepsEngine.payment.PointPayment;

import java.util.ArrayList;
import java.util.List;

public class ActionsManager {

    private static ActionsManager instance;
    private ArrayMap<String, Action> actions;
    private PointPayment paymentFlowState;
    private List<Action> currentActions;
    private Action currentAction;
    private Action prevAction;
    private Step currentStep;
    private Flow flow;
    private int currentActionIndex;
    private Context context;

    public ActionsManager getInstance(){
        if (instance == null) {
            instance = new ActionsManager();
        }
        return instance;
    }





    private ArrayMap<String, Action> getActions(){
        if (actions == null){
            actions = loadActions();
        }
        return  actions;
    }

    /**
     *
     * @param attributes
     * @return
     */
    private static List<Rule> getCurrentSubRules(List<Field> attributes, Rule currentRule){
        List<Rule> retval  = new ArrayList<>();

        if (currentRule instanceof LogicRule){
            for (Rule subRule: ((LogicRule)currentRule).getSubRules()) {
                retval.addAll(getCurrentSubRules(attributes, subRule));
            }

        } else if (currentRule instanceof ComparableRule) {
            for (Field attribute:attributes) {
                if (attribute.getName().equals(((ComparableRule)currentRule).getFieldManager().getFieldName())){
                    retval.add(currentRule);
                }
            }

        }

        return retval;
    }

    private boolean isLastAction(){
        return currentActionIndex == getCurrentActions().size() - 1;
    }

    /**
     * Se evalua si la action cumple o no las reglas para pasar al siguiente action o step
     * @param mCurrentAction
     */
    public void validate (Action mCurrentAction) {
        Rule currentRule = getCurrentStep().getRule();

        //Actualuizo el paymentFlowState con los fields que cargue en la action a evaluar
        upadatePaymentFlowState(mCurrentAction.getFields(), paymentFlowState);

        //Si la regla del Step es del tipo AND (debo hacer que no cumpla al menos una sub rule para salir del step)
        //Estas se evaluan en el ultimo action. Ante la primera que cumple, muestro el error
        if (currentRule instanceof AndRule) {
            if (isLastAction()) {
                for (Rule subRule : ((AndRule)currentRule).getSubRules()) {
                    if (subRule.evaluate(paymentFlowState)) {
                        mCurrentAction.resolveUnfullfiledRule(subRule);
                        return;
                    }
                }
            }
        }
        //Si la regla del Step es del tipo OR (debo hacer que no cumpla ninguna sub rule para salir del step)
        //Ante la primer subRule que este cumpliendo, tengo que resolver el error.
        //Al final de cada action que tenga algun field involucrado en el rule del step, debo evaluar
        else if (currentRule instanceof OrRule) {
            List<Rule> currentRules = getCurrentSubRules(mCurrentAction.getFields(), currentRule);

            for (Rule subRule : currentRules) {
                if (subRule.evaluate(paymentFlowState)) {
                    mCurrentAction.resolveUnfullfiledRule(subRule);
                    return;
                }
            }
        } else if (currentRule instanceof NotRule){
            for (Field attribute :mCurrentAction.getFields()) {
                if (currentRule.getFieldName().equals(attribute.getName()) && !currentRule.evaluate(paymentFlowState)){
                    mCurrentAction.resolveUnfullfiledRule(((NotRule) currentRule).getSubRules().get(0));
                    return;
                }
            }
        }

        executeNext(mCurrentAction);
    }

    /**
     * Se busca el mejor listado de acciones que satisfagan el step actual. Debemos tener en cuenta las siguientes precondiciones:
     *
     * 1 - No pueden haber dos acciones activas que satisfagan exactamente los mismos fields (requeridos + opcionales).
     *      Si quisiéramos por ejemplo hacer un A/B testing de dos pantallas distintas que hagan lo mismo, en el endpoint de acciones
     *      le deberían llegar a los distintos usuarios la acción que queramos que se ejecute.
     * 2 - Dentro de un step, si es satisfecho por varias acciones, el orden de ejecución de las acciones estará dado
     *      por el orden relativo de las acciones.
     *
     * La política apunta a resolver el step en la menor cantidad posible de acciones, abarcando todos los fields requeridos
     *      y la mayor cantidad posible de opcionales. Dicho esto, se toman las siguientes prioridades:
     *
     * 1- Si hay una acción que matchee todos los fields requeridos, se toma esa acción.
     * 2- Si hay una acción que matchea más fields requeridos que otra, entonces gana esa acción.
     *      Ej: acción 1 matchea A y B, y acción 2 solo matchea B, entonces gana acción 1.
     * 3- Si hay dos acciones que matchean los mismos fields requeridos, se toma entonces la que matchee más fields opcionales.
     */
    public List<Action> getRuleActions (Rule rule){
        List<Action> retval = new ArrayList<>();

        //TODO: implementar
        return retval;
    }

    /**
     * Carga de actions del json
     */
    private ArrayMap<String, Action> loadActions(){
        ArrayMap<String, Action> retval = new ArrayMap<>();

        //TODO:Implementar

        return retval;
    }

    public void validateB(Action mCurrentAction){

        upadatePaymentFlowState(mCurrentAction.getFields(), paymentFlowState);



        //Donde y como impacta la evaluacion de campos no obligatorios?
        for (com.example.navigation.stepsEngine.flow.Field ruleField :getCurrentStep().getRequiredFields()) {
            for (Field actionField: mCurrentAction.getFields()) {
                if (ruleField.getId().equals(actionField.getName())){
                    for (Rule rule: ruleField.getRules()) {
                        if (!rule.evaluate(paymentFlowState)){
                            mCurrentAction.resolveUnfullfiledRule(rule);
                            return;
                        }
                    }
                }
            }
        }


        executeNext(mCurrentAction);
    }


    /**
     * Chequea si existe una proxima Action dentro de las acciones del Step actual
     * Si no es asi, se evalua la rule del step (se deberia cumplir )
     */
    private void executeNext(Action mCurrentAction){
        if (!isLastAction()){
            currentActionIndex++;
            currentAction = null;
            getCurrentAction().execute(context, paymentFlowState);
        }  else if (!getCurrentStep().mustExecute(paymentFlowState)) {
            executeNextStep(mCurrentAction);
        } else {
            throw new IllegalStateException("Revisar las rules, se tendrian que haber cumplido las validaciones");
        }

    }

    private void executeNextStep(Action mCurrentAction){
        currentStep = null;
        currentActions = null;
        currentAction = null;
        currentActionIndex = 0;

        if (mCurrentAction != null && getCurrentAction().getName().equals(mCurrentAction.getName())){
            executeAction(mCurrentAction);
        } else {
            executeAction(getCurrentAction());
        }
    }

    private void executeAction(Action action) {
        action.execute(context, getCurrentStep().getRequiredFields(), getCurrentStep().getOptionalFields());
    }

    /**
     * Se intstancia el flow correspondiente al tipo de operacion
     * @param operationType
     */
    public void startFlow (Context context, String operationType, PointPayment paymentFlowState){
        //TODO: cargar flow con json
        flow = new Flow();
        this.context = context;
        this.paymentFlowState = paymentFlowState;
        executeNextStep(null);

    }

    private void upadatePaymentFlowState (List<Field> field, PointPayment paymentFlowState){
        //TODO: implementar: tomar los valores de cada field y actualizarlos al paymentFlowState
    }

    private Step getCurrentStep(){
        if (currentStep == null){
            currentStep = flow.getNext(paymentFlowState);
        }
        return currentStep;
    }

    private List<Action> getCurrentActions(){
        if (currentActions == null){
            currentActions = getRuleActions(getCurrentStep().getRule());
        }
        return currentActions;
    }

    private Action getCurrentAction() {
        if (currentAction == null) {
            currentAction = getCurrentActions().get(currentActionIndex);
        }
        return currentAction;
    }





}
