package com.example.navigation;

import com.example.navigation.action.ActionsManager;
import com.example.navigation.action.Field;
import com.example.navigation.action.Action;
import com.example.navigation.stepsEngine.flow.Flow;
import com.example.navigation.stepsEngine.flow.Step;
import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.navigation.stepsEngine.payment.PointPayment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NavigationManager {

    protected Flow flow;
    protected List<Navigable> screens;
    PointPayment paymentFlowState;
    PointPayment previousPaymentFlowState;
    protected Step currentStep;
    protected Map<Integer, Navigable> currentStepScreens;
    protected Navigable currentScreen;





    //Evaluo si cumplo la regla, con los atributos y valores de la pantalla actual
    public Action evaluate(List<Field> attributes, PointPayment paymentFlowState, UnfullfiledRuleListener navigationActionResolve){

        Action action = null;

        //Actualizo el paymentFlowState con los valores obtenidos de la pantalla
        upadatePaymentFlowState(attributes, paymentFlowState);

        //Evaluo si sumplo las reglas de la pantalla actual
        List<Rule> unfulfilledRules = ActionsManager.evaluateCurrentRule(attributes, currentStep.getRule(), paymentFlowState);
        if (unfulfilledRules != null){
            action = navigationActionResolve.resolveAction(unfulfilledRules);
        } else {

        }

        return action;
    }

    public Action getNextAction(PointPayment paymentFlowState){

        Action retval = null;



        return retval;
    }






    public Action getNextAction(){
        Action retval = null;

        int currentSequence = currentScreen.getSequence() + 1;

        if (currentStepScreens.containsKey(currentSequence)){
            retval = currentStepScreens.get(currentSequence).getNavigationId();
        } else if (currentStep.getRule().evaluate(paymentFlowState)){
            setCurrentStepScreens(paymentFlowState);
            retval = currentStepScreens.get(0).getNavigationId();
        } else {
            retval = currentStep.getRule().getRuleException();
        }


        return retval;
    }

    private void setCurrentStepScreens(PointPayment paymentFlowState) {
        currentStep = flow.getNext(paymentFlowState);
        currentStepScreens = new HashMap<>();

        for (Navigable navigable : screens) {
            for (String id  :navigable.getStepIdentifiers()) {
                if(id.equals(currentStep.getStepIdentifier())){
                    currentStepScreens.put(navigable.getSequence(), navigable);
                }
            }
        }
    }

//    private void searchNavigable(Map<String, AssertNavigable> assertsNavigables, String field) {
//        for (Navigable navigable : screens) {
//            List<Attr> attributes = navigable.getAttrinutesValues();
//            for (Attr attribute: attributes) {
//                if (attribute.getId().equals(field)){
//                    if (assertsNavigables.containsKey(navigable.getNavigationId())){
//                        assertsNavigables.get(navigable.getNavigationId()).sumAssert();
//                    } else {
//                        assertsNavigables.put(navigable.getNavigationId(), new AssertNavigable(navigable));
//                    }
//                }
//            }
//        }
//    }


    //        requiredFields = currentStep.getRequiredFields();
//        optionalFields = currentStep.getOptionalFields();
//
//        Map<String, AssertNavigable> assertsNavigables = new HashMap<>();
//
//        for (String requiredField : requiredFields) {
//            searchNavigable(assertsNavigables, requiredField);
//        }
//
//        if (assertsNavigables.size() == 1){
//            retval = ((AssertNavigable)assertsNavigables.values().toArray()[0]).navigable.getNavigationId();
//        } else {
//            for (String optionalField : optionalFields) {
//                searchNavigable(assertsNavigables, optionalField);
//            }
//            if (assertsNavigables.size() > 0){
//                assertsNavigables.values().toArray()
//            }
//
//        }

    //            {
//                //Obtengo siguiente paso y sus pantallas
//                Step nextStep = flow.getNext(paymentFlowState);
//                Map<Integer, Navigable> nextStepScreens = new HashMap<>();
//                for (Navigable navigable : screens) {
//                    for (String id : navigable.getStepIdentifiers()) {
//                        if (id.equals(nextStep.getStepIdentifier())) {
//                            nextStepScreens.put(navigable.getSequence(), navigable);
//                        }
//                    }
//                }
//                //Ya cumpli la currentStep, pero si la primera screen
//                //de nextStep es mi pantalla actual, entonces la evaluo y obtengo en su RuleException el siguiente action a ejecutar
//                if (nextStepScreens.get(1).getNavigationId().equals(currentScreen.getNavigationId())) {
//                    retval = nextStep.getRule().getRuleException();
//                }
//                // Ya tengo la currentStep cumplida pero aun me quedan pantallas de la currentStep por navegar que el flujo
//                // de navegacion me las requiere (pero no me las requeria el currentStep, por eso es que lo cumplí)
//                else if (currentStepScreens.containsKey(currentScreen.getSequence() + 1)) {
//                    //que hago? No mando ninguna accion hasta que no termine de navegar por las pantallas requeridas?
//                    retval = "";
//
//
//                }
//                // No hay mas pantallas dentro de currentStepScreens
//                else {
//                    setCurrentStepScreens(paymentFlowState);
//                    retval = currentStep.getRule().getRuleException();
//                }
//            }


}
